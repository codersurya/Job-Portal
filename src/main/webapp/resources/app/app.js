var jobPortalApp = angular.module('jobPortalWebApp', [ 'ngRoute', 'login',
		'registration', 'jobSearch' ]);

jobPortalApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'resources/app/login/login-page.html',
		controller : 'loginController'
	}).when('/register', {
		templateUrl : 'resources/app/register/registration-page.html',
		controller : 'registrationController'
	}).when('/jobsearch', {
		templateUrl : 'resources/app/jobsearch/job-search-page.html',
		controller : 'jobSearchController'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);
