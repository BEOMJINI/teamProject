<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책방</title>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


<script src="https://kit.fontawesome.com/116a85af51.js"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<!-- 파비콘 수정 -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/custom.css">
<link rel="stylesheet" href="assets/css/templatemo.css">

<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">

</head>

<body>
	<div class="fixed-top ">
		<nav
			class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
			id="templatemo_nav_top">
			<div class="container text-light">
				<div class="w-100 d-flex justify-content-between">
					<div>
						<i class="fa fa-envelope mx-2"></i> <a
							class="navbar-sm-brand text-light text-decoration-none"
							href="https://www.naver.com/" target="_blank">BOOK@naver.com</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-phone mx-2"></i> <a
							class="navbar-sm-brand text-light text-decoration-none">1544-1234</a>
					</div>
					<div>
						<a class="text-light" href="https://fb.com/templatemo"
							target="_blank"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
						<a class="text-light" href="https://www.instagram.com/"
							target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
						<a class="text-light" href="https://twitter.com/" target="_blank"><i
							class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${id eq null}">
							<a class="text-light" href="${ctx }/join.do"
								style="text-decoration: none;">회원가입</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="text-light" href="${ctx }/login.do"
								style="text-decoration: none;">로그인</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="text-light" href="${ctx }/api.do"
								style="text-decoration: none;">api</a>


						</c:if>
						<c:if test="${id ne null and id ne 'admin'}">
							<a class="text-light" href="${ctx }/memberUpdate.do"
								style="text-decoration: none;">회원정보</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="text-light" href="${ctx }/logout.do"
								style="text-decoration: none;">로그아웃</a>

							<input type="hidden" value="${id }" id="idid" />
						</c:if>

						<c:if test="${id eq 'admin'}">

							<label for="menu">관리자 메뉴:</label>
							<select id="menu" name="menu"
								onchange="if(this.value) location.href=(this.value)">
								<option value="">선택</option>
								<option value="${ctx}/memberList.do">회원 관리</option>
								<option value="">재고 관리</option>
								<option value="">Contact</option>
							</select>
 
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="text-light" href="${ctx }/logout.do"
								style="text-decoration: none;">로그아웃</a>
						</c:if>


					</div>
				</div>
			</div>
		</nav>
		<!-- Close Top Nav -->


		<!-- Header -->
		<nav class="navbar navbar-expand-lg navbar-light shadow bg-white">
			<div
				class="container d-flex justify-content-between align-items-center">

				<a class="navbar-brand text-success logo h1 align-self-center"
					href="${ctx }/main.do"> <b>책방</b>
				</a>

				<button class="navbar-toggler border-0" type="button"
					data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div
					class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
					id="templatemo_main_nav">
					<div class="flex-fill">
						<ul
							class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
							<li class="nav-item"><a class="nav-link"
								href="${ctx }/main.do">홈</a></li>
							<c:if test="${id ne 'admin'}">
								<li class="nav-item"><a class="nav-link"
									href="${ctx}/showMyOrder.do">구매내역</a></li>
							</c:if>
							<c:if test="${id eq 'admin'}">
								<li class="nav-item"><a class="nav-link" href="dummy.do">더미데이터</a></li>
							</c:if>
							<li class="nav-item"><a class="nav-link"
								href="${ctx }/bookList.do">책 구매</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${ctx }/storeInfo.do">지점 안내</a></li>
							<c:if test="${id eq 'admin'}">
								<li class="nav-item"><a class="nav-link"
									href="${ctx }/bookStockManage.do">재고관리</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${ctx }/memberList.do">회원관리</a></li>




							</c:if>
							<c:if test="${id ne 'admin'}">
								<li class="nav-item"><a class="nav-link"
									href="${ctx }/applyRestock.do">재입고신청</a>
							</c:if>

						</ul>
					</div>
					<div class="navbar align-self-center d-flex">
						<div
							class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
							<div class="input-group">
								<input type="text" class="form-control" id="inputMobileSearch"
									placeholder="Search ...">
								<div class="input-group-text">
									<i class="fa fa-fw fa-search"></i>
								</div>
							</div>
						</div>
						<a class="nav-icon d-none d-lg-inline" href="#"
							data-bs-toggle="modal" data-bs-target="#templatemo_search"> <i
							class="fa fa-fw fa-search text-dark mr-2"></i>
						</a> <a class="nav-icon position-relative text-decoration-none"
							href="${ctx }/cartList.do"> <i
							class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i> <span
							class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"
							id="cart-count"></span>
						</a> <a class="nav-icon position-relative text-decoration-none"
							href="${ctx }/memberInfo.do"> <i
							class="fa fa-fw fa-user text-dark mr-3"></i> <span
							class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
						</a>
					</div>
				</div>

			</div>
		</nav>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>

	<script>
	$(document).ready(function () {
		let idid = $('#idid').val();
		console.log("idid = " + idid);
		
		$.ajax({
			type: "post",
			url: "cartCount.do",
			data: {"idid" : idid},
			success: function(cartCount) {
				if(cartCount != 0){
					$('#cart-count').text(cartCount);	
				}
				
			},
			error: console.log('err')
		});
		})
		
	</script>
	<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">


		<div class="modal-dialog modal-lg" role="document">

			<div class="w-100 pt-1 mb-5 text-right">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="${ctx}/bookList.do " method="get"
				class="modal-content modal-body border-0 p-0">
				<div>
					<select name="search">
						<option value="title">제목</option>
						<option value="author">저자</option>
						<option value="description">내용</option>
					</select>
				</div>
				<div class="input-group mb-2">
					<input type="text" class="form-control" id="inputModalSearch"
						name="keyword" placeholder="Search ...">
					<button type="submit"
						class="input-group-text bg-success text-light">
						<i class="fa fa-fw fa-search text-white"></i>
					</button>
				</div>
			</form>
		</div>
	</div>