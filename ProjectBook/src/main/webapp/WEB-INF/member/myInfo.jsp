<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

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
					<td>날짜</td>
					<td>
					<img src="${bookData.get(i.index).image }" style="width: 100px; height: 150px;">
					</td>
					<td>
					<p>${bookData.get(i.index).title }</p>
					<p>${order.cqty } 권</p>
					<p>${moneyData.get(i.index) }</p>
					</td>
					<td>${receiveNameData.get(i.index) }</td>
				</tr>
			</c:forEach>

		</table>


	</div>
</section>




<%@ include file="../footer.jsp"%>