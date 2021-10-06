<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장기이식</title>
<link rel="stylesheet" type="text/css" href="/css/organ.css">
</head>
<body>
	<header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <navi>
        <ul id="navi">
            <li class="subMenu"><a href="#introVideo">기술소개</a></li>
            <li class="subMenu"><a href="#organDetail">장기에 대한 설명</a></li>
            <li class="subMenu"><a href="#findHos-main1">병원찾기</a></li>
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
                    3차원(3D) 장기 바이오프린팅은 동종이식, 고처리량 약물 스크리닝 및 병리학적 분석에 대한 모든 심각한 병목 문제를 해결할 수 있는 막대한 상업적 이익을 가진 매력적인 과학 분야이다. 
                    여러 이종의 성체 세포 유형 및/또는 줄기세포를 다른 생체 재료(예: 고분자, 생리 활성제 또는 생체 분자)와 통합하여
                    3D 구성을 기능적으로 만드는 것이 생체 인공 기관의 3D 바이오프린팅에 대한 핵심 문제 중 하나이다.
                    천연 및 합성 폴리머는 모두 특정 물리적, 화학적, 생물학적 및 생리학적 특성을 기반으로 하는 3D 인쇄 구성에서 계층적 혈관 및 신경망 형성에 필수적이고
                    보편적인 역할을 한다. ‘바이오 3D 프린팅 기술’을 활용하면 손상된 근육, 치아, 조직과 장기 등을 3D 프린터로 출력해 사람에게 이식할 수 있다. 
                    특히 불의의 사고로 손발이나 팔다리 등이 절단된 환자에게 꼭 맞는 신체 일부를 제공하고, 심장이 고장 난 환자에게는 정교한 인공심장을 줄 수 있다.<br><Br>
                        <hr>
                        <h3 style="color: rgb(159, 182, 123);">프린터 안으로 옮겨 간 인체 내 조직 발생 과정</h3>
                        바이오프린팅이라는 아이디어를 도출한 세 가지 주요 개념이 있습니다. 생체모방(Biomimicry), 소형 조직(Mini tissues), 그리고 자율성 자기조립(Autonomous self-assembly)입니다. <br>
                        
                        <h5 style="color: rgb(206, 147, 99);">생체 모방(Biomimicry)</h5>
                        Biomimicry(생체 모방)은 Bios(생명)와 mimesis(모방)의 합성어로, 생물의 기본 구조와 원리, 메커니즘 등 생물체의 특성을 산업 전반에 적용하는 것을 의미합니다. 3D 바이오프린팅으로의 적용은 조직과 장기의 세포나 
                        세포의 구성물을 동일하게 복제하는 것과 관련이 있습니다. 생체모방 방법이 성공하기 위해서는  아주 작은 규모(microscale)로 생물학적 조직을 복제하는 기술이 필요합니다. <br><br>
                        <h5 style="color: rgb(206, 147, 99);">소형조직(Mini tissues)</h5>
                        인간의 장기는 작은 조직으로 구성되어 있고, 이 작은 조직들이 자기조립을 통해 더 큰 단위인 장기가 되는 것입니다. 작은 조직들이 모여서 우리 몸에서 특정 기능을 하는 장기가 되는 조직 발생의 특성을 3D 바이오프린팅에 적용할 수 있습니다.<br><br>
                        <h5 style="color: rgb(206, 147, 99);">자율성 자기조립(Autonomous self-assembly)</h5>
                        배아기관의 발달을 3D 바이오프린팅의 가이드로 사용할 수도 있습니다. 발달 단계에 있는 조직의 초기 세포를 구성하는 물질은 이상적인 기능과 구조를 가진 조직을 만들기 위해 자율성 자기조립 방식을 택합니다. 
                        여기에서 개별 세포들은 조직의 기능적, 구조적 특성을 결정하는 요소로 작용하는데요. 인체의 조직발생 특성인 자율성 자기조립을 바이오프린팅에 적용하기 위해서는 배아조직과 기관의 형성에 대한 지식뿐만 아니라 출력된 조직에서 배아 메커니즘을 이끌어내는 환경을 조정하는 방법을 알아야 합니다.
                        이처럼 다양한 기능적, 구조적, 기계적 구성물질을 가진 복합 3D 바이오프린팅 기술을 사용하기 위해서는 이 세 가지 개념들에 대한 종합적인 이해가 필요합니다. <br><br>
                        <hr>
                        <br>
                        <div id="bioInk">
                            <img src="/img/bioInk.png" width="1200" height="400">
                        </div>
                        <h3 style="color: rgb(159, 182, 123);">어떻게 출력할 것인가?</h3>
                        인체 조직을 출력하기 위해서는 세포를 한 층씩 쌓아 올려야 합니다. 이 때 세포를 손으로 쌓는 것이 아니라 프린터로 인쇄해 한 겹씩 쌓아 올립니다. 또한 쌓아 올릴 때 형태에 대한 정보도 필요한데요. 생물학적 물질의 적층과 정형화에 사용되는 기술에는 3가지가 있습니다. <br>
                      
                        <h5 style="color: rgb(206, 147, 99);">잉크젯 바이오프린팅</h5>
                        잉크젯 바이오프린팅은 생물학적과 비생물학적 3D 프린팅 모두에 있어 가장 일반적으로 사용되는 방식입니다. 프린트 준비시간이 짧고 출력속도가 높고 비용은 적게 든다는 장점이 있습니다. 2D 잉크프린터에서 카트리지 안의 잉크는 생체물질로, 종이는 3차원 출력을 위한 z축을 조절하기 위해 전자적으로 조정된 ‘승강기’로 대체되었다고 생각하시면 됩니다.<br>
                        <h5 style="color: rgb(206, 147, 99);">미세압출(Microextrusion) 바이오프린팅</h5>
                        일반적으로 사용되는 3D 프린터, 그 중에서도 비생물학적 프린터는 미세압출 방법을 사용합니다. 이 기술에서 ‘잉크’는 액체 방울로 떨어지는 것이 아니라, 구슬 방울로 만들어져 그것을 적층해 물체를 출력합니다. 고밀도로 세포를 적층할 수 있다는 장점이 있는데요. 이는 복잡한 구조를 형성하는 데 필요하다는 점에서 중요합니다. <br><br>
                        <h5 style="color: rgb(206, 147, 99);">레이저보조(Laser-assisted) 바이오프린팅</h5>
                        앞서 소개한 잉크젯 방식이나 미세압출 방식에 비해 일반적으로 사용되는 방식은 아닙니다. 하지만 이 두 방식과 달리 노즐이 없어서 세포나 생체물질이 출력 도중 막히는 문제가 없다는 장점이 있습니다. 이 장점을 바탕으로 조직과 장기를 구성하는 데 점점 더 자주 사용되고 있긴 합니다만, 출력 준비 시간이 오래 걸리고 출력 비용이 높다는 단점이 있습니다. <br><br>
                        <hr>
                        <h3 style="color: rgb(159, 182, 123);">바이오프린팅으로 만들어진 인공장기의 특성</h3>
                        바이오프린트된 인공장기는 환자의 조직을 그대로 가져다 사용하거나 그와 유사한 재료를 사용하기 때문에 환자의 몸에 이식되었을 때 원래 있던 장기처럼 사용할 수 있습니다. 
                        유니버시티 칼리지 런던(University College London)의 재생의학 교수인 알렉산더 사이펠리안은 바이오프린팅을 통해 인공 귀를 출력했는데, 이 인공 귀는 이식받는 사람의 피부 아래에 있는 혈관과 결합해 몸의 일부가 될 수 있습니다. 즉, 출력을 통해 만들어진 귀가 몸과 결합해 귀의 기능을 온전히 할 수 있는 것입니다. 
                        기존의 인공심장이 합성고분자 재료를 사용했기 때문에 심장으로 온전한 기능 하는 것이 아니라 보조역할만 했다는 점을 고려하면 바이오프린팅은 한층 더 인간의 것과 가까운 조직을 생산할 수 있다는 의의가 있습니다. 
                        <hr>
                </span>
            </div>
        </div>
        <br>
        <!-- <div class="btn-div">
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
        </div> -->
        <div class="division-lightsand">
            <div id="organDetail">
                <div class="main">
                    <input type="radio" name="show" id="tab-1" checked>
                    <input type="radio" name="show" id="tab-2">
                    <input type="radio" name="show" id="tab-3">
                    <input type="radio" name="show" id="tab-4">
                    <input type="radio" name="show" id="tab-5">
                    <div class="tab">
                        <label for="tab-1"><img src="/img/liver.png" class="menuPic"></label>
                        <label for="tab-2"><img src="/img/heart.png" class="menuPic"></label>
                        <label for="tab-3"><img src="/img/tooth.png" class="menuPic"></label>
                        <label for="tab-4"><img src="/img/bone.png" class="menuPic"></label>
                        <label for="tab-5"><img src="/img/lung.png" class="menuPic"></label>
                        <br><br><br>
                    </div>
                    <br><br>
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
                        <img src="/img/surgery.jpg" width="800" >
                    </div>
                    <div id="hosDesc">
                        <h3>FullLife와 협력하는 병원들</h3>
                        FullLife는 협력병원과의 협력을 통하여 진료의뢰, 각종검사의뢰, 수술의뢰가 원활하게 이루어지도록 하기 위한 의료예약이 가능합니다. 효율적인 Referral System을 통하여 의료기관간 상호신뢰구축 및 긴밀한 협조체제로 지역의료기관과의 균형적인 의료발전을 도모하고 의료전달 체계의 중심적 역할을 수항하여 장기이식수술의 성공율,바이오프린팅기술 증진에 기여하고 있습니다.
