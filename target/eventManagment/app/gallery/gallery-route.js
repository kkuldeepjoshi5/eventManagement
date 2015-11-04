(function(define){
	"use strict";

	define([], function() {

		var GalleryRoute = function ($routeProvider, $stateProvider) {
			$stateProvider.state('Gallery',{
	            url:'/gallery',
	            templateUrl: 'app/gallery/views/gallery.html',
	            controller: 'GalleryCtrl',
	            data: {
                    displayName: 'Gallery'
                }
	        });
		}
	return ['$routeProvider', '$stateProvider', GalleryRoute];
	});

}(define));