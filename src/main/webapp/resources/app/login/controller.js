var controllers = angular
		.module("login", [ 'ngRoute' ])
		.controller(
				"loginController",
				function($scope, $http, $location) {

					$scope.inValidLoginError = false;
					$scope.userNameError = false;
					$scope.passwordError = false;
					$scope.invalidLoginMsg = "";

					$scope.user = {
						username : '',
						password : ''
					};

					$scope.login = function() {

						if ($scope.user.username === ''
								|| $scope.user.username === undefined) {
							$scope.userNameError = true;
						} else if ($scope.user.password === ''
								|| $scope.user.password === undefined) {
							$scope.passwordError = true;
						} else {
							$scope.inValidLoginError = false;
							$scope.userNameError = false;
							$scope.passwordError = false;
							$http({
								method : 'POST',
								url : 'jobportal/user/login',
								data : $scope.user,
							// headers: {'Content-Type':
							// 'application/x-www-form-urlencoded'}
							})
									.success(
											function(data, status, headers,
													config) {
												if (data.error === null && data.user !== null && data.user.username !== null) {
													$location.path('/jobsearch');
												} else if(data.error !== null){
													$scope.inValidLoginError = true;
													$scope.invalidLoginMsg = data.error.message;
												}
											})
									.error(
											function(data, status, headers,
													config) {
												alert('Error ocured while making Rest call Status : '
														+ status);
											});
						}
					};

					$scope.cancel = function() {
						$location.path('/login');
					};
					    $scope.registerNow = function() {
						$location.path('/register');
					};

				});