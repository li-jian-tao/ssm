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
<div class="userdown_main">
    <div class="content">
       <c:forEach items="${list }" var="userDown">
        <div class="line">
         <div>
             <div class="img" style="width: 120px;">
                 <img alt="" src="../img/${userDown.url }" style="width: 120px;height: 100px;border-radius: 0px;margin: 0px;">
             </div>
             <div class="tit">
                 <p>${userDown.article.title }</p>
             </div>
             <div class="date">
                <div class="datebox">
	                 <p>发布日期：${userDown.article.releaseDate }</p>
	                 <p>下载日期：${userDown.downDate }</p>
                </div>
             </div>
         </div>
            <div class="bu">
                <button type="button">删除</button>
                <button type="button" value="">标记未读</button>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
   <div class="page-icon">
        <a class="page-next" onclick="UserMydown(${prepage })">上一页</a>
        <c:forEach var="pages" begin="${start }" end="${end }">
            <c:if test="${page==pages }">
              <a onclick="UserMydown(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
            </c:if>
            <c:if test="${page!=pages }">
              <a onclick="UserMydown(${pages })">${pages }</a>
            </c:if>                
        </c:forEach>
        <a class="page-next" onclick="UserMydown(${nextpage })">下一页<i></i></a>
    </div>
</body>
</html>