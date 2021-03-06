<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                	<input type="text" name="searchKeyword" placeholder="검색 할 제목을 적어주세요">
                	<button id="search-butn">검색</button>
                </form>
            </div>
        </section>
        <section id="notice-section">
            <div class="notice">
                <ul>
                	<c:forEach items="${aList }" var="aOne">
                    <li>
                        <a href="/Notice/Apply/ApplyContents?noticeNo=${aOne.noticeNo }" class="notice-link">
                            <div>
                                <div class="list-img">
                                    <img src="/fileupload/${aOne.picName }" alt="${aOne.picName }" class="li-img">
                                </div>
                                <div class="list-text">
                                    <p class="notice-title">${aOne.noticeTitle }</p>
                                </div>
                                <div id="list-text2">
                                    <div>조회수 : ${aOne.views }<br>추천수 : ${aOne.noticeLike }</div>
                                    <div>${aOne.simsa }</div>
                                </div>
                            </div>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
            <c:if test="${sessionScope.userId ne null }">
              <div class="wrap">
                <a href="/Notice/Apply/ApplyNoticeWriter"><button class="button">글쓰기</button></a>
              </div>
              <br><br>
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