<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./FONT/fontawesome-free-5.15.4-web/css/all.css">
    <title>FullLife</title>
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
    <script>
         window.onload = function() {
        	 
            let btn1 = document.querySelector(".btn1");
            let btn2 = document.querySelector(".btn2");
            let btn3 = document.querySelector(".btn3");
            
            btn1.addEventListener("click", function() {
                document.querySelector(".slides").style.transform = 'translateX(0%)';
                btn1.style.background = "rgba(173, 196, 136)";
                btn2.style.background = "white";
                btn3.style.background = "white";
            });
            btn2.addEventListener("click", function() {
                document.querySelector(".slides").style.transform = 'translateX(-33.3%)';
                btn1.style.background = "white";
                btn2.style.background = "rgba(173, 196, 136)";
                btn3.style.background = "white";
            });
            btn3.addEventListener("click", function() {
                document.querySelector(".slides").style.transform = 'translateX(-66.7%)';
                btn1.style.background = "white";
                btn2.style.background = "white";
                btn3.style.background = "rgba(173, 196, 136)";
            });
        }
    </script>
    <!-------------------------------------------------->
    <header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <section class="slide-section" >
            <div class="slides">    
                <div class="inner">
                    <img src="./img/main1.jpg" alt="" height="100%">
                </div>
                <div class="inner">
                    <img src="./img/main2.jpg" alt="" height="100%">
                </div>
                <div class="inner">
                    <img src="./img/main3.jpg" alt="" height="100%">
                </div>
            </div>
            <button class="btn1"></button>
            <button class="btn2"></button>
            <button class="btn3"></button>
            <div class="navigation-manual">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
                <label for="radio4" class="manual-btn"></label>
            </div>
            <div class="oneway-div">
                <a href="/hospital/move"><button class="oneway-btn">협력병원 찾기</button></a>
                <a href="/donate/move?rank1=1&rank2=2"><button class="oneway-btn">후원</button></a> 
            </div>
        </section>
        <section>
            <div class="con1">
                <h1>수술 성공 사례 1,000,000건</h1>
            </div>
            <div>
                <fieldset class="con2">
                    <legend>3D 바이오프린팅이란?</legend>
                    <p>     3D 바이오프린팅(bioprinting)은 인체의 복잡한 구조의 조직과 기관을 닮은 구조체를 컴퓨터 프로
                        그램 설계를 통해 정확하게 구현할 수 있고 환자 맞춤형 치료를 할 수 있는 장점이 있어 조직 공학
                        과 재생 의약에서 활발히 연구되는 기술이다. 3D 바이오프린팅은 주로 3D 프린터 하드웨어, 컴퓨터
                         프로그래밍, 그리고 바이오잉크으로 구성된다. 세포와 물질 (세포외기질(매트릭스), 성장인자,
                        입자들로 구성된 바이오잉크(bioink)는 3D 바이오프린팅의 핵심 소재이며 인쇄적성(printability),
                        젤화(gelation) 특성, 생분해성(biodegradability), 세포적합성(cell-compatibility), 그리고 세포 성장
                        (proliferation)과 분화(differentiation)를 조절할 수 있는 특성을 가져야 한다.다양한 세포로 구성된 기능을 가진 인체의 조직과 기관을 만들어
                        손상된 조직과 기관을 대체하는것은 조직공학과 재생의약의 주된 목표이다. 바이오프린팅은 이런 조직공학과 재생의약의 목표를
                        빠르게 실현할 수 있도록 도울 수 있는 최근 핵심 기술이다. 바이오프린팅은 자동화된 바이오프린
                        터 기술을 기반으로 세포와 생체재료를 이용해 원하는 삼차원 구조의 조직과 기관을 만드는 것이다</p>
                </fieldset>
            </div>
        </section>
        <section class="vid-section">
            <video width="2000px" height="400px" src="https://cdn.thewellbio.com/wp-content/uploads/2020/10/HomeBannerVideo-Mini.mp4" autoplay loop></video>
        </section>
        <section class="intro-section"> 
            <div class="pic-div">
                <img src="./img/aside.png" alt="" style="width: 100%; height: 100%;">
            </div>
            <p style="color:gray;">  
         평균 생존율은 1년 95%, 5년 92% , FullLife는 언제나 최고의 연구진과 함께합니다.</p>
        </section>
    </main>
        <!------------------------------------------------------------------------------------------------>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>