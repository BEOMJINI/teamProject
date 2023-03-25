<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section>
<div class="container">
<div align="center">
<h1> &lt; 주문 완료 &gt; </h1>
<span> ${printDiscountData } 결제 되었습니다.</span>
<span> 결제 내역은 내 정보에서도 확인 하실 수 있습니다.</span>
<p>
<button type="submit" class="btn btn-success btn-lg" name="" value="" onclick="location.href='${ctx}/main.do'">홈으로</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-success btn-lg" name="" value="" >결제 내역 보기</button>
</p>
</div>
</div>

</section>


<%@ include file="../footer.jsp" %>