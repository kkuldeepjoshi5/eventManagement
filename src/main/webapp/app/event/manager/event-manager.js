(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope, i18nNotifications) {
					$scope.event=[];
					
					$scope.eventGridOptions = {
							multiSelect : false,
							data : 'eventGridData',
							enableColumnResize:true,
							enableHighlighting : true,
							columnDefs : [
									{
										field : 'id',
										visible : false
									},
									{
										field: '',
										displayName: '',
										cellTemplate: '<div align="center" class="ngCellText">{{row.rowIndex + 1}}</div>',
										sortable : false,
										width : '6%'
									},
									{
										field : 'title',
										displayName : 'Title',
										width:'30%',
										cellTemplate: '<div class="ngCellText"><a tooltip-placement="auto" tooltip="{{row.entity.title}}" tooltip-append-to-body="true" ng-click="detailPage(row)">{{resizeTitle(row.entity.title)}}</a></div>'
									},
									{
										field : 'fromDate.dateStr',
										sortable:false,
										displayName : 'From Date'
									},
									{
										field : 'toDate.dateStr',
										sortable:false,
										displayName : 'To Date'
									},
									{
										field:'eventForName',
										visible : $scope.isAdmin,
										displayName : 'Event For'
									},
									{
										field : 'postedBy',
										displayName : 'Posted By'
									},
									{
										field:'',
										displayName:' ',
										visible : $scope.isTeacher || $scope.isAdmin,
										cellTemplate:'  <div class="btn-group btn-group-xs" ng-hide="isHide(row)"><a ng-click="editPage(row)" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true" style="margin-left:4px;"><i class="fa fa-pencil-square-o fa-lg text-info" style="margin-top:3px;"></i></a><a ng-click="deleteConfirmation(row)" tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true" data-toggle="modal" data-target="#deleteModel" style="margin-left:8px;"><i class="fa fa-trash-o fa-lg text-danger"></i></a></div>'
									}



									],

						};

					
					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

					$scope.saveEvent=function(){
						var eventVO={
								 eventTitle:$scope.event.title,
								 eventDesc:$scope.event.des
								 
						};
						$http.post('/rest/event/insert',eventVO)
						.success(function(res){
							alert("success::"+res);
						})
						.error(function(){
							alert("error::"+res);
						});
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'i18nNotifications', EventCtrl ];
			});

}(define));