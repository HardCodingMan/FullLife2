<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장기이식</title>
<link rel="stylesheet" type="text/css" href="/css/organ.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
</head>
<body>
	<header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
 <div id="main-navi">
        <ul id="navi">
            <li class="subMenu"><a href="#introVideo">기술소개</a></li>
            <li class="subMenu"><a href="#organDetail">장기에 대한 설명</a></li>
            <li class="subMenu"><a href="#findHos-main1">병원찾기</a></li>
            <li class="subMenu"><a href="#afterPurchase">구매 후 절차</a></li>
        </ul>
        <div id="buy">
	        <c:if test="${sessionScope.userId eq null}">
	         <form action="/member/login" method="get">
	             <button type="submit" class="buy-btn">예약하러가기</button>
	        </form>
	        </c:if>
	        <c:if test="${sessionScope.userId ne null }">
                <button type="submit" class="buy-btn"><a href="/reserve/reservation?userId=${sessionScope.userId }">예약하러가기</a></button>
	        </c:if>

        </div>
    </div>
    <main>
        <div class="division">
            <div id="bioprinting">
                <div id="introVideo">
                    <h1>기술소개</h1>
                    <iframe width="600" height="400" src="https://www.youtube.com/embed/rgxDixvWbLE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <div id="bioprint-description">
                    <h2>바이오 프린팅 기술</h2>
                    <span>3차원(3D) 장기 바이오프린팅은 동종이식, 고처리량 약물 스크리닝 및 병리학적 분석에 대한 모든 심각한 병목 문제를 해결할 수 있는 막대한 상업적 이익을 가진 매력적인 과학 분야이다.
                    여러 이종의 성체 세포 유형 및/또는 줄기세포를 다른 생체 재료(예: 고분자, 생리 활성제 또는 생체 분자)와 통합하여
                    3D 구성을 기능적으로 만드는 것이 생체 인공 기관의 3D 바이오프린팅에 대한 핵심 문제 중 하나이다.
                    천연 및 합성 폴리머는 모두 특정 물리적, 화학적, 생물학적 및 생리학적 특성을 기반으로 하는 3D 인쇄 구성에서 계층적 혈관 및 신경망 형성에 필수적이고
                    보편적인 역할을 한다. ‘바이오 3D 프린팅 기술’을 활용하면 손상된 근육, 치아, 조직과 장기 등을 3D 프린터로 출력해 사람에게 이식할 수 있다.
                    특히 불의의 사고로 손발이나 팔다리 등이 절단된 환자에게 꼭 맞는 신체 일부를 제공하고, 심장이 고장 난 환자에게는 정교한 인공심장을 줄 수 있다.<br><Br>
                    </span>
                        <hr>
                        <br><br>
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
                        <br><br>
                        <hr>
                        <br><br><br>
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
                        <br><br><hr><br><br>
                        <h3 style="color: rgb(159, 182, 123);">바이오프린팅으로 만들어진 인공장기의 특성</h3><br>
                        바이오프린트된 인공장기는 환자의 조직을 그대로 가져다 사용하거나 그와 유사한 재료를 사용하기 때문에 환자의 몸에 이식되었을 때 원래 있던 장기처럼 사용할 수 있습니다. 
                        유니버시티 칼리지 런던(University College London)의 재생의학 교수인 알렉산더 사이펠리안은 바이오프린팅을 통해 인공 귀를 출력했는데, 이 인공 귀는 이식받는 사람의 피부 아래에 있는 혈관과 결합해 몸의 일부가 될 수 있습니다. 즉, 출력을 통해 만들어진 귀가 몸과 결합해 귀의 기능을 온전히 할 수 있는 것입니다. 
                        기존의 인공심장이 합성고분자 재료를 사용했기 때문에 심장으로 온전한 기능 하는 것이 아니라 보조역할만 했다는 점을 고려하면 바이오프린팅은 한층 더 인간의 것과 가까운 조직을 생산할 수 있다는 의의가 있습니다. 
                        <br><br><br><hr><br><br>
                    </div>
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
                                    <h3>간 </h3>
                                    <h4>10,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <a href="#bottom"><input type="button" value="예약하러가기" class="detailbt"></a>
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <br><br><br>
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
                            <h3>심장 </h3>
                            <h4>20,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <a href="#bottom"><input type="button" value="예약하러가기" class="detailbt"></a>
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <br><br><br>
                        <h3>심장에 대한 설명</h3>
                        심장 내부는 2개의 심방과 2개의 심실로 이루어져 있다. 그리고 이 심장이 주기적으로 수축하여 혈액을 동맥 속으로 밀어내고, 이완하여 정맥에서 오는 혈액을 내강에 채우는 과정에서 판막의 개폐가 차례로 일어나 혈액의 역류를 막음으로써 펌프 작용이 원활하게 반복되고 이에 의하여 혈액이 온몸을 순환하는 일련의 과정을 박동이라고 한다.
                        위치는 보통 왼쪽에 위치했다고 여겨지나 정확히 말한다면 가슴 한가운데의 줄기에서 뻗어나와 가슴 왼쪽으로 틀어진 모양새이다. 즉, 굳이 방향을 따지자면 왼쪽이나 의학 드라마가 아닌 일반 드라마나 영화에서 심장을 부여잡고 쓰러지는 위치나 심장을 저격할때 보여지는 위치는 대부분 심장이 아니라 왼쪽 폐이다. 거의 중심에 맞아야 맞다. 그리고 생각보다 위쪽으로 양 젖꼭지를 이은 선보다 위쪽에 위치한다.
                        이유는 당연히 중력을 거슬러 뇌로 혈류를 보내는 것이 가장 중요하기 때문. 때문에 당뇨 등에 걸리면 신체 말단에는 혈류가 부족하여 썩어들어가기 시작한다.
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="tooth-pic">
                        <div id="money">
                            <h3>치아</h3>
                            <h4>2,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <a href="#bottom"><input type="button" value="예약하러가기" class="detailbt"></a>
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <br><br><br>
                        <h3>치아에 대한 설명</h3>
                        입안의 위턱과 아래턱에 박혀있는 단단한 기관으로 음식물 섭취 시 음식물을 잘게 부수고 저작을 원활하게 하여 소화흡수를 촉진시키는 기관입니다. 보통 사람의 치아는 성장하면서 한번 교체하게 되며 이에 따라 유치와 영구치로 나눌 수 있습니다. 사람의 영구치는 32개입니다.

