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
		if(validarDatos($scope.objUsuario) && this.crearUsuario.$valid){
			var usuarioFoto = $scope.files[0];
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
					services.noty('No se pudo registrar el usuario.', 'error');
				}
			});
		}
		
	}
	//Guarda los archivos seleccionados en el scope.files.
	$scope.onFileSelect = function($files) {
    	$scope.files = $files;
    };
    
    function validarDatos(objUsuario){
    	var isOk = true;
    	if(objUsuario.contrasenna != objUsuario.repetirContrasenna){
    		isOk = false;
    		services.noty('El campo de repetir contraseña tiene que ser igual a la contraseña.', 'warning');
    	}
    	
    	return isOk;
    }
});

App.controller('UsuarioModificarController', function($scope, $location, $routeParams, $upload, services) {
	
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;
		$scope.files = {};
		$scope.tituloPagina = "Modificar usuario";
		$scope.mostrarImagen = true;
		$scope.actualizarImagen = false;
		$scope.objUsuario = {
		idUsuario: $routeParams.pidUsuario
		};
		
		
		$scope.init = function() {
			//Modifica el perfil del usuario
			$http.post('rest/protected/usuario/modificarUsuario')
			.success(function(usuarioResponse) {
				$scope.usuario.nombre = usuarioResponse.usuario.nombre;
				$scope.usuario.apellido1 = usuarioResponse.usuario.apellido1;
				$scope.usuario.apellido2 = usuarioResponse.usuario.apellido2;
				$scope.usuario.correo = usuarioResponse.usuario.correo;
				$scope.usuario.telefono1 = usuarioResponse.usuario.telefono1;
				$scope.usuario.telefono2 = usuarioResponse.usuario.telefono2;
				$scope.usuario.tipoUsuarioId = objUsuario.tipo;
				$scope.usuario.contrasenna = usuarioResponse.usuario.contrasenna;
				$scope.usuario.repetirContrasenna = usuarioResponse.usuario.contrasenna;
				$scope.usuario.fotografia = usuarioResponse.usuario.fotografia;	
				if(usuarioResponse.usuario.fotografia){
					$scope.mostrarImagen = true;
				}
				 
			});
		}
		 
	}else{
		var path = "/usuario/#/iniciar-sesion";
		window.location.href = path;
	}	
	
	
	//Guarda los datos modificados del usuario.
	$scope.guardar = function() {
		if(this.crearUsuario.$valid){
			var usuarioFoto = $scope.files[0];
			var datosUsuario = {};
			datosUsuario = {
				idUsuario: $scope.objUsuario.idUsuario,
				nombre: $scope.objUsuario.nombre,
				apellido1: $scope.objUsuario.apellido1,
				apellido2: $scope.objUsuario.apellido2,
				correo:    $scope.objUsuario.correo,
				telefono1: $scope.objUsuario.telefono1,
				telefono2: $scope.objUsuario.telefono2,
				tipoUsuarioId: $scope.objUsuario.tipoUsuarioId,
				contrasenna: $scope.objUsuario.contrasenna,
				repetirContrasenna: $scope.objUsuario.contrasenna,
			}
	    
		$http.post('rest/protected/usuario/modificarUsuario', datosUsuario).success(function (contractUsuarioResponse){
			if(contractUsuarioResponse.code == 200){
				if(usuarioFoto && $scope.actualizarImagen == true){
					//Guarda la información en variables y se las pasa al controlador de usuario de java.
					$scope.upload = $upload.upload({
						url : 'rest/protected/usuario/registrarFoto',
						data : {
							idUsuario : $scope.objUsuario.idUsuario
						},
						file : usuarioFoto
					}).success(function(UsuarioResponse, status, headers, config) {
						//Muestra un mensaje si el usuario es registrado satisfactoriamente en el sistema.
						if(usuarioResponse.code == 200){
							services.noty('Los datos del usuario fueron modificados correctamente.', 'success');
							$location.path('/usuario-perfil-mostrar');
						}else{
							services.noty('No se pudo registrar la foto.', 'error');
						 }
					});
				}else{
					services.noty('Los datos del usuario fueron modificados correctamente.', 'success');
					$location.path('/usuario-perfil-mostrar');
				}
			}else{
				services.noty('No se pudo modificar los datos del usuario.', 'error');
			}
		});
	}


//Guarda los archivos seleccionados en el scope.files.
$scope.onFileSelect = function($files) {
	$scope.files = $files;
	$scope.actualizarImagen = true;
};

}; 
		
});


App.controller('UsuarioPerfilController', function($scope, $location, $http, $routeParams) {
	
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;
		$scope.files = {};
		$scope.tituloPagina = "Perfil del usuario";
		$scope.usuario = {};
		$scope.mostrarImagen = false;
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
				$scope.usuario.repetirContrasenna = usuarioResponse.usuario.contrasenna;
				$scope.usuario.fotografia = usuarioResponse.usuario.fotografia;	
				if(usuarioResponse.usuario.fotografia){
					$scope.mostrarImagen = true;
				}
				 
			});
		}
		 $scope.init();
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}	
});



