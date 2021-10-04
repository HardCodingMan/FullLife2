<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_support_reply.css">
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
            <div id="notice-div">
                <div id="date-div">
                    <div id="date">${hList.enroll }</div>
                    <div id="view">조회수 : ${hList.views }</div>
                </div>
                    <div id="post">
                        <div id="post-header">
                            <span>${hList.notiTitle }</span>
                        </div>
                        <div id="post-contents">
                            <div id="post-img">
                                <img src="/fileupload/${hList.picPath }" alt="후원사진">
                            </div>
                            <div id="post-text">
                              ${hList.notiCon }
                            </div>
                            <div id="post-footer">
                                    <div id="footer1">
                                        <span>목표 금액 : </span>
                                        <span>${hList.needSup }</span>
                                    </div>
                                    <div id="footer2">
                                        <span>달성률 : </span>
                                        <span>${(hList.nowSup/hList.needSup)*100 }%</span>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="notice-footer">
                    <div id="reply-header">
                        댓글
                    </div>
                    <div id="reply">
                       <table>
                       <c:forEach items="${hList.replies }" var="reply">
                            <tr>
                                <th>${reply.reUserId }</th>
                                <th>${reply.supReCon }</th>
                                <th><button><a href="/manager/m_support_reply_remove?notiNo=${hList.notiNo }&supReNo=${reply.supReNo}">삭제</a></button></th>
                            </tr>
                            </c:forEach>
                       </table>
                    </div>
                </div>
            <div id="back">
                    <button><a href="/manager/m_support_list">목록</a></button>
            </div>
        </div>
    </div>

</body>
</html>