'use strict';

/**
 * UsuarioController
 * 
 * @constructor
 */

App.controller('UsuarioRegistrarController', function($scope, $http, $location, $upload, services) {
	$scope.files = {};
	$scope.tituloPagina = "Registrar nuevo usuario";
	$scope.objUsuario = {
		tipoUsuarioId : 1
	};
	
	$scope.cancelar = function(){
		$location.path('/iniciar-sesion');
	}
	//Guarda los datos ingresados por el usuario.
	$scope.guardar = function() {
		var usuarioFoto = $scope.files[0];
		if(validarDatos($scope.objUsuario, usuarioFoto) && this.crearUsuario.$valid){
			var datosUsuario = {};
			datosUsuario = {
					nombre: $scope.objUsuario.nombre,
					apellido1: $scope.objUsuario.apellido1,
					apellido2: $scope.objUsuario.apellido2,
					correo: $scope.objUsuario.correo,
					telefono1: $scope.objUsuario.telefono1,
					telefono2: $scope.objUsuario.telefono2,
					tipoUsuarioId: $scope.objUsuario.tipoUsuarioId,
					contrasenna: $scope.objUsuario.contrasenna,
					needAccess: "false"
			}
			
			$http.post('rest/protected/usuario/registrar', datosUsuario).success(function (contractUsuarioResponse){
				if(contractUsuarioResponse.code == 200){
					if(usuarioFoto){
						//Guarda la información en variables y se las pasa al controlador de usuario de java.
						$scope.upload = $upload.upload({
							url : 'rest/protected/usuario/registrarFoto',
							data : {
								idUsuario : contractUsuarioResponse.idUsuario
							},
							file : usuarioFoto
						}).success(function(usuarioResponse, status, headers, config) {
							//Muestra un mensaje si el usuario es registrado satisfactoriamente en el sistema.
							if(contractUsuarioResponse.code == 200){
								services.noty('El usuario se registro correctamente.', 'success');
								$location.path('/iniciar-sesion');
							}
						});
					}else{
						services.noty('El usuario se registro correctamente.', 'success');
						$location.path('/iniciar-sesion');
					}
				}else{
					services.noty(contractUsuarioResponse.errorMessage, 'error');
				}
			});
		}
		
	};
	//Guarda los archivos seleccionados en el scope.files.
	$scope.onFileSelect = function($files) {
    	$scope.files = $files;
    };
    
    function validarDatos(objUsuario, file){
    	var extensiones = new Array("jpg","png","gif");
    	var extFile;
    	var isOk = true;
    	var extCorrecto = false;
    	//Valida que el formato del archivo solo sea jpg, png y gif
    	if(file){
    		extFile = file.name.split('.').pop(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.
    		for(var i = 0; i <= extensiones.length; i++){
        		if(extensiones[i] == extFile.toLowerCase()){
        			extCorrecto = true;
    	        }
    	    }
    		if(extCorrecto == false){
    			isOk = false;
    			services.noty('Solo se puede subir archivos con formato jpg, png, gif.', 'warning');
    			
    		}
    	}

    	if(objUsuario.contrasenna != objUsuario.repetirContrasenna){
    		isOk = false;
    		services.noty('El campo de repetir contraseña tiene que ser igual a la contraseña.', 'warning');
    	}   	
    	return isOk;
    }
});

App.controller('UsuarioModificarController', function($scope, $location, $routeParams) {
	$scope.files = {};
	$scope.tituloPagina = "Modificar datos del usuario";
	$scope.objUsuario = {};
	$scope.usuario = $scope.usuarios[$routeParams.id];	
	
	$scope.cancelar = function(){
		$location.path('/');
	}

	$scope.guardar = function() {
		$location.path('/iniciar-sesion');
	}

});


App.controller('UsuarioPerfilController', function($scope, $http, $location, $upload, services,$routeParams) {
	
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = objUsuario.tipo == 1 ? false : true;
		$scope.files = {};
		$scope.tituloPagina = "Perfil del usuario";
		$scope.usuario = {};
		$scope.mostrarImagen = false;
		$scope.actualizarImagen = false;
		$scope.init = function() {
			//Obtiene el perfil del usuario
			$http.get('rest/protected/usuario/perfilUsuario')
			.success(function(usuarioResponse) {
				$scope.usuario.nombre = usuarioResponse.usuario.nombre;
				$scope.usuario.apellido1 = usuarioResponse.usuario.apellido1;
				$scope.usuario.apellido2 = usuarioResponse.usuario.apellido2;
				$scope.usuario.correo = usuarioResponse.usuario.correo;
				$scope.usuario.telefono1 = usuarioResponse.usuario.telefono1;
				$scope.usuario.telefono2 = usuarioResponse.usuario.telefono2;
				$scope.usuario.tipoUsuarioId = objUsuario.tipo;
				$scope.usuario.contrasenna = usuarioResponse.usuario.contrasenna;
				$scope.usuario.contrasennaOriginal = usuarioResponse.usuario.contrasenna;
				$scope.usuario.repetirContrasenna = usuarioResponse.usuario.contrasenna;
				$scope.usuario.fotografia = usuarioResponse.usuario.fotografia;	
				if(usuarioResponse.usuario.fotografia){
					$scope.mostrarImagen = true;
				}
				 
			});
		}
		 $scope.init();
		 
		 $scope.cancelar = function(){
				$location.path('/usuario-perfil');
			}
		 
		//Guarda los datos ingresados por el usuario.
		$scope.guardar = function() {
			var usuarioFoto = $scope.files[0];
			if(validarDatos($scope.usuario, usuarioFoto) && this.perfilUsuario.$valid){
				var datosUsuario = {};
				var cambioContrasenna;
				//valida si la contrasena es igual a la anterior 
				if($scope.usuario.contrasennaOriginal == $scope.usuario.contrasenna){
					cambioContrasenna = "false";
					
				} else{
					cambioContrasenna = "true";
				}
				datosUsuario = {
						idUsuario: objUsuario.idUsuario,
						nombre: $scope.usuario.nombre,
						apellido1: $scope.usuario.apellido1,
						apellido2: $scope.usuario.apellido2,
						correo: $scope.usuario.correo,
						telefono1: $scope.usuario.telefono1,
						telefono2: $scope.usuario.telefono2,
						tipoUsuarioId: $scope.usuario.tipoUsuarioId,
						contrasenna: $scope.usuario.contrasenna,
						needAccess: "false",
						cambio: cambioContrasenna
				}
				
				$http.post('rest/protected/usuario/modificar', datosUsuario).success(function (contractUsuarioResponse){
					if(contractUsuarioResponse.code == 200){
						if(usuarioFoto && $scope.actualizarImagen == true){
							//Guarda la información en variables y se las pasa al controlador de usuario de java.
							$scope.upload = $upload.upload({
								url : 'rest/protected/usuario/registrarFoto',
								data : {
									idUsuario : contractUsuarioResponse.idUsuario
								},
								file : usuarioFoto
							}).success(function(usuarioResponse, status, headers, config) {
							//Muestra un mensaje si el usuario es registrado satisfactoriamente en el sistema.
								if(contractUsuarioResponse.code == 200){
									services.noty('Los datos del usuario fueron modificados correctamente.', 'success');
								}
							});
						}else{
							services.noty('Los datos del usuario fueron modificados correctamente.', 'success');
						}
					}else{
						services.noty('No se pudo modificar los datos del usuario.', 'error');
					}
				});
			}
			
		};
			 	 
		//Guarda los archivos seleccionados en el scope.files.
		$scope.onFileSelect = function($files) {
	    	$scope.files = $files;
	    	$scope.actualizarImagen = true;
	    };
	    
	    function validarDatos(objUsuario, file){
	    	var extensiones = new Array("jpg","png","gif");
	    	var extFile;
	    	var isOk = true;
	    	var extCorrecto = false;
	    	//Valida que el formato del archivo solo sea jpg, png y gif
	    	if(file){
	    		extFile = file.name.split('.').pop(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.
	    		for(var i = 0; i <= extensiones.length; i++){
	        		if(extensiones[i] == extFile.toLowerCase()){
	        			extCorrecto = true;
	    	        }
	    	    }
	    		if(extCorrecto == false){
	    			isOk = false;
	    			services.noty('Solo se puede subir archivos con formato jpg, png, gif.', 'warning');
	    			
	    		}
	    	}

	    	if(objUsuario.contrasenna != objUsuario.repetirContrasenna){
	    		isOk = false;
	    		services.noty('El campo de repetir contraseña tiene que ser igual a la contraseña.', 'warning');
	    	}   	
	    	return isOk;
	    }
	    	 
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}	
});



