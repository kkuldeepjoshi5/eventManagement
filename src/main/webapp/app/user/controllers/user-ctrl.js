(function(define) {
	"use strict";

	define(
			[],
			function() {

				var UserCtrl = function($scope,$http, $location, $state, $rootScope,UserData, i18nNotifications,UserService,UserManager) {
					$scope.newUser=[];
					$scope.newUser.dob = new Date();
					$scope.dobOpen = function($user) {
						$user.preventDefault();
						$user.stopPropagation();

						$scope.isDOBOpened = true;
					};
					
					$scope.userGridData=angular.copy(UserData.userVOs);
					 $scope.isAdmin=UserManager.isAdmin;
					
					$scope.deleteConfirmation=function(row){
						$scope.deleteRow=row.entity;
					};
					$scope.deleteUser=function(){
						var obj ={	userId:$scope.deleteRow.id	};
						UserManager.deleteUser(obj);
					};
					$scope.gridOptions=UserManager.gridOptions;
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

					$scope.saveUser=function(){
						//angular.copy($scope.newUser,userVO);
						
						var userVO={
							firstName:$scope.newUser.firstName,
							lastName:$scope.newUser.lastName,
							dob:$scope.newUser.dob,
							email:$scope.newUser.email,
							role:$scope.newUser.role
						};
						console.log(userVO);
						UserManager.saveUser(userVO);
					}

				};
				return [ '$scope','$http', '$location', '$state', '$rootScope', 'UserData','i18nNotifications','UserService','UserManager', UserCtrl ];
			});

}(define));