협력병원 예약 관리로 병.의원의 진료의뢰에 대해 신속하고 전문적인 치료를 받을 수 있도록 상담 및 진료 예약 관련 업무를 수행하고 있습니다.
또한 장기이식분야 국내 의료계 선두 그룹에 있는 병원들과 협력체계를 형성함으로써, 장기이식수술의 성공률과 수술 후 관리체계를 국내 선두그룹 의료계와 어깨를 나란히 하고 있습니다.
                    </div><br><br>
                    <div id="hosPic2">
                        <img src="/img/HospitalsLogo.png">
                    </div>
                </div>
                <div id="button">
                    <input type="submit" value="협력병원찾기" id="btn-hos">
                </div>
            </div>
        </div>

        <div class="division-light" >
            <div id="afterPurchase"style="height:400px; ">
                <br>
                <h1>구매 후 절차</h1>
                <br>
                <br>
                <table align='center'>
                    <tr>
                        <td class="colored">검사</td>
                        <td> &nbsp;&nbsp;>&nbsp;&nbsp;  </td>
                        <td class="colored">
                            검사결과 및 제작
                        </td>
                        <td> &nbsp;&nbsp;>&nbsp;&nbsp; </td>
                        <td class="colored">
                            제작완료
                        </td>
                        <td> &nbsp;&nbsp;>&nbsp;&nbsp; </td>
                        <td class="colored">수술</td>
                    </tr>
                    <tr class="purText">
                        <td>
                            <li>
                                검진을 통해 이식 적합 확인
                            </li>     
                            <li>
                                장기 제작에 필요한 측정 및 검사 시행
                            </li>     
                        </td>
                        <td> </td>
                        <td class="purText">
                            <li>
                                조건 부합시 제작시작
                            </li>     
                            <li>
                                수술 일정 확정 
                            </li> 
                        </td>
                        <td> </td>
                        <td class="purText">
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
        <br><br><br><br>
        <c:if test="${sessionScope.userId eq null}">
         <form action="/member/login" method="get">
        <div id="bottom-btn">
             <button id="purchase" ><a href="/reserve/reservation">예약하러가기</a></button>
        </div>
        </c:if>
        </form>
        
        <c:if test="${sessionScope.userId ne null }">
        <form action="/reserve/reservation" method="post">
        <div id="bottom-btn">
             <button id="purchase" ><a href="/reserve/reservation">예약하러가기</a></button>
        </div>
        </c:if>
        </form>
                    
        <br><br><br><br>
    </main>

    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>