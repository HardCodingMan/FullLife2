<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FullLife</title>
    
    <link rel="stylesheet" href="../../../FONT/fontawesome-free-5.15.4-web/css/all.css">
    <link rel="stylesheet" href="../../../css/FullLife-Donate.css">
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap" rel="stylesheet">
</head>
<body>
    <script>
        window.onload = function() {
            const prevBtn = document.querySelector(".prev");
            const nextBtn = document.querySelector(".next");
            const progress1 = document.querySelector("#bar1");
            const progress2 = document.querySelector("#bar2");
            let percentage1 = progress1.getAttribute("data-done");
            let percentage2 = progress2.getAttribute("data-done");
            
            console.log(progress1.getAttribute("data-done"));
            console.log(progress2.getAttribute("data-done"));

            prevBtn.addEventListener("click", function(){
                document.querySelector(".support-info1").style.display = "block";
                document.querySelector(".support-info2").style.display = "none";
            });
            nextBtn.addEventListener("click", function(){
                document.querySelector(".support-info2").style.display = "block";
                document.querySelector(".support-info1").style.display = "none";
            });

            setTimeout(function(){
                progress1.style.width = progress1.getAttribute("data-done")+"%";
                progress1.style.opacity = 1;
                progress1.innerHTML = progress1.getAttribute("data-done")+"%";
                if(percentage1 >= 100){
                    progress1.innerHTML = "complete";
                }
            }, 200);

            setTimeout(function(){
                progress2.style.width = progress2.getAttribute("data-done")+"%";
                progress2.style.opacity = 1;
                progress2.innerHTML = progress2.getAttribute("data-done")+"%";
                if(percentage2 >= 100){
                    progress2.innerHTML = "complete";
                }
            }, 200);
        }

    </script>
    <header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <!-- ------------------------------ -->
    <main>
        <section class="support-div">
            <div class="input-div">
                <div class="input-header">
                    <h1>후원</h1>
                </div>
                <div class="input-footer">
                    <p>잔여포인트</p>
                    <input type="text" value="1000 POINT"  style="width: 95%; height: 40px; border: none; background-color: #fafafa; font-family: 'Do Hyeon', sans-serif; font-size: 15px;" readonly>
                    <form action="#">
                        <p>포인트 입력</p>
                        <input type="text" value="" placeholder="1000포인트 이상 기부 가능" style="width: 95%; height: 40px; font-family: 'Do Hyeon', sans-serif; font-size: 15px;"><br>
                        <input type="submit" value="후원하기" id="point-btn">
                    </form>
                </div>
            </div>
            
            <div class="slide-wrapper">
                <div class="support-info1">
                    <h1>BEST1. ${requestScope.firstSupport.noticeTitle }</h1>
                    <img src="${firstSupport.picPath }" alt="" width="90%" height="70%">
                    <div class="support-percentage">
                        <p>조회수: ${requestScope.firstSupport.supportHuman }</p>
                        <p>달성금액: ${requestScope.firstSupport.nowSupport}</p>
                        <p>달성률: ${requestScope.firstPercentage }</p>
                        <div class="progress-bar">
                            <div class="progress-done" id="bar1" data-done="${requestScope.firstPercentage }"></div>
                        </div>
                    </div>
                </div>
                <div class="support-info2">
                    <h1>BEST2. ${requestScope.secondSupport.noticeTitle }</h1>
                    <img src="${secondSupport.picPath }" alt="" width="90%" height="70%">
                    <div class="support-percentage">
                        <p>조회수: ${secondSupport.views }</p>
                        <p>달성금액: ${requestScope.secondSupport.nowSupport }</p>
                        <p>달성률: ${requestScope.secondPercentage }</p>
                        <div class="progress-bar second">
                            <div class="progress-done" id="bar2" data-done="${requestScope.secondPercentage }"></div>
                        </div>
                    </div>
                </div>
                
                <div class="btn-div">
                    <button class="prev"><i class="fas fa-chevron-left"></i></button>
                    <button class="next"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
            
        </section>
    <!-- ------------------------------ -->
    <section>
        <div class="con1">
            <h1>수술 성공 사례 1,000,000건</h1>
        </div>
        <div>
            <fieldset class="con2">
                <legend>3D 바이오프린팅이란?</legend>
                <p>3D 바이오프린팅(bioprinting)은 인체의 복잡한 구조의 조직과 기관을 닮은 구조체를 컴퓨터 프로
                    그램 설계를 통해 정확하게 구현할 수 있고 환자 맞춤형 치료를 할 수 있는 장점이 있어 조직 공학
                    과 재생 의약에서 활발히 연구되는 기술이다. 3D 바이오프린팅은 주로 3D 프린터 하드웨어, 컴퓨
                    터 프로그래밍, 그리고 바이오잉크으로 구성된다. 세포와 물질 (세포외기질(매트릭스), 성장인자,
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
            <img src="../../../img/aside.png" alt="" style="width: 100%; height: 100%;">
        </div>
        <p style="color:gray;">
     평균 생존율은 1년 95%, 5년 92% , FullLife는 언제나 최고의 연구진과 함께합니다.</p>
    </section>
    </main>
    <br>
    <!-- ------------------------------ -->
   <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>