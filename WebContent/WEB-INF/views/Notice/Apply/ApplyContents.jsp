<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/applycontents.css">
</head>
<body>
	 <header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
        <main>
            <div class="wrapper">
            <section>
                <div id="supportnotice-header">
                    <h2>신청 게시글</h2>
                </div>
            </section>
            <section id="notice-section">
                <div id="notice-date">
                    <div><p id="notice-enroll">${aOne.enrollDate }</p></div>
                    <div><p id="notice-views">조회수 ${aOne.views }</p></div>
                </div>
                <div id="notice-contents-section">
                    <div id="notice-title"><p>${aOne.noticeTitle }</p></div>
                    <div id="notice-contents">
                        <div id="contents-img"><img src="/fileupload/${aOne.picName }" alt="후원 게시글 첨부사진"></div>
                        <div id="contents-text"><p>${aOne.noticeContents }</p></div>
                    </div>
                    <div id="notice-bottom">
                    ${nLike.userId }
                        <div id="like-butn">
                        	<c:if test="${nLike.userId eq null}">
	                        	<form action="/Notice/Apply/ApplyLike" method="post">
	                        		추천수 : ${aOne.noticeLike }<BR>
	                        		<input type="hidden" name="noticeNo" value="${aOne.noticeNo }">
	                        		<input type="submit" value="추천하기">
	                        	</form>
                        	</c:if>
                        	<c:if test="${nLike.userId ne null }">
                        		<form action="/Notice/Apply/ApplyLike" method="post">
	                        		추천수 : ${aOne.noticeLike }<BR>
	                        		<input type="hidden" name="noticeNo" value="${aOne.noticeNo }">
	                        		<input type="submit" value="추천하기">
	                        	</form>
	                        </c:if>
                        </div>
                    </div>
                </div>
                <div id="notice-reply">
                    <div id="space"></div>
                    <div id="reply-count"><h2>댓글</h2></div>
                    <div id="reply-contents">
                        <table id="reply-table">
                            <tr>
                                <th id="th-id">아이디</th><th id="th-contents">내용</th><th id="th-enroll">작성일</th>
                            </tr>
                            <c:forEach items="${aOne.replist }" var="aOne">
                            <tr>
                                <td>${aOne.replyUserId }</td>
                                <td>${aOne.replyContents }</td>
                                <td>${aOne.replyDate }</td>
                            </tr>
                            </c:forEach>
                            <tr id="reply-input">
                                <form action="/Notice/Apply/ApplyNoticeReplyWriter" method="post">
                                    <td>댓글 작성 : </td> <td><input type="text" name="replyContents" placeholder="댓글을 작성해보세요" id="text-input"></td>
                                        <td><input type="hidden" name="noticeNo" value="${aOne.noticeNo }">
                                        <input type="submit" value="작성"></td>
                                </form>    
                            </tr>
                        </table>
                    </div>
                </div>
                <div id="bottom-butn">
                    <a href="/Notice/Apply/ApplyNotice"><button id="list">목록</button></a>
                    <a href="/Notice/Apply/ApplyNoticeDelete?noticeNo=${aOne.noticeNo }"><button id="delete">삭제</button></a>
                </div>
            </section>
            </div>
        </main>
            <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>