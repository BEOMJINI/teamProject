<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script src="script/selectShop.js" defer></script>
<section>
	<div class="container">
		<h1>지점 선택</h1>
		<div
			style="border: 1px solid black; width: 100%; height: 300px; text-align: center; vertical-align: middle;">
			<div style="display: flex; justify-content: space-evenly;">
				<div>
					<input type="radio" name="store" value="${storeList[0].storeid }" /><label>&nbsp;&nbsp;${storeList[0].storename }</label>
				</div>
				<div>
					<input type="radio" name="store" value="${storeList[1].storeid }" /><label>&nbsp;&nbsp;${storeList[1].storename }</label>
				</div>
				<div>
					<input type="radio" name="store" value="${storeList[2].storeid }" /><label>&nbsp;&nbsp;${storeList[2].storename }</label>
				</div>
				<div>
					<input type="radio" name="store" value="${storeList[3].storeid }" /><label>&nbsp;&nbsp;${storeList[3].storename }</label>
				</div>
			</div>
		</div>

	<!--  ----------------------------------------------------------------------------------- -->
		<h1>재고 조회</h1>
		<div>
			<c:forEach var="isbn" items="${isbn }" varStatus="i">
				<c:if test="${status[i.index] == 1 }">
					<div>${title[i.index] }</div>
					<table>
					<tr>
					<th>${storeList[0].storename }</th>
					<th>${storeList[1].storename }</th>
					<th>${storeList[2].storename }</th>
					<th>${storeList[3].storename }</th>
					</tr>
					<tr>
					<c:forEach var="stock" items="${stockList[i.index] }" varStatus="j">
						<c:if test="${stock.storeid == '0' }">
							<td>${stock.qty }</td>
						</c:if>
						<c:if test="${stock.storeid == '1' }">
							<td>${stock.qty }</td>
						</c:if>	
						<c:if test="${stock.storeid == '2' }">
							<td>${stock.qty }</td>
						</c:if>	
						<c:if test="${stock.storeid == '3' }">
							<td>${stock.qty }</td>
						</c:if>	
					</c:forEach>
					</tr>
					</table>
				</c:if>
			</c:forEach>
		
		</div>
	<!--  ----------------------------------------------------------------------------------- -->
		<h1>재고 문의</h1>
		<div>1544-1234</div>
		
	<!--  ----------------------------------------------------------------------------------- -->
	<form>
		<input type="hidden" name="discount" value="${discount }"/>
		<input type="hidden" name="qty" value="${qty }"/>
		<input type="hidden" name="img" value="${img }"/>
		<input type="hidden" name="title" value="${title }"/>
		<input type="hidden" name="isbn" value="${isbn }"/>
		<input type="hidden" name="status" value="${status }"/>
	</form>
	</div>
</section>



<%@ include file="../footer.jsp"%>