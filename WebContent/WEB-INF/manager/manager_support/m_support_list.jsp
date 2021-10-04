<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_support_list.css">
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
            후원 게시판 관리
        </div>
        <div id="line-div"></div>
        <div id="contents">
                <div id="list-div">
                <div class="search-div">
                    <form>
                    <input type="text" id="search" placeholder="제목을 검색하세요">&nbsp;&nbsp;&nbsp;
                    <input type="submit" id="search-btn" value="검색">
                    </form>    
                </div>
                <c:forEach items="${requestScope.sList }" var="sup" varStatus="index">
                    <div class="list">
                        <div class="list-img">
                            <img src="/fileupload/${sup.picPath }" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_detail?noticeNo=${sup.notiNo }">${sup.notiTitle }</a> 
                        </div>
                        <div class="list-percent">                      
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing" style="width: ${(sup.nowSup/sup.needSup)*100 }%;">${(sup.nowSup/sup.needSup)*100 }%</div>
                            </div>
                        </div>
                          <div class="list-btn">
                                <button type="submit" class="bt1"><a href="/manager/m_supprot_remove?notiNo=${sup.notiNo }">삭제</a></button>
                        </div>
                        </div>
                        </c:forEach>
                    </div>
            	<div id = "page-div">
            		${pageNavi }
            	</div>
            </div>
        </div>
</body>
</html>