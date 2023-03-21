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
                alert("장바구니에 추가되었습니다.");
            } else if (x > 0) {
                alert("이미 장바구니에 담겨있는 책입니다.");
            }
        }
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
                alert("장바구니에 추가되었습니다.")
            } else if (x > 0) {
                alert("이미 장바구니에 담겨있는 책입니다.")
            }
        }
    });
};