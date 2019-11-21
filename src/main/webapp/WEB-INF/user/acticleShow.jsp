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
<c:forEach items="${list }" var="list">
<div class="templatemo-content-widget orange-bg marginStyle"
    onclick="showDetail(${list.id})">
    <div class="media-body">
        <h2 class="media-heading text-uppercase">${list.title }</h2>
        <p>作者：${list.user.nickname }</p>
        <p>阅读量：${list.clickTimes }</p>
    </div>
</div>
</c:forEach>
</body>
</html>