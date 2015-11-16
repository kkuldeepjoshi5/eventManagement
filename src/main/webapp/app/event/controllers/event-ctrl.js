(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope,EventData, i18nNotifications,EventService,EventManager) {

					$scope.fromDateOpen = function($event) {
						$event.preventDefault();
						$event.stopPropagation();

						$scope.isFromDateOpened = true;
					};

					$scope.toDateOpen = function($event) {
						$event.preventDefault();
						$event.stopPropagation();

						$scope.isToDateOpened = true;
					};

					$scope.eventGridData=angular.copy(EventData.eventVOs);
					 $scope.isAdmin=EventManager.isAdmin;

					$scope.deleteConfirmation=function(row){
						angular.element("#deleteModel").modal("show");
						$scope.deleteRow=row.entity;
					};
					$scope.editPage=function(row){
						angular.element("#createEditModel").modal("show");
						$scope.newEvent=row.entity;
					};
					$scope.deleteEvent=function(){
						var obj ={	eventId:$scope.deleteRow.id	};
						EventManager.deleteEvent($scope.eventGridData,obj,'event.delete.success');
					};
					$scope.gridOptions=EventManager.gridOptions;
					$scope.currentFocused = "";

				    $scope.getCurrentFocus = function(){
				      var rowCol = $scope.gridApi.cellNav.getFocusedCell();
				      if(rowCol !== null) {
				          $scope.currentFocused = 'Row Id:' + rowCol.row.entity.id + ' col:' + rowCol.col.colDef.name;
				      }
				    }

				    $scope.gridOptions.onRegisterApi = function(gridApi){
				       $scope.gridApi = gridApi;
				    };

					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

					$scope.beforeCreate=function(){

						$scope.newEvent=[];
						$scope.newEvent.fromDate = new Date();
						$scope.newEvent.toDate = new Date();
						EventService.beforeCreate(function(response){
									$scope.createrData=angular.copy(response);

								},function(error){
									console.log(error);
									return null;
								});
						angular.element("#createEditModel").modal("show");
					};

					$scope.saveEvent=function(){
						//angular.copy($scope.newEvent,eventVO);
						var path='/rest/event/insert';
						var eventVO={
							title:$scope.newEvent.title,
							description:$scope.newEvent.description,
							fromDate:$scope.newEvent.fromDate,
								toDate:$scope.newEvent.toDate
						};
						console.log(eventVO);
						EventManager.saveEvent(path,eventVO);
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications','EventService','EventManager', EventCtrl ];
			});

}(define));