<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<section>
	<div class="container" style="position: relative;">
		<div>
			<h1 id="카운트되서 html 출력하게">장바구니</h1>
		</div>
		<div class="cart_body">
			<div class="cart_body_inner">
				<table style="width: 100%; border: 1px solid black;">
					<tr>
					<th>체크박스</th>
					<th>이미지</th>
					<th>책정보</th>
					<th>수량</th>
					<th>삭제버튼</th>
					</tr>
				
					<c:forEach var="bean" items="${list}" varStatus="i">
							
				 
						<tr>
						<td><input type="checkbox"/></td>
						<td><img src="${bean.img }"></td>
						<td>
						<h5>${bean.title}</h5>
						<p>${bean.author}</p>
						</td>
						<td><input type="number" min="0" max="99" value="${bean.cqty }"/></td>
						<td><a><i></i></a></td>
						</tr>
				
					</c:forEach>
		
				</table>
				
				
			</div>
			<div class="cart_info_wrap"></div>
		</div>


	</div>
</section>

<%@ include file="../footer.jsp"%>