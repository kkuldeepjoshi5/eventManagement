(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope,EventData, i18nNotifications) {
					$scope.event=[];
					 $scope.isAdmin=true;
					$scope.eventGridData=[
					                      {title:'birth day party',discription:'heeloo',fromDate:'01/02/2015',toDate:'15/02/2015',photoUrl:'/kuldeep.jpg',requestId:1,isDeleted:false},
					                      {title:'marriage party',discription:'hdfdfdloo',fromDate:'05/01/2016',toDate:'25/01/2016',photoUrl:'/arpit.jpg',requestId:2,isDeleted:false},
					                      {title:'crismas',discription:'crismasoo',fromDate:'01/03/2016',toDate:'11/03/2016',photoUrl:'/sandeep.jpg',requestId:3,isDeleted:false}
					                      ];
					var deleteBtn='<a ng-click="deleteConfirmation(row)" tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true" data-toggle="modal" data-target="#deleteModel" style="margin-left:8px;"><i class="fa fa-trash-o fa-lg text-danger"></i></a>';
					var editBtn='<a ng-click="editPage(row)" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true" style="margin-left:4px;"><i class="fa fa-pencil-square-o fa-lg text-info" style="margin-top:3px;"></i></a>';
				
					$scope.getRow=function(row){
						console.log(row);
					};
				/*	$scope.gridOptions = {data : 'eventGridData'};*/
					$scope.gridOptions = {
							multiSelect : false,
							data : 'eventGridData',
							enableColumnResize:true,
							enableHighlighting : true,
							columnDefs : [
									{
										name: 's.no',
										cellTemplate: '<div align="center" class="ngCellText">{{grid.renderContainers.body.visibleRowCache.indexOf(row) +1}}</div>',
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
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications', EventCtrl ];
			});

}(define));