'use strict';

/**
 * ProductoRegistrarController
 * @constructor
 */
App.controller('ProductoRegistrarController', function($scope,$http, $modal) {
   
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		$scope.productos  = [];
		$scope.productosSelecc  = [];
		var listaProductos = [];
		$scope.objCategoria = {};
		$scope.listaCategorias = [];
		$scope.init = function(){
			//var usuario = $.jStorage.get("user");
			
			$http.get('rest/protected/categoria/getAll')
			  .success(function(response){
				  $scope.listaCategorias= response.categorias;
				  $scope.objCategoria.idCategoria = $scope.listaCategorias[0].idCategoria;
				 
			  });
			
			$http.get('rest/protected/producto/getAll')
			  .success(function(response){
				  listaProductos = response.productos;  
				  $scope.productos = _.where(listaProductos, {categoria: $scope.objCategoria.idCategoria})
			  });
			
	   };
	   
	   $scope.cargarProducto = function() {
	   	$scope.productos.length = 0;
			$scope.productos = _.where(listaProductos, {categoria: $scope.objCategoria.idCategoria});
			
	   };
	   
	   
	   $scope.init();
	   $scope.seleccionado = function(item, type){
	       if (type == 'agregar'){
	    	   $scope.productosSelecc.push(item);
	    	   $scope.productos.splice($scope.productos.indexOf(item), 1);
	       } 
	   };
	   
	   $scope.removido = function(item, type){
	       if (type == 'removido'){
	    	   $scope.productos.push(item);
	    	   $scope.productosSelecc.splice($scope.productosSelecc.indexOf(item), 1);
	       } 
	   };
	  
	   $scope.openModal = function(productoSelec){

		   var modalInstance = $modal.open({
			   templateUrl: 'modulos/producto-agregar',
			   controller: ModalInstanceModifyCtrl,
			   resolve:{
				   param: function() {
					   var usuario = $.jStorage.get("user")
					   var obj ={};
					   obj.idUsuario= usuario.idUsuario;
					   obj.idProducto = productoSelec.idProducto;
					   obj.nombre = productoSelec.nombre;
					   var param = obj;
				   return param;
				   }
			   }
		   	});
		      
	   };
	   
	   var ModalInstanceModifyCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param, services){
		   	$scope.requestObject = {};
			$scope.requestObject.catalogo = {};
			$scope.productoSelec= {};
			$scope.idCaterings = [];
			$scope.listaCatering = [];
			$scope.catering= [];
			$scope.onError = false;
			$scope.files= {};
			$scope.objCatalogo = {};
			
			$scope.init = function(){
				
				$scope.requestObject.catalogo = param.idUsuario;	
				$scope.productoSelec.idProducto = param.idProducto;
				$scope.productoSelec.nombre = param.nombre;
				
				
			$http.get('rest/protected/catering/getCaterigLista')
			.success(function(response){
				$scope.listaCatering = response.caterings;
			});
				
			};
			
			$scope.oncateringSeleccionadoChanged = function(catering, checked){
				if(checked){
					$scope.idCaterings.push(catering.idCatering);
				}else{
					$scope.idCaterings.splice($scope.idCaterings.indexOf(catering.idCatering), 1);
				}
			};
			
			$scope.init();
			
			$scope.create = function(){
				if(validarDatos($scope.idCaterings) && this.registroCatalogo.$valid){
					this.onError = false;
					var productoFoto = $scope.files[0];
					var datosProducto = {};
					datosProducto ={
							cateringId: $scope.idCaterings,
							productoId: $scope.productoSelec.idProducto,
							precio: parseFloat($scope.objCatalogo.precio)
							
					}
					$http.post('rest/protected/catalogo/create', datosProducto)
					.success(function(response){
						if(response.code===200){
							if(productoFoto){
								$scope.upload = $upload.upload({
									url : 'rest/protected/catalogo/subirFoto',
									data : {
										idCatalogo: response.idCatalogo
									},
									file : productoFoto
								}).success(function(response, status, headers, config) {
									if(response.code===200){
										services.noty('Se añadio el producto al catálogo', 'success');
										$modalInstance.close();
									}else{
										services.noty('No se añadio la fotografía del producto', 'error');
										$modalInstance.close();
									}
									
									
								});
							
							}else{
								services.noty('Se añadio el producto al catálogo', 'success');
								$modalInstance.close(); 
							}
						}
					});
				}				
				//}else{
				//	services.noty('Error al añadir el producto al catálogo', 'error');
				//	this.onError = true;
				//}
			};
			
		    function validarDatos(cateringSeleccionados){
		    	var isOk = true;
		    	if(cateringSeleccionados == ""){
		    		isOk = false;
		    		services.noty('Debe seleccionar al menos un catering para registrar el producto a un catálogo.', 'warning');
		    	}
		    	
		    	return isOk;
		    }
			$scope.cancel = function(){
				$modalInstance.dismiss('cancel');
			};
	   };
	   
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
	
   
});