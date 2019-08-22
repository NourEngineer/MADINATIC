<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wilaya</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="town.css">
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script><!-- //code.jquery.com/jquery-1.11.1.min.js -->
<script type="text/javascript">
$(document).ready(function() {
	/*$(".input").focus(function() {
		$(this).parent().addClass("focus");
	});*/
	$("#submit").css("display","none");
	$("#cancel").css("display","none");
	$(".input").parent().addClass("focus");
	var att = document.createAttribute("disabled");       // Create a "class" attribute
	att.value = "disabled"; 
	$(".input").each(function(index){
		$(this).prop("disabled",true);
	});
	$("#edit").click(function(){
		$("#submit").css("display","inline-block");
		$("#cancel").css("display","inline-block");
		$("#edit").css("display","none");
		$("#delete").css("display","none");
		$(".input").each(function(index){
			$(this).prop("disabled",false);
		});
	});
	$("#cancel").click(function(){
		$("#submit").css("display","none");
		$("#cancel").css("display","none");
		$("#edit").css("display","inline-block");
		$("#delete").css("display","inline-block");
		$(".input").each(function(index){
			$(this).prop("disabled",true);
		});
	});
	
	
});
</script>
</head>

<body>
	<nav class="navbar navbar-light bg-dark">
	  <a  href="Servlet" style="color: white"><!-- class="navbar-brand" -->
	    <img src="logo.png" width="40" height="30" class="d-inline-block align-top" alt=""> MADINATIC
	  </a>
	</nav>
	<div class="container-fluid">
		<div class="container">
			<div class="formBox">
				<form  method="post" action="UpdateTown">
<!-- 
						<div class="row">
							<div class="col-sm-12">
								<h1>Show</h1>
							</div>
						</div>
 -->
 						<div class="inputBox " style="display : none">
									<div class="inputText">Town Name</div>
									<input type="text" name="town" value="${supervisor.town.id_town }" class="input">
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="inputBox ">
									<div class="inputText">Town Name</div>
									<input type="text" name="town_name" value="${supervisor.town.name }" class="input">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="inputBox">
									<div class="inputText">Supervisor ID-Card</div>
									<input type="text" name="id_card" value="${supervisor.employee.id_card }" class="input">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6">
								<div class="inputBox">
									<div class="inputText">Supervisor Name</div>
									<input type="text"  name="supervisor_name" value="${supervisor.employee.name }" class="input">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="inputBox">
									<div class="inputText">Supervisor First Name</div>
									<input type="text" name="first_name" value="${supervisor.employee.first_name }" class="input">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6">
								<div class="inputBox">
									<div class="inputText">Mobile</div>
									<input type="text"  name="mobile" value="${supervisor.employee.phone_number}" class="input">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="inputBox">
									<div class="inputText">E-mail</div>
									<input type="text"  name="email" value="${supervisor.employee.phone_number}" class="input">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-12">
								<input id="submit" type="submit" name="" class="col-sm-6 button" value="Submit">
								<button type="button" class="col-sm-6 button" id="cancel">Cancel</button>
							</div>
						</div>
				</form>
				<div class="row">
					<div class="col-sm-12">
						<button class="button col-sm-6" id="edit">Edit</button>
						<button class="button col-sm-6" id="delete">Delete</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>

