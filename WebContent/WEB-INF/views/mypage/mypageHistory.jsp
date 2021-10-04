<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
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
        <aside id="menucontainer">
            <ul class="menu">
                 <li><a href="/mypage/cliUpdate">회원정보 수정</a></li>
                <li><a href="/mypage/history">주문내역</a></li>
                <li><a href="/mypage/point">포인트조회/충전</a></li>
                <li><a href="/mypage/regHospital">병원예약조회</a></li>
                <li><a href="/mypage/checkResult">검사내역</a></li>
            </ul>
        </aside>
        <article>
            <form id="order" action="/mypage/history" method="post" name="mypageHistory">
                <h3>주문내역</h3>
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
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </article>
    </div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>