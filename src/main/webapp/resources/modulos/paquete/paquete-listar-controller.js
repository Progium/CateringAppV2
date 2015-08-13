'use strict';

/**
 * PaqueteListarController
 * @constructor
 */
App.controller('PaqueteListarController', function($scope, $http,$location, $upload, services) {
    
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
	    	
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
	
});

