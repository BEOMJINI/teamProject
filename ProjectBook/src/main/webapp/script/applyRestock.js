function sendVO(a,b ){
	
	let query={
		isbn : a,
		storeid : b
		
	}
	$.ajax({
		
		type : "post",
		url : "applyRestockPro.do",
		data : query,
		success: function(data){
			var num=data;
			if(num==-1){
				alert("신청하신 책은 현재 해당지점의 재입고신청리스트에 이미 존재하는 책입니다.");
			}
			else if(num==1){
				alert("신청 성공");
			}
			else{
				alert("알수없는 에러");
			}
		}
	})
}