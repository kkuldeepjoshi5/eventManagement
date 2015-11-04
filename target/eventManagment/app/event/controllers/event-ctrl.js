(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope, i18nNotifications) {
					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

					$scope.saveEvent=function(){
						var obj={
								eventId:1,
								 eventTitle:"kuldeep",
								eventDesc:'desc',
								 eventDate:'12/12/2015',
								 photoUrl:'kuldeep.jpg',
								 deleted:'TRUE',
						};
						$http.post('/rest/event/insertEvent',obj)
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