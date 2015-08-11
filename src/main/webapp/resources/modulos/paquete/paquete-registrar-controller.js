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
		$scope.listaCatalogos = [];
		$scope.listaProductos = [];
		$scope.objProducto = [];
		$scope.objPaquete = {
				cantidadPersonas : 1
		};
		$scope.objCatalogoProducto = {};
		var caterings = [];
		
		$scope.init = function() {	
			//Lista de caterings del administrador en sesión
			$http.get('rest/protected/catering/getCaterigLista')
			.success(function(cateringResponse){
				$scope.listaCaterings = cateringResponse.caterings;
				$scope.objPaquete.idCatering = $scope.listaCaterings[0].idCatering;
				//Obtiene los tipos de eventos
				$http.post('rest/protected/tipo/getTipo', $scope.listaCaterings[0])
				.success(function(tipoResponse) {
					$scope.listaTipoEvento = tipoResponse.tipos;
					$scope.objPaquete.idTipoEvento = $scope.listaTipoEvento[0].idTipo;
				});
				
				//Lista de categorias
				$http.get('rest/protected/categoria/getAll')
				.success(function(categoriaResponse){
					$scope.listaCategorias = categoriaResponse.categorias;
					$scope.objPaquete.idCategoria = $scope.listaCategorias[0].idCategoria;
				});
				
				caterings[0] = $scope.objPaquete.idCatering;
				$scope.objCatalogoProducto.cateringId = caterings;
				//Obtiene los productos del catalogo del catering seleccionado y la categoria
				$http.post('rest/protected/catalogo/getCatalogoByCatering', $scope.objCatalogoProducto)
				.success(function(CatalogoResponse) {
					var i = 0;
	
					$scope.listaCatalogos = CatalogoResponse.catalogos;
					
					var j = $scope.listaCatalogos.length;
					
					for (i = 0; i <= $scope.listaCatalogos.length-1; i++) {
						var objProd = {};
						objProd.idProducto = $scope.listaCatalogos[i].productoId;
						objProd.precio = $scope.listaCatalogos[i].precio; 
						//Guarda en un objeto producto los datos de ese producto
						$scope.objProducto.push(objProd);
						$http.post('rest/protected/producto/getProducto', objProd)
						.success(function(productoResponse){
							j--;
							$scope.objProducto[j].nombre = productoResponse.producto.nombre;
							$scope.objProducto[j].categoria = productoResponse.producto.categoria;
							if(j == 0){
								$scope.listaProductos = _.where($scope.objProducto, {categoria: $scope.objPaquete.idCategoria});
							}
						});
					}

					
				});
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
			
			$scope.llenarCatalogoProducto(catering[0].idCatering);
	    };
		
		//Trae el catalogo del producto del catering seleccionado
	    $scope.llenarCatalogoProducto = function(idCatering) {
	    	//Cuando se cambia de catering selecciona de nuevo la primer categoria
	    	$scope.objPaquete.idCategoria = $scope.listaCategorias[0].idCategoria;
	    	caterings[0] = idCatering;
			$scope.objCatalogoProducto.cateringId = caterings;
			//Obtiene los productos del catalogo del catering seleccionado y la categoria
			$http.post('rest/protected/catalogo/getCatalogoByCatering', $scope.objCatalogoProducto)
			.success(function(CatalogoResponse) {
				var i = 0;

				$scope.listaCatalogos = CatalogoResponse.catalogos;
				
				var j = $scope.listaCatalogos.length;
				
				for (i = 0; i <= $scope.listaCatalogos.length-1; i++) {
					var objProd = {};
					objProd.idProducto = $scope.listaCatalogos[i].productoId;
					objProd.precio = $scope.listaCatalogos[i].precio; 
					//Guarda en un objeto producto los datos de ese producto
					$scope.objProducto.push(objProd);
					$http.post('rest/protected/producto/getProducto', objProd)
					.success(function(productoResponse){
						j--;
						$scope.objProducto[j].nombre = productoResponse.producto.nombre;
						$scope.objProducto[j].categoria = productoResponse.producto.categoria;
						if(j == 0){
							$scope.listaProductos = _.where($scope.objProducto, {categoria: $scope.objPaquete.idCategoria});
						}
					});
				}
			});
	    	
	    };
	    
		//Trae el producto de la categoria seleccionada
	    $scope.llenarProducto = function() {
	    	$scope.listaProductos.length = 0;
	    	$scope.listaProductos = _.where($scope.objProducto, {categoria: $scope.objPaquete.idCategoria});
	    };
	    //Selecciona los productos
	    $scope.seleccionado = function(item){
	    	console.log(item);
	    };
		   
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});