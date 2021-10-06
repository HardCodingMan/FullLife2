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
<link rel="stylesheet"  href="/css/supnoticecontents.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div class="wrapper">
        <section>
            <div id="supportnotice-header">
                <h2>후원 게시글</h2>
            </div>
        </section>
        <section id="notice-section">
            <div id="notice-date">
                <div><p id="notice-enroll">${sOne.enrollDate }</p></div>
                <div><p id="notice-views">조회수 ${sOne.views }</p></div>
            </div>
            <div id="notice-contents-section">
                <div id="notice-title"><p id="No">글번호 : ${sOne.noticeNo }</p><p id="userId">글쓴이 : ${sOne.userId }</p><p id="title">${sOne.userId }</p></div>
                <div id="notice-contents">
                    <div id="contents-img"><img src="/fileupload/${sOne.picName }" alt="${aOne.picName }"></div>
                    <div id="contents-text"><p>${sOne.noticeContents }</p></div>
                </div>
                <div id="notice-bottom">
                    <div id="point-text"><p id="goal">&nbsp;필요 달성 금액 :&nbsp;</p><p id="goal-money">${sOne.needSupport }원</p><p id="goal-rate">달성률 ${requestScope.percentage }%&nbsp;</p></div>
                    <p id="now-support">현재 후원된 금액 : ${sOne.nowSupport }</p>
                    <div id="point-butn">
                    	<c:if test="${sessionScope.userId eq null }">
							로그인 후 <br>이용가능
                        </c:if>
                        <c:if test="${sessionScope.userId ne null }">
                    	<button onclick="hide();">포인트 후원</button>
                    	</c:if>
                    </div>
                    <div id="point-view" class="hide"><p>보유한 포인트 : ${sOne.totalpoint }</p></div>
                    <form action="/Notice/Support/PointSupport" method="post">
                    	<input type="hidden" name="noticeNo">
                    	<div id="point-sub" class="hide"><input type="submit" value="후원하기"><input type="reset" value="취소"></div>
                    	<div id="point-input" class="hide"><input type="text" name="support-point" id="" size="35" placeholder="기부할 포인트를 입력해주세요"></div>
                    </form>
                </div>
            </div>
            <div id="notice-reply">
                <div id="space"></div>
                <div id="reply-count"><h2>후원 댓글</h2></div>
                <div id="reply-contents">
                    <table id="reply-table">
                        <tr>
                            <th id="th-id">아이디</th><th id="th-contents">내용</th><th id="th-enroll">작성일</th>
                        </tr>
                        <c:forEach items="${sOne.replist }" var="sOne">
                            <tr>
                                <td>${sOne.replyUserId }</td>
                                <td>${sOne.replyContents }</td>
                                <td>${sOne.replyDate }
                                	<c:if test="${sessionScope.userId eq sOne.replyUserId }">
                                	<a href="javascript:void(0)" onclick="showModifyReply(this)">수정</a>&nbsp;&nbsp;
									<a href="/Notice/Support/SupportReplyDelete?noticeNo=${sOne.noticeNo }&replyNo=${sOne.replyNo}">삭제</a>
									</c:if>
                                </td>
                            </tr>
                            <tr class="tr" style="display:none;">
                            	<td>${sOne.replyUserId }</td>
                                <td>
                                    <input type="text" class="text-input" value="${sOne.replyContents }" id="modifyReply">
                                </td>
                                <td>
                                    <a href="javascript:void(0)" onclick="modifyReply(this,${sOne.replyNo},${sOne.noticeNo })">수정</a>&nbsp;&nbsp;
                                    <a href="javascript:void(0)" onclick="hideModifyReply(this)">취소</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr id="reply-input">
                            <form action="/Notice/Support/SupportNoticeReplyWriter" method="post">
                                 <td>댓글 작성 : </td> <td><input type="text" name="replyContents" placeholder="댓글을 작성해보세요" class="text-input"></td>
                                     <td><input type="hidden" name="noticeNo" value="${sOne.noticeNo }">
                                     <c:if test="${sessionScope.userId eq null }">
													로그인 후 <br>이용가능
                                        </c:if>
                                     <c:if test="${sessionScope.userId ne null  }">
                                      	<input type="submit" value="작성"></td>
                                   	 </c:if>
                            </form>     
                        </tr>
                    </table>
                    <form action="/Notice/Support/SupportReplyModify" method="post" id="modifyForm">
							<input type="hidden" name="replyContents" id="modifyReplyContents">
							<input type="hidden" name="replyNo" id="modifyReplyNo">
							<input type="hidden" name="noticeNo" id="modifyNoticeNo">
					</form>
                </div>
            </div>
                <div id="bottom-butn">
                    <a href="/Notice/Support/SupportNotice"><button id="list">목록</button></a>
            </div>
        </section>
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
    <script>
        function hide() {
            if($(".hide").css('display') == 'none'){
                $('.hide').show();
            }else{
                $('.hide').hide();
            }
        }
        
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
    </script>
</body>
</html>