let check = 0;

function validId(){
	 if($.trim($("#id").val())==''){
		 alert("아이디를 입력하세요.");
		 $("#id").focus();
		 return
	 }
	 let id=$("#id").val();
	 $.ajax({ 
		 url : "validId.do",
		 type : "POST",
		 data : {"id" : id},
		 success : getResult  		 
	 });
}  

function getResult(z){	
	 if(z == "null"){
		 alert("사용 가능한 id 입니다.");
		 $("#pw").focus();
		 check = 1;
	 }else{
		 alert("사용 중인 id 입니다.");
		 $("#id").val("");
		 $("#id").focus();
		 check = -1;
	 } 	 
}

$("#joinBtn").click(function(){
	console.log("eest");

});

	$("#id").keyup(function(e) {
		 if(e.keyCode=='8'){
			 check =0;
		 }
	  $("#id").css("border", "");
	});
	
	let inputs =  document.querySelectorAll("input"); 
    inputs.forEach((input)=>{
        input.onchange = function(){
            $("#msg").html("");
        };
    })
	
	

	
