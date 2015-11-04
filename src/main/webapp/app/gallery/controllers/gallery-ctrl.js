(function(define) {
	"use strict";

	define(
			[],
			function() {

				var GalleryCtrl = function($scope, $location, $http, i18nNotifications) {
					 $scope.images=[];
					$scope.sildeShow=function(){
						$scope.$parent.isGallery=true;
					}
					_.each($scope.pics,function(item){
						 $scope.images.push({src:item.imageUrl+'.jpg',smallSrc:item.smallUrl+'.jpg',name:item.name,title:item.description});
					});
					
				};
				return [ '$scope', '$location', '$http', 'i18nNotifications', GalleryCtrl ];
			});

}(define));