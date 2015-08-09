'use strict';

/**
 * PaqueteRegistrarController
 * @constructor
 */
App.controller('PaqueteRegistrarController', function($scope, $http,$location, $upload, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		
		$scope.listaCaterings = [];
		$scope.listaCategoria = [];
		$scope.objPaquete = {
				cantidadPersonas : 1
		};
			
		$scope.init = function() {	
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
	}
});