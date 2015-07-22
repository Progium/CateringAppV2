'use strict';

var PrototipoProgium = {};
var _ScopeContainer = {};
var App = angular.module('PrototipoProgium', ['PrototipoProgium.services', 'ui.bootstrap', 'ngRoute', 'angularFileUpload']);

App.controller('MainController', function($scope, $http, $route, $routeParams, $location) {
     $scope.esAdministrador = true;
     
     //Almacenar MainController Scoper para cambiar las variables desde otros scopes
     _ScopeContainer['MainController'] = $scope;
     
     $scope.cerrarSesion = function() {
     	  $http.post('rest/iniciarsesion/setusuario').success(function (){
     		 $.jStorage.flush();
   			  window.location.href = "/catering/#/iniciar-sesion";
     	  });
     	};
});

App.config(function($routeProvider, $locationProvider) {
  	$routeProvider
	  	.when('/iniciar-sesion', {
			templateUrl: 'modulos/seguridad-iniciar-sesion',
			controller: 'IniciarSesionController'
		})
		.when('/usuario-registrar', {
			templateUrl: 'modulos/seguridad-usuario-admin',
			controller: 'UsuarioRegistrarController'
		})
		.when('/usuario-modificar/:pidUsuario', {
			templateUrl: 'modulos/seguridad-usuario-admin',
			controller: 'UsuarioModificarController'
		})
		.when('/catering-registrar', {
			templateUrl: 'modulos/catering-admin',
			controller: 'CateringRegistrarController'
		})
		.when('/catering-modificar/:pidCatering', {
			templateUrl: 'modulos/catering-admin',
			controller: 'CateringModificarController'
		})
		.when('/catering-listar', {
			templateUrl: 'modulos/catering-listar',
			controller: 'CateringListarController'
		})
		.when('/catering-buscar', {
			templateUrl: 'modulos/catering-buscar',
			controller: 'CateringBuscarController'
		})
		.when('/producto-registrar', {
			templateUrl: 'modulos/producto-registrar',
			controller: 'ProductoRegistrarController'
		})
		.when('/producto-agregar', {
			templateUrl: 'modulos/producto-agregar',
			controller: 'ModalInstanceModifyCtrl'
		})
		.when('/cotizacion-registrar', {
			templateUrl: 'modulos/cotizacion-registrar',
			controller: 'CotizacionRegistrarController'
		})
		.when('/paquete-registrar', {
			templateUrl: 'modulos/paquete-registrar',
			controller: 'PaqueteRegistrarController'
		})
		.when('/paquete-listar', {
			templateUrl: 'modulos/paquete-listar',
			controller: 'PaqueteListarController'
		})
		.when('/subasta-registrar', {
			templateUrl: 'modulos/subasta-registrar',
			controller: 'SubastaRegistrarController'
		})
		.when('/subasta-listar', {
			templateUrl: 'modulos/subasta-listar',
			controller: 'SubastaListarController'
		})
		.when('/no-encontrado', {
			templateUrl: 'modulos/no-encontrado',
			controller: 'CompartidoController'
		})
		.otherwise({
        	redirectTo: '/no-encontrado'
		});	
  	
});