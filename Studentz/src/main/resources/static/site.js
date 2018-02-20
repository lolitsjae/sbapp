				$(document).ready(function(){
					$(document.getElementById("addStudent")).click(function(){
						$.ajax({
							url: "/addStudent",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication", document.getElementById("Authentication").value);},
							type: "POST",
							data: {
								firstName: document.getElementById("firstName").value,
								lastName: document.getElementById("lastName").value,
								studId: document.getElementById("studId").value,
							}
						});
					});
		
		
					$(document.getElementById("getStudent")).click(function(){
						$.ajax({
							url: "/getStudent",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication",document.getElementById("Authentication").value);},
							type: "GET",
							data: {
								studId: document.getElementById("studId").value
								}
						});
					});		
		
		
					$(document.getElementById("getAll")).click(function(){
						$.ajax({
							url: "/getAll",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication", document.getElementById("Authentication").value);},
							type: "GET"
						});
					});		
		
		
					$(document.getElementById("deleteStudent")).click(function(){
						$.ajax({
							url: "/deleteStudent",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication",document.getElementById("Authentication").value);},
							data: {
								studId: document.getElementById("studId").value
								},
							type: "POST"
						});
					});	
	
		
					$(document.getElementById("deleteAll")).click(function(){
						$.ajax({
							url: "/deleteAll",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication", document.getElementById("Authentication").value);},
							type: "DELETE"
						});
					});		
		
		
					$(document.getElementById("updateStudent")).click(function(){
						$.ajax({
							url: "/updateStudent",
							beforeSend: function(xhr){xhr.setRequestHeader("Authentication", document.getElementById("Authentication").value);},
							type: "PUT",
							data:{
								firstName: document.getElementById("firstName").value,
								lastName: document.getElementById("lastName").value,
								studId: document.getElementById("studId").value,
								}
						});
					});				
				});
