(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope,$http, $location, $state, $rootScope,EventData, i18nNotifications,EventService,EventManager) {
					$scope.newEvent=[];
					$scope.newEvent.fromDate = new Date();
					$scope.fromDateOpen = function($event) {
						$event.preventDefault();
						$event.stopPropagation();

						$scope.isFromDateOpened = true;
					};
					$scope.newEvent.toDate = new Date();
					$scope.toDateOpen = function($event) {
						$event.preventDefault();
						$event.stopPropagation();

						$scope.isToDateOpened = true;
					};
					$scope.eventGridData=angular.copy(EventData.eventVOs);
					 $scope.isAdmin=EventManager.isAdmin;
					
					$scope.deleteConfirmation=function(row){
						$scope.deleteRow=row.entity;
					};
					$scope.deleteEvent=function(){
						var obj ={	eventId:$scope.deleteRow.id	};
						EventManager.deleteEvent(obj);
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

					$scope.saveEvent=function(){
						//angular.copy($scope.newEvent,eventVO);
						
						var eventVO={
							title:$scope.newEvent.title,
							description:$scope.newEvent.description,
							fromDate:$scope.newEvent.fromDate,
								toDate:$scope.newEvent.toDate
						};
						console.log(eventVO);
						EventManager.saveEvent(eventVO);
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications','EventService','EventManager', EventCtrl ];
			});

}(define));