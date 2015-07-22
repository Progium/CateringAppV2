'use strict';

/**
 * PaqueteRegistrarController
 * @constructor
 */
App.controller('PaqueteRegistrarController', function($scope) {
    
    $scope.cantidad = {
        valor: 1
    };
    
     $scope.productos = [{
        nombre: "Arroz con pollo",
        costo: "2700"
    }, {
        nombre: "Carne en salsa",
        costo: "2600"
    },{
        nombre: "Lasaña de carne",
        costo: "2800"
    }];
});