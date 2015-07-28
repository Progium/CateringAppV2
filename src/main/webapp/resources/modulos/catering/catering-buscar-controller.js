'use strict';

/**
 * CateringBuscarController
 * @constructor
 */
App.controller('CateringBuscarController', function($scope, $http,$location, $upload, $routeParams) {
	 _ScopeContainer['MainController'].esAdministrador = false;
	 var objUsuario = $.jStorage.get("user");
		if(objUsuario){
			_ScopeContainer['MainController'].esAdministrador = true;	
			$scope.files = {};
			$scope.tituloPagina = "Listar catering";
			$scope.cateringLista = [];

		    $scope.init = function() {
		    	
				console.log("entre");
				//Obtiene la lista de caterings
				$http.get('rest/protected/catering/getAll')
				.success(function(cateringResponse) {
					$scope.cateringLista = cateringResponse.caterings;
					console.log($scope.cateringLista);
					//$scope.objCatering.idCatering = $scope.cateringLista[0].idCatering;	
				
				});	
				
		    };
		    
		    $scope.init();
			}
		   
});