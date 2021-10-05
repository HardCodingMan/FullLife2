<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="/m_css/m_login.css">
</head>
<body>
	 <main>
        <div class="login-header">
            <h2 style="height: 100px;">로그인</h2>
                <h4>관리자.ver</h4>
                <form action="/manager/login" method="post">
                <input type="text" placeholder="아이디를 입력해주세요" id="admin-id" name="admin-id"><br>
                <input type="password" placeholder="비밀번호를 입력해주세요" id="admin-pwd" name="admin-pwd"><br>
                <input type="submit" value="로그인" id="login-btn"><br>
                <div class="login-auto">
                    <input type="radio" name="save-id" id="save-id" value="save-id"><label for="save-id">아이디 저장</label>
                </div>
            </form>
        </div>
    </main>
</body>
</html>