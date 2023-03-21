let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
let status = true;
$("#submit").click(function(){
	let query={
			storeid : $("#store").val(),
			qty : $("#qty").val(),
			isbn : $("#isbn").val()
		};
	$.ajax({
		
		type : "post",
		url : "addBookStockPro.do",
		data :query,
		success: function(data){
			var a=data;
			if(a==-1){
				alert("0보다 큰 값만 입력가능합니다!");
			}
			else{
			alert("재고 추가 성공!");
			location.href="bookStockManage.do";
			}
		}
				
			
		
	})
})