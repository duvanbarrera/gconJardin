'use strict';

angular.module('myApp.viewRegistroPostres', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroPostres', {
    templateUrl: 'viewRegistroPostres/viewRegistroPostres.html',
    controller: 'ViewRegistroPostresCtrl'
  });
}])

.controller('ViewRegistroPostresCtrl', ['$scope','actividades',function($scope, actividades) {

        $scope.name="";
        $scope.price ="";
        $scope.code ="";
        $scope.description ="";
        
        $scope.agregarPostre = function(){

            if (!isNaN($scope.price)){
                if($scope.price>0){
                    
                    actividades.get(function(data){
                    var listadotemp=data;
                   
                   
                        var seguro = confirm("El codigo ya esta asociado, esta seguro de cambiar los valores?");
                       
                            var newProduct={"code":$scope.code,"name":$scope.name,"price":$scope.price,"description":$scope.description};
                    
                            actividades.save(newProduct,function(){
                                  console.info("Change   "+ newProduct);
                                  
                                  $scope.name="";
                                  $scope.code="";
                                  $scope.price="";
                                  $scope.description="";
                            });
                        
                            
                        
                    
                    });
                    
                    
                    
                }else{
                alert("El precio debe ser mayor a 0");
            }
                    
       
            }else{
                alert("El precio debe ser numerico");
            }
 
            
           
            
        }



}]);