<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<table>
<tr>
<td>책이름</td>
<td>isbn</td>
<td>작가</td>
<td>출판사</td>
<td>지점이름</td>
<td>지점id</td>
<td>재입고신청</td>
</tr>
<c:forEach var="bean" items="${list}" varStatus="st">
<td>bean.title</td>
<td>bean.isbn</td>
<td>bean.author</td>
<td>bean.publisher</td>
<td>bean.storename</td>
<td>bean.storeid</td>
<td><input type="button" value="신청"></td>
</c:forEach>

</table>
<%@ include file="../footer.jsp" %>