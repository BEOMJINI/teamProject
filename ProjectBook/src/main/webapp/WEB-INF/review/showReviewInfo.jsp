<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="assets/css/table.css">
<center>

        <table class="table table-bordered border-dark text-center" style="width: 400px; height: 700px;">
    
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
            <input type="text" name="title"  style="width: 380px;" malxlength="50" value="${vo.title}" readonly>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <textarea name="comment" style="width: 380px; height: 300px;" maxlength="300" readonly>${vo.comment}</textarea>
        </td>
    </tr>
      <tr>
      <td>평점</td>
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
    
</table>
</center>	
	
	
	
	

  

<%@ include file="../footer.jsp" %>