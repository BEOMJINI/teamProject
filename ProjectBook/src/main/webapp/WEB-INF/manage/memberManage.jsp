<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table class="table table-bordered border-dark text-center">
	
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>ID</th>
        <th>PW</th>
        <th>Email</th>
        <th>Phone</th>
        <th>관심</th>
        <th>주소</th>
        <th>마일리지</th>
        <th>삭제</th>
    </tr>
<c:forEach var="vo" items="${list }">
    <tr>
        <td>${vo.no }</td>
        <td>${vo.name }</td>
        <td>${vo.id }</td>
        <td>${vo.pw }</td>
        <td>${vo.email }</td>
        <td>${vo.phone }</td>
        <td>${vo.interest }</td>
        <td>${vo.address }</td>
        <td>${vo.mileage }</td>
        <td><a href="${ctx }/memberDelete.do?id=${vo.id}">삭제</a></td>
    </tr>
</c:forEach>

<c:forEach var="vo2" items="${testlist }">
	<tr>
	<td>${vo2.name }</td>
	</tr>
	
	
</c:forEach>


</table>


<%@ include file="../footer.jsp" %>