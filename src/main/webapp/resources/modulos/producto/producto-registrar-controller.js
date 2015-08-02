'use strict';

/**
 * ProductoRegistrarController
 * @constructor
 */
App.controller('ProductoRegistrarController', function($scope,$http, $modal) {
   
	$scope.productos  = [];
	$scope.productosSelecc  = [];
	var listaProductos = [];
	$scope.objCategoria = {};
	$scope.listaCategorias = [];
	$scope.init = function(){
		var usuario = $.jStorage.get("user");
		
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
		$scope.productos = _.where(listaProductos, {categoria: $scope.objCategoria.idCategoria})
		$scope.objCategoria.idCategoria =  $scope.listaCategorias[0].idCategoria;	
		
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
   
   var ModalInstanceModifyCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){
	   	$scope.requestObject = {};
		$scope.requestObject.catalogo = {};
		$scope.productoSelec= {};
		$scope.idCaterings = [];
		$scope.listaCatering = [];
		$scope.catering= [];
		$scope.onError = false;
		$scope.files= {};
		
		$scope.init = function(){
			
			$scope.requestObject.catalogo = param.idUsuario;	
			$scope.productoSelec.idProducto = param.idProducto;
			$scope.productoSelec.nombre = param.nombre;
			$scope.
			
			//$http.get('rest/protected/catering/getAll')
			// .success(function(response){
				$scope.listaCatering = 1;
				$scope.precio = 3000;
					//response.catering;
				//});
			
		};
		
		$scope.init();
		
		$scope.create = function(){
			if(this.registroCatalogo.$valid){
				this.onError = false;
				var productoFoto = $scope.files[0];
				var datosProducto = {};
				datosProducto ={
						cateringId: $scope.listaCatering,
						productoId: $scope.productoSelec.idProducto,
						precio: $scope.precio
						
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
								
								$modalInstance.close();
							});
						
						}else{
							$modalInstance.close(); 
						}
					}
				});
			}else{
				this.onError = true;
			}
		};
		$scope.cancel = function(){
			$modalInstance.dismiss('cancel');
		};
   };
   
});