<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Full Life 로그인</title>
    <link rel="stylesheet" href="/css/login.css">
     <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body> 
<script>
	    $("#saveid").ready(function(){
	    	let userInputId = getCookie("userInputId");
	    	$("input[name='user-id']").val(userInputId);
	    	if($("input[name='user-id']").val != ""){
	    		$("#saveid").attr("checked", true);
	    	}
	   
    	
    
    	$("#saveid").change(function(){
    		if($("#saveid").is(":checked")){
    			alert("아이디를 저장하시겠습니까?");
    			let userInputId = $("input[name=user-id]").val();
    			setCookie("userInputId", userInputId, 7);  //7일동안 보관해주는 코드
    		} else {
    			alert("아이디를 저장하지 않으시겠습니까?");
    			deleteCookie("userInputId");
    		}
    	});
    	function setCookie(cookieName, value, exdays){
    		var exdate = new Date();
    		exdate.setDate(exdate.getDate()+exdays);
    		let cookieValue = escape(value)+((exdays == null)?"":"; expires="+exdate.toGMTString());
    		document.cookie = cookieName + "=" +cookieValue;
    	}
	    });
    </script>
    <main>
        <div class="login-header">
            <h2 style="height: 100px;">로그인</h2>
            <form action="/member/login" method="post">
                <input type="text" placeholder="아이디를 입력해주세요" id="user-id" name="user-id"><br>
                <input type="password" placeholder="비밀번호를 입력해주세요" id="user-pw" name="user-pw"><br>
                <input type="submit" value="로그인" id="login-btn"><br>
            </form>
            <div class="login-auto">
                <input type="checkbox" id="saveid" value="save-id"><label for="saveid">아이디 저장</label>
                <div class="login-util">
                    <a href="/member/findInfo">아이디 · 비밀번호 찾기</a>
                </div>
            </div>
            <div class="register-util">
                <a href="/member/enroll">FullLife에 처음이세요?</a>
            </div>
        </div>
 
    </main>
    
</body>
</html>