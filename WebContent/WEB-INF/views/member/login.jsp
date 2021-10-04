<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Full Life 로그인</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body> 
    <main>
        <div class="login-header">
            <h2 style="height: 100px;">로그인</h2>
            <form action="/member/login" method="post">
                <input type="text" placeholder="아이디를 입력해주세요" id="user-id" name="user-id"><br>
                <input type="password" placeholder="비밀번호를 입력해주세요" id="user-pw" name="user-pw"><br>
                <input type="submit" value="로그인" id="login-btn"><br>
            </form>
            <div class="login-auto">
                <input type="radio" name="save-id" id="save-id" value="save-id"><label for="save-id">아이디 저장</label>
                <div class="login-util">
                    <a href="/member/findInfo">아이디 | 비밀번호 찾기</a>
                </div>
            </div>
            <div class="register-util">
                <a href="/member/enroll">FullLife에 처음이세요?</a>
            </div>
        </div>
 
    </main>
</body>
</html>