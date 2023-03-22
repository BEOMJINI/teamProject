function cartUpdate(isbn) {
	
	let query = {
        isbn: isbn,
        cqty: $("#cqty").val()
    };
	
    $.ajax({
        type: "post",
        url: "cartUpdate.do",
        data: query,
        success: function(x) {
			if(x > 0){
				window.location.href = "cartList.do";
			}
		}
    });
}