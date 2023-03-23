<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="header.jsp" %>

    <!-- Modal -->
    <div >
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
        <c:forEach var="vo" items="${threebook}" varStatus="st">
        <c:if test="${st.count eq 1}">
        	<div class="carousel-item active">
        	<div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img width="600" height="700" src="${vo.image}" alt="" onclick="location.href='${ctx}/bookinfo.do?isbn=${vo.isbn}'">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-success"><b onclick="location.href='${ctx}/bookinfo.do?isbn=${vo.isbn}'">${vo.title}</b> <br>${vo.author}</h1>
                                
                                <p>
                        ${vo.description}
                    </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        	</c:if>
        	<c:if test="${st.count ne 1}">
        	<div class="carousel-item">
        	<div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img width="600" height="700" src="${vo.image}" alt="" onclick="location.href='${ctx}/bookinfo.do?isbn=${vo.isbn}'">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                              	<h1 class="h1 text-success"><b onclick="location.href='${ctx}/bookinfo.do?isbn=${vo.isbn}'">${vo.title}</b> <br>${vo.author}</h1>  
                                <p>
                                   ${vo.description}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        	</c:if>
        	
        </c:forEach>
        	
            
                
            
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 >책방이 회원님에게 추천하는 도서!</h1>
                <p>
                   회원님이 회원가입하실때 설정하신 관심있는 장르의 도서들을 추천드립니다!
                </p>
            </div>
        </div>
        <div class="row">
        <c:forEach var="vo" items="${recommendList}" varStatus="st">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="${vo.image}" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">${vo.title}</h5>
                <p class="text-center"><a class="btn btn-success">${vo.author}</a></p>
            </div>
        </c:forEach>    
           
        </div>
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
  
    </div>
    <!-- End Featured Product -->


<%@ include file="footer.jsp" %>