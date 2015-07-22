'use strict';

var PrototipoProgium = {};
var _ScopeContainer = {};
var App = angular.module('PrototipoProgium', ['PrototipoProgium.services', 'ngRoute', 'angular-md5', 'angularFileUpload']);

App.controller('MainController', function($scope, $route, $routeParams, $location) {
     $scope.esAdministrador = true;
     
     //Almacenar MainController Scoper para cambiar las variables desde otros scopes
     _ScopeContainer['MainController'] = $scope;
})

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
		.otherwise({
        	redirectTo: '/iniciar-sesion'
		});
});