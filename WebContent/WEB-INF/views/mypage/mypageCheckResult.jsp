<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                <li class="choice"><a href="/mypage/checkResult">검사내역</a></li>
            </ul>
        </aside>
        <article>
            <form id="checkresult" action="/mypage/checkResult" method="post" name="checkResult">
                <h3>검사내역조회</h3>
                <table class="gumsa">
                    <tr>
                    	<th>파일번호</th>
                        <th>첨부파일</th>
                        <th>병원명</th>
                        <th>검사날짜</th>
                        <th>다운로드</th>
                       
                    </tr>
                      <c:forEach items="${requestScope.cList}" var="checkResult" varStatus="index">
                    <tr>
                    	<td>${checkResult.fileNo}</td>
                        <td>${checkResult.fileName}</td>
                        <td>${checkResult.hospitalName}</td>
                        <td>${checkResult.checkDate}</td>
                        <td>
                        	<form action="/mypage/file_down" method="post">
                        		<input type="hidden" name="file-path" value="${checkResult.filePath }">
                        		<input type="image" src="/img/download.png" name="submit" value="다운" id="down" >
                        	</form>
                        </td>
                    </tr>
                    </c:forEach>
                    <tr>
                    <td colspan="5" align="center" id="pageNavi">${pageNavi}</td>
                    </tr>
                </table>
            </form>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </article>
    </div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>