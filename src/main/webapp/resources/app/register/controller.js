var controllers = angular
		.module("registration", [ 'ngRoute' ])
		.controller(
				"registrationController",
				function($scope, $http, $location) {

					$scope.isFieldsEmptyError = false;
					$scope.isPwdsNotSameError = false;
					$scope.isRegisterFailError = false;
					$scope.rePassword = false;
					$scope.registerFailErrMsg = "";
					$scope.registerUser = {
						fullname : '',
						username : '',
						password : '',
						email : '',
						mobile : ''
					};

					$scope.register = function() {
						$scope.isPwdsNotSameError = false;
						$scope.isFieldsEmptyError = false;
						$scope.isRegisterFailError = false;
						if ($scope.registerUser.fullname === ''
								|| $scope.registerUser.fullname === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.rePassword === ''
								|| $scope.rePassword === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.registerUser.username === ''
								|| $scope.registerUser.username === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.registerUser.password === ''
								|| $scope.registerUser.password === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.registerUser.email === ''
								|| $scope.registerUser.email === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.registerUser.mobile === ''
								|| $scope.registerUser.mobile === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else if ($scope.registerUser.password !== $scope.rePassword) {
							$scope.isPwdsNotSameError = true;
							return;
						} else {

							$http({
								method : 'POST',
								url : 'jobportal/user/register',
								data : $scope.registerUser,
							// headers: {'Content-Type':
							// 'application/x-www-form-urlencoded'}
							})
									.success(
											function(data, status, headers,
													config) {
												if (data.userAdded === true && data.error === null) {
													$location.path('/login');
												} else if (data.userAdded === false && data.error !== null) {
													$scope.registerFailErrMsg = data.error.message;
													$scope.isRegisterFailError = true;
												}
											})
									.error(
											function(data, status, headers,
													config) {
												alert('An Error ocured while making Rest call Status : '
														+ status);
											});
						}
					};

					$scope.cancel = function() {

						// alert("Hi in cancel.........");
						$location.path('/login');

					};

				});
