<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section>
	<div class="container">

		<h1>${id } 님의 결제 내역</h1>

		<table class="table"
			style="text-align: center; vertical-align: middle;">
			<tr>
				<th>날짜</th>
				<th colspan="2">책</th>
				<th>수령 방법</th>
			</tr>
			<c:if test="${empty orderList }">
			<tr>
			<td colspan="20">결제 하신 내역이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="order" items="${orderList }" varStatus="i">
				<tr>
					<td>${order.orderdate}</td>
					<td>
					<img src="${order.image }" style="width: 100px; height: 150px;">
					</td>
					<td>
					<p>${order.title}</p>
					<p>${order.cqty } 권</p>
					<p><fmt:formatNumber type="currency" value="${order.discount}" /></p>
					</td>
					
			
					<c:if test="${order.receive eq -1}">
					<td>배송</td>
					</c:if>
					<c:if test="${order.receive eq  0}">
					<td>직접수령 : 강남점(본점)</td>
					</c:if>
					<c:if test="${order.receive eq  1}">
					<td>직접수령 : 잠실점</td>
					</c:if>
					<c:if test="${order.receive eq  2}">
					<td>직접수령 : 목동점</td>
					</c:if>
					<c:if test="${order.receive eq  3}">
					<td>직접수령 : 영등포점</td>
					</c:if>
					
				</tr>
			</c:forEach>

		</table>


	</div>
</section>




<%@ include file="../footer.jsp"%>