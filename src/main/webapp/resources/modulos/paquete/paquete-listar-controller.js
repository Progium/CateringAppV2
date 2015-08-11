'use strict';

/**
 * PaqueteListarController
 * @constructor
 */
App.controller('PaqueteListarController', function($scope, $http,$location, $upload, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		
		$scope.listaCaterings = [];
		$scope.listaCategoria = [];
		$scope.objPaquete = {
				cantidadPersonas : 1
		};
			
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
	    	//Obtiene todos los paquetes
	    	if($scope.criterioBusqueda == 0){
		    	$http.post('rest/protected/paquete/getAll', $scope.objPaquete).success(function (contractPaqueteResponse){
					$scope.cantResult = contractPaqueteResponse.paquetes.length;
					$scope.paqueteLista = contractPaqueteResponse.paquetes;	
					$scope.totalItems = contractPaqueteResponse.totalElements;
				});
		    	
	    	}	
	    };	 	    
	   
	    	$scope.init();
		  
		 	    $scope.registrar = function() {
		 			$location.path('/paquete-registrar');
		 	    };
	};
	
});
		
		/*$scope.init = function() {	
			//Lista de caterings del administrador en sesión
			$http.get('rest/protected/catering/getCaterigLista')
			.success(function(cateringResponse){
				$scope.listaCaterings = cateringResponse.caterings;
				$scope.objPaquete.idCatering = $scope.listaCaterings[0].idCatering
				//Obtiene los tipos de eventos
				$http.post('rest/protected/tipo/getTipo', $scope.listaCaterings[0])
				.success(function(tipoResponse) {
					$scope.listaTipoEvento = tipoResponse.tipos;
					$scope.objPaquete.idTipoEvento = $scope.listaTipoEvento[0].idTipo
				});
			});
			//Lista de categorias
			$http.get('rest/protected/categoria/getAll')
			.success(function(categoriaResponse){
			  $scope.listaCategorias = categoriaResponse.categorias;
			  $scope.objPaquete.idCategoria = $scope.listaCategorias[0].idCategoria;
			 
		  });
			
		};
		    
	    $scope.init();
	    
		//Trae los tipos de evento del catering seleccionado
	    $scope.llenarTipoEvento = function() {
	    	//Agrega los datos del catering seleccionado en el select de lista de caterings
	    	var catering = _.where($scope.listaCaterings, {idCatering: $scope.objPaquete.idCatering});
			//Obtiene los tipos de eventos
			$http.post('rest/protected/tipo/getTipo', catering[0])
			.success(function(tipoResponse) {
				$scope.listaTipoEvento = tipoResponse.tipos;
				$scope.objPaquete.idTipoEvento = $scope.listaTipoEvento[0].idTipo
			});
	    };
			
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}*/
