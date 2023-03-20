<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<script type="test/javascript" src="script/bookStockManage.js" defer></script>

<table class="table table-bordered border-dark text-center" >
<tr border="3">
<td border="3">책이름</td>
<td>isbn코드</td>
<td>재고</td>
<td>추가할 수량</td>
<td>추가</td>
<td>삭제</td>
</tr>
<c:forEach var="BookVO" items="${list}" varStatus="st">
<tr border="3">
<td>${BookVO.title}</td>
<td>${BookVO.isbn}</td>
<td>0</td>
<input type="number">
<td><input type="button" value="추가"></td>
<td><input type="button" value="삭제"></td>
</tr>
</c:forEach>

</table>
<%@ include file="../footer.jsp" %>