<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/applynoticewriter.css">
</head>
<body>
	<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div class="wrapper">
        <section>
            <div id="applynotice-header">
                <h2>신청 게시판</h2>
            </div>
        </section>
        <section id="writer-section">
            <div id="writer-top">
                <h3>신청 게시글 작성</h3>
                <hr>
            </div>
            <div id="notice-wirte">
            <!-- 게시판 양식 -->
                <form action="/Notice/Apply/ApplyNoticeWriter" method="post" enctype="multipart/form-data">
                    <p>제목</p><input type="text" size="100" placeholder="제목을 입력하세요" name="apply-notice-sub" class="box"><br>
                    <p>필요한 금액</p><input type="text" size="50" placeholder="필요 금액을 적어주세요" name="need-supprot" class="box"><br>
                    <p>내용</p><textarea rows="30" cols="100" placeholder="내용을 입력하세요" name="apply-notice-contents" class="box"></textarea><br>
                    <p>사진첨부</p><input type="file" name="apply-File" id="apply-UpLoad" class="box">
                    <p>첨부파일의 크기가 50MB 미만이여야 합니다.<br>첨부가능한 파일은 jpg.png 입니다</p>
                    <hr>
                    <div id="butn">
                    <input type="submit" value="저장하기" class="input-butn">
                    <input type="reset" value="취소하기" class="input-butn">
                    </div>
                </form>
            </div>
        </section>
        </div>
    </main>
   	<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>