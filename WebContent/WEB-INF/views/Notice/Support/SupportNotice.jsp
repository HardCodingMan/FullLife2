<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/supportnotice.css">
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
                <h2>후원 게시판</h2>
            </div>
            <div id="search">
            	<form action="/Notice/Support/SupportNoticeSearch" method="get">
                	<input type="text" name="searchKeyword" placeholder="검색 할 제목을 적어주세요">
                	<button class="button" id="list">검색</button>
                </form>
            </div>
        </section>
        <section id="notice-section">
            <div class="notice">
                <ul>
                	<c:forEach items="${sList }" var="sOne">
                    <li>
                        <a href="/Notice/Support/SupportContents?noticeNo=${sOne.noticeNo }" class="notice-link">
                        <div class="list">
                            <div class="list-img">
                                <img src="/fileupload/${sOne.picName }" alt="${sOne.picName } class="list-img">
                            </div>
                            <div class="list-text">
                                <p class="notice-title">${sOne.noticeTitle }</p>
                            </div>
                            <div>
                                <p>조회수 : ${sOne.views }</p>
                            </div>
                            <div class="list-percent">                      
                                <div class="prog">
                                <div class="progs" id="progressing" style="width: ${(sOne.nowSupport/sOne.needSupport)*100 }%;"><fmt:formatNumber value="${(sOne.nowSupport/sOne.needSupport)*100 }" pattern="0"/>%</div>
                            </div>
                            </div>
                        </div>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
            <div id="page">${pageNavi }</div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>