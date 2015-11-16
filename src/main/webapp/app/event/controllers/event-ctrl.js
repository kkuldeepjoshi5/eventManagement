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
					$scope.addToList=function(item,index,type){
						if(type=='newAdd'){
							EventManager.addToList(item,index,$scope.newAddedList,$scope.waitList);
						}else{
							EventManager.addToList(item,index,$scope.waitList,$scope.newAddedList);
						}
						
						EventManager.setAddRemoveBtn($scope.waitList,$scope.newAddedList,$scope);
					};
					
					$scope.addAll=function(type){
						if(type=='newAdd'){
							EventManager.transferAll($scope.newAddedList,$scope.waitList);
						}else{
							EventManager.transferAll($scope.waitList,$scope.newAddedList);	
						}
						EventManager.setAddRemoveBtn($scope.waitList,$scope.newAddedList,$scope);
					};
					
					$scope.beforeCreate=function(){

						$scope.newEvent=[];
						$scope.newEvent.fromDate = new Date();
						$scope.newEvent.toDate = new Date();
						$scope.waitList=[];
						$scope.newAddedList=[];
						$scope.isForward=false;
						$scope.isReverse=false;
						EventService.beforeCreate(function(response){
									
									if(response!=null && response.availableUsers!=null){
										$scope.createrData=angular.copy(response.availableUsers);
										EventManager.loadList($scope.createrData,$scope.waitList);
										EventManager.setAddRemoveBtn($scope.waitList,$scope.newAddedList,$scope);
									}
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
							toDate:$scope.newEvent.toDate,
							eventUsers:EventManager.getEventUserList($scope.createrData,$scope.newAddedList)
						};
						console.log(eventVO);
						EventManager.saveEvent(path,eventVO);
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications','EventService','EventManager', EventCtrl ];
			});

}(define));