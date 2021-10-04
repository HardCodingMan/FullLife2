<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_member_modify.css">
</head>
<body>
    <header>
        <div id="logo">
            <a href="#"><img src="/img/fulllife로고3 (1).png" alt=""></a>
        </div>
        <div id="logout">
            <button>로그아웃</button>
        </div>
    </header>
    <aside id="left-aside">
        <div id="main-ul">
            <ul>
                <li class="main-li" id="choice"><a href="/manager/m_member_list">&nbsp;회원 정보 관리</a></li>
                <li class="main-li"><a href="/manager/m_order_list">&nbsp;주문 관리</a></li>
                <li class="serv-li">
                    <a href="/manager/m_support_list">&nbsp;게시판 관리</a>
                    <div class="board-class">
                        <ul>
                            <li><a href="/manager/m_support_list">후원 게시판</a></li>
                            <li><a href="/manager/m_apply_list">신청 게시판</a></li>
                            <li><a href="/manager/m_ask_list">문의 게시판</a></li>
                            <li><a href="/manager/m_result_list">검사 결과 관리</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </aside>
    <div id="main-div">
        <div id="title">
            회원 정보 관리
        </div>
        <div id="line-div"></div>
        <form action="/manager/m_member_modify" method="post">
        <div id="contents">

                <div id="input-div">
                    <label for="">아이디</label><br>
                    <input type="text" name="member-id" style="width: 305px; height: 25px;" readonly value="${member.userId }"><br><br>
                    <label for="">비밀번호</label><br>
                    <input type="text" name="member-pwd" style="width: 305px; height: 25px;" value="${member.userPwd }"><br><br>
                    <label for="">이름</label><br>
                    <input type="text" name="member-name" style="width: 305px; height: 25px;" readonly value="${member.userName }"><br><br>
                    <label for="">주민번호</label><br>
                    <input type="text" name="member-zumin" style="width: 305px; height: 25px;" readonly value="${member.zumin }"><br><br>
                    <label for="">주소</label><br>
                    <input type="text" name="member-addr" style="width: 305px; height: 25px;" value="${member.addr }"><br><br>
                    <label for="">전화번호</label><br>
                    <input type="text" name="member-phone" style="width: 305px; height: 25px;" value="${member.phone }"><br><br>
                    <label for="">포인트</label><br>
                    <input type="text" name="member-totalPoint" style="width: 305px; height: 25px;" value="${member.totalPoint }"><br><br>
                    <label for="">이메일</label><br>
                    <input type="text" name="member-email" style="width: 305px; height: 25px;" value="${member.email }"><br><br>
                </div>
            </div>
            <div id="btn-div">
                <input type="submit" id="modify-btn" value="수정완료" style="width: 150px; height: 40px;">           
            </div>
            </form>
    </div>
</body>
</html>