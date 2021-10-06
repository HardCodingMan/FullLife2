<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"  href="./css/FAQ.css">
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
                    <span><h3>Q. 바이오 프린팅이 뭔가요?</h3></span>
                    <ul class="hide">
                        <li>A. 바이오 프린팅이란 설계확인이나 평가를 위한 파트
                            제작을 위해 주로 사용되는 쾌속조형(Rapid Prototyping, RP)기술을 응용한 적층방법으로, 살아있는 세포
                            (cell)를 원하는 형상 또는 패턴(pattern)으로 적층하여
                            조직이나장기(organ)를제작하는기술입니다.
                            </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 바이오 프린팅의 장점이 뭔가요?</h3></span>
                    <ul class="hide">
                        <li>A. 환자 개인에게 맞춘 '맞춤형' 형태로 제작되어 손상된 인체 조직과 기관을 구현할 수 있는 점은 '바이오 3D 프린팅'의 가장 큰 장점입니다.
                            또 맞춤 제작이어서 재료의 낭비를 막고, 제작 시간을 단축시킬 수 있습니다.
                           </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 바이오프린팅은 위험하지 않나요?</h3></span>
                    <ul class="hide">
                        <li>A. 의료 목적을 위해, (실험 분야에서) bioprinter는 2000 년부터 알려져 왔습니다. 
                            바이오프린팅의 목표는 인체가 자연스럽게하는 것처럼 세포의 3 차원 조직을 재현하려는 것입니다. 
                            병원에서 검사를 통하여 환자의 세포가있는 조직이나 기관을 주문 제작하는 것이기때문에 
                            이식이 필요한 환자의 장기를 바이오프린트로 정밀하게 조정하여 제작하여 거부 위험을 최소화합니다. 
                            </li>
                    </ul>
                </li>
            </ul>
            <ul id="second-question" class="section-ul">
            <!-- 예약 관련 질문 -->
                <li class="menu">
                    <span><h3>Q. 예약 절차가 어떻게 되나요?</h3></span>
                    <ul class="hide">
                        <li>A. 홈페이지 메인상단의 장기이식 메뉴에서 관련장기를 선택하신후 예약을 하시면 
                            병원에서 검사할 날짜를 지정할수있습니다.
                            선택하신 병원에서 검사를 하시면 수일내로 이식가능여부의 결과가 나옵니다.
                            이식이 가능하시면 처음에 선택하신 장기가 제작에 들어가므로 그후의 예약취소는 유선상으로만 가능해집니다.
                            </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 예약자랑 환자가 다른사람이면 어떻게 하나요?</h3></span>
                    <ul class="hide">
                        <li>A. 예약페이지에 본인인지 아닌지 체크하는란이 있습니다. 
                            본인과 다를경우 반드시 체크하여 예약 진행해주세요 .
                            </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 예약을 취소하려면 어떻게 해야하나요?</h3></span>
                    <ul class="hide">
                        <li>A. 기본적으로 검사를 위한 병원예약은 병원 검사예약 3일전까지 취소가능합니다. 
                            병원 검사예약 취소는 로그인>마이페이지에서에서 가능하시며 , 검사후 장기 제작중에 예약취소는 원칙상 불가능합니다.
                            </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 예약금 환불은 언제 되나요?</h3></span>
                    <ul class="hide">
                        <li>A. 은행마다 약간의 차이는 있을수 있습니다만,보통 예약금은 예약취소후 3일안에 환불됩니다. </li>
                    </ul>
                </li>
            </ul>
            <ul id="three-question" class="section-ul">
            <!-- 후원 관련 질문 -->
                <li class="menu">
                    <span><h3>Q. 후원은 어떻게 해야하나요?</h3></span>
                    <ul class="hide">
                        <li>A. 후원은 후원게시판 내에서 포인트로 후원이 가능합니다.
                            포인트는 신청게시판내 글쓰기 100, 댓글 50 포인트 적립이 가능하며 포인트 충전을 통해서도 구매가능합니다.
                            </li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 후원한 포인트는 어떻게 사용되나요?</h3></span>
                    <ul class="hide">
                        <li>A. 후원신청자의 신청글에 후원이 달성되면 신청자가 필요한 장기를 바이오프린트로 제작하여 지원해줍니다.</li>
                    </ul>
                </li>
                <hr>
                <li class="menu">
                    <span><h3>Q. 후원신청자는 어떻게 뽑나요 ?</h3></span>
                    <ul class="hide">
                        <li>A. 신청게시판에 신청사연을 올려주시면 심사를 통하여 후보자를 뽑아서 후원게시판으로 게시글을 옮겨드리고있습니다.</li>
                    </ul>
                </li>
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