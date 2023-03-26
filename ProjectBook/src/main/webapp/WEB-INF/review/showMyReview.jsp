<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">
<form action="${ctx}/showMyReviewPro.do" method="post">
        
        
        
        <table class="table table-bordered border-dark text-center" style="width: 400px; height: 700px;">
    <tr>
        <td colspan="2" style="width: 100px">게시글 작성</td>
    </tr>
    <tr>
        <td style="width: 70px">글번호</td>
        <td style="width: 230px">${vo.no}</td>
    </tr>
    <tr>
        <td style="width: 70px">책이름</td>
        <td style="width: 230px">${vo.title}</td>
    </tr>
    <tr>
        <td style="width: 70px">작성자</td>
        <td style="width: 230px">${id}</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="text" name="title"  style="width: 380px;" malxlength="50" value="${vo.title}">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <textarea name="comment" style="width: 380px; height: 300px;" maxlength="300" >${vo.comment}</textarea>
        </td>
    </tr>
      <tr>
        <td colspan="2">
            평점: 
            <input type="radio" name="rating" value="1" <c:if test="${vo.rating eq 1}">checked</c:if>>1점 
            <input type="radio" name="rating" value="2" <c:if test="${vo.rating eq 2}">checked</c:if>>2점 
            <input type="radio" name="rating" value="3" <c:if test="${vo.rating eq 3}">checked</c:if>>3점 
            <input type="radio" name="rating" value="4" <c:if test="${vo.rating eq 4}">checked</c:if>>4점 
            <input type="radio" name="rating" value="5" <c:if test="${vo.rating eq 5}">checked</c:if>>5점 
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" name="submit" value="삭제하기" >
            <input type="submit" name="submit" value="수정하기" >
        </td>
    </tr>
</table>
	<input type="hidden" name="no" value="${vo.no}">
	
	
	
	

    </form>

<%@ include file="../footer.jsp" %>