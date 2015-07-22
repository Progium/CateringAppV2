'use strict';

/**
 * SubastaListarController
 * @constructor
 */
 
 
App.controller('SubastaListarController', function($scope) {
    
    $scope.listaSubastas = [{
        nombre: "Yuliana Arias",
        fecha: "25 julio del 2015",
        hora: "11:00 AM"
    }, {
        nombre: "Marcela Leandro",
        fecha: "28 agosto del 2015",
        hora: "11:00 AM"
    },{
        nombre: "Josue Perez",
        fecha: "15 agosto del 2015",
        hora: "03:00 PM"
    }];
});