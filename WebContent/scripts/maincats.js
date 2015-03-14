$(document).ready(function() {
	"use strict"

	function handleError(error) {
		console.error("error", error, arguments);
	}
	
	function appendToList(list, post) {
		var newElement = $("<li><a href="+post.title+".hmtl>"+post.title+"</a></li>");
		//newElement.text(post.title);
		list.append(newElement);
	}
	function processResponse(response) {
		var list = $("#indexpagelist");
		var i = 0;
		$.each(response, function() {
			appendToList(list, this);
		});
	}

	$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category', {
	  method: "GET"
	}).then(processResponse, handleError);
	
	
});