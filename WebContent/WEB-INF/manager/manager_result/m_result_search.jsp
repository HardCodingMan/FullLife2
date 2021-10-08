<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_result_list.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
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
            검사 결과 관리
        </div>
        <div id="line-div"></div>
       <div id="contents">
            <div id="table-div">
            <div class="search-div">
                    <form action="/manager/m_result_search" method="get">
                      <input type="text" name="searchKeyword" id="search" placeholder="🔎검사 번호를 입력해주세요">&nbsp;&nbsp;&nbsp;
                        <input type="submit" id="search-btn" value="검색">
                    </form>
            </div>
                    <table>
                        <tr>
                            <th>검사 번호</th>
                            <th>회원 아이디</th>
                            <th>환자 이름</th>
                            <th>파일 이름</th>
                            <th>병원 입력</th>
                            <th>결과 업로드</th>
                            <th>결과 삭제</th>
                        </tr>
                    <c:forEach items="${requestScope.pList }" var="pList" varStatus="index">
                        <tr>
                            <td>${pList.resultNo }</td>
                            <td>${pList.userId }</td>
                            <td>${pList.pName }</td>
                            <td>${pList.fileName }</td>
                       <form action="/manager/m_file_upload" method="post" enctype="multipart/form-data">
                             <td>
                            	<input type="text" name="hos-no" placeholder="병원 번호 입력" style="width: 60px; text-align: center;">
                            </td>
                            <td>
                            	<input type="hidden" name="user-id" value="${pList.userId }">
                            	<label class="file-btn" for="upload-file">파일 선택</label>&nbsp;&nbsp;
                            	<input type="file" id="upload-file" name="upFile" style="display: none;">
                            	<input type="submit" value="업로드">
                            </td>
                       </form>
                       <form action = "/manager/m_file_remove" method="post">
                            <td>
                            	<input type="hidden" name="file-path" value="${pList.filePath }">
                            	<input type="hidden" name="file-name" value="${pList.fileName }">
                            	<input type="hidden" name="file-user" value="${pList.userId }">
                                <input type="submit" value="삭제">
                            </td>
                       </form>
                        </tr>
                        </c:forEach>
                        <tr>
                        	<td colspan="6">
                        		${pageNavi }
                        	</td>
                        </tr>
                    </table>
            </div>
        </div>
    </div>
</body>
</html>