'use strict';

/**
 * MenuAdministradorController
 * @constructor
 */

App.controller('MenuAdministradorController', function($scope, $location) {

    $scope.registrarCatering = function() {
        $location.path('/registrarcatering');
    };
});