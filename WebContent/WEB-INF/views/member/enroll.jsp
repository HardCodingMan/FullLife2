<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<!--     <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="/css/join.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function checkAgreeAll(checkbox)  {
    const selectall 
        = document.querySelector('input[class="check"]');
    
    if(checkbox.checked === false)  {
        selectall.checked = false;
    }
    }
    function agreeAll(agreeAll){
        console.log('실행');
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach((checkbox) => {checkbox.checked = agreeAll.checked;
    })
    }

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
                <a href="#">Full Life</a>
                <br> 회원가입
            </h2>
        </header>
        
        <form action="/member/enroll" method="post">
        <div id="id">
            <h4 class="join_title">
                아이디
            </h4>
                <input type="text" class="wrong-input" id="userId" name="userId" placeholder="아이디 입력(5~11자)" required>
        </div>
        <div id="password">
            <h4 class="join_title">
                비밀번호
            </h4>
                <input type="password" class="wrong-input" name="userPwd" id="userPwd" placeholder="비밀번호(숫자,영문,특수문자(!,@,#,%,&) 조합) 최소8자" required><br>
                <input type="password" class="wrong-input" name="userRePwd" id="userRePwd" placeholder="비밀번호 확인" required>
        </div>
        <div id="zumin">
            <h4 class="join_title">
                주민등록번호
            </h4>
                <input type="text" class="wrong-input" name="userZumin" id="userZumin" placeholder="-를 제외한 숫자 13자리를 입력해주세요" size="13">
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
                <input type="checkbox" class="check" name='agreeAll' value='agreeAll' onclick='agreeAll(this)'> 
                <label for="agreeAll">전체동의</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="personalInfo" id=""   onclick='checkAgreeAll(this)'> 
                <label for="personalInfo">개인정보 수집(필수)</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="useTerm" id="" onclick='checkAgreeAll(this)'>
                <label for="useTerm">Full Life 이용약관(필수)</label>
            </div>
            <div>
                <input type="checkbox" class="check" name="ageAgree" id="" onclick='checkAgreeAll(this)'> 
                <label for="ageAgree">만 14세 미만 가입 제한(필수)</label>
            </div>
        </div><br>
    
        <div id="joinBox">
            <input type="submit" value="회원가입 완료">
        </div>
    </form>
    </main>
    
</body>
</html>