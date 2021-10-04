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
                <div class="title-one">1</div>
                <div class="title-one">언제 만들어지나요</div>
                <div class="title-two">답변완료</div>
                <div class="title-two">2021-09-21</div>
            </div>
            <div id="ask-contents">
            <!-- 상담 내용 -->
                <p>
                    이틀 전에 병원가서 검사했는데<br>
                    장기가 완성이 돼야 수술을 받을 수 있다고 해서 10월 25일로 수술 날짜를 잡았는데<br>
                    더 빨리 못만드나요?
                </p>
            </div>
            <hr>
            <div id="ask-answer">
            <!-- 상담 답변 -->
                <div id="ask-enroll">
                    [답변] 언제 만들어지나요<br>
                    2021-09-22 16:40:11
                </div>
                <div id="contents-answer">
                    안녕하세요 Full Life 상담사 김정미 입니다.<br><br>
                    김복자님께서 주문하신 인공심장 완성 날짜 확인 해 보았습니다. <br><br>
                    자사의 인공장기는 보통 배양에서부터 제작하는데 3주에서 4주까지 걸립니다.<br>
                    하지만, 부득이하게 늦어질 수도 있어 병원 수술 날짜를 여유롭게 잡습니다.<br>
                    감사합니다
                </div>
            </div>
            <hr>
            <div id="ask-butn">
            <!-- 목록, 삭제 버튼 -->
                <a href="#"><button>목록</button></a>
                <a href="#"><button>삭제</button></a>
            </div>
        </section>
        </div>
    </main>
        <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>