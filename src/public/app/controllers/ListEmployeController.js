"use strict"
angular.module("bankonetModule")
.controller('ListEmployeController', function(EmployeService){
	var listEmpCtrl=this;

	function fetchEmployes(){
		EmployeService.getEmployes()
			.then(function(employes){
				console.log(employes)
				listEmpCtrl.employes=employes.data;
		})
	}
	fetchEmployes();
})