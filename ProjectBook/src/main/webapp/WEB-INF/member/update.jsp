<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="container py-5">

	<form action="${ctx }/memberUpdate.do?update=true" method="post">
		<div id="title" class="mt-3 mb-3">
			<font size="30px" style="font-weight: bold;" color="#00BFFF">회원 정보 </font>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="id" id="id" value="${vo.id }"
					readonly>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="pw" value="${vo.pw }"
					id="pw">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name" value="${vo.name }"
					>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" name="email" placeholder="Example@com" value="${vo.email }"
					>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">전화번호</label>
			<div class="col-sm-10">
				<input type="tel" class="form-control" name="phone"  pattern="010-[0-9]{4}-[0-9]{4}" placeholder="010-1111-1234" value="${vo.phone }"
					>
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">주소</legend>
			<div class="col-sm-10">

				<select class="form-select" name="address" >
					<option selected value="${vo.address }">${vo.address }</option>
					<option value="서울">서울</option>
					<option value="경기도">경기도</option>
					<option value="제주도">제주도</option>


				</select>
			</div>
		</fieldset>
		
		<br>
		<div class="row mb-3">
			
			<div class="col-sm-10"  style="text-align: center; margin: 0 auto;">
			<p>${updateMsg }</p>
				<br>
					  <input type="submit" value="수정하기"/>
					  &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="탈퇴하기" id="leaveBtn"/>
			</div>
		</div>


	</form>


</div>

<%@ include file="../footer.jsp" %>