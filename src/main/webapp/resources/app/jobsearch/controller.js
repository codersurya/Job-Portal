var controllers = angular
		.module("jobSearch", [ 'ngRoute' ])
		.controller(
				"jobSearchController",
				function($scope, $http, $location) {
					$scope.isFieldsEmptyError = false;

					$scope.keyword = '';

					$scope.searchJob = function() {
						if ($scope.keword === ''
								|| $scope.keyword === undefined) {
							$scope.isFieldsEmptyError = true;
							return;
						} else {
							$scope.isFieldsEmptyError = false;
							$http({
								method : 'GET',
								url : 'jobportal/user/jobsearch/'+$scope.keyword,
							// headers: {'Content-Type':
							// 'application/x-www-form-urlencoded'}
							})
									.success(
											function(data, status, headers,config) {
												$scope.jobList = data.jobs;
											})
									.error(
											function(data, status, headers,config) {
												alert('An Error ocured while making Rest call Status : '+ status);
											});
						}
					};
				});
