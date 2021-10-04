<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/applynotice.css">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div class="wrapper">
        <section>
            <div id="applynotice-header">
                <h2>신청 게시판</h2>
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
                                    <div>조회수 : ${aOne.views }</div>
                                    <div>추천수 : ${aOne.noticeLike }</div>
                                </div>
                                <div class="list-btn">
                                    <button>자세히보기</button>
                                </div>
                            </div>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
            <a href="/Notice/Apply/ApplyNoticeWriter"><button id="write">글쓰기</button></a>
            <div id="page">${pageNavi }</div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>