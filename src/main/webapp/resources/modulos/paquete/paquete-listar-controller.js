'use strict';

/**
 * PaqueteListarController
 * @constructor
 */
App.controller('PaqueteListarController', function($scope, $http,$location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;
		//Valida si el llamado de listar paquete fue desde el boton participar subas o el boton ver mis paquetes
		//Si es de participar subasta se le debe habilitar el boton de enviar paquete
		if($routeParams.pidSubasta == 0){
			$scope.mostrarBoton = false;
		}else{
			$scope.objPropuesta = {
					subastaId: $routeParams.pidSubasta
			};
			$scope.mostrarBoton = true;
		}
		
		$scope.paquetesLista = [];
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objPaquete = {};
		$scope.objPaquete .pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaPaquetes(pageNo);
			$scope.currentPage = pageNo;
		};
	  
	    $scope.init = function() {
	    	$scope.ObtenerListaPaquetes($scope.currentPage);
	    	
	    };
	    
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaPaquetes = function(pageNumber){
	    	$scope.objPaquete.pageNumber = pageNumber;
	    	$http.post('rest/protected/paquete/getPaqueteByAdministrador', $scope.objPaquete).success(function (contractPaqueteResponse){
				$scope.cantResult = contractPaqueteResponse.paquetes.length;
				$scope.paquetesLista = contractPaqueteResponse.paquetes;
				$scope.totalItems = contractPaqueteResponse.totalElements;
	    	});
	    };	 	    
	   
	    $scope.init();
	    
	    $scope.registrar = function() {
	    	$location.path('/paquete-registrar');
	    };
	    
	    $scope.enviarPaquete = function(paquete) {
	    	$scope.objPropuesta.paqueteId = paquete.idPaquete;
	    	$scope.objPropuesta.tipoTransaccion = 0;
	    	
			$http.post('rest/protected/subasta/createPropuestaSubasta', $scope.objPropuesta).success(function (contractPropuestaSubastaResponse){
				if(contractPropuestaSubastaResponse.code == 200){
					services.noty('Se ha enviado correctamente la propuesta de subasta al cliente.', 'success');
					$location.path('/subasta-listar');
					
				}else{
					services.noty('No se pudo enviar la propuesta de la subasta.', 'error');
				}
			});
	    	
	    };
	    
	    $scope.openModalDetallePaquete = function(paqueteSelec){
	    	
	    	var modalInstance = $modal.open({
	    		templateUrl: 'modulos/paquete-mostrar-detalle',
	    		controller: ModalInstanceViewDetallePaqueteCtrl,
	    		resolve:{
	    			param: function() {
	    				var obj ={};
	    				obj.idPaquete = paqueteSelec.idPaquete;
	    				obj.nombre= paqueteSelec.nombre;
	    				obj.descripcion = paqueteSelec.descripcion;
	    				obj.idCatering = paqueteSelec.idCatering;
	    				obj.nombreCatering = paqueteSelec.nombreCatering;
	    				obj.idTipoEvento = paqueteSelec.idTipoEvento;
	    				obj.nombreTipoEvento = paqueteSelec.nombreTipoEvento;
	    				obj.cantidadPersonas = paqueteSelec.cantidadPersonas;
	    				obj.precio = paqueteSelec.precio;
		 				obj.descuento = paqueteSelec.descuento;
		 				obj.montoTotal = paqueteSelec.montoTotal;
		 				obj.catalogoProducto = paqueteSelec.catalogoProducto;
		 				var param = obj;
		 				return param;
	    			}
	    		}
	    	}); 	      
	    };
	    
	    //Funcion que muestra el detalle de un paquete determinado
	    var ModalInstanceViewDetallePaqueteCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){
			$scope.listaCatalogos = [];
			$scope.listaProductos = [];
			$scope.objProducto = [];				   
			$scope.paquete = {};
			$scope.onError = false;
				
		    //Funcion que convierte en miles los montos
		    Number.prototype.numberFormat = function(decimals, dec_point, thousands_sep) {
		    	dec_point = typeof dec_point !== 'undefined' ? dec_point : '.';
		        thousands_sep = typeof thousands_sep !== 'undefined' ? thousands_sep : ',';

		        var parts = this.toFixed(decimals).split('.');
		        parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, thousands_sep);

		        return parts.join(dec_point);
		    }
		    
			$scope.init = function(){
				$scope.paquete.idPaquete = param.idPaquete;
				$scope.paquete.nombre = param.nombre;
				$scope.paquete.descripcion = param.descripcion;
				$scope.paquete.idCatering = param.idCatering;
				$scope.paquete.nombreCatering = param.nombreCatering;
				$scope.paquete.idTipoEvento = param.idTipoEvento;
 				$scope.paquete.nombreTipoEvento = param.nombreTipoEvento;
 				$scope.paquete.cantidadPersonas = param.cantidadPersonas;
 				$scope.paquete.precio = (param.precio).numberFormat(2);
 				$scope.paquete.descuento = param.descuento;
 				$scope.paquete.montoTotal = (param.montoTotal).numberFormat(2);
 				$scope.paquete.catalogoProducto = param.catalogoProducto;
 				$scope.paquete.total = (param.precio * param.cantidadPersonas).numberFormat(2);
 				

				//Obtiene los tipos de eventos
				$http.post('rest/protected/catalogo/getCatalogoProducto', param)
				.success(function(CatalogoResponse) {		
					var i = 0;
					var j = 0;
					var f = 0;
					$scope.listaCatalogos = CatalogoResponse.catalogos;
					
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
									$scope.objProducto[j].nombre = productoResponse.producto.nombre + " => " + $scope.objProducto[j].precio;
									$scope.objProducto[j].categoria = productoResponse.producto.categoria;
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

