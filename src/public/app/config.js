"use strict"
angular.module("bankonetModule",['ui.router'/*,'ui.bootstrap'*/])
.config(function ($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/');

	$stateProvider
		.state('index', {
			url:'/',
			views: {
				'header': {
					templateUrl: 'view/header.html'
				},
				'content': {
					templateUrl: 'view/home.html'
				},
				'footer':{
					templateUrl: 'view/footer.html'
				}
			}
		})
		.state('listeEmploye', {
			url:'/api/employes',
			views:{
				'header': {
						templateUrl: 'view/header.html'
				},
				'content': {
					templateUrl: 'view/employesListe.html',
					controller: 'ListEmployeController',
					controllerAs: 'listEmpCtrl'
				},
				'footer':{
						templateUrl: 'view/footer.html'
				}
			}
		})
});


