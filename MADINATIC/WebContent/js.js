/**
 * 
 */
$(document).ready(function(){
	/*  $('#sup').on("click", function(e){
		  window.location.replace("Admin.jsp");
	  });*/
	  $(".icon_add").click(function(){
		  $(".main").show();
		  });
	  
		$(".exit").click(function(){
			$("#register").off("click");
			$(".main").hide();
	});
});

