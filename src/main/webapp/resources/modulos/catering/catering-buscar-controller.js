'use strict';

/**
 * CateringBuscarController
 * @constructor
 */
App.controller('CateringBuscarController', function($scope, $http,$location, $upload, $routeParams, $modal, $log) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = false;	
		$scope.files = {};
		$scope.tituloPagina = "Listar catering";
		$scope.cateringLista = [];
		$scope.listaProvincia = [];
		$scope.listaCanton = [];
		$scope.listaTipoEvento = [];
		$scope.listaDistrito = [];
		var listaCantones = [];
		var cantones =  [];
		var listaDistritos = [];
		var distritos =  [];


		//Setear cuantos catering va mostrar por pantalla y el primer número de página
		$scope.objCatering = {};
		$scope.objCatering .pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del catering
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaCatering(pageNo);
			$scope.currentPage = pageNo;
		};

		$scope.maxSize = 5;
		$scope.bigTotalItems = 50;
		$scope.bigCurrentPage = 1;
	  
	    $scope.init = function() {
	    	$scope.ObtenerListaCatering($scope.currentPage);
	    	
	    	//Obtiene los tipos de eventos
	    	$http.get('rest/protected/tipo/getTipoEvento')
			.success(function(tipoResponse) {
				$scope.listaTipoEvento = tipoResponse.tipos;
				$scope.objCatering.idTipoEvento = $scope.listaTipoEvento[0].idTipo;
			});
	    	
	    	//Obtiene la lista de provincias
	    	$http.get('rest/protected/provincia/getAll')
			.success(function(provinciaResponse) {
				$scope.listaProvincia = provinciaResponse.listaProvincia;
				$scope.objCatering.idProvincia = $scope.listaProvincia[0].idProvincia;	
			});
	    	
	    	//Obtiene la lista de cantones
	    	$http.get('rest/protected/canton/getAll')
			.success(function(cantonResponse) {
				listaCantones = cantonResponse.listaCanton;
				$scope.listaCanton = _.where(listaCantones, {provincia:$scope.objCatering.idProvincia})
				$scope.objCatering.idCanton = $scope.listaCanton[0].idCanton;		
			});
	    	
	    	//Obtiene la lista de distritos
	    	$http.get('rest/protected/distrito/getAll')
			.success(function(distritoResponse) {
				listaDistritos = distritoResponse.listaDistrito;
				$scope.listaDistrito =_.where(listaDistritos, {canton: $scope.objCatering.idCanton});
				$scope.objCatering.idDistrito = $scope.listaDistrito[0].idDistrito;
			});
	    	
	    	
	    };
	  	    
	    //Funcion que obtiene la lista de todos los catering por paginación
	    $scope.ObtenerListaCatering = function(pageNumber){
	    	$scope.objCatering.pageNumber = pageNumber;
	    	$http.post('rest/protected/catering/getAll', $scope.objCatering).success(function (contractCateringResponse){
				$scope.cantResult = contractCateringResponse.caterings.length;
				$scope.cateringLista2 = contractCateringResponse.caterings;	
				$scope.totalItems = contractCateringResponse.totalElements;
			});
	    };
	    
	    //Funcion que obtiene lista de catering por localizacion
	    $scope.ObtenerListaCateringPorLocalizacion = function(pageNumber){
	    	$scope.objCatering.pageNumber = pageNumber;
	    	$http.post('rest/protected/catering/getPorLocalización', $scope.objCatering).success(function (contractCateringResponse){
				$scope.cantResult = contractCateringResponse.caterings.length;
				$scope.cateringLista2 = contractCateringResponse.caterings;	
				$scope.totalItems = contractCateringResponse.totalElements;
			});
	    };
	    
	    
	    $scope.init();
	    
	  //Trae los cantones de la provincia seleccionada
	    $scope.llenarCanton = function() {
	    	$scope.listaCanton.length = 0;
			$scope.listaCanton = _.where(listaCantones, {provincia:$scope.$scope.objCatering.idCanton})
			$scope.objCatering.idCanton = $scope.listaCanton[0].idCanton;	
			
			$scope.llenarDistrito();
	    };
	    
		//Trae los distritos del canton seleccionado
	    $scope.llenarDistrito = function() {
	    	$scope.listaDistrito.length = 0;
			$scope.listaDistrito =_.where(listaDistritos, {canton: $scope.objCatering.idCanton});
			$scope.objCatering.idDistrito = $scope.listaDistrito[0].idDistrito;
	    };
	        
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
		
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});