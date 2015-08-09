'use strict';

/**
 * UsuarioOlvidarContrasennaController
 * 
 * @constructor
 */

App.controller('UsuarioOlvidarContrasennaController', function($scope, $http, $location, services) {
	$scope.tituloPagina = "Olvidar Contraseña";
	
	$scope.cancelar = function(){
		$location.path('/iniciar-sesion');
	}
	
	//enviar el correo al controlador
	$scope.olvidoContrasenna = function() {
		if(this.frmOlvidoContrasenna.$valid){
			var datosUsuario = {};
			datosUsuario = {
					correo: $scope.objUsuario.correo
			}
			
			$http.post('rest/protected/usuario/olvidoContrasenna', datosUsuario).success(function (baseResponse){
				if(baseResponse.code == 200){
					services.noty('Se ha enviado una nueva contraseña al correo que usted ha proporcionado', 'success');
					$location.path('/iniciar-sesion');
				}else{
					services.noty('El correo proporcionado no existe', 'error');
				}
			})
			.error(function(baseResponse){
				services.noty('El correo proporcionado no existe', 'error');
			});
					
		}
		
	};
});

