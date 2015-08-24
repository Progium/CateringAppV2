'use strict';

/**
 * CateringBuscarController
 * @constructor
 */
App.controller('CateringBuscarController', function($scope, $http,$location, $upload, $routeParams, $modal, $log, services) {
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
		$scope.criterioBusqueda = 0;
		$scope.mostrarTablaListPaquete = false;
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
				$scope.objCatering.distritoId = $scope.listaDistrito[0].idDistrito;
			});
	    	
	    	
	    };
	  	    
	    //Funcion que obtiene la lista de todos los catering por paginación
	    $scope.ObtenerListaCatering = function(pageNumber){
	    	$scope.mostrarTablaListPaquete = false;
	    	$scope.objCatering.pageNumber = pageNumber;
	    	//Obtiene todos los caterings
	    	if($scope.criterioBusqueda == 0){
		    	$http.post('rest/protected/catering/getAll', $scope.objCatering).success(function (contractCateringResponse){
					$scope.cantResult = contractCateringResponse.caterings.length;
					$scope.cateringLista = contractCateringResponse.caterings;	
					$scope.totalItems = contractCateringResponse.totalElements;
				});
		    
		    //Obtiene los catering por nombre
	    	}else if($scope.criterioBusqueda == 1){
	    		 //Funcion que obtiene la lista de catering por nombre
	    	    	$http.post('rest/protected/catering/getCateringByNombre', $scope.objCatering).success(function (contractCateringResponse){
	    	    	$scope.cantResult = contractCateringResponse.caterings.length;
	    			$scope.cateringLista = contractCateringResponse.caterings;	
	    			$scope.totalItems = contractCateringResponse.totalElements;
	    		});
	    	  
		    	
			 //Obtiene los catering por localización
	    	}else if($scope.criterioBusqueda == 2){
	    	    //Funcion que obtiene lista de catering por localizacion
	    		$http.post('rest/protected/catering/getCateringByLocalizacion', $scope.objCatering).success(function (contractCateringResponse){
	    			$scope.cantResult = contractCateringResponse.caterings.length;
					$scope.cateringLista = contractCateringResponse.caterings;	
					$scope.totalItems = contractCateringResponse.totalElements;
				});
	    			
		    //Obtiene los catering por tipo de evento
	    	}else if($scope.criterioBusqueda == 3){
	    		var tipoEventos = [];
	    		tipoEventos[0] = $scope.objCatering.idTipoEvento;
	    		
	    		$scope.objCatering.tipoEvento = tipoEventos;
		    	$http.post('rest/protected/catering/getCateringByTipoEvento', $scope.objCatering).success(function (contractCateringResponse){
		    		$scope.cantResult = contractCateringResponse.caterings.length;
					$scope.cateringLista = contractCateringResponse.caterings;	
					$scope.totalItems = contractCateringResponse.totalElements;
				});
	    	}

	    };
	    
	    $scope.init();
	    
	  //Trae los cantones de la provincia seleccionada
	    $scope.llenarCanton = function() {
	    	$scope.listaCanton.length = 0;
			$scope.listaCanton = _.where(listaCantones, {provincia:$scope.objCatering.idProvincia})
			$scope.objCatering.idCanton = $scope.listaCanton[0].idCanton;	
			
			$scope.llenarDistrito();
	    };
	    
		//Trae los distritos del canton seleccionado
	    $scope.llenarDistrito = function() {
	    	$scope.listaDistrito.length = 0;
			$scope.listaDistrito =_.where(listaDistritos, {canton: $scope.objCatering.idCanton});
			$scope.objCatering.distritoId = $scope.listaDistrito[0].idDistrito;
	    };
	    //Boton que busca y se le setea que el numero de la pagina siempre empiece 1      
	    $scope.buscarCaterings = function(){
	    	$scope.ObtenerListaCatering(1);		    	
	    }
	    
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
			   
		   //Funcion que lista los paquetes de evento de un catering determinado
		    $scope.listarPaqueteEvento = function(cateringSelec){

				$scope.paquetesLista = [];
				//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
				$scope.objPaquete = {};
				$scope.mostrarTablaListPaquete = true;
				$scope.objPaquete.cateringId = cateringSelec.idCatering;
				$scope.nombreCatering = cateringSelec.nombre;
		    	
		    	$http.post('rest/protected/paquete/getPaqueteByCatering', $scope.objPaquete).success(function (contractPaqueteResponse){
					$scope.paquetesLista = contractPaqueteResponse.paquetes;
		    	});
			 	      
		    };
			
			//Funcion que reserva un paquete seleccionado
		    $scope.reservarPaquete = function(paqueteSelec){
				//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
				$scope.objReservarPaquete = {};
				$scope.objReservarPaquete.paqueteId = paqueteSelec.idPaquete;
				$scope.nombrePaquete = paqueteSelec.nombre;
		    	
		    	$http.post('rest/protected/paquete/createReservaPaquete', $scope.objReservarPaquete).success(function (contractReservaPaqueteResponse){
		    		if(contractReservaPaqueteResponse.code == 200){
		    			var msj = "Se le envió un correo al catering indicando que reservo el paquete " + $scope.nombrePaquete;
						services.noty(msj, 'success');
						
					}else{
						services.noty('No se pudo reservar el paquete.', 'error');
					}
		    	});
			 	      
		    };
		    
		    //Funcion que muestra el detalle del catering determinado
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
					
					//Obtiene las provincias
					$http.post('rest/protected/provincia/getProvincia', param)
					.success(function(ProvinciaResponse) {
						provincia = ProvinciaResponse.provincia.nombre;
					});
					
					//Obtiene los cantones
					$http.post('rest/protected/canton/getCanton', param)
					.success(function(CantonResponse) {
						canton = CantonResponse.canton.nombre;
					});
					
					//Obtiene los distritos
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
					$scope.paquete.descripcion = param.nombre;
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
    				
    				//Obtiene el catalogo del producto del paquete
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