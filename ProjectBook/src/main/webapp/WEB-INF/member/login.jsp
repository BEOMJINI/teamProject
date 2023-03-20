<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script defer type="text/javascript" src="script/logIn.js">

</script>
<div class="container py-5">
	<div class="row">

		<section>


			<div id="view_login">
				<div id="title" class="mt-3 mb-3">
					<font size="30px" style="font-weight: bold;" color="#00BFFF">로그인</font>
				</div>
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
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="joinBtn" class="btn btn-primary mb-3">회원가입</button>
				</div>

			</div>


		</section>




	</div>
</div>
<script>
$("#joinBtn").click(function () {
    window.location.href = "join.do"
});
</script>


<%@ include file="../footer.jsp"%>