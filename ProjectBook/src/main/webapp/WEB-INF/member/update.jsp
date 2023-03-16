<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="container py-5">

	<div id="title" class="mt-3 mb-3">
					<font size="30px" style="font-weight: bold;" color="#00BFFF">회원 정보 수정</font>
				</div>
<form>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idbox" readonly
					> <input type="button"
					value="중복확인" style="margin-left: 20px;" />
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idbox" >
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idbox" value="">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="idbox" value="">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">전화번호</label>
			<div class="col-sm-10">
				<input type="tel" class="form-control" id="idbox" value="">
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">주소</legend>
			<div class="col-sm-10">

				<select class="form-select" id="idbox"}>
					<option selected disabled value="">Choose...</option>
					<option>...</option>
<!--  					
<option value="0" if(변수.equal("0")){%>selected="selected"}%>>전체조회</option>
<option value="1" if(변수.equal("1")){%>selected="selected"}%>>전체공지</option>
<option value="2" if(변수.equal("2")){%>selected="selected"}%>>자유게시판</option>
-->		
				</select>
			</div>
		</fieldset>
		
<!--  
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">radios</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="option1" checked> <label
						class="form-check-label" for="gridRadios1"> First radio </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="option2"> <label
						class="form-check-label" for="gridRadios2"> Second radio </label>
				</div>
				<div class="form-check disabled">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios3" value="option3" disabled> <label
						class="form-check-label" for="gridRadios3"> Third disabled
						radio </label>
				</div>
			</div>
		</fieldset>
-->
		<br>
		<div class="row mb-3" style="align-items: center;">
			
		
		<div class="col-sm-10 offset-sm-6">
		
		<button type="submit" class="btn btn-primary">수정완료</button>
		
		</div>
		</div>
	</form>

</div>

<%@ include file="../footer.jsp" %>