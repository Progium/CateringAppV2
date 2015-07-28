'use strict';

/**
 * CateringListarController
 * @constructor
 */
App.controller('CateringListarController', function($scope, $http,$location, $upload, $routeParams) {
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
	   
	   
	
	
});