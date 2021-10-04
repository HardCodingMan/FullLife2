<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장기이식</title>
<link rel="stylesheet" type="text/css" href="/css/organTrans.css">
</head>
<body>
	<header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <navi>
        <ul id="navi">
            <li class="subMenu"><a href="#">기술소개</a></li>
            <li class="subMenu"><a href="#organDetail">장기에 대한 설명</a></li>
            <li class="subMenu"><a href="#findHos-main">병원찾기</a></li>
            <li class="subMenu"><a href="#afterPurchase">구매 후 절차</a></li>
        </ul>
    </navi>
    <main>
        <div class="division">
            <div id="bioprinting">
                <div id="introVideo">
                    <h1>기술소개</h1>
                    <iframe width="600" height="400" src="https://www.youtube.com/embed/rgxDixvWbLE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <span id="bioprint-description">
                    <h2>바이오 프린팅 기술</h2>
                    3차원(3D) 장기 바이오프린팅은 동종이식, 고처리량 약물 스크리닝 및 병리학적 분석에 대한 모든 심각한 병목 문제를 해결할 수 있는 막대한 상업적 이익을 가진 매력적인 과학 분야입니다. 
                    여러 이종의 성체 세포 유형 및/또는 줄기세포를 다른 생체 재료(예: 고분자, 생리 활성제 또는 생체 분자)와 통합하여
                    3D 구성을 기능적으로 만드는 것이 생체 인공 기관의 3D 바이오프린팅에 대한 핵심 문제 중 하나입니다.
                    천연 및 합성 폴리머는 모두 특정 물리적, 화학적, 생물학적 및 생리학적 특성을 기반으로 하는 3D 인쇄 구성에서 계층적 혈관 및 신경망 형성에 필수적이고
                    보편적인 역할을 합니다.  
                </span>
            </div>
        </div>
        <br>
        <div class="division-lightsand">
            <div id="organDetail">
                
                    
                    <div class="main">
                        <input type="radio" name="show" id="tab-1" checked>
                        <input type="radio" name="show" id="tab-2">
                        <input type="radio" name="show" id="tab-3">
                        <input type="radio" name="show" id="tab-4">
                        <input type="radio" name="show" id="tab-5">
                        <div class="tab">
                            <label for="tab-1"><img src="../img/organTrans/liver.png" class="menuPic"></label>
                            <label for="tab-2"><img src="../img/organTrans/heart.png" class="menuPic"></label>
                            <label for="tab-3"><img src="../img/organTrans/tooth.png" class="menuPic"></label>
                            <label for="tab-4"><img src="../img/organTrans/bone.png" class="menuPic"></label>
                            <label for="tab-5"><img src="../img/organTrans/lung.png" class="menuPic"></label>
                        </div>
                    
                    
            <div class="content">
                <div class="content-dis">
                    <div id="liver-pic">
                        <div id="money">
                            <h3>간, 간 때문이야~ </h3>
                            <h4>50,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <input type="button" value="예약하러가기">
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <h3>간에 대한 설명</h3>
                        간은 동물의 주요 생체 기관 중 하나로, 대표적으로 해독 작용을 하며, 단백질을 합성하고, 양분을 저장하며, 쓸개즙, 요소 등을 생성한다.
                        간은 모든 내장 기관 중 가장 크다. 간은 물질대사에서 주요 역할을 담당하며, 글리코겐의 저장, 적혈구의 분해, 혈청 단백질의 합성, 호르몬 생산, 해독작용 등 기타 여러 역할을 한다.
                        간은 배에서 복부-골반 부분의 횡격막 아래에 놓여 있다.
                        간은 지질의 유화로 소화를 돕는 알칼리성의 혼합물인 담즙을 생산한다.
                        간의 고도로 전문화된 조직들은 작고 복잡한 분자들의 합성과 분해와 같은 매우 다양한 대량의 생화학적 작용을 조절하며, 이들은 평상시의 주요 기능을 위해 필요하다.
                        간은 생존에 필요하다. 현재로서는 오랜 기간 간의 손실을 메울 수 있는 방법은 없다.
                        오직 인공장기 이식만이 대안이다. 
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="heart-pic">
                        <div id="money">
                            <h3>아 ~ 심장박동 </h3>
                            <h4>100,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <input type="button" value="예약하러가기">
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <h3>심장에 대한 설명</h3>
                        
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="tooth-pic">
                        <div id="money">
                            <h3>이가탄탄 치아! </h3>
                            <h4>2,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <input type="button" value="예약하러가기">
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <h3>치아에 대한 설명</h3>
                        간은 동물의 주요 생체 기관 중 하나로, 대표적으로 해독 작용을 하며, 단백질을 합성하고, 양분을 저장하며, 쓸개즙, 요소 등을 생성한다.
                        간은 모든 내장 기관 중 가장 크다. 간은 물질대사에서 주요 역할을 담당하며, 글리코겐의 저장, 적혈구의 분해, 혈청 단백질의 합성, 호르몬 생산, 해독작용 등 기타 여러 역할을 한다.
                        간은 배에서 복부-골반 부분의 횡격막 아래에 놓여 있다.
                        간은 지질의 유화로 소화를 돕는 알칼리성의 혼합물인 담즙을 생산한다.
                        간의 고도로 전문화된 조직들은 작고 복잡한 분자들의 합성과 분해와 같은 매우 다양한 대량의 생화학적 작용을 조절하며, 이들은 평상시의 주요 기능을 위해 필요하다.
                        간은 생존에 필요하다. 현재로서는 오랜 기간 간의 손실을 메울 수 있는 방법은 없다.
                        오직 인공장기 이식만이 대안이다. 
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="bone-pic">
                        <div id="money">
                            <h3>뼈 개뼈다귀 </h3>
                            <h4>2,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <input type="button" value="예약하러가기">
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <h3>뼈에 대한 설명</h3>
                        
                        오직 인공장기 이식만이 대안이다. 
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="lung-pic">
                        <div id="money">
                            <h3>폐야 아프지마 </h3>
                            <h4>20,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <input type="button" value="예약하러가기">
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <h3>폐에 대한 설명</h3>
                        
                        오직 인공장기 이식만이 대안이다. 
                    </div>
                  </div>
                      
            </div>
            </div>
        </div>
        </div>
        <div class="division">
            <div id="findHos-main">
                <h1><strong>협력병원</strong></h1>
                <div id="findHos-main1">
                    <div id="hosPic">
                        <img src="../img/organTrans/AsanHos.jpg">
                    </div>
                    <div id="hosDesc">
                        <h3>아산병원 장기이식팀</h3>
                        현대 아산병원은 몇년부터 세워진 전통의 뭐시기.... 간 파트 뭐시기.. 뭐시기..
                    </div>
                </div>
                <div id="button">
                    <input type="submit" value="협력병원찾기" id="btn-hos">
                </div>
            </div>
        </div>

        <div class="division-lightsand">
            <div id="afterPurchase">
                <h1>구매 후 절차</h1>
                <table align='center'>
                    <tr>
                        <td class="colored">검사</td>
                        <td> &nbsp;>&nbsp;  </td>
                        <td class="colored">
                            검사결과 및 제작
                        </td>
                        <td> &nbsp;>&nbsp; </td>
                        <td class="colored">
                            제작완료
                        </td>
                        <td> &nbsp;>&nbsp; </td>
                        <td class="colored">수술</td>
                    </tr>
                    <tr>
                        <td>
                            <li>
                                건강검진을 통해 이식이 적합한지 확인
                            </li>     
                            <li>
                                이식받는 장기 모양 및 세부사항 체크
                            </li>     

                        </td>
                        <td> </td>
                        <td>
                            <li>
                                조건 부합시 제작시작
                            </li>     
                            <li>
                                수술 일정 확정 
                            </li> 
                        </td>
                        <td> </td>
                        <td>
                            <li>
                                수술당일 병원으로 장기이송  
                            </li>     
                        </td>
                        <td> </td>
                        <td> </td>
                    </tr>
                </table>
                <br>
                <br>
            </div>
        </div>
        <div id="bottom-btn">
            <button id="purchase" ><a href="/reserve/reservation">예약하러가기</a></button>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>