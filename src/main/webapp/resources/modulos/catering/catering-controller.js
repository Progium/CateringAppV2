'use strict';

/**
 * CateringController
 * @constructor
 */
App.controller('CateringRegistrarController', function($scope, $http,$location, $upload) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;	
		$scope.files = {};
		$scope.tituloPagina = "Registrar nuevo catering";
		$scope.listaProvincia = [];
		$scope.listaCanton = [];
		$scope.listaTipoEvento = [];
		var listaCantones = [];
		var cantones =  [];
		var listaDistritos = [];
		var distritos =  [];
		$scope.listaDistrito = [];
		$scope.objCatering = {};
		
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
	    
		$scope.cancelar = function(){
			$location.path('/catering-listar');
		}
		
		//Guarda los datos ingresados por el usuario.
		$scope.guardar = function() {
			if(this.crearCatering.$valid){
				var cateringLogo = $scope.files[0];
				var datosCatering = {};
				datosCatering = {
					administradorId: objUsuario.idUsuario,
					nombre: $scope.objCatering.nombre,
					cedulaJuridica : $scope.objCatering.cedulaJuridica,
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
									alert("El catering se registro correctamente.");
									$location.path('/catering-listar');
								}else{
									alert("No se pudo registrar el logo.");
								 }
							});
						}else{
							alert("El catering se registro correctamente.");
							$location.path('/catering-listar');
						}
					}else{
						alert("No se pudo registrar el catering.");
					}
				});
			}
			
		}
		//Guarda los archivos seleccionados en el scope.files.
		$scope.onFileSelect = function($files) {
	    	$scope.files = $files;
	    };

	}else{
		var path = "/catering/#/iniciar-sesion";
		window.location.href = path;
	}
});

App.controller('CateringModificarController', function($scope, $location, $routeParams) {
	var objUsuario = $.jStorage.get("user");
	if(objUsuario){
		_ScopeContainer['MainController'].esAdministrador = true;
		$scope.objUsuario = {
				idCatering: $routeParams.pidCatering
		};
		$scope.files = {};
		$scope.tituloPagina = "Modificar datos del catering";
		$scope.listaProvincia = [];
		$scope.listaCanton = [];
		$scope.listaDistrito = [];
		$scope.objCatering = {};
		
	    $scope.init = function() {
	    	//Obtiene la lista de provincias
	    	$http.get('rest/protected/provincia/getAll')
			.success(function(provinciaResponse) {

				$scope.listaProvincia = provinciaResponse.listaProvincia;
				$scope.objCatering.idProvincia = $scope.listaProvincia[0].idProvincia;	
			});
	    	//Obtiene la lista de cantones
	    	$http.get('rest/protected/canton/getAll')
			.success(function(cantonResponse) {

				$scope.listaCanton = cantonResponse.listaCanton;
				$scope.objCatering.idCanton = $scope.listaCanton[0].idCanton;	
			});
	    	//Obtiene la lista de distritos
	    	$http.get('rest/protected/distrito/getAll')
			.success(function(distritoResponse) {
				$scope.listaDistrito = cantonResponse.listaDistrito;
				$scope.objCatering.idDistrito = $scope.listaDistrito[0].idDistrito;	
			});
	    	
	    };
	    
	    $scope.init();
		$scope.cancelar = function(){
			$location.path('/');
		}
		
		$scope.guardar = function() {
			$location.path('/iniciar-sesion');
		}
	};   

});