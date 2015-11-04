(function(define) {
	"use strict";

	define(	[],	function() {

				var AboutCtrl = function($scope,$http, $location,  i18nNotifications) {
					
					$scope.getAll=function(){
						$http.get('/eventManagment/rest/event/getAll')
						.success(function(res){
							alert(res);
						})
						.error(function(res){
							alert(res);
						});
					};
					
					$http({method:'GET',url:'/eventManagment/dataFile/about.json'})
						.success(function(response){
							$scope.abouts=response.abouts;
						})
						.error(function(response){
							i18nNotifications.removeAll();
	
						});
				};
				return [ '$scope','$http', '$location', 'i18nNotifications', AboutCtrl ];
			});

}(define));