(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope, i18nNotifications) {
					$scope.event=[];
					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

					$scope.saveEvent=function(){
						var eventVO={
								title:'kul',
								description:'descerr'

						};
						$http.post('/rest/event/insert',eventVO)
						.success(function(res){
							alert("success::"+res);
						})
						.error(function(){
							alert("error::"+res);
						});
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'i18nNotifications', EventCtrl ];
			});

}(define));