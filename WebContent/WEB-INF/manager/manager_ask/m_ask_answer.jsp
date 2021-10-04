<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_ask_answer.css">
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
                <li class="main-li"><a href="/manager/m_member_list">&nbsp;회원 정보 관리</a></li>
                <li class="main-li"><a href="/manager/m_order_list">&nbsp;주문 관리</a></li>
                <li class="serv-li" id="choice">
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
            문의 게시판 관리
        </div>
        <div id="line-div"></div>
        <div id="main-contents">
            <form action="/manager/m_ask_answer" method="post">

                <div id="contents">
                    <br>
                    <span class="contents-title">
                        <label for="subject"><strong>제목</strong></label>
                    </span>
                    <span class="contents_con">
                        <input type="text" id="subject" name="ask-sub" placeholder="제목을 입력해주세요" value="${ask.askSub }">
                    </span>
                    <br>
                    <span class="contents-title" >
                        <label for="textarea">
                            <strong>문의내용</strong>
                        </label>
                    </span>
                    <span class="contents_con">
                        <textarea id="textarea" name="ask-con" cols="100" rows="30" placeholder="내용을 입력해주세요">${ask.askCon}</textarea>
                    </span>
                    <br>
                     <span class="contents-title" >
                        <label for="textarea">
                            <strong>답변내용</strong>
                        </label>
                    </span>
                    <span class="contents_con">
                        <textarea  id="textarea" name="answer-con" cols="100" rows="30" placeholder="내용을 입력해주세요">${ask.answerCon}</textarea>
                    </span>
                    <br><br>
                    <input type="hidden" name="ask-no" value="${ask.askNo }">
                	<input type="hidden" name="reply" value="${ask.reply }">
                	<input type="hidden" name="answer-date" value="${ask.answerDate }">
                    <button type="submit" id="btnJoin">답변완료</button>
                    
                </div>
            </form>
        </div>
    </div>

    </div>
</body>
</html>