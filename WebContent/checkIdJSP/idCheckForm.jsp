<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="pValue()">
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
 		var id = document.querySelector("#id").value;
 		if(!id){
 			alert("아이디를 입력하지 않았습니다.");
 			return false;
 		} else if((id < "0" || id > "9") && (id < "A" || id > "a") && (id < "a" || id > "z") {
 			alert("한글 및 특수문자는 아이디에 사용하실 수 없습니다.");
 			return false;
 		} else {
 			var param = "id="+id
 			httpRequest = getXMLHttpRequest();
 			httpRequest.onreadystatechange = callback;
 			httpRequest.open("POST", "MemberIdCheckAction.do", true);
 			httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
 			httpRequest.send(param);
 		}
 	}
 	function pValue(){
 		document.getElementById("userId").value = opener.document.userInfo.id.value;
 	}
 	function callback(){
 		if(httpRequest.readyState == 4){
 			var resultText = httpRequest.responseText;
 			if(resultText == 0){
 				alert("사용할 수 없는 아이디입니다.");
 				document.getElementById("cancelBtn").style.visibility = "visible";
 				document.getElementById("useBtn").style.visibility = "hidden";
 				document.getElementById("msg").innerHTML = "";
 			} else if(resultText == 1){
 				document.getElementById("cancelBtn").style.visibility = "hidden";
 				document.getElementById("useBtn").style.visibility = "visible";
 				document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
 			}
 		}
 		function sendCheckValue(){
 			opener.document.userInfo.idDuplication.value = "idCheck";
 			opener.document.userInfo.id.value = document.getElementById("userId").value;
 			
 			if(opener != null){
 				opener.chkForm = null;
 				self.close();
 			}
 		}
 	}
 </script>
</body>
</html>