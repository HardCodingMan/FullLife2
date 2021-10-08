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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                    <div id="notice-title"><p id="No">글번호 : ${aOne.noticeNo }</p><p id="userId">글쓴이 : ${aOne.userId }</p><p id="title">${aOne.noticeTitle }</p></div>
                    <div id="notice-contents">
                        <div id="contents-img"><img src="/fileupload/${aOne.picName }" alt="후원 게시글 첨부사진"></div>
                        <div id="contents-text"><p>${aOne.noticeContents }</p></div>
                    </div>
                    <div id="notice-bottom">
                        <div id="like-butn">
                        	<c:if test="${sessionScope.userId eq null}">
	                        	<form action="/member/login" method="post">
	                        		로그인을 하셔야합니다<BR>
	                        		<input type="submit" value="로그인">
	                        	</form>
                        	</c:if>
                        	<c:choose>
                        		<c:when test="${nLike.userId eq sessionScope.userId and sessionScope.userId ne null}">
			                        		추천수 : ${aOne.noticeLike }<BR>
			                        		<button id="like-butn">이미 추천을 하셨습니다</button>
                        		</c:when>
                        		<c:when test="${sessionScope.userId ne nLike.userId}">
                        			<form action="/Notice/Apply/ApplyLike" method="post">
		                        		추천수 : ${aOne.noticeLike }<BR>
		                        		<input type="hidden" name="noticeNo" value="${aOne.noticeNo }">
		                        		<input type="submit" value="추천하기">
	                        		</form>
                        		</c:when>
                        	</c:choose>
                        </div>
                    </div>
                </div>
                <div id="notice-reply">
                    <div id="space"></div>
                    <div id="reply-count"><h2>댓글</h2></div>
                    <div id="reply-contents">
                        <table id="reply-table">
                            <tr class="">
                                <th id="th-id">아이디</th><th id="th-contents">내용</th><th id="th-enroll">작성일</th>
                            </tr>
                            <c:forEach items="${aOne.replist }" var="aOne">
                            <tr class="tr">
                                <td>${aOne.replyUserId }</td>
                                <td>${aOne.replyContents }</td>
                                <td>
                                	${aOne.replyDate }
                                	<c:if test="${sessionScope.userId eq aOne.replyUserId }">
                                	<a class="hide" href="javascript:void(0)" onclick="showModifyReply(this)">수정</a>&nbsp;&nbsp;
									<a class="hide" href="/Notice/Apply/ApplyReplyDelete?noticeNo=${aOne.noticeNo }&replyNo=${aOne.replyNo}&userId=${aOne.replyUserId}">삭제</a>
									</c:if>
                                </td>
                            </tr>
                            <tr class="tr" style="display:none;">
                            	<td>${aOne.replyUserId }</td>
                                <td>
                                    <input type="text" class="text-input" value="${aOne.replyContents }" id="modifyReply">
                                </td>
                                <td >
                                    <a href="javascript:void(0)" onclick="modifyReply(this,${aOne.replyNo},${aOne.noticeNo })">수정</a>&nbsp;&nbsp;
                                    <a href="javascript:void(0)" onclick="hideModifyReply(this)">취소</a>
                                </td>
                            </tr>
                            </c:forEach>
                            <tr id="reply-input">
                                <form action="/Notice/Apply/ApplyNoticeReplyWriter" method="post">
                                    <td>댓글 작성 : </td> <td><input type="text" name="replyContents" placeholder="댓글을 작성해보세요" class="text-input"></td>
                                        <td><input type="hidden" name="noticeNo" value="${aOne.noticeNo }">
                                        <c:if test="${sessionScope.userId eq null }">
													로그인 후 <br>이용가능
                                        </c:if>
                                        <c:if test="${sessionScope.userId ne null  }">
                                        	<input type="submit" value="작성"></td>
                                       	</c:if>
                                </form>    
                            </tr>
                        </table>
                        <form action="/Notice/Apply/ApplyReplyModify" method="post" id="modifyForm">
							<input type="hidden" name="replyContents" id="modifyReplyContents">
							<input type="hidden" name="replyNo" id="modifyReplyNo">
							<input type="hidden" name="noticeNo" id="modifyNoticeNo">
						</form>
                    </div>
                </div>
                <div id="bottom-butn">
                    <a href="/Notice/Apply/ApplyNotice"><button id="list">목록</button></a>
                    <c:if test="${sessionScope.userId eq aOne.userId }">
                    <a href="/Notice/Apply/ApplyNoticeDelete?noticeNo=${aOne.noticeNo }&userId=${aOne.userId }"><button id="delete">삭제</button></a>
                    </c:if>
                </div>
            </section>
            </div>
        </main>
            <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
    <script>
            function modifyReply(obj, replyNo, noticeNo){
                var contents = $(obj).parent().prev().find("input").val();
                //var contents = $("#modifyReply").val(); 이렇게하면 다바뀜 아이디값이 다 같아서 
                $("#modifyReplyContents").val(contents);
                $("#modifyReplyNo").val(replyNo);
                $("#modifyNoticeNo").val(noticeNo);
                $("#modifyForm").submit();
            }
            function showModifyReply(obj){
                $(obj).parents("tr").next().show();
                $(obj).parents("tr").hide();
            }
            function hideModifyReply(obj){
                $(obj).parents("tr").prev().show();
                $(obj).parents("tr").hide();
            }
            $(".tr").click(function(){
                if($(".hide").css("display") == 'none'){
                    $(".hide").show();
                }else{
                    $(".hide").hide();
                }
            });
        </script>
</body>
</html>