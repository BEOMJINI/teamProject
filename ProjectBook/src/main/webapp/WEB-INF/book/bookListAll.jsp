<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>

<h1> ${list.size()}</h1>
<script type="text/javascript" src="script/cartAdd.js" defer></script>

<!-- Modal -->

<div >
    



    <!-- Start Content -->
    <div class="container py-5">
        <div class="row">

            <div class="col-lg-3">
                <h1 class="h2 pb-4">Categories</h1>
                <ul class="list-unstyled templatemo-accordion">
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                            장르
                            <i class="fa fa-fw fa-chevron-circle-down mt-1"></i>
                        </a>
                        <ul class="collapse show list-unstyled pl-3">
                        <c:forEach var="BookVO" items="${genreList}" varStatus="st">
                        <li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=genre&key=${BookVO.genre}">${BookVO.genre}</a></li>
                        </c:forEach>
                            
                            
                        </ul>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                           국가
                            <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                        </a>
                        <ul id="collapseTwo" class="collapse list-unstyled pl-3">
                        <c:forEach var="BookVO" items="${countryList}" varStatus="st">
                        <li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=country&key=${BookVO.country}">${BookVO.country}</a></li>
                        </c:forEach>
                        </ul>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                            출판사
                            <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                        </a>
                        <ul id="collapseThree" class="collapse list-unstyled pl-3">
                        <c:forEach var="BookVO" items="${publisherList}" varStatus="st">
                        <li><a class="text-decoration-none" href="${ctx}/bookList.do?cate=publisher&key=${BookVO.publisher}">${BookVO.publisher}</a></li>
                        </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="col-lg-9">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="${ctx}/bookList.do?show=letter">글자순</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="${ctx}/bookList.do?show=latest">최신순</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="${ctx}/bookList.do?show=sale">판매순</a>
                            </li>
                           
                        </ul>
                    </div>
                    
                </div>
                <div class="row">




					<c:forEach var="BookVO" items="${list}" varStatus="st">
						
							<div class="col-md-4 ">
								<div class="card mb-4 product-wap rounded-0">
									<div class="card rounded-0">
										<img src="${BookVO.image}" height="200">
										<div
											class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
											<ul class="list-unstyled">
												<li><a class="btn btn-success text-white"
													href="shop-single.html"><i class="far fa-heart"></i></a></li>
												<li><a class="btn btn-success text-white mt-2"
													href="${ctx}/bookinfo.do?isbn=${BookVO.isbn}"><i
														class="far fa-eye"></i></a></li>
												<li><a class="btn btn-success text-white mt-2"
													href="#" onclick="cartAdd(${BookVO.isbn})" id="cartAddBtn"><i class="fas fa-cart-plus"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="card-body text-center mb-0">
										<a href="${ctx}/bookinfo.do?isbn=${BookVO.isbn}"
											class="h3 text-decoration-none">${BookVO.title}</a>
										<ul class="w-100 list-unstyled  mb-0 text-center mb-0">
											<li>${BookVO.author}</li>
											<li class="pt-2"><span
												class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
												</li>
										</ul>
										<ul class="list-unstyled d-flex justify-content-center mb-1">
											<li><i class="text-warning fa fa-star"></i> <i
												class="text-warning fa fa-star"></i> <i
												class="text-warning fa fa-star"></i> <i
												class="text-muted fa fa-star"></i> <i
												class="text-muted fa fa-star"></i></li>
										</ul>
										<p class="text-center mb-0">${BookVO.publisher}</p>
									</div>
								</div>
							</div>
							<input type="hidden" value="${BookVo.isbn }" id="getIsbn"/>
					</c:forEach>



				</div>
                <div div="row">
                    <ul class="pagination pagination-lg justify-content-end">
                        <li class="page-item disabled">
                            <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="#" tabindex="-1">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark" href="#">3</a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    </div>
    <!-- End Content -->
<%@ include file="../footer.jsp" %>