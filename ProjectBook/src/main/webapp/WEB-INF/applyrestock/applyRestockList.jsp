<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">
<h1>현재 재입고 신청 리스트입니다.</h1>

<table class="table table-bordered border-dark text-center">
<tr>
<td>책이름</td>
<td>isbn</td>
<td>작가</td>
<td>출판사</td>
<td>지점이름</td>
<td>지점id</td>
<td>재입고</td>
</tr>
<c:forEach var="vo" items="${list}" varStatus="st">
<tr>
<td>${vo.title}</td>
<td>${vo.isbn}</td>
<td>${vo.author}</td>
<td>${vo.publisher}</td>
<td>${vo.storename}</td>
<td>${vo.storeid}</td>
<td>
<button onclick="location.href='${ctx}/addBookStock.do?isbn=${vo.isbn}'" >재입고</button></td>

</tr>
</c:forEach>

</table>

<%@ include file="../footer.jsp" %>