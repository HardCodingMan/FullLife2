<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/applynotice.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div class="wrapper">
        <section id="main-header">
            <div id="supportnotice-header">
                <h2>신청 게시판</h2>
            </div>
            <div id="search">
            	<form action="/Notice/Apply/ApplyNoticeSearch" method="get">
                	<input type="text" name="searchKeyword">
                	<input type="submit" value="검색">
                </form>
            </div>
        </section>
        <section id="notice-section">
            
            <c:if test="${sessionScope.userId ne null }">
            <a href="/Notice/Apply/ApplyNoticeWriter"><button id="write">글쓰기</button></a>
            </c:if>
            <br><div id="page">${pageNavi }</div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>