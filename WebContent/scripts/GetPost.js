$(document).ready(function() {
	"use strict"

/*
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
	
	*/
	 
	$("#regbutton").click(function() {
		
		 var name = $("#name").val();
		 var username = $("#username").val();
		 var email = $("#email").val();
		 var password = $("#password").val();
		
		
		 if(name.length <= 0){	 
			 alert("You must enter name");
			 return false;
		 } else if(username.length <= 0){
			 alert("You must enter username");
			 return false;
		 } else if(email.length <= 0){
			 alert("You must enter email");
			 return false;
		 } else if(password.length <= 0){
			 alert("You must enter password");
			 return false;
		 }
		 
		var randid = Math.floor((Math.random() * 100) + 1);
		 console.log(randid);
		 
		 $.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/users/', { 
			 method: 'POST',
			  data: {
				  	id: randid,
				    name: name,
				    username: username,
		            email: email,
		            password: password
			  },
			  success:function(result)
		       {
		        alert('You have successfully registered');
		       },
		       error:function(exception){alert('Exeption:'+exception);}
		 })	
		 return false;
	})
});