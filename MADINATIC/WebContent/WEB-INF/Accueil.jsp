<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./accueil.css">
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js.js"></script>
<title>Welcome</title>
</head>

<body>

	<nav class="navbar navbar-light bg-dark">
	  <a  href="Servlet" style="color: white"><!-- class="navbar-brand" -->
	    <img src="logo.png" width="40" height="30" class="d-inline-block align-top" alt=""> MADINATIC
	  </a>
	</nav>
	
	<div class="left">
		<div class="circle" id="supervisor">
			<img src="super.png">
		</div>
		<div class="circle" id="service">
			<img src="service.png">
		</div>
		<div class="circle" id="declaration">
			<img src="declaration.png">
		</div>
	</div>
	<div class="right">
		<div id="sup" style="display: none">
			<div class="contenu">
				<p class="class">Supervisor</p>
				<img alt="ajout" src="add.png" class="addSup icon_add">
			</div>
			<div class="plus">
				<div id="navig">
					<p class="champ"  style="color:#4A888A">Wilaya</p>
					<p class="champ">Commune</p>
				</div>
				<hr>
				<%@ include file="towns.jsp" %>
			</div>
		</div>
		<div id="ser" style="display: none">
			<div class="contenu">
				<p class="class">Services</p>
			</div>
			<img alt="ajout" src="add.png" class="addSer icon_add">
			<div class="plus">
				<div id="navig">
					<p class="champ" style="color:#4A888A">Wilaya</p>
					<p class="champ">Commune</p>
					<p class="champ">Service</p>
				</div>
				<hr>
				<%@ include file="services.jsp" %>
				
			</div>
		</div>
		<div id="dec" style="display: none">
			<div class="contenu">
				<p class="class">Type Declaration</p>
			</div>
			<img alt="ajout" src="add.png" class="addDec icon_add">
			<div class="plus"></div>
		</div>
	</div>
	
	<!-- <div id="SupForm" class="main" style="display: none">
		<form class="form" method="post" action="Servlet">
			<div id="headfrom">
				<h2>Add Supervisor</h2>
				<p class="exit">x</p>
			</div>
			<hr>
			<div id="info">
				<div id="labels">
					<label name="id_card">ID-Card</label><br>
					<label name="name">Name</label>
					<label name="first_name">First Name</label>
					 <label name="phone_number">Phone Number</label><br>
					 <label name="town">Town</label><br>
						
				</div>
				<div id="inputs">
					<input type="text" name="id_card"><br>
					<input type="text" name="name"><br>
					<input type="text" name="first_name">
					<input type="text" name="phone_number"><br>
					<input type="text" name="town"><br>
						
						<input type="hidden" value="Supervisor" name="kind">
				</div>

			</div>
			<div id="subm">
				<input type="submit" name="register" id="register">
			</div>
		</form>
	</div>-->

	<div id="SerForm" class="main" style="display: none">
		<form class="form" method="post" action="Servlet">
			<div id="headfrom">
				<h2>Add Service</h2>
				<p class="exit">x</p>
			</div>
			<hr>
			<div id="info">
				<div id="labels">
					<label name="service_name">Service Name</label><br>
					<label name="id_card">ID-Card</label><br>
					<label name="name">Name</label>
					<label name="first_name">First Name</label>
					<label name="email">E-mail</label><br>
					<label name="phone_number">Phone Number</label><br>
					<label name="site_web">Site Web</label><br>
					<label name="town">Town</label><br> 
					<label name="type">Type</label><br>
				</div>
				<div id="inputs">
					<input type="text" name="service_name"><br> 
					<input type="text" name="id_card"><br> 
					<input type="text" name="name"><br>
					<input type="text" name="first_name">
					<input type="text" name="email"><br>
					<input type="text" name="phone_number"><br>
					<input type="text" name="site_web"><br>
					<input type="text" name="town"><br>
					<input type="text" name="type"><br>
					<input type="hidden" value="Service" name="kind">
				</div>

			</div>
			<div id="subm">
				<input type="submit" name="register" id="register">
			</div>
		</form>
	</div>

	<div id="DecForm" class="main" style="display: none">
		<form class="form" method="post" action="Servlet">  <!-- ${pageContext.request.contextPath}/Servlet -->
			<div id="headfrom">
				<h2>Add Declaration Type</h2>
				<p class="exit">x</p>
			</div>
			<hr>
			<div id="info">
				<div id="labels">
					<label name="title">Title</label><br>
				</div>
				<div id="inputs">
					<input type="text" name="title"><br>
					<input type="hidden" value="Declaration" name="kind">
				</div>

			</div>
			<div id="subm">
				<input type="submit" name="register" id="register">
			</div>
		</form>
	</div>

	<div class="container">

		<div id="sup">
			<div class="contenu">
				<img class="class" src="super.png">
				<p class="class">Supervisor</p>
			</div>
			<img alt="ajout" src="add.png" class="addSup icon_add">
			<div class="plus">
				<div id="navig">
					<p class="champ" style="color: #4A888A">Wilaya</p>
					<p class="champ">Commune</p>
					<p class="champ">Service</p>
				</div>
				<hr>
				<div class="wilayas">
					<div class="wilaya">
						<p class="name">Ouargla</p>
						<p class="nb">0</p>
					</div>
					<div class="wilaya">
						<p class="name">Sidi Bel-Abbas</p>
						<p class="nb">0</p>
					</div>
				</div>
			</div>
		</div>

		<div id="ser">
			<div class="contenu">
				<img class="class" src="service.png">
				<p class="class">Services</p>
			</div>
			<img alt="ajout" src="add.png" class="addSer icon_add">
			<div class="plus">
				<div id="navig">
					<p class="n">Wilaya</p>
					<p class="n">Commune</p>
					<p class="n">Service</p>
				</div>

			</div>
		</div>
		<div id="dec">
			<div class="contenu">
				<img class="class" src="declaration.png">
				<p class="class">Type Declaration</p>
			</div>
			<img alt="ajout" src="add.png" class="addDec icon_add">
			<div class="plus"></div>
		</div>
	</div>

</body>
</html>