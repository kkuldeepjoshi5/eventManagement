(function(define) {
	"use strict";

	define([], function() {

		var EventManager = function(EventService,$http,i18nNotifications) {
			var deleteBtn='<a ng-click="grid.appScope.deleteConfirmation(row)" style="cursor:pointer;margin-left:2%" tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true"><i class="fa fa-trash-o fa-lg text-danger"></i></a>';
			var editBtn='<a ng-click="grid.appScope.editPage(row)" style="cursor:pointer;margin-left:2%" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true"><i class="fa fa-pencil-square-o fa-lg text-info"></i></a>';
			var isAdmin=true;
			var data={
					 isAdmin:true,
					 saveEvent:function(eventVO){
								$http.post('/rest/event/insert',eventVO)
								.success(function(res){
									alert("success::"+res);
								})
								.error(function(){
									alert("error::"+res);
								});
							},
					deleteEvent:function(eventGridData,obj){
									EventService.deleteEvent(obj,function(response){
										i18nNotifications.removeAll();
										i18nNotifications.pushForCurrentRoute('event.delete.success', 'success', {}, {});
										var deleteIndex=eventGridData.indexOf(deleteRow);
										eventGridData.splice(deleteIndex, 1);
									},function(error){
										console.log(error);
									});
							},
					addToWaitList:function(item,index,waitList,newAddedList){
								waitList.unshift(item);
								newAddedList.splice(index,1);
								setAddRemoveBtn();
							},
					addToNewAddList:function(item,index,waitList,newAddedList){
								$scope.newAddedList.unshift(item);
								$scope.waitList.splice(index,1);
								setAddRemoveBtn();
							},
					addToList:function (destination,source){
								$.each(source,function(){
									destination.push(this);
								});
							},
					transferAll:function(destination,source){
								var temp=angular.copy(source);
								addToList(temp,destination);
								destination=temp;
								source=[];
								setAddRemoveBtn();
							},
					setAddRemoveBtn	:function (waitList,newAddedList,isForward,isReverse){
								if(!_.isEmpty(waitList)){
									isForward=true;
								}else{
									isForward=false;
								}
								if(!_.isEmpty(newAddedList)){
									isReverse=true;
								}else{
									isReverse=false;
								}
							},
					loadList:function(){
							 var idList=_.pluck($scope.newAddedList,'id');
				        	 if( ! _.contains(idList,item.id)){
				        		 $scope.waitList.push({firstNameUpperCase: item.name, enrollmentNumber: item.enrollmentNumber,id:item.id});
				        	 }
							},
					gridOptions : {
							multiSelect : false,
							enableCellEditOnFocus : true,
							data : 'eventGridData',
							columnDefs : [
									{
										name: 's.no',
										cellTemplate: '<div align="center" style="padding-top: 6%;" class="ngCellText">{{grid.renderContainers.body.visibleRowCache.indexOf(row) +1}}</div>',
										enableSorting : false,
										width:60
									},
									{
										name : 'title',
										enableCellEdit: true,
										width:300
									},
									{
										field : 'fromDate',
										type: 'date',
										enableCellEdit: true,
										cellFilter: 'date:"dd-MMM-yyyy"'
									},
									{
										field : 'toDate',
										type: 'date',
										enableCellEdit: true,
										cellFilter: 'date:"dd-MMM-yyyy"'
									},
									{
										field:'  ',
										displayName:'  ',
										name:' ',
										enableCellEdit: false,
										enableSorting : false,
										visible : isAdmin,
										cellTemplate:'<div class="" style="padding-top: 1%;">'+editBtn+deleteBtn+'</div>'
									}
									],

						}
				};
			return data;
			};

		return [ 'EventService','$http','i18nNotifications',EventManager  ];
	});
}(define));