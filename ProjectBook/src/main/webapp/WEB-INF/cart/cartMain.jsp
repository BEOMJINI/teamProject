<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="script/cartCheck.js" defer></script>
<script>
function cartDelete(isbn) {

    $.ajax({
        type: "post",
        url: "cartDelete.do",
        data: { "isbn": isbn },
        success: function(x) {
			if(x > 0){
				window.location.href = "cartList.do";
			}
		}
    });
}

function cartDeleteAll() {

    $.ajax({
        type: "post",
        url: "cartDeleteAll.do",
        data: "",
        success: function (x) {
            if (x > 0) {
                window.location.href = "cartList.do";
            }
        }
    });
}

</script>

<section style="min-height: 1000px;">
	<div class="container" style="position: relative;">
		<div>
			<h1 id="카운트되서 html 출력하게">장바구니(${listSize})</h1>
		</div>
		<div class="cart_body">
				<form action="" method="post" id="cart_form">
				
			<div class="cart_body_inner">
				
				<div class="table-responsive" id="">
					<table class="table">
						<thead style="text-align: center; font-size: 15px;">
							<tr>
								<th scope="col"><input type="checkbox" name="check-all"/></th>
								<th scope="col">이미지</th>
								<th scope="col">책 정보</th>
								<th scope="col">주문 수량</th>
								<th scope="col"><a onclick="cartDeleteAll()"><i class="fa-solid fa-trash"></i></a></th>
							
						
							</tr>
						</thead>
						<tbody>
								<c:if test="${empty list }">
									<tr>
									<td colspan="20" style="text-align: center;">
									장바구니에 담긴 책이 없습니다.
									</td>
									</tr>
								</c:if>
							<c:forEach var="bean" items="${list}" varStatus="i">
							
						 
								<tr>
								<td><input type="checkbox" name="check" value="" onclick="statusControll(${i.index })"/>
								<input type="hidden" name="status" value="${bean.status }"/>
								<td><img src="${bean.img }" style="width: 100px; height: 150px;"></td>
								<td>
								<h5>${bean.title}</h5>
								<p>
								${bean.author}
								</p>
								<p>
								<input type="hidden" value="${bean.discount }" name="cart_discount"/>
								${moneyData.get(i.index) }
								
								</p>
								</td>
								<td><div class="qty_div"><input type="number" min="1" max="99" value="${bean.cqty}" id="cqty" name="cart_qty" class="cart_qtyBtn"/>
								</div><p class="total${i.index}"></p>
								<span class="cost"></span>
								</td>
							
								<td style="text-align: center; vertical-align: middle;"><a onclick="cartDelete(${bean.isbn})"><i class="fa-solid fa-x"></i></a></td>
								</tr>
								<input type="hidden" name="cart_isbn" value="${bean.isbn }"/>
							<input type="hidden" name="cart_img" value="${bean.img }"/>
							<input type="hidden" name="cart_title" value="${bean.title }"/> 
					</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			
			<div class="cart_info_wrap">
				<table class="table">
				<thead style="text-align: center; font-size: 15px;">
							<tr>
								<th scope="col">결제 예정 금액</th>
							
							</tr>
							<c:forEach var="bean" items="${list}" varStatus="i">
							<tr id="costtr">
						<!--  -->
							
						<!--  -->
							</tr>
							
							</c:forEach>
							<tr>
							<td>총금액:<p id="sumsumsum"> </p></td>
							</tr>
							<tr>
							<td>
							<input type="submit" value="직접수령" id="pickupBtn" onclick="javascript: form.action='${ctx}/main.do';"/>
							<input type="button" value="배송주문" name="deliveryBtn"/>
							</td>
							</tr>
						</thead>
				</table>
				
			</div>
			<input type="hidden" value="${loginId }" name="loginId" />
			</form>
		</div>


	</div>
</section>



<%@ include file="../footer.jsp"%>