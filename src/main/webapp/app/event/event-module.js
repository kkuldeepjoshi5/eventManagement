(function(define){
	"use strict";

	define(['common/common',
	        'event/event-route',
	        'event/controllers/event-ctrl',
	        'event/manager/event-manager',
	        'event/services/event-service'],
			function(common, EventRoute, EventCtrl,EventManager, EventService) {

		var moduleName = 'event';
		angular.module(moduleName, [common, 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav', 'restResource', 'services.i18nNotifications'])
				.config(EventRoute)
				.controller('EventCtrl', EventCtrl)
				.factory('EventManager', EventManager)
				.factory('EventService', EventService);
		return moduleName;
	});

}(define));