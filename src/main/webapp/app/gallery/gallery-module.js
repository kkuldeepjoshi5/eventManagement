(function(define){
	"use strict";
	
	define(['common/common',
	        'gallery/gallery-route',
	        'gallery/controllers/gallery-ctrl',
	        'gallery/services/gallery-service'], 
			function(common, GalleryRoute, GalleryCtrl, GalleryService) {
		
		var moduleName = 'galleryPage';
		angular.module(moduleName, [common, 'ngGrid', 'restResource', 'services.i18nNotifications'])
				.config(GalleryRoute)
				.controller('GalleryCtrl', GalleryCtrl)
				.factory('GalleryService', GalleryService);
		return moduleName;
	});
	
}(define));