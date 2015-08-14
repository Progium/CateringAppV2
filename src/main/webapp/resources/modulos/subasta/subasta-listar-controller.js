'use strict';

/**
 * SubastaListarController
 * 
 */

App.controller('SubastaListarController', function($scope, $http, $location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		
		_ScopeContainer['MainController'].esAdministrador = true;	
		$scope.mostrarBoton = false;
		$scope.tituloPagina = "Listar subasta";
		$scope.subastaLista = [];
		
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objSubasta = {};
		$scope.objSubasta.pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaSubasta(pageNo);
			$scope.currentPage = pageNo;
		};
	   
		$scope.init = function() {  	
	    	//Obtiene la lista de caterings
			 $scope.ObtenerListaSubasta($scope.currentPage);
			
	    };
	 	   
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaSubasta = function(pageNumber){
	    	$scope.objSubasta.pageNumber = pageNumber;
	    	$http.post('rest/protected/subasta/getSubastaLista', $scope.objSubasta)
			.success(function(subastaResponse) {
				$scope.cantResult = subastaResponse.subastas.length;
				$scope.subastaLista = subastaResponse.subastas;
				$scope.totalItems = subastaResponse.totalElements;
	    	});
	    };	
	    
	    $scope.init();
	    
	    $scope.openModalDetalleSubasta = function(subastaSelec){
	
		   var modalInstance = $modal.open({
			   templateUrl: 'modulos/subasta-mostrar-detalle',
			   controller: ModalInstanceViewDetalleSubastaCtrl,
			   resolve:{
				   param: function() {
					   var obj ={};
					   obj.id = subastaSelec.idSubasta;
					   obj.nombre= subastaSelec.nombre;
					   obj.fechaEvento = subastaSelec.fechaEvento;
					   obj.cantidadPersonas = subastaSelec.cantidadPersonas;
					   obj.montoMaximo = subastaSelec.montoMaximo;
					   obj.descripcion = subastaSelec.descripcion;
					   obj.idTipo = subastaSelec.idTipo;
					   obj.nombreTipoEvento = subastaSelec.nombreTipoEvento;
					   obj.estado = subastaSelec.estado;
					   var param = obj;
				   return param;
				   }
			   }
			});      
		 };
	
		 //Funcion que muestra el detalle de una subasta determinado
	    var ModalInstanceViewDetalleSubastaCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){			   
			$scope.subasta = {};
			$scope.onError = false;
				
			$scope.init = function(){
				$scope.subasta.idSubasta = param.idSubasta;
				$scope.subasta.nombre = param.nombre;
				$scope.subasta.descripcion = param.descripcion;
 				$scope.subasta.idTipoEvento = param.idTipoEvento;
				$scope.subasta.nombreTipoEvento = param.nombreTipoEvento;
				$scope.subasta.fechaEvento = param.fechaEvento;
				$scope.subasta.cantidadPersonas = param.cantidadPersonas;
 				$scope.subasta.montoMaximo = param.montoMaximo;
 				
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

App.controller('SubastaClienteListarController', function($scope, $http, $location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		
		_ScopeContainer['MainController'].esAdministrador = false;	
		$scope.mostrarBoton = true;
		
		$scope.tituloPagina = "Mis subasta";
		$scope.subastaLista = [];
		
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objSubasta = {};
		$scope.objSubasta.pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaSubasta(pageNo);
			$scope.currentPage = pageNo;
		};
	   
		$scope.init = function() {  	
	    	//Obtiene la lista de caterings
			 $scope.ObtenerListaSubasta($scope.currentPage);
			
	    };
	 	   
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaSubasta = function(pageNumber){
	    	$scope.objSubasta.pageNumber = pageNumber;
	    	$http.post('rest/protected/subasta/getSubastaByUsuario', $scope.objSubasta)
			.success(function(subastaResponse) {
				$scope.cantResult = subastaResponse.subastas.length;
				$scope.subastaLista = subastaResponse.subastas;
				$scope.totalItems = subastaResponse.totalElements;
	    	});
	    };	
	    
	    $scope.init();
	    
	    $scope.registrar = function() {
	    	$location.path('/subasta-registrar');
	    };
	    
	    $scope.openModalDetalleSubasta = function(subastaSelec){
	
		   var modalInstance = $modal.open({
			   templateUrl: 'modulos/subasta-mostrar-detalle',
			   controller: ModalInstanceViewDetalleSubastaCtrl,
			   resolve:{
				   param: function() {
					   var obj ={};
					   obj.id = subastaSelec.idSubasta;
					   obj.nombre= subastaSelec.nombre;
					   obj.fechaEvento = subastaSelec.fechaEvento;
					   obj.cantidadPersonas = subastaSelec.cantidadPersonas;
					   obj.montoMaximo = subastaSelec.montoMaximo;
					   obj.descripcion = subastaSelec.descripcion;
					   obj.idTipo = subastaSelec.idTipo;
					   obj.nombreTipoEvento = subastaSelec.nombreTipoEvento;
					   obj.estado = subastaSelec.estado;
					   var param = obj;
				   return param;
				   }
			   }
			});      
		 };
	
		 //Funcion que muestra el detalle de una subasta determinado
	    var ModalInstanceViewDetalleSubastaCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){			   
			$scope.subasta = {};
			$scope.onError = false;
				
			$scope.init = function(){
				$scope.subasta.idSubasta = param.idSubasta;
				$scope.subasta.nombre = param.nombre;
				$scope.subasta.descripcion = param.descripcion;
 				$scope.subasta.idTipoEvento = param.idTipoEvento;
				$scope.subasta.nombreTipoEvento = param.nombreTipoEvento;
				$scope.subasta.fechaEvento = param.fechaEvento;
				$scope.subasta.cantidadPersonas = param.cantidadPersonas;
 				$scope.subasta.montoMaximo = param.montoMaximo;
 				
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