<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/supportintroduce.css">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div class="wrapper">
        <section>
            <div id="support-header">
                <h2>후원</h2>
            </div>
        </section>
        <section>
            <div id="support-top">
                <img src="img/new.jpg" alt="후원 이미지">
            </div>
            <div id="support-top-one">
                <h3>Full Life 후원</h3><br>
                <p>대충 후원 독려하는 메세지</p>
            </div>
            <hr>
        </section>
        <section id="middle-section">
            <div id="support-middle-top">
                <h3>사업 후원</h3>
                <p>"생명 나눔 운동의 아름다운 가치를 널리 알립니다"</p>
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
                            사랑을 기억하고 그 가족을 위로하며,<br> 격력하는 사업을 전개하고, 생존 시 장기기증인들께 자부심을<br> 선물
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
        <hr>
        <section id="bottom-ul">
            <div>
                <h2>마! 니 아직도 후원 안해봣나!</h2>
            </div>
            <div id="bottom-contents">
                <ul>
                    <li><a href="#"><img src="" alt="후원 게시판"></a></li>
                    <li><a href="#"><img src="" alt="신청 게시판"></a></li>
                </ul>
            </div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>