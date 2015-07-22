'use strict';

/**
 * IniciarSesionController
 * @constructor
 */

App.controller('IniciarSesionController', function($scope, $http,  $location, md5) {
  $scope.user = {correo:"", contrasenna:""};
  $scope.mostrarMensaje = false;
  $scope.init = function() {
  };

  $scope.init();

  $scope.iniciarSesion = function() {
	
	  $http.post('rest/iniciarsesion/verificarusuario', $scope.user).success(function (iniciarSesionResponse){
		  if(iniciarSesionResponse.code == 200){
			  var usuario = {'idUsuario': iniciarSesionResponse.idUsuario,
					         'apellido1': iniciarSesionResponse.apellido1,
					         'apelido2':iniciarSesionResponse.apelido2,
					         'correo': iniciarSesionResponse.correo,
					         'fotografia': iniciarSesionResponse.fotografia,
					         'nombre':iniciarSesionResponse.nombre,
					         'tipo':iniciarSesionResponse.tipo
			  				};
			  $.jStorage.set("user", usuario);
			  if (iniciarSesionResponse.tipo === 1){
				  //va al menu de cliente
				  var path = "/catering/app#/catering-buscar";
				  window.location.href = path;
			  }else{
				  //va al menu administrador
				  var path = "/catering/app#/catering-registrar";
				  window.location.href = path;
			  }

		  }else{
			  $scope.mostrarMensaje = true;
		  }
	  })
 
  };
});