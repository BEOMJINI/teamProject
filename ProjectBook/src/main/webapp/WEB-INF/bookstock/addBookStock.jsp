<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="script/addBookStock.js" defer></script>
<link rel="stylesheet" href="assets/css/table.css">
<table class="table table-bordered">
<tr>
<td>책이름</td>
<td>isbn</td>
<td>재고 추가할 지점명</td>
<td>추가할 재고 수량</td>
<td>추가하기</td>

</tr>
<tr>
<td>${bookVO.title}</td>
<td>${bookVO.isbn}</td>
<td>
<select id="store" name="id">
<c:forEach var="StoreVO" items="${storeList}" varStatus="st">
<option value="${StoreVO.storeid}">${StoreVO.storename}</option>
</c:forEach>

</select>
</td>
<td><input id="qty" type="number"></td>

<td><input id="submit" type="button" value="추가하기"></td>

</tr>
<input id="isbn" type="hidden" value="${bookVO.isbn}">

</table>
<%@ include file="../footer.jsp" %>