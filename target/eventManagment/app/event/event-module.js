(function(define){
	"use strict";

	define(['common/common',
	        'event/event-route',
	        'event/controllers/event-ctrl',
	        'event/services/event-service'],
			function(common, EventRoute, EventCtrl, EventService) {

		var moduleName = 'event';
		angular.module(moduleName, [common, 'ngGrid', 'restResource', 'services.i18nNotifications'])
				.config(EventRoute)
				.controller('EventCtrl', EventCtrl)
				.factory('EventService', EventService);
		return moduleName;
	});

}(define));