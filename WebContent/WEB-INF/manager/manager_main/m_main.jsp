<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/m_css/m_main.css">
</head>
<body>
    <div class="header">
        <div class="main-div">
            <div id="logo">
            	<c:if test="${sessionScope.adminId eq null }">
                	<a href="#"><img src="/img/FULLLIFE로고6.png" alt=""></a>
                </c:if>
            	<c:if test="${sessionScope.adminId ne null }">
                	<a href="/manager/m_member_list"><img src="/img/FULLLIFE로고6.png" alt=""></a>
                </c:if>
            </div>
            <div id="title">
                MANAGER ver.
            </div>
            <div class="btn-div">
                 <c:if test="${sessionScope.adminId eq null }">
               		<button><a href="/manager/login">LOGIN</a></button>
            	</c:if>
           		<c:if test="${sessionScope.adminId ne null }">
               		<button><a href="/manager/logout">LOGOUT</a></button>
               	</c:if>
                <button><a href="/index.jsp">FULL LIFE</a></button>
            </div>
        </div>
    </div>
</body>
</html>