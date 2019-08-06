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
				if($(this).text()== "Commune"){
					$(this).css("color","black");
				}
				if($(this).text()== "Wilaya"){
					$(this).css("color","#4A888A");
				}
			});
			$(".wilaya").show();
			$(".towns").hide();
		}
	});
	$("#supervisor").click(function() {
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
	});
	$("#service").click(function() {
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
		$("#ser").show();
		$("#sup").hide();
		$("#dec").hide();
	});
	$("#declaration").click(function() {
		$("#dec").show();
		$("#ser").hide();
		$("#sup").hide();
	});
	$(".wilaya").click(function(){
		$(".champ").each(function(index){
			if($(this).text()== "Commune") $(this).css("color","#4A888A");
			if($(this).text()== "Wilaya") $(this).css("color","black");
		});
		$(".wilaya").hide();
		$("#"+this.getAttribute('id')+".towns").show();
	});
});
