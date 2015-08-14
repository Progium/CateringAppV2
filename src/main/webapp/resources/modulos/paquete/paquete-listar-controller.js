'use strict';

/**
 * PaqueteListarController
 * @constructor
 */
App.controller('PaqueteListarController', function($scope, $http,$location, $upload, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		
		$scope.paquetesLista = [];
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objPaquete = {};
		$scope.objPaquete .pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaPaquetes(pageNo);
			$scope.currentPage = pageNo;
		};
	  
	    $scope.init = function() {
	    	$scope.ObtenerListaPaquetes($scope.currentPage);
	    	
	    };
	    
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaPaquetes = function(pageNumber){
	    	$scope.objPaquete.pageNumber = pageNumber;
	    	$http.post('rest/protected/paquete/getPaqueteByAdministrador', $scope.objPaquete).success(function (contractPaqueteResponse){
				$scope.cantResult = contractPaqueteResponse.paquetes.length;
				$scope.paquetesLista = contractPaqueteResponse.paquetes;
				console.log($scope.paquetesLista);
				$scope.totalItems = contractPaqueteResponse.totalElements;
	    	});
	    };	 	    
	   
	    $scope.init();
	    
	    $scope.registrar = function() {
	    	$location.path('/paquete-registrar');
	    };
	    
	    $scope.openModalDetallePaquete = function(paqueteSelec){
	    	
	    	var modalInstance = $modal.open({
	    		templateUrl: 'modulos/paquete-mostrar-detalle',
	    		controller: ModalInstanceViewDetallePaqueteCtrl,
	    		resolve:{
	    			param: function() {
	    				var obj ={};
	    				obj.idPaquete = paqueteSelec.idPaquete;
	    				obj.nombre= paqueteSelec.nombre;
	    				obj.descripcion = paqueteSelec.descripcion;
	    				obj.idCatering = paqueteSelec.idCatering;
	    				obj.nombreCatering = paqueteSelec.nombreCatering;
	    				obj.idTipoEvento = paqueteSelec.idTipoEvento;
	    				obj.nombreTipoEvento = paqueteSelec.nombreTipoEvento;
	    				obj.cantidadPersonas = paqueteSelec.cantidadPersonas;
	    				obj.precio = paqueteSelec.precio;
		 				obj.descuento = paqueteSelec.descuento;
		 				obj.montoTotal = paqueteSelec.montoTotal;
		 				obj.catalogoProducto = paqueteSelec.catalogoProducto;
		 				var param = obj;
		 				return param;
	    			}
	    		}
	    	}); 	      
	    };
	    
	    //Funcion que muestra el detalle de un paquete determinado
	    var ModalInstanceViewDetallePaqueteCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){
		    				   
			$scope.paquete = {};
			$scope.onError = false;
				
			$scope.init = function(){
				$scope.paquete.idPaquete = param.idPaquete;
				$scope.paquete.nombre = param.nombre;
				$scope.paquete.descripcion = param.nombre;
				$scope.paquete.idCatering = param.idCatering;
				$scope.paquete.nombreCatering = param.nombreCatering;
				$scope.paquete.idTipoEvento = param.idTipoEvento;
 				$scope.paquete.nombreTipoEvento = param.nombreTipoEvento;
 				$scope.paquete.cantidadPersonas = param.cantidadPersonas;
 				$scope.paquete.precio = param.precio;
 				$scope.paquete.descuento = param.descuento;
 				$scope.paquete.montoTotal = param.montoTotal;
 				$scope.paquete.catalogoProducto = param.catalogoProducto;
 				$scope.paquete.total = (param.precio * param.cantidadPersonas);
					
			};
						
			$scope.init();
			
			$scope.cancel = function(){
				$modalInstance.dismiss('cancel');
			};
	   };	   
	    	
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
	
});

