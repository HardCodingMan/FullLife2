<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
	<div style="margin: 0 auto;">
        <div class="mypage">
            <h2>마이페이지</h2>
        </div>
        <aside id="menucontainer">
            <ul class="menu">
                <li><a href="/mypage/cliUpdate">회원정보 수정</a></li>
                <li><a href="/mypage/history">주문내역</a></li>
                <li><a href="/mypage/point">포인트조회/충전</a></li>
                <li><a href="/mypage/regHospital">병원예약조회</a></li>
                <li><a href="/mypage/checkResult">검사내역</a></li>
            </ul>
        </aside>
        <article id="point1">
            <h3>포인트 충전</h3>
                <div class="mopoint">
                    <div class="mopoint1">
                        <form class="money">1,100P <button type="button" style="float:right" class="bt2">￦ &nbsp;&nbsp;&nbsp; 1,000</button></form>
                    </div>
                    <div class="mopoint1">
                        <form class="money">5,500P <button type="button" style="float:right" class="bt2">￦ &nbsp;&nbsp;&nbsp; 5,000</button></form>
                    </div>
                    <div class="mopoint1">
                        <form class="money">11,000P <button type="button" style="float:right" class="bt2">￦ &nbsp;&nbsp;&nbsp; 10,000</button></form>
                    </div>
                </div><br>
                <div class="mopoint2">
                    <form class="num">
                    <input type="text" placeholder="금액을 입력해주세요" class="po1" id="point"><button type="button" class="bt2" style="float:right" onclick="charge(); ">포인트계산하기</button>
                    </form>
                    <form class="num">
                    <input type="text" placeholder="충전할 포인트" class="po1" id="final-point"><a href="#"><button type="button" class="bt2" style="float:right">충전하기</button></a>
                    </form>
                </div>
                <hr style="width: 400px;margin-left: 300px;margin-top: 20px;">
                <div class="box">
                    ＊포인트 사용 시 적립 포인트 소진 후 충전 포인트가 차감됩니다.<br>
                    ＊미성년자가 법정대리인의 동의 없이 포인트를 사용한 경우, 본인 또는 법정대리인이 사용을 취소할 수 있습니다.<br>
                    ＊1원당 1P(포인트)가 충전됩니다.<br>
                    ＊충전시 1.1배의 포인트가 추가로 적립됩니다.<br>
                    ＊원하는금액을 입력하여 충전할수 있습니다.<br>
                    ＊충전수단에 따라 충전수단 발행자가 부과하는 사용 수수료를 부담할 수 있습니다.<br>
                    &nbsp; &nbsp; &nbsp; - 충전 취소 및 환불 시 사용 수수료의 반환은 충전수단 발행자의 정책을 따릅니다.<br>
                    ＊포인트는 충전시 환불이 불가합니다.<br>
                </div> 
                <br>
                <br><br><br>
        </article>
    </div>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
</footer>

<script>
    // 33은 100에서 몇 퍼센트?
    // var x = 33;
    // var y = 100;
    // result = x / y * 100;

    function charge(){
        let pointTag = document.querySelector("#point");
        let finalPointTag = document.querySelector("#final-point");
        var x = 1;
        var y = pointTag.value;
        finalPointTag.value = parseInt(y) + parseInt(y * 10 / 100);
    }
</script>
</body>
</html>