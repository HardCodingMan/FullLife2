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
    
    <link rel="stylesheet" href="/FONT/fontawesome-free-5.15.4-web/css/all.css">
    <link rel="stylesheet" href="/css/FullLife-Hospital.css">
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap" rel="stylesheet">
    <script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <script>
        window.onload = function() {
        	 	
            var locationTag = document.querySelector("#location");
			var result = "";
            locationTag.addEventListener("change", function() {
				result = locationTag.value;
				location.href="/hospital/listAll?location="+result;	
            });
<<<<<<< HEAD
<<<<<<< HEAD
=======
            

=======
>>>>>>> origin/Hyunseok
            document.querySelector("input[name='chosen-hospital']").addEventListener("change", function(){
            	console.log(this.value);
            });
//             console.log(document.querySelector("input[name='chosen-hospital']:checked").value);

			var BtnTag = querySelector("#submitBtn");
			
<<<<<<< HEAD
=======
            

>>>>>>> origin/Hyunseok
=======
>>>>>>> origin/JaeWon
>>>>>>> origin/Hyunseok
        }
    </script>
    <header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
	<!---------------------------------->
    <main>
        <section class="hospital-div">
            <div class="input-div">
                <div class="input-header">
                    <h1>협력병원</h1>
                </div>
                <div class="input-footer">
                    <p>가까운 병원 찾기</p>
                    <h6>지역을 선택해주세요.</h6>
                    <c:if test="${sessionScope.userId ne null or requestScope.location ne null }">
                    <form action="/reserve/reservation" method="get">
                    </c:if>
                    <c:if test="${sessionScope.userId eq null or requestScope.location eq null }">
                    <form action="/member/login" method="get">
                    </c:if>
                        <div class="select">
                           	<select name="metro-city" id="location">
                            	<option value="" disabled <c:if test="${requestScope.location eq null }">selected</c:if>>지역 선택</option>
                                <option value="seoul" <c:if test="${requestScope.location eq 'seoul' }">selected</c:if>>서울</option>
                                <option value="daejeon" <c:if test="${requestScope.location eq 'daejeon' }">selected</c:if>>대전</option>
                                <option value="daegu" <c:if test="${requestScope.location eq 'daegu' }">selected</c:if>>대구</option>
                                <option value="busan" <c:if test="${requestScope.location eq 'busan' }">selected</c:if>>부산</option>
                                <option value="gwangju" <c:if test="${requestScope.location eq 'gwangju' }">selected</c:if>>광주</option>
                            </select>
                        </div>
                        <br><br><br>
                        <input type="submit" value="바로 예약하기">
                    </form>
                </div>
            </div>
            
            <div class="output-div">
                <div>
                	<c:if test="${requestScope.city ne null }">
                    <p><b id="location-result">${city }</b>에서 가까운 병원 조회 결과</p>
                    </c:if>
                    <c:if test="${city eq null }">
                    <p><b id="location-result">내 지역</b>에서 가까운 병원 조회 결과</p>
                    </c:if>
                </div>
                <div id="hospital-result">
                	<c:forEach items="${requestScope.hospitals }" var="hospital" varStatus="index">
<<<<<<< HEAD
<<<<<<< HEAD
=======
                		<label><input type="radio" name="chosen-hospital" value="${hospital.hospitalNo }"><b style="font-size:25px">${hospital.hospitalName }</b></label>
=======
>>>>>>> origin/Hyunseok
                		<label>
                		<input type="radio" name="chosen-hospital" value="${hospital.hospitalNo }">
                		<b style="font-size:25px">${hospital.hospitalName }</b>
                		</label>
<<<<<<< HEAD
=======
                		<label><input type="radio" name="chosen-hospital" value="${hospital.hospitalNo }"><b style="font-size:25px">${hospital.hospitalName }</b></label>
>>>>>>> origin/Hyunseok
=======
>>>>>>> origin/JaeWon
>>>>>>> origin/Hyunseok
                		<h4 style="margin:10px">${hospital.hospitalAddr }</h4>
                		<a href="#"><h5 style="margin: 0 0 40px 30px">${hospital.hospitalPhone }</h5></a>
                	</c:forEach>
                </div>
            </div>
        </section>
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