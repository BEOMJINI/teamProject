<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<table class="table table-bordered border-dark text-center">
  <thead class="table-dark">
    <tr>
      <th>주문번호</th>
      <th>수령방법</th>
      <th>ISBN</th>
      <th>책 이름</th>
      <th>구매 수량</th>
      <th>리뷰</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="vo" items="${list}" varStatus="st">
      
        <tr>
          <td>${vo.no}</td>
          <td>
            <c:choose>
              <c:when test="${vo.receive eq -1}">배송</c:when>
              <c:when test="${vo.receive eq 0}">책방 강남점(본점) 직접수령</c:when>
              <c:when test="${vo.receive eq 1}">책방 잠실점 직접수령</c:when>
              <c:when test="${vo.receive eq 2}">책방 목동점 직접수령</c:when>
              <c:when test="${vo.receive eq 3}">책방 영등포점 직접수령</c:when>
            </c:choose>
          </td>
          <td>${vo.isbn}</td>
          <td>${vo.title}</td>
          <td>${vo.cqty}</td>
          <td>
            <c:choose>
              <c:when test="${vo.reviewCheck eq true}">
                <a href="showMyReview.do?isbn=${vo.isbn}" class="btn btn-primary">작성한 리뷰 보기</a>
              </c:when>
              <c:when test="${vo.reviewCheck eq false}">
                <a href="writeReview.do?isbn=${vo.isbn}" class="btn btn-outline-primary">리뷰 작성하러 가기</a>
              </c:when>
            </c:choose>
          </td>
        </tr>
      
    </c:forEach>
  </tbody>
</table>

<%@ include file="../footer.jsp" %>