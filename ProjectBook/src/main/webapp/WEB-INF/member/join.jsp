<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="script/join.js" defer>

</script>
<div class="container py-5" id="joinDIV">

	<form action="${ctx }/join.do" method="post">
		<div id="title" class="mt-3 mb-3">
			<font size="30px" style="font-weight: bold;" color="#00BFFF">회원가입</font>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idbox" name="id" id="id"
					required> <span id="msg" style="display: none"></span>
				<!--  
				<input type="button" value="중복확인" style="margin-left: 20px;" onclick="validId()"/>
				-->
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="idbox" name="pw"
					id="pw" required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idbox" name="name"
					required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="idbox" name="email"
					required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">전화번호</label>
			<div class="col-sm-10">
				<input type="tel" class="form-control" id="idbox" name="phone"
					required>
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">주소</legend>
			<div class="col-sm-10">

				<select class="form-select" id="idbox" name="address" required>
					<option selected disabled value="">배송 받을 지역을 선택해주세요.</option>
					<option value="서울">서울</option>
					<option value="경기도">경기도</option>
					<option value="제주도">제주도</option>


				</select>
			</div>
		</fieldset>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">관심사 선택 (최대 3개)
				(선택사항)</legend>
			<div class="col-sm-10">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox1" value="소설" name="interest"> <label
						class="form-check-label" for="inlineCheckbox1">소설</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox2" value="과학" name="interest"> <label
						class="form-check-label" for="inlineCheckbox2">과학</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox3" value="자기계발" name="interest"> <label
						class="form-check-label" for="inlineCheckbox3">자기계발 </label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox1" value="추리소설" name="interest"> <label
						class="form-check-label" for="inlineCheckbox1">추리소설</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox2" value="컴퓨터" name="interest"> <label
						class="form-check-label" for="inlineCheckbox2">컴퓨터</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox3" value="육아" name="interest"> <label
						class="form-check-label" for="inlineCheckbox3">육아 </label>
				</div>
			</div>
		</fieldset>
		<br>
		<div class="row mb-3" style="align-items: center;">
			<div class="col-sm-10 offset-sm-5">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck1"
						required> <label class="form-check-label" for="gridCheck1">
						개인정보 취급 동의 <a href="#">(전문보기)</a>
					</label>
				</div>
			</div>
			<div class="col-sm-10 offset-sm-5">
				<br>

			</div>
			<div class="col-sm-10 offset-sm-6">
				<br>
					  <input type="submit" id="joinBtn" value="가입하기"/>

			</div>
		</div>


	</form>


</div>

<%@ include file="../footer.jsp"%>