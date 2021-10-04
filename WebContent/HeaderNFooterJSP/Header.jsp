<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FullLife</title>
    <link rel="stylesheet" href="/css/HSheader.css">
</head>
<body>
<header>
        <div id="logo">
            <a href="/index.jsp"><img src="/img/HSfulllife로고3 (1).png" alt=""></a>
        </div>
        <div id="blank"></div>
        <div id="header-menu">
            <ul>
                <li class="main-menu"><a href="#">장기이식</a></li>
                <li class="main-menu">
                    <a href="/Notice/Support/Supportintroduce">후원</a>
                    <ul class="serv-menu">
                        <li><a href="/Notice/Support/Supportintroduce">후원</a></li>
                        <li><a href="/Notice/Support/SupportNotice">후원게시판</a></li>
                        <li><a href="/Notice/Apply/ApplyNotice">신청게시판</a></li>
                    </ul>
                </li>
                <li class="main-menu">
                    <a href="/ask/list">상담</a> 
                    <ul class="serv-menu">
                        <li><a href="/faq/FAQ">FAQ</a></li>
                        <li><a href="#">문의하기</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="btn-div">
           	<c:if test="${sessionScope.userId eq null }">
               <button><a href="/member/login">LOGIN</a></button>
            </c:if>
            <c:if test="${sessionScope.userId ne null }">
               <button style="width:90px;"><a href="/mypage/main?userId=${sessionScope.userId }">
               MYPAGE</a></button>
               <div class="logout">
               <a href="/member/logout"><img src="/img/logout.png" style="width:20px;"></a>
               </div>
            </c:if>
        </div>
    </header>
</body>
</html>