<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="../css/ask.css">
</head>
<body>
	<div class="wrapper">
    <header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <section>
            <div id="ask-header">
                <h2>문의</h2>
            </div>
        </section>
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
                <a href="/ask/remove?askNo=${askOne.askNo }"><button>삭제</button></a>
            </div>
        </section>
        </div>
    </main>
        <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>