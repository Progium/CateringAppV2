'use strict';

/* Services */

var AppServices = angular.module('PrototipoProgium.services', [])
	.factory('services', function() {
    	 return {
    	noty: function(text, type) {
                var n = noty({
                    text        : text,
                    type        : type,
                    maxVisible  : 1,
                    timeout		: 3000,
                    killer		: true
                });
            }
    	 };
    });
AppServices.value('version', '0.1');