뼈와 치아의 구성 요소는 칼슘, 인 등의 무기질로 상당히 유사하다. 또한 뼈는 사람의 생명 유지를 위해 필수불가결한 것이지만, 현대에서 이는 빠져도 생명에 뼈만큼 큰 지장은 없다. 원시시대의 인류는 치아에 문제가 있을 시 매우 큰 고통을 겪었지만, 현대에는 치아가 전부 사라진다고해도 FullLife회사가 만든 인공 치아가 대체제가 존재하기 때문이다. 치아가 없으면 음식물 섭취와 발음에 문제가 오고, 따라서 정상적인 사회 생활을 위해 틀니나 임플란트로 이를 보충한다.

인간의 신체 중 경도가 가장 높은 부위로, 치아의 구조 중에서도 경도가 가장 높은 법랑질은 모스 굳기 5에 해당하는 경도를 자랑한다. 그러나 경도가 높다고 해서 단단하다는 뜻은 아니다. 치아의 법랑질은 절대 단단한 부위가 아니다. 조개 껍질 등 딱딱한 음식을 씹다가 잘못하면 치아에 금이 쫙 가서 뿌리채 뽑아야 하는 불상사가 발생할 수 있다. 따라서, 이는 엄청 조심하게 관리해야 하고, 특히 오래 씹어 노후화된 치아일수록(나이가 많을수록) 더 조심하게 사용해야 한다. 하루 최소 2번씩 양치질 해줘야 되는건 덤. 반면, 뼈는 나이가 들어 노후화 되는 경우를 제외하면 따로 관리해 줄 필요가 없다.

 또 하나. 이는 한 번 망가지면 그걸로 끝이다. 뼈와 달리 콜라겐이 없어서 다시 재생이 되지 않는다. 그냥 그걸로 끝이다. 하지만 FullLife에서는 바이오 프린팅으로 새 치아를 만들어 반영구 사용 가능하다.
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="bone-pic">
                        <div id="money">
                            <h3>뼈</h3>
                            <h4>2,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <a href="#bottom"><input type="button" value="예약하러가기" class="detailbt"></a>
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <br><br><br>
                        <h3>뼈에 대한 설명</h3>
                        뼈(骨, bone)는 척삭동물문에 속하는 동물들의 동체를 지탱하는 단단한 연결 조직이자 기관이다.
                        뼈는 뼈대를 구축해 몸의 구조물을 지지하고 여타 신체 기관들의 부상을 막으며 백혈구·적혈구를 생산한다.
                         또한 무기염류를 저장하고 근육과 함께 동물이 스스로 움직일 수 있도록 한다. 해당된 신체 부위에 따라 다양한 크기를 가지고 있으며 내·외적으로 복잡한 구조를 갖고 있다. 가볍고 튼튼한 동시에 활발한 생명 활동을 한다. 
                        척삭동물문 이외의 갈래에 속한 무척추동물 가운데에서는 뼈 대신 껍질이나 껍데기, 키틴질을 사용하는 것들도 있다.
                        
                    </div>
                  </div>
                  <div class="content-dis">
                    <div id="lung-pic">
                        <div id="money">
                            <h3>폐 </h3>
                            <h4>30,000,000원부터</h4>
                        </div>
                        <div id="detail-purchase">
                            <a href="#bottom"><input type="button" value="예약하러가기" class="detailbt"></a>
                        </div>
                    </div>
                    <div id="detail-explantion">
                        <br><br><br>
                        <h3>폐에 대한 설명</h3>
                        허파라고도 하며 양서류 이상의 척추동물에게 있는 호흡기 기관이다.
            [1] 공기 중의 산소를 얻어 혈액에 공급해주고, 혈액이 운반한 이산화탄소를 몸 밖으로 내보내는 기능을 한다.
                        이를 가스 교환이라고 부르며 허파꽈리(폐포)에서 이루어진다. 물론 호흡 이외의 다른 기능도 있다.
			심장과 가장 가까운 곳에 위치한 장기로 늑골의 보호를 받는다. 근육이 없어서 늑골과 횡격막에 의해 움직인다. 생물은 횡격막을 수축시켜 흉강의 빈 공간을 늘리는 방법으로 바깥 공기가 들어오게 하며, 이완시켜서 흉강을 좁게 하는 방법으로 체내에 있던 가스를 내쉰다. 일단 공기가 들어오면 수분을 머금은 폐포에 산소가 녹고, 이것이 순환계를 통해 전신의 혈관에 전달된다. 폐에는 약 3억 개에 달하는 폐포가 있는데, 각 폐포의 지름은 100~200㎛ 정도이다. 폐포의 총 표면적은 100㎡로 체표 면적(2㎡)의 약 50배나 돼 이 폐포들을 펴놓으면 테니스 코트의 절반을 덮을 수 있는 넓이가 된다.

