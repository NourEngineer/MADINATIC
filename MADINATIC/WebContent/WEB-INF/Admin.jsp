<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./css.css">
<title>Insert title here</title>
</head>
<style>
.dropdown-submenu {
  position: relative;
}

.dropdown-submenu .dropdown-menu {
  top: 0;
  left: 100%;
  margin-top: -1px;
}
</style>
<body>
	<script>
$(document).ready(function(){
  $('.dropdown-submenu a.test').on("click", function(e){
    $(this).next('ul').toggle();
    e.stopPropagation();
    e.preventDefault();
  });
});
</script>  

<button>Ajouter Superviseur</button> 
<button>Ajouter Service</button>
<!--  
<div name="service">
	<form action="Post" >
		<label name="ServiceName">Nom de Service</label>
		<input type="text" name="ServiceName"><br>
		<label name="AgentService">ID carte</label>
		<input type="text" name="AgentService"><br>
		 <div class="dropdown"> 
		    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Commune
		    <span class="caret"></span></button>
		    <ul class="dropdown-menu">
		      <li class="dropdown-submenu">
		        <a class="test" tabindex="-1" href="#">Alger <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a tabindex="-1" href="#">Bab Zouar</a></li>
		          <li><a tabindex="-1" href="#">Oued Semr</a></li>
		        </ul>
		      </li>
		      <li class="dropdown-submenu">
		        <a class="test" tabindex="-1" href="#">Ouargla <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a tabindex="-1" href="#">Mekhadma</a></li>
		          <li><a tabindex="-1" href="#">Rouissat</a></li>
		        </ul>
		      </li>
		    </ul>
		 </div> 
		 <input type="submit">
	</form>
</div>-->

	<form method="post" action="Servlet" >
		<label name="id_card">ID carte</label>
		<input type="text" name="id_card"/><br>
		<label name="phone_number">Numero de telephone</label>
		<input type="text" name="phone_number"/><br>
		<!--  <div class="dropdown"> 
		    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Commune
		    <span class="caret"></span></button>
		    <ul class="dropdown-menu">
		      <li class="dropdown-submenu">
		        <a class="test" tabindex="-1" href="#">Alger <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a tabindex="-1" href="#">Bab Zouar</a></li>
		          <li><a tabindex="-1" href="#">Oued Semr</a></li>
		        </ul>
		      </li>
		      <li class="dropdown-submenu">
		        <a class="test" tabindex="-1" href="#">Ouargla <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a tabindex="-1" href="#">Mekhadma</a></li>
		          <li><a tabindex="-1" href="#">Rouissat</a></li>
		        </ul>
		      </li>
		    </ul>
		 </div> -->
		 <input type="submit"/>
	</form>


</body>
</html>