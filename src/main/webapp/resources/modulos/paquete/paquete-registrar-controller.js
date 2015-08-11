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
				cantidadPersonas : 1,
				descuento : 0
		};
		$scope.objCatalogoProducto = {};
		$scope.total = 0;
		
		var sumaProducto = 0;
		var descuento = 0;
		var montoDescuento = 0;
		$scope.productosSelecc = [];
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
	    	//inicializa la lista de productos y objeto producto
	    	$scope.listaProductos.length = 0;
	    	$scope.objProducto.length = 0;
	    	//Inicializa de nuevo los montos a 0
			$scope.total = 0;
			sumaProducto = 0;
			descuento = 0;
			montoDescuento = 0;
	    	$scope.objPaquete.precio = 0;
	    	$scope.objPaquete.montoTotal =  0;
	    	
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
						$scope.objProducto[j].done = 1;
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
	    
	    //Selecciona los productos y los suma
	    $scope.productoSeleccionado = function(producto){
	    	if(producto.done == 2){
	    		$scope.productosSelecc.push(producto);
	    		sumaProducto += producto.precio;
	    	}else{
	    		$scope.productosSelecc.splice($scope.productosSelecc.indexOf(producto), 1);
	    		sumaProducto -= producto.precio;
	    	}
	    	//Inicializa de nuevo los importes si no tiene ningun producto seleccionado
	    	if($scope.productosSelecc == ""){
		    	//Inicializa de nuevo los montos a 0
				$scope.total = 0;
				sumaProducto = 0;
				descuento = 0;
				montoDescuento = 0;
		    	$scope.objPaquete.precio = 0;
		    	$scope.objPaquete.montoTotal =  0;
	    	}
	    	//le agrega a la variable el precio por persona
	    	$scope.objPaquete.precio = sumaProducto;
	    	//calcula en decimal el porcentale en descuento
	    	descuento = $scope.objPaquete.descuento / 100;
	    	//calcula el total del precio por la cantidad de personas
	    	$scope.total = sumaProducto * $scope.objPaquete.cantidadPersonas;
	    	//calcula cuanto es el monto que tiene que descontar
	    	montoDescuento =  $scope.total  * descuento;
	    	//el monto total con el descuento aplicado
	    	$scope.objPaquete.montoTotal =  $scope.total - montoDescuento;
	    };
		   
	    
	  //Guarda los datos ingresados por el usuario.
		$scope.guardar = function() {
			/*if(validarDatos($scope.productosSelecc) && this.crearPaquete.$valid){
				var datosPaquete = {};
				datosCatering = {
					administradorId: objUsuario.idUsuario,
					nombre: $scope.objCatering.nombre,
					cedulaJuridica : $scope.objCatering.cedula,
					direccion: $scope.objCatering.direccion,
					telefono1: $scope.objCatering.telefono1,
					telefono2: $scope.objCatering.telefono2,
					horario: $scope.objCatering.horarioAtencion,
					provinciaId: $scope.objCatering.idProvincia,
					cantonId: $scope.objCatering.idCanton,
					distritoId: $scope.objCatering.idDistrito,
					tipoEvento: $scope.productosSelecc
				}
				
				$http.post('rest/protected/catering/registrar', datosCatering).success(function (contractCateringResponse){
					if(contractCateringResponse.code == 200){
						
						services.noty('El paquete se registro correctamente.', 'success');
						$location.path('/catering-listar');
						
					}else{
						services.noty('No se pudo registrar el paquete.', 'error');
					}
				});
			}*/
			
		}
		
	    function validarDatos(productosSeleccionados){
	    	var isOk = true;
	    	if(productosSeleccionados == ""){
	    		isOk = false;
	    		services.noty('Debe seleccionar al menos un producto para poder registrar el paquete.', 'warning');
	    	}
	    	
	    	return isOk;
	    }
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});