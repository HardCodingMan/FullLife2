<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판</title>
<link rel="stylesheet" type="text/css" href="/css/askList.css">
</head>
<body>
<header>
<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
</header>
	<main>
        <div id="main-navi">
            <span>
                <ul class="subMenu">
                    <li>문의</li>
                    <li><a href="#">FAQ</a></li>
                </ul>
            </span>
        </div>
        <div id="main-contents">
            <div id="contents-header"><u><strong>문의</strong></u></div>
            <hr>
            <div id="top">
            <div class="search">
            <form action="/ask/search" method="get">
                        <input type="text" name="searchKeyword" id="searchWord" placeholder="검색할 단어를 입력하세요">&nbsp;&nbsp;
                        <input type="submit" value="검색">
            </form>
            </div>
                <span class="inquiry">
                <button><a href="/ask/post">문의하기</a></button>
                </span>
            </div>
            <div >
                <table border="1px">
                    <tr>
                        <th class="inquiryNo">글 번호</th>
                        <th class="title">제목</th>
                        <th class="writer">작성자</th>
                        <th class="enrollDate">작성일</th>
                        <th class="status">답변여부</th>
                        <th class="disclosure">공개여부</th>
                        
                    </tr>
                    <c:forEach items="${requestScope.aList }" var="ask" varStatus="index">
                    <tr>
                    
                        <td>${ask.askNo}</td>
                        <td><a href="/ask/askContents?askNo=${ask.askNo }"> ${ask.askSubject } </a></td>
                        
                        <td>${ask.userId }</td>
                        <td>${ask.askDate }</td>
                        <td>${ask.reply }</td>
                        <td>${ask.disclosure }</td>
                    </tr>
                    </c:forEach>
                    <tr>
			<td colspan="6" align="center">
				${pageNavi  }
			</td>
		</tr>

                </table>
            </div>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>