$(function(){
	  $(window).scroll(function(){
          if($(this).scrollTop() > 300){
              $(".upDownButton").fadeIn();
          }else{
              $(".upDownButton").fadeOut();
          }
      });

	  $(".upDownButton").click(function(){
          $("html, body").animate({
              scrollTop:0
          },200);
      });

    
});