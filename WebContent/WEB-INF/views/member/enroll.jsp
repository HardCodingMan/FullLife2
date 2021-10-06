<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="/css/join.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>

 $(document).ready(function() {
	
	$("#agreeAll").click(function(){
	    if( $("#agreeAll").is(':checked') ){
	      $("input[type=checkbox]").prop("checked", true);
	    }else{
	      $("input[type=checkbox]").prop("checked", false);
	    }
	});

	$("input[name=check]").click(function(){
		var total = $("input[name=check]").length;
		var checked = $("input[name=check]:checked").length;
		
		if(total != checked) 
			$("#agreeAll").prop("checked",false);
		else
			$("#agreeAll").prop("checked",true);
		
	});
	});
	
    function searchAddr(){
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = ''; 
                var extraAddr = ''; 

                if (data.userSelectedType === 'R') { 
                    addr = data.roadAddress;
                } else { 
                    addr = data.jibunAddress;
                }
                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }
                document.getElementById('postalNum').value = data.zonecode;
                document.getElementById('roadAddress').value = addr;
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }

</script>
   <main id="fullLifeWrap">
        <header class="header">
            <h2>
                <a href="/index.jsp">Full Life</a>
                <br> 회원가입
            </h2>
        </header>
        
        <form action="/member/enroll" method="post">
        <div id="id">
            <h4 class="join_title">
                아이디
            </h4>
                <input type="text" class="wrong-input" id="userId" name="userId" placeholder="아이디 입력(5~11자)" required>
                <input type="button" onclick="openIdChk();" value="본인인증"><br>
                <span id="id-out">안녕</span>
        </div>
        <div id="password">
            <h4 class="join_title">
                비밀번호
            </h4>
                <input type="password" class="wrong-input" name="userPwd" id="userPwd" placeholder="비밀번호(숫자,영문,특수문자(!,@,#,%,&) 조합) 최소8자" required><br>
                <input type="password" class="wrong-input" name="userRePwd" id="userRePwd" placeholder="비밀번호 확인" required><br>
                <span id="pw-out">안녕</span>
        </div>
        <div id="name">
           <h4 class="join_title">
           이름</h4>
           <input type="text" class="wrong-input" name="userName" id="userName" placeholder="이름을 입력해주세요">
        </div>
        <div id="zumin">
            <h4 class="join_title">
                주민등록번호
            </h4>
                <input type="text" class="wrong-input" name="userZumin" id="userZumin" placeholder="-를 제외한 숫자 13자리를 입력해주세요" size="13"><br>
                <span id="zumin-out">안녕</span>
        </div>
        <div id="phone">
            <h4 class="join_title">
                핸드폰 번호        
            </h4>
            <span class="join_box">
                <input type="tel" name="userPhone" id="userPhone" placeholder="전화번호 입력">
            </span>
        </div>
        <span class="join_box">
            <button id="join_box"> 본인인증 </button>
        </span>
        <div id="address">
            <h4 class="join_title">
                주소
            </h4>
            <span class="join_box">
                <input type="text" class="wrong-input" name="" id="postalNum" placeholder="우편번호" size="6"> 
            </span>
                <span class="search_button">
                    <input type="button" value="주소검색" id="searchBox" onclick="searchAddr()">
                </span>
                <br>
                <input type="text" id="roadAddress" placeholder="주소를 입력해주세요">
                <input type="text" id="detailAddress" placeholder="상세주소를 입력해주세요" required>
                <input type="hidden" id="sample6_extraAddress" placeholder="참고항목" >
        </div>
        <div id="email">
            <h4 class="join_title">
                이메일
            </h4>
            <input type="email" name="userEmail" id="userEmail" placeholder="이메일을 입력해주세요">
        </div><br>
       
        <div id="checkbox_group">
            <div>
                <input type="checkbox" class="check" name='agreeAll' id="agreeAll" >
                <label for="agreeAll">전체동의</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="check" id="" > 
                <label for="personalInfo">개인정보 수집(필수)</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="check" id="" >
                <label for="useTerm">Full Life 이용약관(필수)</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="check" id="" > 
                <label for="ageAgree">만 14세 미만 가입 제한(필수)</label>
            </div>
        </div><br>
    
        <div id="joinBox">
        	<button id="join_box"><a href="/member/login">회원가입 완료</a></button>
        </div>
    </form>
    </main>
    <script>
    let userId = document.querySelector("#userId");
    let idOut = document.querySelector("#id-out");
    let userPw = document.querySelector("#userPwd");
    let userPw2 = document.querySelector("#userRePwd");
    let pwOut = document.querySelector("#pw-out");
    let phone = document.querySelector("#userPhone");
    let emailTag = document.querySelector("#userEmail");
    let zuminTag = document.querySelector("#userZumin");
    let zuminOut = document.querySelector("#zumin-out");
    let roadTag = document.querySelector("#roadAddress");
    let detailTag = document.querySelector("#detailAddress");
    let searchTag = document.querySelector("#searchBox");
    let postalTag = document.querySelector("#postalNum");
    let checkbox1 = document.querySelector("input[name=agreeAll]");
    let checkbox2 = document.querySelector("input[name=useTerm]")
    let checkbox3 = document.querySelector("input[name=personalInfo]");        
    let checkbox4 = document.querySelector("input[name=ageAgree]");
    
    let idRegex = /[a-zA-Z0-9]{5,11}$/;
    let pwRegex = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$!@#%&\\(\\)\-_=+]).{8,16}$/;
    let pwRegex2 = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$!@#%&\\(\\)\-_=+]).{8,16}$/;
    let zuminRegex = /\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[-]*[1-4]\d{6}/;

    

    function check(){
       
        if(!idRegex.test(userId.value)){
            alert("아이디를 입력하세요.");
            return false;
        } else if(userPw.value == "" || userPw2.value == ""){
            alert("비밀번호를 입력해주세요.");
            return false;
        }else if(!pwRegex.test(userPw.value)){
            alert("올바른 비밀번호를 입력해주세요");
            return false;
        } else if(zuminTag.value == "" || !zuminRegex.test(zuminTag.value)){
            alert("주민번호를 입력해주세요.");
            return false;
        } else if(emailTag.value == ""){
            alert("이메일을 입력해주세요.");
            return false;
        } else if(detailTag.value == ""){
            alert("주소를 입력해주세요.");
            return false;
        } else if(checkbox1.checked == false){
            alert("동의를 해주세요.");
            return false;
        } else if(checkbox2.checked == false){
            alert("개인정보 수집에 동의해주세요.");
            return false;
        } else if(checkbox3.checked == false){
            alert("이용약관에 동의해주세요.");
            return false;
        } else if(checkbox4.checked == false){
            alert("가입 제한에 동의해주세요.");
            return false;
        } else if(!emailTag.value.includes("@")){
            alert("올바른 이메일을 입력해주세요.");
            return false;
        } else if(phone.value == ""){
            alert("전화번호 본인인증을 해주세요.");
            return false;
        } else if(roadTag.value == "" || postalTag.value == ""){
            alert("주소를 등록하여 주세요.");
            return false;
        }
        return true;
    }

    userId.addEventListener("keyup", function(){
        if(this.value.length > 1){
            if(!idRegex.test(userId.value)){
                idOut.innerHTML = "<h5 style='color:red'>유효한 아이디가 아닙니다.</h5>";
                this.addEventListener("blur", function(){
                    if(!idRegex.test(userId.value)){
                        userId.value = "";
                        userId.focus();
                    }
                });
            } else {
                idOut.innerHTML = "<h5 style='color:blue'>유효한 아이디입니다.</h5>";
                this.addEventListener("blur", function(){
                    idOut.innerHTML = "";
                });
            }
        }

    });
    userPw.addEventListener("keyup", function(){
        if(this.value.length > 1){
            if(!pwRegex.test(userPw.value)){
               pwOut.innerHTML = "<h5 style='color:red'>* 숫자, 영문, 특수문자 각 1자리 이상이면서<br> 8자에서 16자이내 사용 가능합니다.<br> * 사용 가능한 특수 문자 : $!@#%& </h5>";
                userPw.addEventListener("blur", function(){
                    if(!pwRegex.test(userPw.value)){
                        userPw.value = "";
                        userPw.focus();
                    }
                });
            } else {
                pwOut.innerHTML = "<h5 style='color:blue'>사용 가능한 비밀번호입니다.</h5>";
                this.addEventListener("blur", function(){
                    pwOut.innerHTML = "";
                })
            }
        }
    }   );
    userPw2.addEventListener("keyup", function(){
        if(userPw.value != this.value || userPw.value.length < 8){
            pwOut.innerHTML = "<h5 style='color:red'>비밀번호가 일치하지 않습니다. 다시 입력해주세요.</h5>";
        
        } else {
            pwOut.innerHTML = "<h5 style='color:blue'>비밀번호가 일치합니다.</h5>";
            this.addEventListener("blur", function(){
                pwOut.innerHTML = "";
            });
        }
    })

    zuminTag.addEventListener("keyup", function(){
        if(this.value.length > 1){
        if(!zuminRegex.test(this.value)){
            zuminOut.innerHTML = "<h5 style='color:red'>유효한 주민번호가 아닙니다.</h5>";
        } else {
            zuminOut.innerHTML = "<h5 style='color:blue'>유효한 주민번호입니다.</h5>";
            this.addEventListener("blur", function(){
                zuminOut.innerHTML = "";
            });
        }
    }
    });

    phone.addEventListener("blur", function(){
        if(/[ㄱ-힣a-zA-Z]/.test(this.value)){
            alert("숫자만 입력할 수 있습니다.");
            this.value = "";
        }
    });
      function openIdChk(){
         var userId = $("#userId").val();
        $.ajax({
          type: "POST",
          url: "./idCheck",
          data: {userId: userId},
          success: function(result){
             if(result == 1){
                $("#id-out").html("<h6 style='color:red; font-size:15px; font-family:'Do Hyeon', sans-serif;'>사용중인 아이디입니다.</h6>");
             } else if(result == 0) {
                $("#id-out").html("<h6 style='color:blue; font-size:15px; font-family:'Do Hyeon', sans-serif;'>사용할 수 있는 아이디입니다.</h6>");
             }
          }
        });
      }
    </script>
</body>
</html>