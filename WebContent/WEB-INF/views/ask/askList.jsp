<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판</title>
<link rel="stylesheet" type="text/css" href="/css/askList.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
</head>
<body style="overflow-x: hidden">
<header>
<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
</header>
	
	<main>
        <div id="main-navi">
                <div class="subMenu">
                    <h2>문의</h2>          
                </div>
        </div>
        <div id="main-contents">
        	<div id="main-pic">
        		<img src="/img/ask.png">
        	</div>
        	<br><br>
            
            <div id="table">
            <div id="top">
	           <div class="search">
		           <form action="/ask/search" method="get" class="asksearch">
                       <input type="text" name="searchKeyword" id="searchWord" placeholder="검색할 단어를 입력하세요">&nbsp;&nbsp;
                       <input type="submit" value="검색" class="searchbt1">
		           </form>
	           </div>
                <div class="inquiry">
		            <c:if test="${sessionScope.userId eq null }">
		            <form action="/member/login" method="get">
		                <button class="askbt">문의하기</button>
		            </form>
		            </c:if>
                </div>
        		<div class="inquiry">
		            <c:if test="${sessionScope.userId ne null}">
		         		<button class="askbt"><a href ="/ask/post">문의하기</a></button>
		        	</c:if>
                </div>
            </div>
                <table>
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
                        <td>
                        <c:if test="${ask.disclosure eq 'N'}" >
	                        <c:choose>
				                <c:when test="${sessionScope.userId eq ask.userId }">
				                    <a href="/ask/askContents?askNo=${ask.askNo }"> ${ask.askSubject } </a>
				                </c:when>
			                	<c:otherwise>비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
				            </c:choose>
				        </c:if>
				        <c:if test="${ask.disclosure eq 'Y'}" >
				            <a href="/ask/askContents?askNo=${ask.askNo }"> ${ask.askSubject } </a>
				        </c:if>
                        </td>
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