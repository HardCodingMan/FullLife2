<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/m_css/m_header.css">
</head>
<body>

	<header>
        <div id="logo">
            <a href="#"><img src="/img/fulllife로고3 (1).png" alt=""></a>
        </div>
        <div id="logout">
           <c:if test="${sessionScope.adminId eq null }">
               <button><a href="/manager/login">LOGIN</a></button>
            </c:if>
            <c:if test="${sessionScope.adminId ne null }">
               <button style="width:90px;"><a href="/manager/m_member_list?admin-id=${sessionScope.adminId }">
               MANAGER</a></button>
               <div class="logout">
               <a href="/manager/logout"><img src="/img/logout.png" style="width:20px;"></a>
               </div>
            </c:if>
        </div>
    </header>
</body>
</html>