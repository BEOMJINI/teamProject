<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript">

let status = true;
	
	$(function() {

		$("#login").click(function() {
			checkIt();
			if (status) {
					let query = {
					id : $("#id").val(),
					pw : $("#pw").val()
				};

				$.ajax({
					type : "post",
					url : "login.do",
					data : query,
					success : function(x) {

						if (x != null) {
							alert("로그인성공");
							window.location.href = "main.do";
						} else {
							alert("아이디와 패스워드를 확인해주세요.");
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
			status = true;
			if (!$.trim($("#id").val())) {
				alert("아이디를 입력하세요.");
				$("#id").focus();
				status = false;
				return false;
			} else if (!$.trim($("#pw").val())) {
				alert("비밀번호를 입력하세요.");
				$("#pw").focus();
				status = false;
				return false;
			}

		}
		;

	});
</script>


 <div class="container py-5">
        <div class="row">
        
        <section>
		
			
				<div id="view_login">
					<div id="title" class="mt-3 mb-3"><font size="30px" style="font-weight: bold;" color="#00BFFF">Login</font></div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="id" placeholder="ID"
							name="id" required> <label for="floatingInput">ID</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="pw"
							placeholder="Password" name="pw" required> <label
							for="floatingPassword">Password</label>
					</div>
					<div align="center">
						<button id="login" class="btn btn-primary mb-3">로그인</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button id="cancle" class="btn btn-primary mb-3">취소</button>
					</div>

				</div>
			
		
	</section>
        
        
        
        
        </div>
        </div>



<%@ include file="../footer.jsp" %>