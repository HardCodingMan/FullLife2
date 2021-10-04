<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/css/reservation_check.css">
</head>
<body>
 <header>
    <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
 </header>
   <section>
        <div id="title-div">구매 예정 정보</div>
        <article>
            <div id="top-div">
                <div id="viscera-check">
                    <div id="viscera-title">
                        <h4>장기 선택 확인</h4> 
                    </div>
                    <div id="viscera">
                        <input type="text" name="" id="" value="심장">&nbsp;&nbsp;
                        <input type="text" name="" id="" value="1">
                    </div>
                </div>
                <div id="buyer-check">
                    <div id="buyer-title">
                       <h4>환자 정보</h4> 
                    </div>
                    <div id="buyer">
                        <label for="">이름</label><input type="text" name="" id="" value="임정현"><br>
                        <label for="">주민번호</label><input type="text" name="" id="" value="123456-7894567"><br>
                        <label for="">연락처</label><input type="text" name="" id="" value="010-1234-7894">
                    </div>
                </div>
                <div id="hospital-check">
                    <div id="hospital-title">
                        <h4>병원</h4>
                    </div>
                    <div id="hospital">
                        <label for="">병원이름</label><input type="text" name="" id="" value="서울대병원"><br>
                        <label for="">예약날짜</label><input type="text" name="" id="" value="2021.12.15"><br>
                        <label for="">예약시간</label><input type="text" name="" id="" value="15:00">
                    </div>
                </div>
                <div id="modify-btn">
                    <button type="submit">수정하기</button>
                </div>
            </div>
            <div id="bottom-div">
                <div id="payment-check">
                    <div id="payment-title">
                        <h4>결제 내역</h4>
                    </div>
                    <div id="payment">
                        <label for="">구매장기</label><input type="text" name="" id="" value="심장"><br>
                        <label for="">계약금</label><input type="text" name="" id="" value="1,000,000">
                    </div>
                </div>
                <div id="pay-check">
                    <label for="">총 금액</label><input type="text" name="" id="" value="1,000,000">
                </div>
                <div id="rule-div">
                    <div id="rule-title">
                        <h4>규정</h4>
                    </div>
                    <div id="rule-img">
                        <img src="/img/rule.jpg" alt="">
                    </div>
                    <div id="rule-check">
                        <input type="checkbox" name="" id="">&nbsp;규정에 동의합니다
                    </div>
                </div>
                <div id="pay-btn">
                    <button type="submit">결제하기</button>
                </div>
            </div>
        </article>
    </section>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>