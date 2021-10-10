<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/supportintroduce.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
     <main>
        <div class="wrapper">
            <div id="support-header">
                후원
            </div>
        <section>
            <div id="support-top">
                <img src="/img/intro.png" alt="후원 이미지">
            </div>
            <div id="support-top-one">
                <h3>Full Life 후원</h3><br>
                <p>Full Life는 장기기증 활성화를 위한 홍보 및 교육, 장기등 이식 대상자의 선정 및 승인, 장기등 이식에 관한 의학적 표준 마련, 장기이식정보망 운영, 통계자료 발간, 장기등 기증 및 이식에 대한 상담을 하고 있습니다. 또한 장기매매 등 비윤리적 행위가 근절될 수 있도록 모니터링하고, 장기등 기증자가 사회적으로 부당한 대우를 받지 않도록 ‘장기기증자 차별 불이익 신고센터’를 운영하는 등 올바른 장기기증 문화의 확산과 안정적 혈액 공급을 위한 수혈 관리를 위해 노력하고 있습니다.</p>
            </div>
        </section>
        <section id="middle-section">
            <div id="support-middle-top">
                <p>"생명 나눔 운동의 아름다운 가치를 널리 알립니다"</p>
            </div>
            <div id="middle-img">
                <img src="/img/heartbar.jpg" alt="">
            </div>
            <div id="middle-bottom">
                <ul id="middle-ul">
                    <li>
                        <h3 class="li-text">장기기증운동의 참여를 돕는<br> 장기기증 홍보사업</h3>
                        <p class="li-text">장기기증에 대한 오해와 편견을 해소하고<br> 장기기증의 아름다운 가치를 널리 알리기 위해<br>
                            다양한 홍보 캠페인을 전개하며<br> 장기기증 관련 정책을 제안합니다
                        </p>
                    </li>
                    <li>
                        <h3 class="li-text">기증자와 그 가족을 위한<br> 장기기증인 예우사업</h3>
                        <p class="li-text">뇌사 장기 기증인들의
                            사랑을 기억하고<br> 그 가족을 위로하며, 격력하는 사업을 전개하고, 생존 시 장기기증인들께 자부심을<br> 선물
                            하기 위한 다양한 예우 사업을 전개합니다.
                        </p>
                    </li>
                    <li>
                        <h3 class="li-text">초중고 학생 생명존중 교육사업<br><br></h3>
                        <p class="li-text">초중고 학생들을 대상으로<br> 생명의 소중함을 전하며 생명나눔 문화 확산에<br> 기여하고 있습니다.</p>
                    </li>
                </ul>
            </div>
        </section>
        <section id="bottom-ul">
            <div id="bottom-title">
               나눔 이야기
            </div>
            <div id="bottom-contents">
                <ul>
                    <li><a href="/Notice/Support/SupportNotice"><img src="/img/donation2.png" alt="후원 게시판"></a></li>
                    <li><a href="/Notice/Apply/ApplyNotice"><img src="/img/apply.png" alt="신청 게시판"></a></li>
                </ul>
            </div>
            <div id="img-div">
            	<img alt="사업" src="/img/process.png">
            </div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>