"use strict"

angular.module("bankonetModule")
.factory("EmployeService", ['$http', function($http){
	return{
		version : "1.0",
		pseudo: "Romain",
		apiUrl: "http://localhost:8081/bankonetREST",
		listEmployesUrl: "http://localhost:8081/bankonetREST/api/employes/list",
		employeUrl: "http://localhost:8081/bankonetREST/api/employes",
		getEmployes: function (){
			return $http.get(this.listEmployesUrl)
			/*.then(function(result){
					return result.data;
				})*/
		},
		addEmploye: function(){
			return $http.post(this.employeUrl);
		}
	}
}])