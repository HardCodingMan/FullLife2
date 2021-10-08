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
        $(document).ready(function(){
		    var userInputId = getCookie("userInputId");//저장된 쿠기값 가져오기
		    $("input[name='user-id']").val(userInputId); 
		     
		    if($("input[name='user-id']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩
		                                           // 아이디 저장하기 체크되어있을 시,
		        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
		    }
		     
		    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 발생시
		        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
		            var userInputId = $("input[name='user-id']").val();
		            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
		        }else{ // ID 저장하기 체크 해제 시,
		            deleteCookie("userInputId");
		        }
		   });
     
    	// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
	    $("input[name='user-id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
	            var userInputId = $("input[name='user-id']").val();
	            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
	        }
	    });
	});
 
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	 
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	 
	function getCookie(cookieName) {
	    cookieName = cookieName + '=';
	    var cookieData = document.cookie;
	    var start = cookieData.indexOf(cookieName);
	    var cookieValue = '';
	    if(start != -1){
	        start += cookieName.length;
	        var end = cookieData.indexOf(';', start);
	        if(end == -1)end = cookieData.length;
	        cookieValue = cookieData.substring(start, end);
	    }
	    return unescape(cookieValue);
	}
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
                <input type="checkbox" id="idSaveCheck" value="save-id"><label for="idSaveCheck">아이디 저장</label>
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