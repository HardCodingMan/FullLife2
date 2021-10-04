<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="../../../css/findpw.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <script>
         window.onload = function() {
            let radioBtn = document.querySelector("input[name=choice]:checked");
            const radio1 = document.querySelector("#email-radio");
            const radio2 = document.querySelector("#phone-radio");
            const emailDiv = document.querySelector(".pw-email");
            const phoneDiv = document.querySelector(".pw-phone");

            emailDiv.style.display = "block";
            radio1.addEventListener("change", function(){
                emailDiv.style.display = "block";
                phoneDiv.style.display = "none";
            });
            radio2.addEventListener("change", function(){
                emailDiv.style.display = "none";
                phoneDiv.style.display = "block";
            });
        }
    </script>
    <main>
        <section class="find">
            <div>
                <div class="find-title">
                    <p>아이디 찾기</p>
                </div>
                <div class="find-field1">
                    <div>
                        <a href="/member/findId" style="text-decoration:none; color:black; line-height:10px"><p>아이디 찾기</p></a>
                    </div>
                    <div>
                        <a href="javascript:void(0);" style="text-decoration:none; color:black; line-height:10px"><p>비밀번호 찾기</p></a>
                    </div>
                </div>
                <div class="find-field2">
                    <div>
                        <label>
                            <input type="radio" name="choice" id="email-radio" value="email" checked>
                            아이디
                        </label>
                    </div>
                    <div>
                        <label>
                            <input type="radio" name="choice" id="phone-radio" value="phone">
                            본인인증
                        </label>
                    
                    </div>
                </div>  
            </div>
            
            <div class="pw-email">
                <form action="/member/findPw" method="post">
                    <input type="text" name="user-id" id="" placeholder="아이디를 입력해주세요."><br>
                    <input type="text" name="user-name" id="" placeholder="이름을 입력해주세요."><br>
                    <input type="submit" value="비밀번호 찾기">
                </form>
            </div>
            <div class="pw-phone">
                <form action="#">
                    <p>
                        본인명의의 휴대폰으로 비밀번호를 찾는 방법입니다.
                        기존에 본인인증을 완료한 아이디만 찾으실 수 있습니다.   
                    </p>
                    <input type="submit" value="비밀번호 찾기">
                </form>
            </div>
        </section>
        
    </main>
    
</body>
</html>