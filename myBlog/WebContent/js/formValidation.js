
$(function(){
    $("#postTitleMsg").hide();
    $("#postCategoryMsg").hide();
    $("#postBodyMsg").hide();
    $("#postImageMsg").hide();
    
    var errorPostTitle = false;
    var errorPostCategory = false;
    var errorPostBody = false;
    var errorPostImage = false;
    
    function checkPostTitle(){
    	var postTitleLength = $("#postTitles").val().length;
    	if(postTitleLength = null || postTitleLength < 4 || postTitleLength > 100){
    		$("#postTitleMsg").html("Post title should be 4-100.");
    		$("#postTitleMsg").show();
    		errorPostTitle = true;
    	}else{
    		$("#postTitleMsg").hide();
    		errorPostTitle = false;
    	}
    }
    function checkPostBody(){
    	var postBodyLength = $("#postbody").val().length;
    	if(postBodyLength = null || postBodyLength < 50 || postBodyLength > 5000){
    		$("#postBodyMsg").html("Post body should be 50-5000.");
    		$("#postBodyMsg").show();
    		errorPostBody = true;
    	}else{
    		$("#postBodyMsg").hide();
    		errorPostBody = false;
    	}
    }
    
  

    
    
    
    
    $("#postTitles").focusout(function(){
    	checkPostTitle()
    });
    $("#postbody").focusout(function(){
    	checkPostBody()
    });
    
    
    
    $("#postForms").submit(function(){
        if(errorPostTitle == true || errorPostBody == true){
        	return false;
        }else{
        	return true;
        }
       });	
    
    
 
    
 
});





