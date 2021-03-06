<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 작성</title>
	<link rel="stylesheet" type="text/css" href="/css/askPost.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
</head>
<body>
	<header>
	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
	</header>
    <main>
       
            <div id="main-navi">
                 <div class="subMenu">
                    <h2>문의</h2>          
                </div>
            </div>
             <form action="/ask/post" method="post">
            <div id="main-contents">
                <br>
                <div id="contents">
                    <br>
                    <span class="contents-title">
                        <label for="subject"><strong>제목</strong></label>
                    </span>
                    <span class="contents_con">
                        <input type="text" name="subject" id="subject" placeholder="제목을 입력해주세요">
                    </span>
                    <br>
                    <span class="contents-title" >
                        <label for="textarea"><strong>문의내용</strong></label>
                    </span>
                    <span class="contents_con">
                        <textarea name="askContent" id="askContent" cols="100" rows="30" placeholder="내용을 입력해주세요"></textarea>
                    </span>
                    <br>
                    <span class="contents-title">
                        <strong>공개여부</strong>
                    </span>
                    공개 <input type="radio" name="disclosure" value="Y" checked>
                    비공개 <input type="radio" name="disclosure" value="N">
                    <br>
                    <div>
                        <input type="submit" value="문의작성" id="btn-submit">
                    </div>
                    
                </div>
            </div>
        </form>
        <br>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>