인간의 폐는 오른쪽이 왼쪽보다 조금 더 크며, 크기가 큰만큼 무게 역시 오른쪽이 더 나간다. 오른쪽 폐는 3엽으로 갈라져 있는 반면 왼쪽은 2엽이다.
 진화생물학에서는 이것이 왼쪽에 있는 심장의 존재로 인한 체내 용적 문제에서 비롯한 것이라 추정하고 있다.
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
                    <br><br><br>
                        <h3>FullLife와 협력하는 병원들</h3>
                        FullLife는 협력병원과의 협력을 통하여 진료의뢰, 각종검사의뢰, 수술의뢰가 원활하게 이루어지도록 하기 위한 의료예약이 가능합니다. 효율적인 Referral System을 통하여 의료기관간 상호신뢰구축 및 긴밀한 협조체제로 지역의료기관과의 균형적인 의료발전을 도모하고 의료전달 체계의 중심적 역할을 수항하여 장기이식수술의 성공율,바이오프린팅기술 증진에 기여하고 있습니다.
협력병원 예약 관리로 병.의원의 진료의뢰에 대해 신속하고 전문적인 치료를 받을 수 있도록 상담 및 진료 예약 관련 업무를 수행하고 있습니다.
또한 장기이식분야 국내 의료계 선두 그룹에 있는 병원들과 협력체계를 형성함으로써, 장기이식수술의 성공률과 수술 후 관리체계를 국내 선두그룹 의료계와 어깨를 나란히 하고 있습니다.
                    </div><br><br><br><br>
                    <div id="hosPic2">
                        <img src="/img/HospitalsLogo.png">
                    </div>
                    <br><br><br><br>
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
        <div class="bottom-btn">
        <c:if test="${sessionScope.userId eq null}">
         <form action="/member/login" method="get">
             <button id="purchase" class="bts">예약하러가기</button>
        </form>
        </c:if>
        </div>
        
        <div class="bottom-btn" id="bottom">
        <c:if test="${sessionScope.userId ne null }">
             <button id="purchase1" class="bts"><a href="/reserve/reservation?userId=${sessionScope.userId }">예약하러가기</a></button>

        </c:if>
        </div>
                    
        <br><br><br><br>
    </main>

    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>