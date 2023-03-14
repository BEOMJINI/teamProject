<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container">

	<c:forEach var="vo" items="${list }">
	<h1>${vo.no }</h1>
	<h1>${vo.name }</h1>
	</c:forEach>

	<h1>${test.name }</h1>
 	<h1>${x }</h1>
 <h1>test</h1>
</div>