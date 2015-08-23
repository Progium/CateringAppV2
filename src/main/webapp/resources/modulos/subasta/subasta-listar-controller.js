'use strict';

/**
 * SubastaListarController
 * 
 */

App.controller('SubastaListarController', function($scope, $http, $location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		
		_ScopeContainer['MainController'].esAdministrador = true;	
		$scope.mostrarBoton = false;
		$scope.mostrarBotonSubasta = true;
		$scope.mostrarBotonPropuesta = false;
		$scope.mostrarTablaListPaquete = false;
		$scope.tituloPagina = "Listar subasta";
		$scope.subastaLista = [];
		
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objSubasta = {};
		$scope.objSubasta.pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaSubasta(pageNo);
			$scope.currentPage = pageNo;
		};
	   
		$scope.init = function() {  	
	    	//Obtiene la lista de caterings
			 $scope.ObtenerListaSubasta($scope.currentPage);
			
	    };
	 	   
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaSubasta = function(pageNumber){
	    	$scope.objSubasta.pageNumber = pageNumber;
	    	setInterval(function () {$http.post('rest/protected/subasta/getSubastaLista', $scope.objSubasta)
			.success(function(subastaResponse) {
				$scope.cantResult = subastaResponse.subastas.length;
				$scope.subastaLista = subastaResponse.subastas;
				$scope.totalItems = subastaResponse.totalElements;
	    	});
	    	}, 6000);
	    	$scope.subastaLista.length = 0;
	    };	
	    
	    $scope.init();
	    
	    $scope.participarSubasta = function(idSubasta){
	    	$location.path('/paquete-listar/'+idSubasta);
	    }
	    
	    $scope.openModalDetalleSubasta = function(subastaSelec){
	
		   var modalInstance = $modal.open({
			   templateUrl: 'modulos/subasta-mostrar-detalle',
			   controller: ModalInstanceViewDetalleSubastaCtrl,
			   resolve:{
				   param: function() {
					   var obj ={};
					   obj.id = subastaSelec.idSubasta;
					   obj.nombre= subastaSelec.nombre;
					   obj.fechaEvento = subastaSelec.fechaEvento;
					   obj.cantidadPersonas = subastaSelec.cantidadPersonas;
					   obj.montoMaximo = subastaSelec.montoMaximo;
					   obj.descripcion = subastaSelec.descripcion;
					   obj.idTipo = subastaSelec.idTipo;
					   obj.nombreTipoEvento = subastaSelec.nombreTipoEvento;
					   obj.estado = subastaSelec.estado;
					   var param = obj;
				   return param;
				   }
			   }
			});      
		 };
	
		 //Funcion que muestra el detalle de una subasta determinado
	    var ModalInstanceViewDetalleSubastaCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){			   
			$scope.subasta = {};
			$scope.onError = false;
				
			$scope.init = function(){
				$scope.subasta.idSubasta = param.idSubasta;
				$scope.subasta.nombre = param.nombre;
				$scope.subasta.descripcion = param.descripcion;
 				$scope.subasta.idTipoEvento = param.idTipoEvento;
				$scope.subasta.nombreTipoEvento = param.nombreTipoEvento;
				$scope.subasta.fechaEvento = param.fechaEvento;
				$scope.subasta.cantidadPersonas = param.cantidadPersonas;
 				$scope.subasta.montoMaximo = param.montoMaximo;
 				
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

App.controller('SubastaClienteListarController', function($scope, $http, $location, $upload, $routeParams, $modal, services) {
    
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		
		_ScopeContainer['MainController'].esAdministrador = false;	
		$scope.mostrarBoton = true;
		$scope.mostrarBotonSubasta = false;
		$scope.mostrarBotonPropuesta = true;
		$scope.mostrarTablaListPaquete = false;
		$scope.tituloPagina = "Mis subasta";
		$scope.subastaLista = [];
		
		//Setear cuantos paquetes va mostrar por pantalla y el primer número de página
		$scope.objSubasta = {};
		$scope.objSubasta.pageSize = 5;
		$scope.currentPage = 1;

		//Obtiene la pagina que selecciono y se la pasa al metodo que obtiene los datos del paquete
		$scope.setPage = function (pageNo) {
			$scope.ObtenerListaSubasta(pageNo);
			$scope.currentPage = pageNo;
		};
	   
		$scope.init = function() {  	
	    	//Obtiene la lista de caterings
			 $scope.ObtenerListaSubasta($scope.currentPage);
			
	    };
	    //Funcion que obtiene las propuestas de una subasta determinada
	    $scope.verPropuestas = function(idSubasta){
	    	$scope.mostrarTablaListPaquete = true;
			$scope.mostrarBotonElegir = true;
			$scope.objPropuestaSubasta = {};
			$scope.objPropuestaSubasta.subastaId = idSubasta;
			$scope.listaPropuesta = [];
			$scope.listaPaquete = [];
			$scope.objPropuesta = [];
	
			
			setInterval(function () {$http.post('rest/protected/subasta/getPropuestaSubastaBySubasta', $scope.objPropuestaSubasta).success(function (contractPropuestaResponse){
				var i = 0;
				var j = 0;
				var f = 0;
				$scope.listaPaquete.length = 0;
	    		$scope.listaPropuesta = contractPropuestaResponse.propuestas;
	    		//recorre la lista de propuesta para obtener todo el objeto paquete
	    	
				for (i = 0; i <= $scope.listaPropuesta.length-1; i++) {
					var objProp = {};
					objProp.idPropuestaSubasta = $scope.listaPropuesta[i].idPropuestaSubasta;
					objProp.idPaquete = $scope.listaPropuesta[i].paqueteId; 
					objProp.subastaId = $scope.listaPropuesta[i].subastaId;
					objProp.tipoTransaccion = $scope.listaPropuesta[i].tipoTransaccion;
					objProp.estadoPropuesta = $scope.listaPropuesta[i].tipoTransaccion == 0 ? "Pendiente" : $scope.listaPropuesta[i].tipoTransaccion == 2 ? "Acceptada" :"Rechazada";
					$scope.mostrarBotonElegir = $scope.listaPropuesta[i].tipoTransaccion != 0 ? false : true;
					//Guarda en un objeto propuesta los datos de esa propuesta
					$scope.objPropuesta.push(objProp);
					$http.post('rest/protected/paquete/getPaqueteById', objProp)
					.success(function(paqueteResponse){
						for(j = 0; j <=$scope.objPropuesta.length-1; j++){
							if(paqueteResponse.paquete.idPaquete == $scope.objPropuesta[j].idPaquete ){
								$scope.objPropuesta[j].nombre = paqueteResponse.paquete.nombre;
								$scope.objPropuesta[j].descripcion = paqueteResponse.paquete.nombre;
								$scope.objPropuesta[j].idCatering = paqueteResponse.paquete.idCatering;
								$scope.objPropuesta[j].nombreCatering =  paqueteResponse.paquete.nombreCatering;
								$scope.objPropuesta[j].idTipoEvento =  paqueteResponse.paquete.idTipoEvento;
			    				$scope.objPropuesta[j].nombreTipoEvento =  paqueteResponse.paquete.nombreTipoEvento;
			    				$scope.objPropuesta[j].cantidadPersonas =  paqueteResponse.paquete.cantidadPersonas;
			    				$scope.objPropuesta[j].precio =  paqueteResponse.paquete.precio;
			    				$scope.objPropuesta[j].descuento =  paqueteResponse.paquete.descuento;
			    				$scope.objPropuesta[j].montoTotal =  paqueteResponse.paquete.montoTotal;
			    				$scope.objPropuesta[j].catalogoProducto =  paqueteResponse.paquete.catalogoProducto;
			    				$scope.objPropuesta[j].total = (paqueteResponse.paquete.precio *  paqueteResponse.paquete.cantidadPersonas);
							}
							
						}
						
						
						if(f == $scope.listaPropuesta.length-1 ){
							
							$scope.listaPaquete = $scope.objPropuesta;
						}
						f++;
					
						
					});
				}
				
	    	});
	    	}, 6000);
			console.log(lista);
	    };
	 	   
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.ObtenerListaSubasta = function(pageNumber){
	    	$scope.objSubasta.pageNumber = pageNumber;
	    	$http.post('rest/protected/subasta/getSubastaByUsuario', $scope.objSubasta)
			.success(function(subastaResponse) {
				$scope.cantResult = subastaResponse.subastas.length;
				$scope.subastaLista = subastaResponse.subastas;
				$scope.totalItems = subastaResponse.totalElements;
	    	});
	    };	
	    
	    //Funcion que obtiene la lista de todos los paquetes por paginación
	    $scope.AcceptarPropuesta = function(propuestaSubastaSelecc){
	    	$http.post('rest/protected/subasta/getReservarPropuestaSubasta', propuestaSubastaSelecc)
			.success(function(propuestaSubastaResponse) {
				if(propuestaSubastaResponse.code == 200){
					services.noty('Se le envió un correo al catering indicando que su propuesta fue eligida.', 'success');
					$scope.verPropuestas(propuestaSubastaSelecc.subastaId);
					
				}else{
					services.noty('No se pudo guardar que se eligio esa propuesta.', 'error');
				}
	    	});
	    };
	    $scope.init();
	    
	    $scope.registrar = function() {
	    	$location.path('/subasta-registrar');
	    };
	    
	    $scope.openModalDetalleSubasta = function(subastaSelec){
	
		   var modalInstance = $modal.open({
			   templateUrl: 'modulos/subasta-mostrar-detalle',
			   controller: ModalInstanceViewDetalleSubastaCtrl,
			   resolve:{
				   param: function() {
					   var obj ={};
					   obj.id = subastaSelec.idSubasta;
					   obj.nombre= subastaSelec.nombre;
					   obj.fechaEvento = subastaSelec.fechaEvento;
					   obj.cantidadPersonas = subastaSelec.cantidadPersonas;
					   obj.montoMaximo = subastaSelec.montoMaximo;
					   obj.descripcion = subastaSelec.descripcion;
					   obj.idTipo = subastaSelec.idTipo;
					   obj.nombreTipoEvento = subastaSelec.nombreTipoEvento;
					   obj.estado = subastaSelec.estado;
					   var param = obj;
				   return param;
				   }
			   }
			});      
		 };
		 
		//Funcion que se encarga de mostrar el detalle de paquete
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
		    
		 //Funcion que muestra el detalle de una subasta determinado
	    var ModalInstanceViewDetalleSubastaCtrl = function($scope, $http, $modalInstance,$log, $location, $upload, param){			   
			$scope.subasta = {};
			$scope.onError = false;
				
			$scope.init = function(){
				$scope.subasta.idSubasta = param.idSubasta;
				$scope.subasta.nombre = param.nombre;
				$scope.subasta.descripcion = param.descripcion;
 				$scope.subasta.idTipoEvento = param.idTipoEvento;
				$scope.subasta.nombreTipoEvento = param.nombreTipoEvento;
				$scope.subasta.fechaEvento = param.fechaEvento;
				$scope.subasta.cantidadPersonas = param.cantidadPersonas;
 				$scope.subasta.montoMaximo = param.montoMaximo;
 				
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
			
		   $scope.init = function(){
			   $scope.paquete.idPaquete = param.idPaquete;
			   $scope.paquete.nombre = param.nombre;
			   $scope.paquete.descripcion = param.descripcion;
			   $scope.paquete.idCatering = param.idCatering;
			   $scope.paquete.nombreCatering = param.nombreCatering;
			   $scope.paquete.idTipoEvento = param.idTipoEvento;
			   $scope.paquete.nombreTipoEvento = param.nombreTipoEvento;
			   $scope.paquete.cantidadPersonas = param.cantidadPersonas;
			   $scope.paquete.precio = param.precio;
			   $scope.paquete.descuento = param.descuento;
			   $scope.paquete.montoTotal = param.montoTotal;
			   $scope.paquete.catalogoProducto = param.catalogoProducto;
			   $scope.paquete.total = (param.precio * param.cantidadPersonas);
			
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