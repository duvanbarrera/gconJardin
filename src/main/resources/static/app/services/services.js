'use strict';
angular.module('services.module1', ['ngRoute','ngResource'])


    .factory('actividades', function($resource) {
            
        return $resource('/actividades',{},{ get: { method: 'GET', isArray: true
} });
    })
    
    
   
    
    /*.factory('pedidosPostres', function($resource) {
            
        return $resource('/pedidos/postres',{},{ get: { method: 'GET', isArray: true
        } });
    })*/
    
   
    

    
    

