(function(define) {
	"use strict";

	define([], function() {

		var UserService = function($resource, $interpolate) {
			var data = $resource('/rest/user/:operation',{
				operation:"@operation"
			},
			{
				getUserForGrid:{
					method : 'GET',
					params : {
						operation : 'getAll'
					}
				},
				getUserForEdit:{
					method : 'GET',
					params : {
						operation : 'beforeEdit'
					}
				},
				getUserForProfile:{
					method : 'GET',
					params : {
						operation : 'showDetail.do'
					}
				},
				deleteUser:{
					method:'DELETE',
					params:{
						operation:'delete'
					}
				},
				saveUser:{
					method:'POST',
					params:{
						operation:'save'
					}
				}
			});

			return data;
		};

		return [ '$resource', '$interpolate', UserService ];
	});
}(define));