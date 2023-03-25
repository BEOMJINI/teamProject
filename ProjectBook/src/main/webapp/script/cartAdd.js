function cartAdd(isbn) {
	
    let query = {
        isbn: isbn,
        cqty: 1
    };

    $.ajax({
        type: "post",
        url: "cartAdd.do",
        data: query,
        success: function (x) {
            if (x == 0) {
               	Swal.fire('담기 완료', '장바구니에 담았습니다', 'success');
            } else if (x > 0) {
                Swal.fire('이미 장바구니에 담겨 있습니다.');
            } else if (x == -1){
				window.location.href = "login.do"
			}
        },
        error: console.log('err')
    });
};

function cartAdds(isbn) {
    let cqty = $('#var-value').text();
    let query = {
        isbn: isbn,
        cqty: cqty
    };

    $.ajax({
        type: "post",
        url: "cartAdd.do",
        data: query,
        success: function (x) {
            if (x == 0) {
               	Swal.fire('담기 완료', '장바구니에 담았습니다', 'success');
            } else if (x > 0) {
                 Swal.fire('이미 장바구니에 담겨 있습니다.');
            }  else if (x == -1){
				window.location.href = "login.do"
			}
        }
    });
};

$("#payDirect").click(function(){
	let qtyValue = $("#var-value").text();
	console.log("QQQ ", qtyValue);
	$("input[name=cart_qty").val(qtyValue);
	let bookinfoForm = document.querySelector("#bookinfo-form");
	bookinfoForm.action="payMain.do";
	bookinfoForm.submit();
	
});

	