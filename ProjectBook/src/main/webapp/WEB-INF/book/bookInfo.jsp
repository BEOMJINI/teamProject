<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="script/cartAdd.js" defer></script>
<section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="card-img img-fluid" src="${BookVO.image}" alt="Card image cap" id="product-detail">
                    </div>
                    
                </div>
                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2">${BookVO.title}</h1>
                            <span class="list-inline-item text-dark">평점:</span>
                            <p class="py-2">
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-secondary"></i>
                                
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>가격: &nbsp; ${BookVO.discount}원</h6>
                                </li>
                                
                                
                            </ul>

                            <h6>마일리지 적립:${mileage}원</h6>
                            <br>
                                
                            <h6>책소개</h6>
                            <p>${BookVO.description}</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>저자:${BookVO.author}</h6>
                                </li>
                                
                            </ul>

                            <h6>출판사:${BookVO.publisher}</h6>
                            <h6>출간일:${BookVO.pubdate}</h6>
                            

                            <form action="" method="post" id="bookinfo-form">
                                <input type="hidden" name="isbn" value="${BookVO.isbn}">
                                <div class="row">
                                    
                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                            <li class="list-inline-item text-right">
                                                구매수량
                                                <input type="hidden" name="qty" id="qty" value="1">
                                            </li>
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                            <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" name="" value="buy" id="payDirect">바로구매</button>
                                    </div>
                                    <div class="col d-grid">
                                        <button type="button" class="btn btn-success btn-lg" name="" value="addtocard" onclick="cartAdds(${BookVO.isbn})">장바구니</button>
                                    </div>
                                    <div class="col d-grid">
                                        <button type="button" class="btn btn-success btn-lg" name="submit" value="addtocard" onclick="location.href='${ctx}/showMyReview.do?isbn=${BookVO.isbn}'">리뷰보기</button>
                                    </div>
                                </div>
                                <input type="hidden" name="cart_discount" value="${BookVO.discount }"/>
                                <input type="hidden" name="cart_img" value="${BookVO.image }"/>
                                <input type="hidden" name="cart_qty" value=""/>
                                <input type="hidden" name="cart_title" value="${BookVO.title }"/>  
                                <input type="hidden" name="cart_isbn" value="${BookVO.isbn }"/>
                                <input type="hidden" name="status" value="1"/>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <script>
   
    </script>
    <%@ include file="../footer.jsp" %>