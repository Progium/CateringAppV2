'use strict';

/**
 * SubastaRegistrarController
 * @constructor
 */

App.controller('SubastaRegistrarController', function($scope, $http, $location, services) {
	var objUsuario = $.jStorage.get("user");
	
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = false;	
		$scope.objSubasta = {};
		var nombre= objUsuario.nombre;
		$scope.objSubasta.nombre = nombre;
		$scope.tituloPagina = "Crear Subasta";
		$scope.listaTipoEvento = [];
		$scope.init = function(){
			$http.get('rest/protected/tipo/getTipoEvento')
			.success(function(tipoResponse) {
				$scope.listaTipoEvento = tipoResponse.tipos;
				$scope.objSubasta.idTipo = $scope.listaTipoEvento[0].idTipo;
			});
	   };
	     
	   $scope.init();
	    
		$scope.create = function(){
			if(this.crearSubasta.$valid){
				this.onError = false;
				var datosSubasta = {};
				datosSubasta ={
						nombre: $scope.objSubasta.nombre, 
						tipoId: $scope.objSubasta.idTipo,
						fechaEvento: $scope.objSubasta.fechaEvento,
						cantidadPersonas: $scope.objSubasta.CantPersonas,
						descripcion: $scope.objSubasta.descripcion,
						montoMaximo: $scope.objSubasta.montoMaximo,
						clienteId: objUsuario.idUsuario
				}
				$http.post('rest/protected/subasta/create', datosSubasta)
				.success(function(response){
					if(response.code===200){
						services.noty('Se ha registrado la subasta', 'success');
						$location.path('/subasta-cliente-listar');
					}else{
						services.noty('error al crear la subasta', 'error');			
					}				
				});				
			};
		};	
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
	
});