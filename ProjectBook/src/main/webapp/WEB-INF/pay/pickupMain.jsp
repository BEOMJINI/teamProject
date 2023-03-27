<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="script/pickupMain.js" defer></script>
<script type="text/javascript">

</script>

<section>
	<div class="container">
	<form action="" method="post" id="payMain_form">
		<table class="table" style="text-align: center; vertical-align: middle;">
			<tr>
				<th colspan="20" style="text-align: center;">주문 내역</th>
			</tr>
			<tr style="text-align: center;">
			<th>이미지</th>
			<th>제목</th>
			<th>수량</th>
			<th>가격</th>
			</tr>
			<c:forEach var="pay" items="${isbn }" varStatus="i">
				<c:if test="${status[i.index] == 1}">
					<tr>
						<td><img src="${img[i.index] }" style="width: 100px; height: 150px;"></td>
						<td>${title[i.index] }	</td>
						<td>${qty[i.index] }	</td>	
						<td id="total${i.index}">${discount[i.index] * qty[i.index] }</td>
					</tr>
					<input type="hidden" value="${isbn[i.index] }" name="isbn"/>
					<input type="hidden" value="${qty[i.index] }" name="cqty"/>
					<input type="hidden" value="${storeid }" name="storeid"/>
				</c:if>
			</c:forEach>
			<tr>
			<td></td>
			<td>직접 수령 지점</td>
			<td></td>
			<td>${store_name }</td>
			</tr>
			
			<tr style="font-weight: bold;">
				<td></td>
			<td>총 결제 금액</td>
				<td></td>
			<td id="totalSum"></td>
			</tr>
		
		</table>
		
		<table class="table" style="text-align: center; vertical-align: middle;">
			<tr>
				<th colspan="20" style="text-align: center;">마일리지</th>
			</tr>
			<tr>
			<td>적립</td>
			
			<td id="saveMileage"></td>
			</tr>
			<tr>
			<td>보유 마일리지</td>
			<td>${vo.mileage }</td>
			</tr>
			<tr>
			<td>사용할 마일리지</td>
			
			<td>
			<input type="number" name="useMileage" min="0" max="${vo.mileage }" value=0 style="text-align: center;"/>
			<input type="hidden" name="saveMileage" value="0"/>
			<input type="hidden" name="totalSum" value="0"/>
			</td>
			</tr>
		</table>
		<div align="center">
			 <button type="button" class="btn btn-success btn-lg" name="" value="" id="payBtn">결제하기</button>
			 </div>
</form>
		

	</div>
</section>



<%@ include file="../footer.jsp"%>