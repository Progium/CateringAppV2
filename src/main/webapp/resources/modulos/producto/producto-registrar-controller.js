'use strict';

/**
 * ProductoRegistrarController
 * @constructor
 */
App.controller('ProductoRegistrarController', function($scope,$http, $modal) {
   
	$scope.productos  = [];
	$scope.productosSelecc  = [];
	$scope.init = function(){
		var usuario = $.jStorage.get("user");
		$http.get('rest/protected/producto/getAll')
		  .success(function(response){
			  $scope.productos = response.productos;   
		  });
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
		
		$scope.onError = false;
		
		$scope.init = function(){
			
			$scope.requestObject.catalogo = param.idUsuario;
			
			
//			var requestProducto = {};
//			
//			requestProducto.producto = {};
//			requestProducto.producto.id = param.idProducto;
			
			$scope.productoSelec.idProducto = param.idProducto;
			$scope.productoSelec.nombre = param.nombre;
			/*$http.post('rest/protected/producto/findOne', requestProducto)
			.success(function (response) {
				
			});*/
			
					
//			$http.post('rest/protected/cateing/getAllFromUsuario', $scope.requestObject )
//			.success(function(response) {
//				if(response.code === 200){
//					//$scope.talleresPropietario = response.talleres;
//					//alert(response.codeMessage);
//				} else {
//					//alert(response.errorMessage);
//				}	
//			});
		};
		
		$scope.init();
		
		$scope.create = function(){
			if(this.registroCatalogo.$valid){
				
				this.onError = false;
				$http.post('rest/protected/catalogo/create', $scope.requestObject)
				.success(function(response){
					if(response.code===200){
						if($scope.fileSelected){
							
							var file = $scope.files[0];
							$scope.upload = $upload.upload({
								url : 'rest/protected/catalogo/subirFoto',
								data : {
									idCatalogo: catalogo.idCatalogo
								},
								file : file
							}).success(function(data, status, headers, config) {
								// Rent is uploaded successfully
								$modalInstance.close(); //en caso de no ser modal se haría un redirect
							});
						//.error(...)
						//.then(success, error, progress); 
						}else{
							$modalInstance.close(); //en caso de no ser modal se haría un redirect
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