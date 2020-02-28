<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="showSomething2">
<div class="templatemo-content col-1 white-bg">
    <c:forEach items="${list }" var="list">
    <div class="templatemo-content-widget green-bg" onclick="showDetail2(${list.id })">
        <div class="media">
            <div class="media-left">
                <img class="media-object img-circle" src="../images/sunset.jpg"
                    alt="Sunset">
            </div>
            <div class="media-body">
                <h2 class="media-heading text-uppercase">${list.title }</h2>
                <p>作者：${list.user.nickname }</p>
                <p>阅读量：${list.clickTimes }</p>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
</div>
</body>
</html>