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

	
	
	$.ajax('http://private-9a35a-firstapi108.apiary-mock.com/notes', {
	  method: "GET"
	}).then(processResponse, handleError);

	 $.ajax('http://private-9a35a-firstapi108.apiary-mock.com/notes', {
		  method: 'POST',
		  data: {
			  	id:5,
			    title: 'NEW POST',
		  } 
		}).then(function(data) {
			console.log(data)});
	
	

});