(function(define){
	"use strict";
	
	define(['common/common',
	        'home/home-route',
	        'home/controllers/home-page-ctrl',
	        'home/services/home-page-service'], 
			function(common, HomeRoute, HomePageCtrl, HomePageService) {
		
		var moduleName = 'homePage';
		angular.module(moduleName, [common, 'ngGrid', 'restResource', 'services.i18nNotifications'])
				.config(HomeRoute)
				.controller('HomePageCtrl', HomePageCtrl)
				.factory('HomePageService', HomePageService);
		return moduleName;
	});
	
}(define));