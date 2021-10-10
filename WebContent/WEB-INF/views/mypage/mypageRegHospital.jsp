<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mypage.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
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
                <li class="choice"><a href="/mypage/regHospital">병원예약조회</a></li>
                <li><a href="/mypage/checkResult">검사내역</a></li>
            </ul>
        </aside>
        <article>
            <form id="reghospital" action="/mypage/delete" method="get">
                <h3>병원예약 조회</h3>
                    <table id="book1">
                        <tr>
                            <td>예약병원 |</td>
                            <td><input class="bookbox" type="text" name="" value="${requestScope.info.hospitalName }" readonly onfocus="this.blur()"></td>
                        </tr>
                        <tr>
                            <td>병원위치 |</td>
                            <td><input class="bookbox" type="text" name="" value="${requestScope.info.hospitalAddr }" readonly onfocus="this.blur()"></td>
                        </tr>
                        <tr>
                            <td>검사날짜 |</td>
                            <td><input class="bookbox" type="text" name="" value="${requestScope.info.checkDate }" readonly onfocus="this.blur()"></td>
                        </tr>
                        <tr>
                            <td>예약시간 |</td>
                            <td><input class="bookbox" type="text" name="" value="${requestScope.info.hospitalTime }"  readonly onfocus="this.blur()"></td>
                        </tr>
                        <tr>
                            <td>이식장기 |</td>
                            <td><input class="bookbox" type="text" name="" value="${requestScope.bodyPart }"  readonly onfocus="this.blur()"></td>
                        </tr>
                    </table>
                    <input type="submit" value="예약취소" class="bookbt">
                </form>        
                    <br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br>
        </article>
    </div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>