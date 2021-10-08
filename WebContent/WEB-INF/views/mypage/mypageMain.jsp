<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
	<div style="margin: 0 auto;">
    <div class="mypage">
        <h2>마이페이지</h2>
    </div>
    <article>
        <div>
            <div id="mypagemain">
            	<br>
            	<br>
                <form action="/mypage/main" method="post" id="mypagepic" name="mypagemain"><img src="/img/mypic1.png" alt="" style="width: 100px;"><input type="text" class="userid2" id="userid" value=${sessionScope.userId } readonly onfocus="this.blur()"></form> 
            	<br>
            <hr style="width: 1000px;">
            </div>
            <br>
            <div id="icon" style="text-align: center;">
                <div class="icon-pic"><a href="/mypage/cliUpdate"><img src="/img/m1.png" alt=""><p>회원정보수정</p></a></div>
                <div class="icon-pic"><a href="/mypage/history"><img src="/img/m2.png" alt=""><p>주문내역 조회</p></a></div>
                <div class="icon-pic"><a href="/mypage/point"><img src="/img/m3.png" alt=""><p>포인트 조회</p></a></div>
                <div class="icon-pic"><a href="/mypage/regHospital"><img src="/img/m4.png" alt=""><p>병원예약 조회</p></a></div>
                <div class="icon-pic" style="margin-bottom: 30px;"><a href="/mypage/checkResult"><img src="/img/m5.png" alt=""><p>검사내역 조회</p></a></div>   
            </div>
            <hr style="width: 1000px;">
            <p style="text-align: center;">
            <img src="/img/mypageMain.png" alt="" id="mymain" style="width: 600px;">
            </p>
            <br>
    </article>
</div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>