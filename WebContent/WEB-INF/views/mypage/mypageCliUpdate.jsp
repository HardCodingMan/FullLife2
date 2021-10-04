<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
<header>
        <jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
</header>
 <div style="margin: 0 auto;">
        <div class="mypage">
            <h2>마이페이지</h2>
        </div>
        <aside id="menucontainer">
            <ul class="menu">
          		<li><a href="/mypage/cliUpdate}">회원정보 수정</a></li>
                <li><a href="/mypage/history">주문내역</a></li>
                <li><a href="/mypage/point">포인트조회/충전</a></li>
                <li><a href="/mypage/regHospital">병원예약조회</a></li>
                <li><a href="/mypage/checkResult">검사내역</a></li>
            </ul>
        </aside>
        <article>
            <div id="clientupdate">
                <h3>회원정보 수정</h3>
                <form action="https:/www.naver.com" method="post">
                    <input type="hidden" name="userid" value="">
                    <div id="result-div" style="height: 30px; width: 200px; margin-left: 380px;margin-bottom: 20px;"></div>
                    <table class="cliupdateTable">
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" class="userid1" id="user-id" value=${sessionScope.userId } readonly></td>
                        </tr>
                        </table>
                        <table class="cliupdateTable1" style="background-color: rgba(173, 196, 136, 0.445);">
                            <tr>
                                <td>현재 비밀번호</td>
                                <td>
                                	<input type="password" name="pw1" id="user-currPw" >
                                	<input type="hidden" id="origin-pwd" value=${requestScope.member.userPwd } >
                                	<input type="hidden" id="user-zumin" value=${requestScope.member.userZumin } >
                                </td>
                            </tr>
                            <tr>
                                <td>신규 비밀번호</td>
                                <td><input type="password" name="pw2" id="user-newPw"></td>
                            </tr>
                            <tr>
                                <td>비밀번호 확인</td>
                                <td><input type="password" name="pw2" id="user-reNewPw"><br></td>
                            </tr>
                        </table>
                        <table class="cliupdateTable3">
                        <tr>
                            <td>이름</td>
                            <td><input type="text" name="name" id="user-name" value=${requestScope.member.userName } readonly></td>
                        </tr>
                        <tr>
                            <td>주민등록번호</td>
                            <td><input type="password" name="zumin" id="zumin1"></td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td><input type="text" name="tel" id="tel1" size="3">&nbsp;-&nbsp;<input type="text" name="tel" id="tel2" size="3">&nbsp;-&nbsp;<input type="text" name="tel" id="tel3" size="3"></td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td><input type="text" id="email-id" name="email-id" class="email_id" value="" title="이메일 아이디" placeholder="이메일" maxlength="18" >@
                                <select class="select" name="email-addr" title="이메일 도메인 주소 선택" id="email-addr" onclick="">
                                    <option value="">-선택-</option>
                                    <option value="naver.com">naver.com</option>
                                    <option value="gmail.com">gmail.com</option>
                                    <option value="hanmail.net">hanmail.net</option>
                                    <option value="hotmail.com">hotmail.com</option>
                                    <option value="korea.com">korea.com</option>
                                    <option value="nate.com">nate.com</option>
                                    <option value="yahoo.com">yahoo.com</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td><input type="text" name="addr" id="addr"></td>
                        </tr>
                       
                    </table>
                    <div class="cliupdateBtn">
                        <input type="submit" value="정보수정" class="clibt" onclick="return check();"><br>
                        <input type="submit" value="회원탈퇴" class="clibt" onclick="">
                    </div>
                </form>
            </div>
            <br><br><br><br><br><br><br><br><br>
        </article>
    </div>
       <script>
        let userId = document.querySelector("#user-id");
        let userPw = document.querySelector("#user-currPw");
        let userNewPw = document.querySelector("#user-newPw");
        let checkNewPw = document.querySelector("#user-reNewPw");
        let userName = document.querySelector("#user-name");
        let originPwd = document.querySelector("#origin-pwd")
        let phone1 = document.querySelector("#tel1");
        let phone2 = document.querySelector("#tel2");
        let phone3 = document.querySelector("#tel3");
        let emailId = document.querySelector("#email-id");
        let address = document.querySelector("#addr");
        let resultDiv = document.querySelector("#result-div");
        let select = document.querySelector("select[name=email-addr]");
        let zumin = document.querySelector("#zumin1");
        let userZumin = document.querySelector("#user-zumin");
        let idRegex = /[a-zA-Z0-9]{5,11}$/;
        let pwRegex = /[a-zA-Z0-9$!@#%&]{8,}$/;
        let newPwRegex = /[a-zA-Z0-9$!@#%&]{8,}$/;
        let checkPwRegex = /[a-zA-Z0-9$!@#%&]{8,}$/;
//         let zuminRegex =/^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))[1-4][0-9]{6}$ /;
        let phRegex1 = /[010]$/;
        let phRegex2 = /[0-9]{4}$/;
        let phRegex3 = /[0-9]{4}$/;

      

        function check(){
           
            if(!idRegex.test(userId.value)){
                alert("아이디를 입력하세요.");
                return false;
            } else if(!userPw.value == originPwd.value || userPw.value == ""){
                alert("현재 비밀번호를 입력해주세요.");
                return false;
            } else if(!newPwRegex.test(userNewPw.value) || userNewPw.value == ""){
                alert("신규 비밀번호를 입력해주세요.");
                return false;
            } else if(zumin.value == ""){
                alert("주민번호를 입력해주세요.");
                return false;
            } else if(!phRegex1.test(phone1.value) || phone1.value == ""){
                alert("전화번호를 확인해주세요.");
                return false;
            } else if(!phRegex2.test(phone2.value) || phone2.value == ""){
                alert("전화번호를 확인해주세요.");
                return false;
            } else if(!phRegex3.test(phone3.value) || phone3.value == ""){
                alert("전화번호를 확인해주세요.");
                return false;   
            } else if(emailId.value == ""){
                alert("이메일을 입력해주세요.");
                return false;
            } else if(address.value == ""){
                alert("주소를 입력해주세요.");
                return false;
            } else if(select.value == ""){
            	alert("이메일주소를 선택해주세요.");
            	return false;
            }
            return true;
        }

        userId.addEventListener("keyup", function(){
            if(this.value.length > 1){
                if(!idRegex.test(userId.value)){
                resultDiv.innerHTML = "<h5 style='color:red'>유효한 아이디가 아닙니다.</h5>";
                } else {
                    resultDiv.innerHTML = "<h5 style='color:blue'>유효한 아이디입니다.</h5>";
                }
            }
            this.addEventListener("blur", function(){
                resultDiv.innerHTML = "";
            });
        });
        userPw.addEventListener("keyup", function(){
            if(this.value.length > 1){
                if(originPwd.value !=  userPw.value){
                	resultDiv.innerHTML = "<h5 style='color:red'>유효한 비밀번호가 아닙니다.</h5>";
                } else {
                    resultDiv.innerHTML = "<h5 style='color:blue'>현재 비밀번호와 일치합니다.</h5>";
                }
            }
            
        });
        
        userNewPw.addEventListener("keyup", function(){
            if(this.value.length > 1){
                if(!newPwRegex.test(userNewPw.value)){
                    resultDiv.innerHTML = "<h5 style='color:red'>유효한 새비밀번호가 아닙니다.</h5>";
                } else {
                    resultDiv.innerHTML = "<h5 style='color:blue'>유효한 새비밀번호입니다.</h5>";
                }
            }
        });
        userNewPw.addEventListener("blur", function(){
                if(userPw.value == userNewPw.value) {
                    alert("이전 비밀번호와 일치하면 안됩니다.");
                    userPw.value = "";
                    userNewPw.value = "";
                    userPw.focus();
                }
        });
        zumin.addEventListener("blur", function(){
            if(userZumin.value != zumin.value){
                resultDiv.innerHTML = "<h5 style='color:red'>유효한 주민번호가 아닙니다.</h5>";
            } else {
                resultDiv.innerHTML = "<h5 style='color:blue'>유효한 주민번호입니다.</h5>";
            }
        });
//         zumin.addEventListener("blur", function(){
//             if(!zuminRegex.test(zumin.value)){
//                 resultDiv.innerHTML = "<h5 style='color:red'>유효한 주민번호가 아닙니다.</h5>";
//             } else {
//                 resultDiv.innerHTML = "<h5 style='color:blue'>유효한 주민번호입니다.</h5>";
//             }
//         });
        checkNewPw.addEventListener("blur", function(){
            if(checkNewPw.value == userNewPw.value){
                resultDiv.innerHTML = "<h5 style='color:blue'>비밀번호가 일치합니다.</h5>"
            } else {
                alert("비밀번호가 일치하지 않습니다.");
                checkNewPw.value = "";
            }
        });
        phone1.addEventListener("keyup", function(){
            if(/[ㄱ-힣a-zA-Z]/.test(this.value)){
                alert("숫자만 입력할 수 있습니다.");
                this.value = "";
            }
        });
        phone2.addEventListener("keyup", function(){
            if(/[ㄱ-힣a-zA-Z]/.test(this.value)){
                alert("숫자만 입력할 수 있습니다.");
                this.value = "";
            }
        });
        phone3.addEventListener("keyup", function(){
            if(/[ㄱ-힣a-zA-Z]/.test(this.value)){
                alert("숫자만 입력할 수 있습니다.");
                this.value = "";
            }
        });
    </script>
<footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
    
</body>
</html>