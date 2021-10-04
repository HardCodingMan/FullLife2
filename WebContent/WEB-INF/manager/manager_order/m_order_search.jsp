<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_order_list.css">
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
                <li class="main-li" id="choice"><a href="/manager/m_order_list">&nbsp;주문 관리</a></li>
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
            주문 관리
        </div>
        <div id="line-div"></div>
        <div id="contents">
        	
            <div id="table-div">
            		<div class="search-div">
                        <form action="/manager/m_order_search" method="get">
                        <input type="text" id="search" name="searchNo" placeholder="주문번호를 검색하세요">&nbsp;&nbsp;&nbsp;
                        <input type="submit" id="search-btn" value="검색">
                        </form>    
                    </div>
                    <table border="1" cellspacing="0">
                        <tr>
                            <th>주문 번호</th>
                            <th>장기 번호</th>
                            <th>회원 아이디</th>
                            <th>주문 날짜</th>
                            <th>결제 금액</th>
                            <th>결제 날짜</th>
                            <th>사용 포인트</th>
                            <th>주문 취소</th>
                        </tr>
                        <c:forEach items="${requestScope.oList }" var="order" varStatus="index">
                        <tr>
                            <td>${order.historyNo }</td>
                            <td>${order.organNo }</td>
                            <td>${order.userId }</td>
                            <td>${order.historyDate }</td>
                            <td>${order.payment }</td>
                            <td>${order.payDate }</td>
                            <td>${order.usedPoint }</td>
                            <td>
                            	<button type="submit" class="delete"><a href="/manager/m_order_remove?historyNo=${order.historyNo }">주문취소</a></button>
                            </td>
                        </tr>
						</c:forEach>
                        <tr>
                        	<td colspan="8" align="center">
	                        	${pageNavi }
                        	</td>
                        </tr>
                    </table>
            </div>
        </div>
    </div>
</body>
</html>