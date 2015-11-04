(function(define) {
	"use strict";

	define([], function() {

		var EventService = function($resource, $interpolate) {
			var data = $resource('/rest/Event/:operation',{
				operation:"@operation"
			},
			{
				getEventForGrid:{
					method : 'GET',
					params : {
						operation : 'data.do'
					}
				},
				getEventForEdit:{
					method : 'GET',
					params : {
						operation : 'beforeEdit'
					}
				},
				getEventForProfile:{
					method : 'GET',
					params : {
						operation : 'showDetail.do'
					}
				},
				deleteEvent:{
					method:'DELETE',
					params:{
						operation:'delete'
					}
				},
				saveEvent:{
					method:'POST',
					params:{
						operation:'save'
					}
				}
			});

			return data;
		};

		return [ '$resource', '$interpolate', EventService ];
	});
}(define));