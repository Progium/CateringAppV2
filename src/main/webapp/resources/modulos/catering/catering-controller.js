'use strict';

/**
 * CateringController
 * @constructor
 */
App.controller('CateringRegistrarController', function($scope, $http,$location, $upload, services) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		$scope.files = {};
		$scope.tituloPagina = "Registrar nuevo catering";
		$scope.listaProvincia = [];
		$scope.listaCanton = [];
		$scope.listaTipoEvento = [];
		$scope.mostrarImagen = false;
		var listaCantones = [];
		var cantones =  [];
		var listaDistritos = [];
		var distritos =  [];
		$scope.listaDistrito = [];
		$scope.objCatering = {
				tipoCedula : 1
		};
		$scope.exp = /^[1-7]{1}\d{8}$/;
		$scope.msj = "Debe ingresar solo números, debe ingresar los 9 números como se encuentra en la cédula sin espacios.";
		$scope.placeholder = "304650757";
		
	    $scope.init = function() {
	    	//Obtiene los tipos de eventos
	    	$http.get('rest/protected/tipo/getTipoEvento')
			.success(function(tipoResponse) {
				$scope.listaTipoEvento = tipoResponse.tipos;
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
			$scope.objCatering.idDistrito = $scope.listaDistrito[0].idDistrito;
	    };
	    
	    $scope.validarFormatoCedula = function(){
	    	
	    	if($scope.objCatering.tipoCedula == 1){
	    		$scope.exp = /^[1-7]{1}\d{8}$/;
	    		$scope.msj = "Debe ingresar solo números, debe ingresar los 9 números como se encuentra en la cédula sin espacios.";
	    		$scope.placeholder = "304650757";
	    	}else{
	    		$scope.exp = /^3-?\d{3}-?\d{6}$/;
	    		$scope.msj = "Debe ingresar solo números, debe ingresar los 10 números de la cédula jurídica con el siguiente formato 3-###-######.";
	    		$scope.placeholder = "3-101-018738";
	    	}
	    	
	    }
	    
		$scope.cancelar = function(){
			$location.path('/catering-listar');
		}
		
		//Guarda los datos ingresados por el usuario.
		$scope.guardar = function() {
			var cateringLogo = $scope.files[0];
			if(validarDatos(cateringLogo) && this.crearCatering.$valid){
				var datosCatering = {};
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
					tipoEvento: $scope.objCatering.tipoEventos
				}
				
				$http.post('rest/protected/catering/registrar', datosCatering).success(function (contractCateringResponse){
					if(contractCateringResponse.code == 200){
						if(cateringLogo){
							//Guarda la información en variables y se las pasa al controlador de catering de java.
							$scope.upload = $upload.upload({
								url : 'rest/protected/catering/registrarFoto',
								data : {
									idCatering : contractCateringResponse.idCatering
								},
								file : cateringLogo
							}).success(function(cateringResponse, status, headers, config) {
								//Muestra un mensaje si el catering es registrado satisfactoriamente en el sistema.
								if(cateringResponse.code == 200){
									services.noty('El catering se registro correctamente.', 'success');
									$location.path('/catering-listar');
								}else{
									services.noty('No se pudo registrar el logo.', 'error');
								 }
							});
						}else{
							services.noty('El catering se registro correctamente.', 'success');
							$location.path('/catering-listar');
						}
					}else{
						services.noty('No se pudo registrar el catering.', 'error');
					}
				});
			}
			
		}
		//Guarda los archivos seleccionados en el scope.files.
		$scope.onFileSelect = function($files) {
	    	$scope.files = $files;
	    };
	    
	    function validarDatos(objUsuario, file){
	    	var extensiones = new Array("jpg","png","gif");
	    	var extFile;
	    	var isOk = true;
	    	var extCorrecto = false;
	    	//Valida que el formato del archivo solo sea jpg, png y gif
	    	if(file){
	    		extFile = file.name.split('.').pop(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.
	    		for(var i = 0; i <= extensiones.length; i++){
	        		if(extensiones[i] == extFile){
	        			extCorrecto = true;
	    	        }
	    	    }
	    		if(extCorrecto == false){
	    			isOk = false;
	    			services.noty('Solo se puede subir archivos con formato jpg, png, gif.', 'warning');
	    			
	    		}
	    	}

	    	if(objUsuario.contrasenna != objUsuario.repetirContrasenna){
	    		isOk = false;
	    		services.noty('El campo de repetir contraseña tiene que ser igual a la contraseña.', 'warning');
	    	}   	
	    	return isOk;
	    }
	    
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});

App.controller('CateringModificarController', function($scope, $location, $http, $routeParams, $upload, services) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;
		$scope.files = {};
		$scope.tituloPagina = "Modificar datos del catering";
		$scope.listaProvincia = [];
		$scope.listaCanton = [];
		$scope.listaTipoEvento = [];
		var listaCantones = [];
		var cantones =  [];
		var listaDistritos = [];
		var distritos =  [];
		$scope.listaDistrito = [];
		$scope.mostrarImagen = true;
		$scope.actualizarImagen = false;
		$scope.objCatering = {
				idCatering: $routeParams.pidCatering
		};
		
	    $scope.init = function() {
	    	var tamannoCedula;
			$http.post('rest/protected/catering/getCaterigById', $scope.objCatering.idCatering).success(function (contractCateringResponse){
				tamannoCedula = contractCateringResponse.catering.cedulaJuridica.length;
				if(tamannoCedula == 9){
					$scope.objCatering.tipoCedula = 1;
				}else{
					$scope.objCatering.tipoCedula = 2;
				}
				$scope.objCatering.nombre = contractCateringResponse.catering.nombre;
				$scope.objCatering.cedula = contractCateringResponse.catering.cedulaJuridica;
				$scope.objCatering.direccion = contractCateringResponse.catering.direccion;
				$scope.objCatering.telefono1 = contractCateringResponse.catering.telefono1;
				$scope.objCatering.telefono2 = contractCateringResponse.catering.telefono2;
				$scope.objCatering.horarioAtencion = contractCateringResponse.catering.horario;
				$scope.objCatering.idProvincia = contractCateringResponse.catering.provinciaId;
				$scope.objCatering.idCanton = contractCateringResponse.catering.cantonId;
				$scope.objCatering.idDistrito = contractCateringResponse.catering.distritoId;
				$scope.objCatering.tipoEventos =contractCateringResponse.catering.tipoEvento;
				$scope.files[0] =contractCateringResponse.catering.fotografia;
			});
			
	    	//Obtiene los tipos de eventos
	    	$http.get('rest/protected/tipo/getTipoEvento')
			.success(function(tipoResponse) {
				$scope.listaTipoEvento = tipoResponse.tipos;
			});
	    	
	    	//Obtiene la lista de provincias
	    	$http.get('rest/protected/provincia/getAll')
			.success(function(provinciaResponse) {
				$scope.listaProvincia = provinciaResponse.listaProvincia;
			});
	    	
	    	//Obtiene la lista de cantones
	    	$http.get('rest/protected/canton/getAll')
			.success(function(cantonResponse) {
				listaCantones = cantonResponse.listaCanton;
				$scope.listaCanton = _.where(listaCantones, {provincia:$scope.objCatering.idProvincia})	
			});
	    	
	    	//Obtiene la lista de distritos
	    	$http.get('rest/protected/distrito/getAll')
			.success(function(distritoResponse) {
				listaDistritos = distritoResponse.listaDistrito;
				$scope.listaDistrito =_.where(listaDistritos, {canton: $scope.objCatering.idCanton});
			});

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
			$scope.objCatering.idDistrito = $scope.listaDistrito[0].idDistrito;
	    };
	    
	    $scope.validarFormatoCedula = function(){
	    	
	    	if($scope.objCatering.tipoCedula == 1){
	    		$scope.exp = /^[1-7]{1}\d{8}$/;
	    		$scope.msj = "Debe ingresar solo números, debe ingresar los 9 números como se encuentra en la cédula sin espacios.";
	    		$scope.placeholder = "304650757";
	    	}else{
	    		$scope.exp = /^3-?\d{3}-?\d{6}$/;
	    		$scope.msj = "Debe ingresar solo números, debe ingresar los 10 números de la cédula jurídica con el siguiente formato 3-###-######.";
	    		$scope.placeholder = "3-101-018738";
	    	}
	    	
	    }
	    
		$scope.cancelar = function(){
			$location.path('/catering-listar');
		}
		
		//Guarda los datos modificados del catering.
		$scope.guardar = function() {
			var cateringLogo = $scope.files[0];
			if(validarDatos(cateringLogo) && this.crearCatering.$valid){
				var datosCatering = {};
				datosCatering = {
					idCatering: $scope.objCatering.idCatering,
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
					tipoEvento: $scope.objCatering.tipoEventos
				}
				
				$http.post('rest/protected/catering/modificar', datosCatering).success(function (contractCateringResponse){
					if(contractCateringResponse.code == 200){
						if(cateringLogo && $scope.actualizarImagen == true){
							//Guarda la información en variables y se las pasa al controlador de catering de java.
							$scope.upload = $upload.upload({
								url : 'rest/protected/catering/registrarFoto',
								data : {
									idCatering : $scope.objCatering.idCatering
								},
								file : cateringLogo
							}).success(function(cateringResponse, status, headers, config) {
								//Muestra un mensaje si el catering es registrado satisfactoriamente en el sistema.
								if(cateringResponse.code == 200){
									services.noty('Los datos del catering fueron modificados correctamente.', 'success');
									$location.path('/catering-listar');
								}else{
									services.noty('No se pudo registrar el logo.', 'error');
								 }
							});
						}else{
							services.noty('Los datos del catering fueron modificados correctamente.', 'success');
							$location.path('/catering-listar');
						}
					}else{
						services.noty('No se pudo modificar los datos del catering.', 'error');
					}
				});
			}
		}
		
		//Guarda los archivos seleccionados en el scope.files.
		$scope.onFileSelect = function($files) {
	    	$scope.files = $files;
	    	$scope.actualizarImagen = true;
	    };
	    
	    function validarDatos(objUsuario, file){
	    	var extensiones = new Array("jpg","png","gif");
	    	var extFile;
	    	var isOk = true;
	    	var extCorrecto = false;
	    	//Valida que el formato del archivo solo sea jpg, png y gif
	    	if(file && $scope.actualizarImagen == true){
	    		extFile = file.name.split('.').pop(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.
	    		for(var i = 0; i <= extensiones.length; i++){
	        		if(extensiones[i] == extFile){
	        			extCorrecto = true;
	    	        }
	    	    }
	    		if(extCorrecto == false){
	    			isOk = false;
	    			services.noty('Solo se puede subir archivos con formato jpg, png, gif.', 'warning');
	    			
	    		}
	    	}

	    	if(objUsuario.contrasenna != objUsuario.repetirContrasenna){
	    		isOk = false;
	    		services.noty('El campo de repetir contraseña tiene que ser igual a la contraseña.', 'warning');
	    	}   	
	    	return isOk;
	    }
	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});