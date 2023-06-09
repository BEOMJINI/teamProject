<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="script/bookstockmanage.js" defer></script>
<link rel="stylesheet" href="assets/css/table.css">
<table class="table table-bordered border-dark text-center" >
<tr border="3">
<td border="3">책이름</td>
<td>isbn코드</td>
<c:forEach var="i" begin="0" end="${storeList.size()-1}">
<td>지점명 / 지점id</td>
<td>재고</td>
</c:forEach>


<td>추가</td>
<td>삭제</td>
</tr>
<c:forEach var="BookVO" items="${list}" varStatus="st">
<tr border="3">
<td>${BookVO.title}</td>
<td>${BookVO.isbn}</td>

<c:forEach var="StoreVO" items="${storeList}" varStatus="st">
<td>${StoreVO.storename}&nbsp;/&nbsp;${StoreVO.storeid}</td>
<c:set var="stockQty" value="0" />
<c:forEach var="stock" items="${bookStockList}">
    <c:if test="${BookVO.isbn eq stock.isbn && StoreVO.storeid eq stock.storeid}">
        <c:set var="stockQty" value="${stock.qty}" />
    </c:if>
</c:forEach>
<td>${stockQty}</td>





</c:forEach>
<td><input type="button" value="추가" onclick="location.href='addBookStock.do?isbn=${BookVO.isbn}'"></td>
<form action="${ctx}/bookStockChange.do" method="post">
<td><button type="submit" name="submit" value="${BookVO.isbn}" >삭제</button></td>
</form>
</tr>
</c:forEach>

</table>
<form action="${ctx}/bookStockChange.do" method="post">

<button type="submit" name="submit" value="add" >재고채우기</button>
<button type="submit" name="submit" value="reset">재고초기화</button>



</form>
<button onclick="location.href='${ctx}/applyRestockList.do'">재입고신청리스트</button>

<%@ include file="../footer.jsp" %>