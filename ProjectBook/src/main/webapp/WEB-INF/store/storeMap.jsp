<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=8u9s7as9cy">
</script>    
<div id="map" style="width:100%; height:800px;"></div>

    <script>

    var HOME_PATH = window.HOME_PATH || '.';

    var bookstore = new naver.maps.LatLng(${vo.location1}, ${vo.location2}),
        map = new naver.maps.Map('map', {
            center: bookstore.destinationPoint(${vo.location1}, ${vo.location2}),
            zoom: 17
        }),
        marker = new naver.maps.Marker({
            map: map,
            position: bookstore
        });

    var contentString = [
            '<div class="iw_inner">',
            '<h3>${vo.storename}</h3>',
            '<p>${vo.address}</p>',
            '<img src="${vo.img}" width="200" height="100" alt="" class="thumb" /><br />',
            ,
            '</div>'
        ].join('');

    var infowindow = new naver.maps.InfoWindow({
        content: contentString
    });

    naver.maps.Event.addListener(marker, "click", function(e) {
        if (infowindow.getMap()) {
            infowindow.close();
        } else {
            infowindow.open(map, marker);
        }
    });

    infowindow.open(map, marker);

    </script>

<%@ include file="../footer.jsp" %>