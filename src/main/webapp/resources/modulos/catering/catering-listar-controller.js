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
				console.log($scope.cateringLista);
				//$scope.objCatering.idCatering = $scope.cateringLista[0].idCatering;	
			
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

	    	console.log(cateringSelec);
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
			
			$scope.init = function(){
				console.log("entre al modal");
				console.log(param);
				$scope.catering.nombre = param.nombre;
				$scope.catering.cedula = param.cedulaJuridica;
				$scope.catering.direccion = param.direccion;
				$scope.catering.telefono1 = param.telefono1;
				$scope.catering.telefono2 = param.telefono2;
				$scope.catering.horario = param.horario;
				$scope.catering.idProvincia = param.provinciaId;
				$scope.catering.idCanton = param.cantonId;
				$scope.catering.idDistrito = param.distritoId;
				$scope.catering.tipoEvento = param.tipoEvento;
				$scope.catering.fotografia = param.fotografia;
				if(param.fotografia){
					$scope.mostrarImagen = true;
				}
				
				//Obtiene los tipos de eventos
				$http.post('rest/protected/tipo/getTipo', param.tipoEvento)
				.success(function(tipoResponse) {
					$scope.listaTipoEvento = tipoResponse.tipos;
				});
		    	
		    	//Obtiene la lista de provincias
		    	$http.get('rest/protected/provincia/getAll')
				.success(function(provinciaResponse) {
					$scope.listaProvincia = provinciaResponse.listaProvincia;
				});
		    	
		    	//Obtiene la lista de cantones
		    	$http.get('rest/protected/canton/getAll')
				.success(function(cantonResponse) {
					listaCantones = cantonResponse.listaCanton;
					$scope.listaCanton = _.where(listaCantones, {provincia:$scope.objCatering.idProvincia})	
				});
		    	
		    	//Obtiene la lista de distritos
		    	$http.get('rest/protected/distrito/getAll')
				.success(function(distritoResponse) {
					listaDistritos = distritoResponse.listaDistrito;
					$scope.listaDistrito =_.where(listaDistritos, {canton: $scope.objCatering.idCanton});
				});

			};
			
			$scope.init();
			
			$scope.cancel = function(){
				$modalInstance.dismiss('cancel');
			};
	   };	   
	
	
});