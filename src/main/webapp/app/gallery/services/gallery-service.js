(function(define) {
	"use strict";

	define([], function() {

		var GalleryService = function($resource, $interpolate) {
			var data = $resource('/rest/Gallery/:operation',{
				operation:"@operation"
			},
			{
				getGalleryData:{
					method : 'GET',
					params : {
						operation : 'data.do'
					}
				}
			});

			return data;
		};

		return [ '$resource', '$interpolate', GalleryService ];
	});
}(define));