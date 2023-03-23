<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	

		let sum = 0;
		for(let i=0; i<20; i++){
			sum += $("#total"+i).text() * 1;
			
		}
		console.log(sum);
		if(sum < 50000){
			$("#deli").text("3,000");
			$("#totalSum").text(sum *1 + 3000);
		} else{
			$("#deli").text("0");
			$("#totalSum").text(sum);
		}
	
	

	
});	


</script>

<section>
	<div class="container">
	<form action="${ctx }/payResult.do">
		<table class="table" style="text-align: center;">
			<tr>
				<th colspan="20" style="text-align: center;">주문 내역</th>
			</tr>
			<tr style="text-align: center;">
			<th>제목</th>
			<th>수량</th>
			<th>가격</th>
			</tr>
			<c:forEach var="pay" items="${ck }" varStatus="i">
				<c:if test="${ck[i.index] == 1}">
					<tr>
						
						<td>${title[i.index] }
						<input type="hidden" value="${isbn[i.index] }" name="isbn"/></td>
						<td>${qty[i.index] }</td>
						<td id="total${i.index}">${price[i.index] * qty[i.index] }</td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
			<td colspan="2">배송비 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td id="deli"></td>
			</tr>
			<tr style="font-weight: bold;">
			<td colspan="2">총 결제 금액 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td id="totalSum"></td>
			</tr>
			<tr>
				<td colspan="20" style="text-align: center;"><input type="submit" value="결제하기"/></td>
			</tr>
		</table>
</form>
		

	</div>
</section>



<%@ include file="../footer.jsp"%>