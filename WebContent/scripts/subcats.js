$(document).ready(function() {
	"use strict"

	
	
	
	
	$("#severinfo").click(function() {
		$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1', {
			  method: "GET"
			}).then(function(data) {
				var pars = JSON.stringify(data);
				console.log(pars);
				pars= pars.split(":");
				//var par = JSON.parse(pars);
				alert(pars[3].substr(0, pars[3].length-1) );
				return false;
				//console.log(pars);
			});
	
	});
	
	
	
	
	
});