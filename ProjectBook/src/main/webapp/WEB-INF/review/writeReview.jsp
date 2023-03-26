<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">
<form action="${ctx}/writeReviewPro.do" method="post">
     
        
        <table class="table table-bordered border-dark text-center" style="width: 400px; height: 700px;">
    <tr>
        <td colspan="2" style="width: 100px">게시글 작성</td>
    </tr>
    <tr>
        <td style="width: 70px">글번호</td>
        <td style="width: 230px">${no}</td>
    </tr>
    <tr>
        <td style="width: 70px">책이름</td>
        <td style="width: 230px">${title}</td>
    </tr>
    <tr>
        <td style="width: 70px">작성자</td>
        <td style="width: 230px">${id}</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="text" name="title" placeholder="제목" style="width: 380px;" malxlength="50">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <textarea name="comment" placeholder="300자이내 작성" style="width: 380px; height: 300px;" maxlength="300"></textarea>
        </td>
    </tr>
      <tr>
        <td colspan="2">
            평점: 
            <input type="radio" name="rating" value="1">1점 
            <input type="radio" name="rating" value="2">2점 
            <input type="radio" name="rating" value="3">3점 
            <input type="radio" name="rating" value="4">4점 
            <input type="radio" name="rating" value="5" checked>5점 
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="작성">
        </td>
    </tr>
</table>
	<input type="hidden" name="isbn" value="${isbn}">
	

    </form>

<%@ include file="../footer.jsp" %>