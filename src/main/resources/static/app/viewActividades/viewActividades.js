'use strict';

angular.module('myApp.viewActividades', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewActividades', {
    templateUrl: 'viewActividades/viewActividades.html',
    controller: 'ViewActividadesCtrl'
  });
}])

.controller('ViewActividadesCtrl', ['$scope','actividades','$filter',function($scope,actividades,$filter) {
        
       
                
                
                  actividades.get(function(data){
                        console.info("get postre  ");
                        $scope.listadoPostres=data;
                    });
        
        var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listadoPostres = orderBy($scope.listadoPostres, predicate, $scope.reverse);
        };
        $scope.order('code', true);
                
                
                
         

}]);