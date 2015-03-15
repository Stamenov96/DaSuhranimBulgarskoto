$(document).ready(function() {
	"use strict"

	var a = {"Ё":"YO","Й":"I","Ц":"TS","У":"U","К":"K","Е":"E","Н":"N","Г":"G","Ш":"SH","Щ":"SCH","З":"Z","Х":"H","Ъ":"'","ё":"yo","й":"i","ц":"ts","у":"u","к":"k","е":"e","н":"n","г":"g","ш":"sh","щ":"sch","з":"z","х":"h","ъ":"'","Ф":"F","Ы":"I","В":"V","А":"a","П":"P","Р":"R","О":"O","Л":"L","Д":"D","Ж":"ZH","Э":"E","ф":"f","ы":"i","в":"v","а":"a","п":"p","р":"r","о":"o","л":"l","д":"d","ж":"zh","э":"e","Я":"Ya","Ч":"CH","С":"S","М":"M","И":"I","Т":"T","Ь":"'","Б":"B","Ю":"YU","я":"ya","ч":"ch","с":"s","м":"m","и":"i","т":"t","ь":"'","б":"b","ю":"yu"};

	function transliterate(word){
	  return word.split('').map(function (char) { 
	    return a[char] || char; 
	  }).join("");
	}
	
	
	function handleError(error) {
		console.error("error", error, arguments);
	}
	
	function appendToList(list, post) {
		console.log(post.title);
		var newElement = $("<li id='"+transliterate(post.title.split(" ")[0])+"'>"+post.title+"<button id='"+transliterate(post.title.split(" ")[0])+"'>Read full article</button></li><br>");
		list.append(newElement);
	}
	function processResponse(response) {
		console.log(response);
		var list = $("#severlist");
		$.each(response, function() {
			appendToList(list, this);
		});
		
		
		$("#Horata").one("click",function() {
			//debugger;
			$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1/post/1', {
				  method: "GET"
				}).then(function(data) {
					var pars = JSON.stringify(data);
					//console.log(data.title);
					//$.each(data,function(){
						console.log(data[0].content);
					//});
					
						var article = $("#Horata");
						article.append("<br><p>"+data[0].content+"</p>");
						article.append("<br><p>---------------------</p><br>")
								
						

						$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1/post/1/comments', {
							  method: "GET"
							}).then(function(data2) {
								$.each(data2,function(){
									console.log(this.author);
									article.append("<h3>"+this.author+":</h3>");
									article.append("<p>"+this.text+"</p>");
								})
								
							});
						
					
					
			
					article.append("<form>Username:<input type='text' uname='uname' id='unamecoment'><textarea id='txtarea1' name='myTextBox' cols='150' rows='5'></textarea><br/> <button type='submit' value='Submi' id='commentbtn'>Comment</button> </form>");
					
					
					
					
					$("#commentbtn").one("click",function(){
						var uname = $("#unamecoment").val();
						var text = $("#txtarea1").val();
						$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1/post/1/comments', { 
							 method: 'POST',
							  data: {
								    'id': 1,
								    'author': uname,
								    'text': text,
								    'subcat': 1,
								    'post': 1
							},
							  success:function(result)
						       {
						        alert('You successfully published your comment');
						       },
						       error:function(exception){alert('Exeption:'+exception);}
						      
						 })	
						 return false;
						 
					});					
					
					
					
				},handleError);
		});
		
		
		
	}

	
	
	$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1/posts', {
	  method: "GET"
	}).then(processResponse, handleError);
	
	
	$("#severinfo").click(function() {
		$.ajax('http://private-9ece4-dasuhranimbulgarskoto.apiary-mock.com/category/1/subcat/1', {
			  method: "GET"
			}).then(function(data) {
				var pars = JSON.stringify(data);
				//console.log(pars);
				pars= pars.split(":");
				//var par = JSON.parse(pars);
				alert(pars[3].substr(0, pars[3].length-1) );
				return false;
				//console.log(pars);
			});
	
	});

	
});