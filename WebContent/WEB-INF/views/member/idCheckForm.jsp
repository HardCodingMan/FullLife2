<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="wrap">
 	<br>
 	<b><font size="4" color="black">아이디 중복체크</font></b>
 	<hr size="1" width="460">
 	<br>
 	<div id="chk">
 		<form id="checkForm">
 			<input type="text" name="idInput" id="userId">
 			<input type="button" value="중복확인" onclick="IdCheck()">
 		</form>
 		<div id="msg"></div>
 		<br>
 		<input id="calcelBtn" type="button" value="취소" onclick="window.close()"><br>
 		<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
 	</div>
 </div>
 <script>
 	function idCheck(){
 		var id = document.querySelector("#");
 	}
 </script>
</body>
</html>