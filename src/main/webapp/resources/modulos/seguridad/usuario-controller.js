'use strict';

/**
 * UsuarioController
 * 
 * @constructor
 */

App.controller('UsuarioRegistrarController', function($scope, $http, $location, $upload) {
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
								alert("El usuario se registro correctamente.");
								$location.path('/iniciar-sesion');
							}
						});
					}else{
						alert("El usuario se registro correctamente.");
						$location.path('/iniciar-sesion');
					}
				}else{
					alert("No se pudo registrar el usuario.");
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
    		alert("El campo de repetir contraseña tiene que ser igual a la contraseña.");
    	}
    	
    	return isOk;
    }
});

App.controller('UsuarioModificarController', function($scope, $location, $routeParams) {
	$scope.files = {};
	$scope.tituloPagina = "Modificar datos del usuario";
	$scope.objUsuario = {};
	
	//$routeParams.pidUsuario
	
	$scope.cancelar = function(){
		$location.path('/');
	}

	$scope.guardar = function() {
		$location.path('/iniciar-sesion');
	}
});