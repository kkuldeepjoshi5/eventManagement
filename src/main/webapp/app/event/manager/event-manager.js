(function(define) {
	"use strict";

	define([], function() {

		var EventManager = function(EventService,$http,i18nNotifications) {
			var deleteBtn='<a ng-click="grid.appScope.deleteConfirmation(row)" style="cursor:pointer;margin-left:2%" tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true"><i class="fa fa-trash-o fa-lg text-danger"></i></a>';
			var editBtn='<a ng-click="grid.appScope.editPage(row)" style="cursor:pointer;margin-left:2%" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true"><i class="fa fa-pencil-square-o fa-lg text-info"></i></a>';
			var isAdmin=true;
			var data={
					 isAdmin:true,
					 saveEvent:function(path,eventVO){
								$http.post(path,eventVO)
								.success(function(res){
									alert("success::"+res);
								})
								.error(function(){
									alert("error::"+res);
								});
							},
					deleteEvent:function(eventGridData,obj,msg,deleteRow){
									EventService.deleteEvent(obj,function(response){
										/*i18nNotifications.removeAll();
										i18nNotifications.pushForCurrentRoute(msg, 'success', {}, {});*/
										var deleteIndex=eventGridData.indexOf(deleteRow);
										eventGridData.splice(deleteIndex, 1);
									},function(error){
										console.log(error);
									});
							},
					addToList:function(item,index,destList,sourceList){
								destList.unshift(item);
								sourceList.splice(index,1);
							},
					addAllToList:function (destination,source){
								$.each(source,function(){
									destination.push(this);
								});
							},
					transferAll:function(destination,source){
								var temp=angular.copy(source);
								this.addAllToList(destination,temp);
								destination=temp;
								source.splice(0,source.length);
							},
					setAddRemoveBtn	:function (source,dest,scope){
								if(!_.isEmpty(source)){
									scope.isForward=true;
								}else{
									scope.isForward=false;
								}
								if(!_.isEmpty(dest)){
									scope.isReverse=true;
								}else{
									scope.isReverse=false;
								}
							},
					getEventUserList:function(listData,uiList){
						var eventUsers=[];
									var filterData=_.filter(listData,function(item){
										var found=false;
										$.each(uiList,function(k,v){
											if(v.id==item.userId){
												found=true;
												return true;
											}
										});
										if(found){
											return true;
										}
									});
									eventUsers=filterData;
								return eventUsers;
							},
					loadList:function(ListData,destList){
								$.each(ListData,function(){
									destList.push({id:this.userId,primary:this.userName,secondry:this.role});
								});
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