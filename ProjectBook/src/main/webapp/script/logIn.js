let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
let status = true;

$("#login").click(function() {


	if (checkIt() == true) {
		let query = {
			id: $("#id").val(),
			pw: $("#pw").val()
		};

		$.ajax({
			type: "post",
			url: "login.do",
			data: query,
			success: function(x) {
				if (x != "null") {
					window.location.href = "main.do";
				} else if (x == "null") {
					Swal.fire('로그인 실패','아이디와 비밀번호를 확인해주세요','error')

					$("#id").val("");
					$("#pw").val("");
				}

			}

		});
	}
});

$("#cancle").click(function() {
	window.location.href = "main.do";
});

function checkIt() {

	if (!$.trim($("#id").val())) {
		alert('아이디를 입력해주세요');
		$("#id").focus()
		

		return false;
	} else if (!$.trim($("#pw").val())) {
		alert('비밀번호를 입력해주세요');
		$("#pw").focus();

		return false;
	}
	return true;
}
;



