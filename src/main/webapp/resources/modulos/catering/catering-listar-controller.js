'use strict';

/**
 * CateringListarController
 * @constructor
 */
App.controller('CateringListarController', function($scope, $http,$location, $upload, $routeParams, $modal) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		$scope.files = {};
		$scope.tituloPagina = "Listar catering";
		$scope.cateringLista = [];
		$scope.listaProvincia = [];
		var datosUsuario = {
				idAdministrador : objUsuario.idUsuario
		}

		
		
	    $scope.init = function() {
	    	//Obtiene la lista de caterings
			$http.get('rest/protected/catering/getCaterigLista')
			.success(function(cateringResponse) {
				$scope.cateringLista = cateringResponse.caterings;	
			
			});	
			
	    };
	    
	    $scope.init();
		}
	    
	    $scope.registrar = function() {
			$location.path('/catering-registrar');
	    }
	    
	    $scope.modificar = function(idCatering) {
			$location.path('/catering-modificar/'+idCatering);
	    }
	    
	    $scope.openModal = function(cateringSelec){

	 	   var modalInstance = $modal.open({
	 		   templateUrl: 'modulos/catering-mostrar-detalle',
	 		   controller: ModalInstanceViewCtrl,
	 		   resolve:{
	 			   param: function() {
	 				   var obj ={};
	 				   obj.nombre= cateringSelec.nombre;
	 				   obj.cedulaJuridica = cateringSelec.cedulaJuridica;
	 				   obj.direccion = cateringSelec.direccion;
	 				   obj.telefono1 = cateringSelec.telefono1;
	 				   obj.telefono2 = cateringSelec.telefono2;
	 				   obj.horario = cateringSelec.horario;
	 				   obj.fotografia = cateringSelec.fotografia;
	 				  obj.provinciaId = cateringSelec.provinciaId;
	 				  obj.cantonId = cateringSelec.cantonId;
	 				 obj.distritoId = cateringSelec.distritoId;
	 				obj.tipoEvento = cateringSelec.tipoEvento;
	 				   var param = obj;
	 			   return param;
	 			   }
	 		   }
	 	   	});
	 	      
	    };
	   
	    var ModalInstanceViewCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){
	    	
			$scope.catering = {};
			$scope.mostrarImagen = false;
			$scope.onError = false;
			var provincia;
			var canton;
			var distrito;
			
			$scope.init = function(){
				$scope.catering.nombre = param.nombre;
				$scope.catering.cedula = param.cedulaJuridica;
				$scope.catering.telefono1 = param.telefono1 + (param.telefono2 != null ? " / " + param.telefono2: "");
				$scope.catering.horario = param.horario;
				$scope.catering.provinciaId = param.provinciaId;
				$scope.catering.cantonId = param.cantonId;
				$scope.catering.distritoId = param.distritoId;
				$scope.catering.tipoEvento = param.tipoEvento;
				$scope.catering.fotografia = param.fotografia;
				if(param.fotografia){
					$scope.mostrarImagen = true;
				}
				
				//Obtiene los tipos de eventos
				$http.post('rest/protected/tipo/getTipo', param)
				.success(function(tipoResponse) {
					$scope.listaTipoEvento = tipoResponse.tipos;
				});
				
				//Obtiene los tipos de eventos
				$http.post('rest/protected/provincia/getProvincia', param)
				.success(function(ProvinciaResponse) {
					provincia = ProvinciaResponse.provincia.nombre;
					console.log(provincia);
				});
				
				//Obtiene los tipos de eventos
				$http.post('rest/protected/canton/getCanton', param)
				.success(function(CantonResponse) {
					canton = CantonResponse.canton.nombre;
				});
				
				//Obtiene los tipos de eventos
				$http.post('rest/protected/distrito/getDistrito', param)
				.success(function(DistritoResponse) {
					distrito = DistritoResponse.distrito.nombre;
					$scope.catering.direccion = provincia + ", " + canton + ", " + distrito + ", " + param.direccion;
				});
	
			};
			
			$scope.init();
			
			
			$scope.cancel = function(){
				$modalInstance.dismiss('cancel');
			};
	   };	   
	
	
});