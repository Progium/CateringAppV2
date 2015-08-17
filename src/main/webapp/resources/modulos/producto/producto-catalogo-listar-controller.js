'use strict';

/**
 * ProductoCatalogoListarController
 * @constructor
 */
App.controller('ProductoCatalogoListarController', function($scope, $http,$location, $upload, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		
		$scope.listaCaterings = [];
		$scope.listaCatalogos = [];
		$scope.listaProductos = [];
		$scope.objProducto = [];
		$scope.objPaquete = {
				cantidadPersonas : 1
		};
		$scope.objCatalogoProducto = {};
		$scope.objCatalogoProducto .pageSize = 5;
		$scope.currentPage = 1;
		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			ObtenerListaCatalogo(pageNo);
		};

		var caterings = [];
		
		$scope.init = function() {	
						
			//Lista de caterings del administrador en sesión
			$http.get('rest/protected/catering/getCaterigLista')
			.success(function(cateringResponse){
				$scope.listaCaterings = cateringResponse.caterings;
				$scope.objPaquete.idCatering = $scope.listaCaterings[0].idCatering;				
				caterings[0] = $scope.objPaquete.idCatering;
				$scope.objCatalogoProducto.cateringId = caterings;
				ObtenerListaCatalogo($scope.currentPage);
			});

		};
		    
	    $scope.init();
		
		//Trae el catalogo del producto del catering seleccionado
	    $scope.llenarCatalogoProducto = function() {
	    	caterings[0] = $scope.objPaquete.idCatering;
			$scope.objCatalogoProducto.cateringId = caterings;
			ObtenerListaCatalogo(1);
	    	
	    };
	    
	    //Funcion que obtiene la lista de todos los catalogos de un catering por paginación
	    function ObtenerListaCatalogo(pageNumber){
	    	//inicializa la lista de productos y objeto producto
	    	$scope.listaProductos.length = 0;
	    	$scope.objProducto.length = 0;
			$scope.currentPage = pageNumber;
	    	$scope.objCatalogoProducto.pageNumber = pageNumber;
	    	
			//Obtiene los productos del catalogo del catering seleccionado y la categoria
			$http.post('rest/protected/catalogo/getCatalogoProductoByCatering', $scope.objCatalogoProducto)
			.success(function(catalogoResponse) {
				var i = 0;
				var j = 0;
				var f = 0;
				
				$scope.listaCatalogos = catalogoResponse.catalogos;
				$scope.cantResult = catalogoResponse.catalogos.length;
				$scope.totalItems = catalogoResponse.totalElements;
				
				for (i = 0; i <= $scope.listaCatalogos.length-1; i++) {
					var objProd = {};
					objProd.idProducto = $scope.listaCatalogos[i].productoId;
					objProd.precio = $scope.listaCatalogos[i].precio; 
					objProd.idCatalogoProducto = $scope.listaCatalogos[i].idCatalogoProducto;
					//Guarda en un objeto producto los datos de ese producto
					$scope.objProducto.push(objProd);
					$http.post('rest/protected/producto/getProducto', objProd)
					.success(function(productoResponse){
						for(j = 0; j <=$scope.objProducto.length-1; j++){
							if(productoResponse.producto.idProducto == $scope.objProducto[j].idProducto ){
								$scope.objProducto[j].nombre = productoResponse.producto.nombre;
								$scope.objProducto[j].categoriaId = productoResponse.producto.categoria;
								$scope.objProducto[j].categoriaNombre = productoResponse.producto.nombreCategoria;
							}
						}

						if(f == $scope.listaCatalogos.length-1){
							$scope.listaProductos = $scope.objProducto;
						}
						f++;
					});
				}
			});
	    };	
	    
	    $scope.agregarProducto = function() {
	    	$location.path('/producto-registrar');
	    };
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});