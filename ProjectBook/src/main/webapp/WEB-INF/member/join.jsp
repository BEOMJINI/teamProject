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
				<input type="text" class="form-control" name="id" id="id"
					required> <span>${idMsg }</span>
				<!--  
				<input type="button" value="중복확인" style="margin-left: 20px;" onclick="validId()"/>
				-->
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="pw"
					id="pw" required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name"
					required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" name="email" placeholder="Example@com"
					required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">전화번호</label>
			<div class="col-sm-10">
				<input type="tel" class="form-control" name="phone"  pattern="010-[0-9]{4}-[0-9]{4}" placeholder="010-1111-1234"
					required>
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">주소</legend>
			<div class="col-sm-10">

				<select class="form-select" name="address" required>
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
						id="inlineCheckbox1" value="소설" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox1">공포</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox2" value="과학" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox2">추리</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox3" value="자기계발" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox3">판타지 </label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox1" value="추리소설" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox1">로맨스</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox2" value="컴퓨터" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox2">과학</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox"
						id="inlineCheckbox3" value="육아" name="interest" onclick="checkCount(this)"> <label
						class="form-check-label" for="inlineCheckbox3">자기계발 </label>
				</div>
			</div>
		</fieldset>
		<br>
		<div class="row mb-3">
			<div class="col-sm-10" >
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck1"
						required> <label class="form-check-label" for="gridCheck1">
						개인정보 취급 동의 <a href="#" id="specialty">(전문보기)</a>
					</label>
				</div>
			</div>
			<div class="col-sm-10 offset-sm-5">
				<br>

			</div>
			<div class="col-sm-10"  style="text-align: center; margin: 0 auto;">
				<br>
					  <input type="submit" id="joinBtn" value="가입하기"/>

			</div>
		</div>


	</form>


</div>

<dialog>
	<h2 style="text-align: center;">개인정보 취급 동의서</h2>
	<hr style="border: solid 3px black;">
	<pre>
	
	본인은 개인정보 보호법에 따라 주식회사 XXX(이하 '회사'라 함)가 본인의 개인정보를 수집, 이용, 제공하는 것에 동의합니다.
	
	1. 개인정보의 수집항목 및 이용목적
	
	&bull; 수집항목 : 이름, 생년월일, 성별, 연락처(휴대전화번호, 이메일주소), 주소, 신용카드정보 등
	&bull; 이용목적 : 회원 가입 및 관리, 서비스 제공, 결제 및 정산, 상담 및 불만처리, 광고 및 마케팅 활용 등
	
	2. 개인정보의 보유 및 이용기간
	
	&bull; 회사는 수집한 개인정보를 수집 및 이용목적이 달성되면 지체 없이 파기합니다. 단, 관련법령의 규정에 의하여 보존할 필요가 있는 경우에는 관련 법령에서 정한 일정 기간 동안 개인정보를 보관합니다.

	3. 개인정보 제공

	&bull; 회사는 회원의 개인정보를 제3자에게 제공하지 않습니다. 단, 회원의 동의가 있거나 법령에서 정한 경우에는 예외로 합니다.
	
	4. 개인정보의 취급위탁
	&bull; 회사는 서비스 제공에 필요한 경우, 회원의 개인정보를 위탁할 수 있습니다. 이 경우 회사는 위탁업무의 내용과 수탁자를 사전에 회원에게 고지하고 동의를 받습니다.

	5. 개인정보의 파기절차 및 방법
	&bull; 회원의 개인정보는 수집 및 이용목적이 달성된 후에는 지체 없이 파기됩니다. 파기절차 및 방법은 다음과 같습니다.
	&bull; 파기절차 : 회원이 동의한 개인정보 보유기간이 종료된 경우 별도의 DB로 이동하여 (종이의 경우 분쇄기 등을 사용하여) 파기합니다.
	&bull; 파기방법 : 전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제하며, 종이에 출력된 개인정보는 분쇄기 등을 사용하여 파기합니다.

	본인은 본 개인정보 취급 동의서에 대하여 충분한 설명을 들은 후 동의를 하였으며, 언제든지 동의를 철회할 수 있습니다.	
	</pre>
	<menu id="specialtyMenu" style="display: flex; justify-content: center; align-items: center;">
	<button value="cancel" id="cancelBtn">돌아가기</button>
	</menu>
</dialog>

<%@ include file="../footer.jsp"%>