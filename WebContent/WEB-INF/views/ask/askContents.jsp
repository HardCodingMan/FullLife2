<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/ask.css">
</head>
<body>
	
    <header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
    <div id="main-navi">
            <span class="subMenu">
                <ul class="subMenu">
                    <li><a href="/faq/FAQ">FAQ</a></li>
                    <li><u><strong>문의</strong></u></li>
                    <hr>
                </ul>
            </span>
        </div>
        
        <br>
        <section id="ask">
        <!-- 상담 제목 및 날짜 -->
            <div id="ask-title">
                <div class="title-one">${requestScope.askOne.askNo }</div>
                <div class="title-one">${requestScope.askOne.askSubject }</div>
                <div class="title-two">${requestScope.askOne.reply }</div>
                <div class="title-two">${askOne.askDate }</div>
                <div class="title-two">${requestScope.askOne.userId }</div>
            </div>
            <div id="ask-contents">
            ${askOne.askContents }
    
            </div>
            <hr>
            <div id="ask-answer">
            <!-- 상담 답변 -->
                <div id="ask-enroll">
                    ${askOne.answerContents }
                                    
                </div>
            </div>
            <hr>
            <div id="ask-butn">
            <!-- 목록, 삭제 버튼 -->
                <a href="/ask/list"><button>목록</button></a>
                <c:if test="${sessionScope.userId eq askOne.userId && sessionScope.userId ne null}">
                <a href="/ask/remove?askNo=${askOne.askNo }"><button>삭제</button></a>
                </c:if>
            </div>
        </section>
        </div>
    </main>
        <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>