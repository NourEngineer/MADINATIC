/**
 * 
 */
$(document).ready(function() {
	/*
	 * $('#sup').on("click", function(e){ window.location.replace("Admin.jsp");
	 * });
	 */
	$(".addSup").click(function() {
		$("#SupForm").show();
	});
	$(".addSer").click(function() {
		$("#SerForm").show();
	});
	$(".addDec").click(function() {
		$("#DecForm").show();
	});
	$(".exit").click(function() {
		// $("#subm").off("click");
		$(".main").hide();
	});
	/*$(".left").click(function() {
		if(!$(".pWlc").is(':visible')) $(".pWlc").show();
		else $(".pWlc").hide();
	});
	$(".circle").click(function() {
		$("#sup").show();
	});*/
	$(".champ").click(function(){
		if($(this).text()== "Wilaya"){
			$(".champ").each(function(index){
				if($(this).text()== "Wilaya"){
					$(this).css("color","#4A888A");
				}
				else $(this).css("color","black");
			});
			$(".wilaya").show();
			$(".towns").hide();
			$(".services").hide();
		}
		
	});
	$("#supervisor").click(function() {
		if($("#"+this.getAttribute('id')).css("opacity")=="0.4"){
			$("#"+this.getAttribute('id')).css("opacity","1");
			$("#service").css("opacity","0.4");
			$("#declaration").css("opacity","0.4");
			$(".wilaya").show();
			$(".towns").hide();
			$(".champ").each(function(index){
				if($(this).text()== "Commune"){
					$(this).css("color","black");
				}
				if($(this).text()== "Wilaya"){
					$(this).css("color","#4A888A");
				}
			});
			$("#sup").show();
			$("#ser").hide();
			$("#dec").hide();
		}else{
			$("#sup").hide();
			$("#"+this.getAttribute('id')).css("opacity","0.4");
		}
		
	});
	$("#service").click(function() {
		if($("#service").css("opacity")=="0.4"){
			$("#service").css("opacity","1");
			$("#supervisor").css("opacity","0.4");
			$("#declaration").css("opacity","0.4");
			$(".wilaya").show();
			$(".towns").hide();
			$(".services").hide();
			$(".champ").each(function(index){
			
				if($(this).text()== "Wilaya"){
					$(this).css("color","#4A888A");
				} else $(this).css("color","black");
			});
			$("#ser").show();
			$("#sup").hide();
			$("#dec").hide();
		}else{
			$("#ser").hide();
			$("#"+this.getAttribute('id')).css("opacity","0.4");
		}
	});
	$("#declaration").click(function() {
		if($("#"+this.getAttribute('id')).css("opacity")=="0.4"){
			$("#"+this.getAttribute('id')).css("opacity","1");
			$("#supervisor").css("opacity","0.4");
			$("#service").css("opacity","0.4");
			$("#dec").show();
			$("#ser").hide();
			$("#sup").hide();
		}else{
			$("#dec").hide();
			$("#"+this.getAttribute('id')).css("opacity","0.4");
		}
	});
	$(".wilaya").click(function(){
		$(".champ").each(function(index){
			if($(this).text()== "Commune") $(this).css("color","#4A888A");
			if($(this).text()== "Wilaya") $(this).css("color","black");
			if($(this).text()== "Service") $(this).css("color","black");
		});
		$(".wilaya").hide();
		$("#"+this.getAttribute('id')+".towns").show();
	});
	$(".town").click(function(){
		if($(this).parent().parent().parent().attr("id")=="towns"){

		}else{
			$(".champ").each(function(index){
				if($(this).text()== "Commune") $(this).css("color","black");
				if($(this).text()== "Wilaya") $(this).css("color","black");
				if($(this).text()== "Service") $(this).css("color","#4A888A");
			});
	
			$(".towns").hide();
			$("#"+this.getAttribute('id')+".services").show();
		}

	});

});
