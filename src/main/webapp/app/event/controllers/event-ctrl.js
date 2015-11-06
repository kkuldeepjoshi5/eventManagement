(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope,EventData, i18nNotifications,EventService) {
					$scope.event=[];
					$scope.eventGridData=angular.copy(EventData.eventVOs);
					 $scope.isAdmin=true;
					
					var deleteBtn='<a ng-click="grid.appScope.deleteConfirmation(row)" tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true" data-toggle="modal" data-target="#deleteModel" style="margin-left:8px;"><i class="fa fa-trash-o fa-lg text-danger"></i></a>';
					var editBtn='<a ng-click="grid.appScope.editPage(row)" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true" style="margin-left:4px;"><i class="fa fa-pencil-square-o fa-lg text-info" style="margin-top:3px;"></i></a>';
					$scope.deleteConfirmation=function(row){
						$scope.deleteRow=row.entity;
					};
					$scope.deleteEvent=function(){
						var obj ={
								eventId:$scope.deleteRow.id
							};
							EventService.deleteEvent(obj,function(response){
								i18nNotifications.removeAll();
								i18nNotifications.pushForCurrentRoute('event.delete.success', 'success', {}, {});
								var deleteIndex=$scope.eventGridData.indexOf($scope.deleteRow);
								$scope.eventGridData.splice(deleteIndex, 1);
							},function(error){
								console.log(error);
							});
					};
					$scope.gridOptions = {
							multiSelect : false,
							data : 'eventGridData',
							enableColumnResize:true,
							enableHighlighting : true,
							columnDefs : [
									{
										name: 's.no',
										cellTemplate: '<div align="center" style="padding-top: 6%;" class="ngCellText">{{grid.renderContainers.body.visibleRowCache.indexOf(row) +1}}</div>',
										enableSorting : false,
										width:60
									},
									{
										field : 'title',
											
									},
									{
										field : 'fromDate',
									},
									{
										field : 'toDate',
									},
									{
										field:'  ',
										displayName:'  ',
										name:' ',
										enableSorting : false,
										visible :  $scope.isAdmin,
										cellTemplate:'<div class="btn-group btn-group-xs">'+editBtn+deleteBtn+'</div>'
									}
									],

						};

					
					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

					$scope.saveEvent=function(){
						var eventVO={
								title:'kul',
								description:'descerr'

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
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications','EventService', EventCtrl ];
			});

}(define));