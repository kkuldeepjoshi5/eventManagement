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

					$scope.deleteEvent=function(){
						var obj ={	eventId:$scope.deleteRow.id	};
						EventManager.deleteEvent($scope.eventGridData,obj,'event.delete.success',$scope.deleteRow);
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
					$scope.editPage=function(row){

						$scope.newEvent=row.entity;
						$scope.waitList=[];
						$scope.newAddedList=[];
						$scope.isForward=false;
						$scope.isReverse=false;
						$scope.createrData=[];
						var obj={
							id:	$scope.newEvent.id
						};
						EventService.beforeEdit(obj,function(response){

									if(response!=null && response.availableUsers!=null){
										$scope.createrData=angular.copy(response.availableUsers);
										EventManager.loadList($scope.createrData,$scope.waitList);
										EventManager.setAddRemoveBtn($scope.waitList,$scope.newAddedList,$scope);
									}
									if(response!=null && response.existingUsers!=null){
										$scope.createrData2=angular.copy(response.existingUsers);
										EventManager.loadList($scope.createrData2,$scope.newAddedList);
										$scope.newEvent.eventUsers = $scope.createrData2 ;
										EventManager.setAddRemoveBtn($scope.waitList,$scope.newAddedList,$scope);
									}
								},function(error){
									console.log(error);
									return null;
								});
						angular.element("#createEditModel").modal("show");
					};
					$scope.beforeCreate=function(){

						$scope.newEvent=[];
						$scope.newEvent.fromDate = new Date();
						$scope.newEvent.toDate = new Date();
						$scope.waitList=[];
						$scope.newAddedList=[];
						$scope.isForward=false;
						$scope.isReverse=false;
						$scope.createrData=[];
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
						if($scope.newEvent.id!=null){
							eventVO.id=$scope.newEvent.id;
							var newAddedDataList=EventManager.getEventUserList($scope.newEvent.eventUsers , $scope.newAddedList);
							eventVO.creatableEventUsers=EventManager.getCreatableEventUserInEditMode($scope.createrData , $scope.newAddedList);
							eventVO.deletableEventUsers=EventManager.getDeletableEventUserInEditMode($scope.createrData , $scope.newAddedList);
							
						}else{
							eventVO.creatableEventUsers=EventManager.getEventUserList($scope.createrData,$scope.newAddedList);
						}
					
						
						console.log(eventVO);
						EventManager.saveEvent(path,eventVO);
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'EventData','i18nNotifications','EventService','EventManager', EventCtrl ];
			});

}(define));