
<%@ page  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./accueil.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js.js"></script>
<title>Welcome</title>
</head>

<body>

	
	<div class="nav-bar" background="black"><img src="logo.png" class="logo"></div>
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
		<p class="pWlc" style="display: none;">Welcome Admin!</p>
		<div id="sup" style="display: none">
			<div class="contenu">
				<img class="class" src="super.png">
				<p class="class">Supervisor</p>
			</div>
			<img alt="ajout" src="add.png" class="addSup icon_add">
			<div class="plus">
				<div id="navig">
					<p class="champ"  style="color:#4A888A">Wilaya</p>
					<p class="champ">Commune</p>
				</div>
				<hr>
				<%@ include file="Wilayas.jsp" %>
			</div>
		</div>
		<div id="ser" style="display: none">
			<div class="contenu">
				<img class="class" src="service.png">
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
				<%@ include file="Wilayas.jsp" %>
				
			</div>
		</div>
		<div id="dec" style="display: none">
			<div class="contenu">
				<img class="class" src="declaration.png">
				<p class="class">Type Declaration</p>
			</div>
			<img alt="ajout" src="add.png" class="addDec icon_add">
			<div class="plus"></div>
		</div>
	</div>
	
	<div id="SupForm" class="main" style="display: none">
		<form class="form" method="post" action="#">
			<div id="headfrom">
				<h2>Add Supervisor</h2>
				<p class="exit">x</p>
			</div>
			<hr>
			<div id="info">
				<div id="labels">
					<label name="id_card">ID-Card</label><br> <label
						name="phone_number">Phone Number</label><br> <label
						name="town">Town</label><br>
				</div>
				<div id="inputs">
					<input type="text" name="id_card"><br> <input
						type="text" name="phone_number"><br> <input
						type="text" name="town"><br>
				</div>

			</div>
			<div id="subm">
				<input type="submit" name="register" id="register">
			</div>
		</form>
	</div>

	<div id="SerForm" class="main" style="display: none">
		<form class="form" method="post" action="#">
			<div id="headfrom">
				<h2>Add Service</h2>
				<p class="exit">x</p>
			</div>
			<hr>
			<div id="info">
				<div id="labels">
					<label name="service_name">Service Name</label><br> <label
						name="id_card">ID-Card</label><br> <label name="phone_number">Phone
						Number</label><br> <label name="town">Town</label><br> <label
						name="type">Type</label><br>
				</div>
				<div id="inputs">
					<input type="text" name="service_name"><br> <input
						type="text" name="id_card"><br> <input type="text"
						name="phone_number"><br> <input type="text"
						name="town"><br> <input type="text" name="type"><br>
					<input type="hidden" value="Service">
				</div>

			</div>
			<div id="subm">
				<input type="submit" name="register" id="register">
			</div>
		</form>
	</div>

	<div id="DecForm" class="main" style="display: none">
		<form class="form" method="post" action="#">
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