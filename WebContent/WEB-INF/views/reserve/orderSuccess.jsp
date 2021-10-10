<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/orderSuccess.css">
<meta http-equiv="refresh" content="60 url=/index.jsp">
</head>
<body>
	<header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
	<main>
        <fieldset>
            <legend><h1>예약완료</h1></legend>
        
        </div>
        <div id="contents">
            
            고객님의 병원 예약과 결제가 정상적으로 완료 되었습니다!<br><br>
            
            저희 FULL LIFE 홈페이지를 이용해주셔서 감사합니다.<br><br>
            
            이 페이지는 60초 후에 메인 페이지로 이동합니다.
        </div>
        <br><br>    
        <button id="toMain"><a href="/index.jsp">메인페이지로 이동</a></button>
     </fieldset> 
    </main>
      <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>