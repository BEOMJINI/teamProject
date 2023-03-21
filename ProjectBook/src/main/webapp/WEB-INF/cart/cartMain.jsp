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
				
				<div class="table-responsive" id="">

					<table class="table">
						<thead style="text-align: center; font-size: 15px;">
							<tr>
								<th scope="col">전체선택</th>
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
						<td><input type="checkbox"/></td>
						<td><img src="${bean.img }" style="width: 100px; height: 150px;"></td>
						<td>
						<h5>${bean.title}</h5>
						<p>
						${bean.author}
						</p>
						<p>
						${moneyData.get(i.index) }
						</p>
						</td>
						<td><input type="number" min="0" max="99" value="${bean.cqty }"/></td>
						<td style="text-align: center; vertical-align: middle;"><a onclick="cartDelete(${bean.isbn})"><i class="fa-solid fa-x"></i></a></td>
						</tr>
				
					</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			
			<div class="cart_info_wrap"></div>
		</div>


	</div>
</section>

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

<%@ include file="../footer.jsp"%>