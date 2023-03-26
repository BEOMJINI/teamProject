<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">    
<table class="table table-bordered border-dark text-center">
<tr>
<td>매장명</td>
<td>매장주소</td>
<td>지도로 보기</td>
</tr>

<c:forEach var="vo" items="${list}" varStatus="st">
<tr>
<td>${vo.storename}</td>
<td>${vo.address}</td>
<td><button onclick="location.href='storeMap.do?storeid=${vo.storeid}'">지도보기</button></td>
</tr>
</c:forEach>

</table>
<%@ include file="../footer.jsp" %>