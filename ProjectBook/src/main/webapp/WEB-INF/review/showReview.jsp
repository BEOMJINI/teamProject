<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">
<h1>${title} 의 리뷰 목록입니다.</h1>
<center>
<table class="table table-bordered border-dark text-center center" style="width: 700px; ">
<tr>
<td>제목</td>
<td>작성자</td>
<td>평점</td>
</tr>
<c:forEach var="vo" items="${list}" varStatus="st">
<tr>
<td><a href="showReviewInfo.do?no=${vo.no}">${vo.title}</a></td>
<td>${vo.id}</td>
<td>

<ul class="list-unstyled d-flex justify-content-center mb-1">
<c:if test="${vo.rating eq 1}">
<li><i class="text-warning fa fa-star"></i> 
<i class="text-muted fa fa-star"></i>
<i class="text-muted fa fa-star"></i>
<i class="text-muted fa fa-star"></i> 
<i class="text-muted fa fa-star"></i></li>
</c:if>
<c:if test="${vo.rating eq 2}">
<li><i class="text-warning fa fa-star"></i> 
<i class="text-warning fa fa-star"></i>
<i class="text-muted fa fa-star"></i>
<i class="text-muted fa fa-star"></i> 
<i class="text-muted fa fa-star"></i></li>
</c:if>
<c:if test="${vo.rating eq 3}">
<li><i class="text-warning fa fa-star"></i> 
<i class="text-warning fa fa-star"></i>
<i class="text-warning fa fa-star"></i>
<i class="text-muted fa fa-star"></i> 
<i class="text-muted fa fa-star"></i></li>
</c:if>
<c:if test="${vo.rating eq 4}">
<li><i class="text-warning fa fa-star"></i> 
<i class="text-warning fa fa-star"></i>
<i class="text-warning fa fa-star"></i>
<i class="text-warning fa fa-star"></i> 
<i class="text-muted fa fa-star"></i></li>
</c:if>
<c:if test="${vo.rating eq 5}">
<li><i class="text-warning fa fa-star"></i> 
<i class="text-warning fa fa-star"></i>
<i class="text-warning fa fa-star"></i>
<i class="text-warning fa fa-star"></i> 
<i class="text-warning fa fa-star"></i></li>
</c:if>
</ul>

</td>
</tr>
</c:forEach>
</table>
</center>

<%@ include file="../footer.jsp" %>