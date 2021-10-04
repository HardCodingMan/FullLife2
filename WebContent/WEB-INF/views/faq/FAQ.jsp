<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"  href="/css/FAQ.css">
</head>
<body>
	 <header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
	<div class="wrapper">
        <div>
        <section>
            <div id="FAQ-header">
                <h2>자주 묻는 질문</h2>
            </div>
        </section>
        <section>
        <!-- FAQ 질문 -->
            <div id="FAQ-top">
            	<br>
                <button id="bio-question" onclick="dis(1)">3D 바이오 기술 문의</button>
                <button id="reservation-question" onclick="dis(2)">예약 관련 문의</button>
                <button id="support-question" onclick="dis(3)">후원 관련 문의</button>
            </div>
        </section>
        <section id="question-section">
            <ul id="frist-question" class="section-ul">
            <!-- 바이오 프린팅 관련 질문 -->
                <li class="menu">
                    <span><h3>바이오 프린팅이 뭔가요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>바이오 프린팅의 장점이 뭔가요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>바이오 프린팅으로 하면 위험하지 않을까요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>질문4</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
            </ul>
            <ul id="second-question" class="section-ul">
            <!-- 예약 관련 질문 -->
                <li class="menu">
                    <span><h3>예약 절차가 어떻게 되나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>예약자랑 환자가 다른사람이면 어떻게 하나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>예약을 취소하려면 어떻게 해야하나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>예약금 환불은 언제 되나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
            </ul>
            <ul id="three-question" class="section-ul">
            <!-- 후원 관련 질문 -->
                <li class="menu">
                    <span><h3>후원은 어떻게 해야하나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>후원금은 어떻게 사용되나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>후원을 하면 무슨 장점이 있나요?</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>저도 후원 받고싶어요</h3></span>
                    <ul class="hide">
                        <li>답변 내용</li>
                    </ul>
                </li>
                <hr>
            </ul>
        </section>
        </div>
    </div>
    </main>
    <script>
        
        function dis(int){
//           onclik 버튼 클릭 시 값을 비교
            if(int == '1' && $("#frist-question").css('display') == 'none'){
                $('#frist-question').show();
            }else{
                $('#frist-question').hide();
            }
            if(int == '2' && $("#second-question").css('display') == 'none'){
                $('#second-question').show();
            }else{
                $('#second-question').hide();
            }
            if(int == '3' && $("#three-question").css('display') == 'none'){
                $('#three-question').show();
            }else{
                $("#three-question").hide();
            }
        }
        
        // menu 클래스 바로 하위에 있는 span 태그를 클릭했을때
        $(".menu>span").click(function(){
            var submenu = $(this).next("ul");
 
            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 부드럽게 펼치기
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    </script>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>