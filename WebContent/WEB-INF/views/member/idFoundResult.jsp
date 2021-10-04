<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FullLife</title>
    <link rel="stylesheet" href="../../../css/idFound.css">
</head>
<body>
    <main>
        <div class="header">
            <h1>아이디 찾기 결과</h1>
        </div>
        <div class="output-field">
        <c:if test="${requestScope.userId ne null }">
            <h4>회원님의 아이디입니다.</h4>
            <input type="text" value="${userId }" readonly>
        </c:if>
        <c:if test="${requestScope.userId eq null }">
            <h4>회원가입해주세요.</h4>
            <input type="text" value="없는 회원정보입니다." readonly>
        </c:if>
        </div>
        <div class="footer">
            <div>
                <a href="/member/findPw">비밀번호가 기억나지 않으세요?</a>
            </div>
            <div>
            	<form action="/member/login" method="get">
                	<input type="button" value="로그인">
                </form>
            </div>
        </div>
    </main>
</body>
</html>