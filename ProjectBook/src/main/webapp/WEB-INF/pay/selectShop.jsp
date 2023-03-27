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
		<br>
		<div style="">	
			<div id="sto0" style="display: none; border: 1px solid black; width: 100%; text-indent: 5em; padding: 20px;">
				<c:set var="tag" value="0"/>
				<c:forEach var="sto0" items="${sto0 }">
					<c:set var="sto0" value="${sto0 }"/>
					<c:set var="size" value="${fn:length(sto0)}"/>
					<c:set var="ck" value="${fn:substring(sto0, 0, 1) }"/>
					<c:if test="${ck eq 'O'}">
						<p><font color="blue">${fn:substring(sto0, 1,size) } -> 바로 수령 가능합니다</font> </p>
					</c:if>
					<c:if test="${ck eq 'X'}">
						<c:set var="tag" value="1"/>
						<p><font color="red">${fn:substring(sto0, 1,size) } -> 지점 사정으로 구매가 불가능합니다</font> </p>
					</c:if>
				</c:forEach>
				<c:if test="${tag eq '0'}">
					<p style="text-align: center; vertical-align: middle;"><input type="button" name="payBtn" value="결제하러가기"/> </p>
				</c:if>
			</div>
		</div>
		
		<div style="">	
			<div id="sto1" style="display: none; border: 1px solid black; width: 100%; text-indent: 5em; padding: 20px;">
				<c:set var="tag" value="0"/>
				<c:forEach var="sto1" items="${sto1 }">
					<c:set var="sto1" value="${sto1 }"/>
					<c:set var="size" value="${fn:length(sto1)}"/>
					<c:set var="ck" value="${fn:substring(sto1, 0, 1) }"/>
					<c:if test="${ck eq 'O'}">
						<p><font color="blue">${fn:substring(sto1, 1,size) } -> 바로 수령 가능합니다</font> </p>
					</c:if>
					<c:if test="${ck eq 'X'}">
						<c:set var="tag" value="1"/>
						<p><font color="red">${fn:substring(sto1, 1,size) } -> 지점 사정으로 구매가 불가능합니다</font> </p>
					</c:if>
				</c:forEach>
				<c:if test="${tag eq '0'}">
					<p style="text-align: center; vertical-align: middle;"><input type="button" name="payBtn" value="결제하러가기"/> </p>
				</c:if>
			</div>
		</div>
		
		<div style="">	
			<div id="sto2" style="display: none; border: 1px solid black; width: 100%; text-indent: 5em; padding: 20px;">
				<c:set var="tag" value="0"/>
				<c:forEach var="sto2" items="${sto2 }">
					<c:set var="sto2" value="${sto2 }"/>
					<c:set var="size" value="${fn:length(sto2)}"/>
					<c:set var="ck" value="${fn:substring(sto2, 0, 1) }"/>
					<c:if test="${ck eq 'O'}">
						<p><font color="blue">${fn:substring(sto2, 1,size) } -> 바로 수령 가능합니다</font> </p>
					</c:if>
					<c:if test="${ck eq 'X'}">
						<c:set var="tag" value="1"/>
						<p><font color="red">${fn:substring(sto2, 1,size) } -> 지점 사정으로 구매가 불가능합니다</font> </p>
					</c:if>
				</c:forEach>
				<c:if test="${tag eq '0'}">
					<p style="text-align: center; vertical-align: middle;"><input type="button" name="payBtn" value="결제하러가기"/> </p>
				</c:if>
			</div>
		</div>
		
		<div style="">	
			<div id="sto3" style="display: none; border: 1px solid black; width: 100%; text-indent: 5em; padding: 20px;">
				<c:set var="tag" value="0"/>
				<c:forEach var="sto3" items="${sto3 }">
					<c:set var="sto3" value="${sto3 }"/>
					<c:set var="size" value="${fn:length(sto3)}"/>
					<c:set var="ck" value="${fn:substring(sto3, 0, 1) }"/>
					<c:if test="${ck eq 'O'}">
						<p><font color="blue">${fn:substring(sto3, 1,size) } -> 바로 수령 가능합니다</font> </p>
					</c:if>
					<c:if test="${ck eq 'X'}">
						<c:set var="tag" value="1"/>
						<p><font color="red">${fn:substring(sto3, 1,size) } -> 지점 사정으로 구매가 불가능합니다</font> </p>
					</c:if>
				</c:forEach>
				<c:if test="${tag eq '0'}">
					<p style="text-align: center; vertical-align: middle;"><input type="button" name="payBtn" value="결제하러가기"/> </p>
				</c:if>
			</div>
		</div>
	<!--  ----------------------------------------------------------------------------------- -->
		<br>
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
					<td>${Tlist.get(i.index).get(0) }</td>
					<td>${Tlist.get(i.index).get(1) }</td>
					<td>${Tlist.get(i.index).get(2) }</td>
					<td>${Tlist.get(i.index).get(3) }</td>
					</tr>
					</table>
				</c:if>
			</c:forEach>
		
		</div>
	<!--  ----------------------------------------------------------------------------------- -->
		<h1>재고 문의</h1>
		<div>1544-1234</div>
		
	<!--  ----------------------------------------------------------------------------------- -->
	<form id="selectShop_Form">
		<c:forEach var="pay" items="${orderbeanlist }" varStatus="i">
			<p><input type="hidden" value="${pay.discount }" name="cart_discount"/></p>
			<p><input type="hidden" value="${pay.qty }" name="cart_qty"/></p>
			<p><input type="hidden" value="${pay.img }" name="cart_img"/></p>
			<p><input type="hidden" value="${pay.title }" name="cart_title"/></p>
			<p><input type="hidden" value="${pay.isbn }" name="cart_isbn"/></p>
			<p><input type="hidden" value="${pay.status }" name="status"/></p>
		</c:forEach>
		
	</form>
	
	
	</div>
</section>



<%@ include file="../footer.jsp"%>