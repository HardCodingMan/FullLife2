<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_result_list.css">
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
            검사 결과 관리
        </div>
        <div id="line-div"></div>
        <div id="contents">
            <div id="search-div">
                <div id="search">
                    <form action="">
                        주문 번호 검색 :&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="" id="" placeholder="주문 번호를 입력해주세요">
                    </form>
                </div>
           </div>
            <form action="/manager/m_file_upload" method="post">
                   <input type="submit" id="upload-btn" value="업로드">
           </form>
            <div id="table-div">
                    <table border="1" cellspacing="0">
                        <tr>
                            <th>주문 번호</th>
                            <th>회원 아이디</th>
                            <th>파일 이름</th>
                            <th>결과 삭제</th>
                        </tr>
                        <c:forEach items="${fList }" var="data" varStatus="index">
                        <tr>
                            <td>${data.resultNo }</td>
                            <td>${data.userId }</td>
                            <td>${data.fileName }</td>
                            <td>
                                <form action="/manager/m_file_remove" method="post">
                                    <input type="submit" value="삭제">
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                        <tr>
                        	<td colspan="4" align="center">
                        		${pageNavi }
                        	</td>
                        </tr>
                    </table>
            </div>
        </div>
    </div>
</body>
</html>