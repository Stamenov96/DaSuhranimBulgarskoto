$(document).ready(function() {
	"use strict"


	function handleError(error) {
		console.error("error", error, arguments);
	}
	
	function appendToList(list, post) {
		var newElement = $("<li/>");
		newElement.text(post.title);
		list.append(newElement);
	}
	function processResponse(response) {
		var list = $("#posts");
		var i = 0;
		$.each(response, function() {
			appendToList(list, this);
			if (++i >= 5) {
				return false;
			}
		});
	}

	
	
	$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category', {
	  method: "GET"
	}).then(processResponse, handleError);

	 $.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category', {
		  method: 'POST',
		  data: {
			  	id:5,
			    title: 'New Main Category',
			    desctiption: 'This si a new main category'
		  } 
		}).then(function(data) {
			console.log(data)});
	
	

});