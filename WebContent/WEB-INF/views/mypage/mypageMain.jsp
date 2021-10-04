<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
.<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <hr style="width: 1100px;">
                <form action="/mypage/main" method="post" id="mypagepic" name="mypagemain"><img src="/img/mypic.png" alt="" style="width: 100px;"><input type="text" class="userid2" id="userid" value=${sessionScope.userId } readonly></form> 
            <hr style="width: 1100px;">
            </div>
            <div class="icon">
                <div class="icon-pic"><a href="/mypage/cliUpdate"><img src="/img/m1.png" alt=""><p>회원정보수정</p></a></div>
                <div class="icon-pic"><a href="/mypage/history"><img src="/img/m2.png" alt=""><p>주문내역 조회</p></a></div>
                <div class="icon-pic"><a href="/mypage/point"><img src="/img/m3.png" alt=""><p>포인트 조회</p></a></div>
                <div class="icon-pic"><a href="/mypage/regHospital"><img src="/img/m4.png" alt=""><p>병원예약 조회</p></a></div>
                <div class="icon-pic"><a href="/mypage/checkResult"><img src="/img/m5.png" alt=""><p>검사내역 조회</p></a></div>   
            </div>
            <form id="mypagejumun"action="/mypage/history" method="post" name="mypageHistory">
                <table class="jumun">
                    <tr>
                        <th>주문번호</th>
                        <th>구매장기</th>
                        <th>구매수량</th>
                        <th>예약병원</th>
                        <th>결제금액</th>
                        <th>결제일자</th>
                        <th>구매날짜</th>
                    </tr>
                        <c:forEach items="${requestScope.hList}" var="history" varStatus="index">
                    <tr>
                        <td>${history.historyNo}</td>
                        <td>${history.organNo}</td>
                        <td>${history.organQuantity}</td>
                        <td>${history.hospitalNo}</td>
                        <td>${history.payment}</td>
                        <td>${history.paymentDate}</td>
                        <td>${history.historyDate}</td>
                    </tr>
					</c:forEach>    
					<tr>
                	 <td colspan="7" align="center">${pageNavi}</td>
                	 <tr>            
                </table>
                
            </form>
            <br>
    </article>
</div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>