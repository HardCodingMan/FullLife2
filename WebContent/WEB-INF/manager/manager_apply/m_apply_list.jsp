<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_apply_list.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
       <header>
       <jsp:include page="/HeaderNFooterJSP/m_header.jsp"></jsp:include>
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
                신청 게시판 관리
            </div>
            <div id="line-div"></div>
            <div id="contents">
                <div id="list-div">
                <div class="search-div">
                    <form action="/manager/m_apply_search" method="get">
                    <input type="text" id="search" name="searchKeyword" placeholder="🔎제목을 검색하세요">&nbsp;&nbsp;&nbsp;
                    <input type="submit" id="search-btn" value="검색">
                    </form>    
                </div>
                    <c:forEach items="${requestScope.apList }" var="apply" varStatus="index">
                    <div class="list">
                        <div class="list-img">
                            <img src="/fileupload/${apply.picName }" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_apply_detail?noticeNo=${apply.notiNo }">${apply.notiTitle }</a> 
                        </div>
                        <div id="list-text2">
                            <div>조회수 : ${apply.views } <br>추천수 : ${apply.notiLike }</div>
                           <c:if test="${apply.simsa eq '신청' }">
                            	<div id="apply-text">${apply.simsa }</div>
                            </c:if>
                            <c:if test="${apply.simsa eq '심사중' }">
                            	<div id="apply-text2">${apply.simsa }</div>
                            </c:if>
                        </div>
                        <div class="list-btn">
                        		<button type="submit" id="apply-btn"><a href="/manager/m_apply_simsa?notiNo=${apply.notiNo }">심사 시작</a></button>&nbsp;
                                <button type="submit"><a href="/manager/m_apply_update?notiNo=${apply.notiNo }">심사 완료</a></button>&nbsp;
                                <button type="submit" class="bt1"><a href="/manager/m_apply_remove?notiNo=${apply.notiNo }&userId=${apply.userId}">삭제</a></button>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                    <div id="page-div">
                    	${pageNavi }
                    </div>
            
            </div>
        </div>
</body>
</html>