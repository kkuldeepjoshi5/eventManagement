(function(define){
	"use strict";

	define([], function() {

		var EventRoute = function ($routeProvider, $stateProvider) {
			$stateProvider.state('Event',{
	            url:'/event',
	            templateUrl: 'app/event/views/event.html',
	            controller: 'EventCtrl',
	            data: {
                    displayName: 'Event'
                }
	        });
		}
	return ['$routeProvider', '$stateProvider', EventRoute];
	});

}(define));