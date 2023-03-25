<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<table class="table table-bordered border-dark text-center">
<tr>
<td>주문번호</td>
<td>수령방법</td>
<td>isbn</td>
<td>책이름</td>
<td>구매수량</td>
<td>리뷰</td>
</tr>
<c:forEach var="vo" items="${list}" varStatus="st">
<tr>
<td>${vo.no}</td>
<td>${vo.receive}</td>
<td>${vo.isbn}</td>
<td>${vo.title}</td>
<td>${vo.cqty}</td>
<c:if test="${vo.reviewCheck eq true}">
<td><a href="showReview.do?isbn=${vo.isbn}">작성한리뷰보러가기</a></td>
</c:if>
<c:if test="${vo.reviewCheck eq false}">
<td><a href="writeReview.do?isbn=${vo.isbn}">리뷰작성하러가기</a></td>
</c:if>
</tr>
</c:forEach>


</table>
<%@ include file="../footer.jsp" %>