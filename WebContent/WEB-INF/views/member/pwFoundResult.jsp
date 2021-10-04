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
    <link rel="stylesheet" href="../../../css/pwFound.css">
</head>
<body>
    <main>
        <div class="header">
            <h1>비밀번호 찾기 결과</h1>
        </div>
        <div class="output-field">
        <c:if test="${requestScope.userPwd ne null }">
            <h4>회원님의 비밀번호입니다.</h4>
            <input type="text" value="${requestScope.userPwd }" readonly>
        </c:if>
        <c:if test="${userPwd eq null }">
            <h4>FullLife에 회원가입하세요.</h4>
            <input type="text" value="없는 회원정보입니다." readonly>
        </c:if>
        </div>
        <div class="footer">
<!--             <div> -->
<!--                 <a href="#">비밀번호가 기억나지 않으세요?</a> -->
<!--             </div> -->
            <div>
            	<form action="/member/login" method="get">
                	<input type="submit" value="로그인">
                </form>
            </div>
        </div>
    </main>
</body>
</html>