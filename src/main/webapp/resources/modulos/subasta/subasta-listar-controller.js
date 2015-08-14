'use strict';

/**
 * SubastaListarController
 * 
 */

App.controller('SubastaListarController', function($scope, $http, $location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		
		_ScopeContainer['MainController'].esAdministrador = true;	
		
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
				console.log($scope.subastaLista);
				$scope.totalItems = subastaResponse.totalElements;
	    	});
	    };	
	    
	    $scope.init();
	    
	    $scope.openModal = function(subastaSelec){
	
		 	   var modalInstance = $modal.open({
		 		   templateUrl: 'modulos/subasta-mostrar-detalle',
		 		   controller: ModalInstanceViewCtrl,
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
		 				   obj.nombreTipo = subastaSelec.nombreTipo;
		 				   obj.estado = subastaSelec.estado;
		 				   var param = obj;
		 			   return param;
		 			   }
		 		   }
		 	   	});      
		 };
	

	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});