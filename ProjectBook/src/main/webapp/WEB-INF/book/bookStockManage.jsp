<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="script/bookstockmanage.js" defer></script>

<table class="table table-bordered border-dark text-center" >
<tr border="3">
<td border="3">책이름</td>
<td>isbn코드</td>
<c:forEach var="i" begin="0" end="${storeList.size()-1}">
<td>지점명 / 지점id</td>
<td>재고</td>
</c:forEach>


<td>추가</td>
<td>삭제</td>
</tr>
<c:forEach var="BookVO" items="${list}" varStatus="st">
<tr border="3">
<td>${BookVO.title}</td>
<td>${BookVO.isbn}</td>

<c:forEach var="StoreVO" items="${storeList}" varStatus="st">
<td>${StoreVO.storename}&nbsp;/&nbsp;${StoreVO.storeid}</td>
<c:if test="${bookStockList.size() eq 0}">
<td>0</td>
</c:if>
<c:forEach var="BookStockVO" items="${bookStockList}" varStatus="st">
<c:if test="${BookVO.isbn eq BookStockVO.isbn && StoreVO.storeid eq BookStockVO.storeid}">
<td>
${BookStockVO.qty}
</td>
</c:if>

</c:forEach>




</c:forEach>
<td><input type="button" value="추가" onclick="showModal(${BookVO.isbn})"></td>
<td><input type="button" value="삭제"></td>
</tr>
</c:forEach>

</table>
<form action="${ctx}/bookStockChange.do" method="post">

<button type="submit" name="submit" value="add" >재고채우기</button>
<button type="submit" name="submit" value="delete">재고초기화</button>


</form>
<dialog>
	<h2 style="text-align: center;">개인정보 취급 동의서</h2>
	<hr style="border: solid 3px black;">
	<pre>
	
	
	</pre>
	<menu id="specialtyMenu" style="display: flex; justify-content: center; align-items: center;">
	<button value="cancel" onclick="closeModal()">돌아가기</button>
	</menu>
</dialog>

<%@ include file="../footer.jsp" %>