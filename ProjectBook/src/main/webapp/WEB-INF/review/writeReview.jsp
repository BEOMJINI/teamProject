<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp" %>
<table class="table table-bordered border-dark text-center">
<tr><td colspan="1">번호</td><td colspan="1">${no}</td></tr>
<tr><td colspan="1">책이름</td><td colspan="1">${title}</td></tr>
<tr><td colspan="1">제목</td><td colspan="1"><input type="text" name="title"></td></tr>
<tr><td colspan="4"><textarea placeholder="내용을 입력하세요.">

</textarea></td></tr>
</table>


<%@ include file="../footer.jsp" %>