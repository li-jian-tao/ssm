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
<div class="templatemo-content-widget no-padding">
        <div class="panel panel-default table-responsive">
            <div class="tableTitle">
                <div class="square"></div>
                点赞记录
            </div>
            <table
                class="table table-striped table-bordered templatemo-user-table">

                <thead>
                    <tr align="center">
                        <td>编号</td>
                        <td>文章题目</td>
                        <td>点赞时间</td>
                        <td>当前状态</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list }" var="list" varStatus="status">
                    <tr align="center" valign="middle">
                        <td>${status.index+1 }</td>
                        <td>${list.article.title }</td>
                        <td>${list.likeDate }</td>
                        <c:if test="${list.state==1 }">                        
	                        <td>已点赞</td>
                        </c:if>
                        <c:if test="${list.state==0 }">                        
                            <td>已被举报</td>
                        </c:if>
                        <td><i class="fa fa-thumbs-up fa-lg" title="修改"></i><i
                            class="fa fa-thumbs-o-up fa-lg" title="修改"></i></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page-icon">
            <a class="page-next" onclick="UserMylike(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
               <c:if test="${page==pages }">                   
                  <a onclick="UserMylike(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
               </c:if>
               <c:if test="${page!=pages }">                  
                  <a onclick="UserMylike(${pages })">${pages }</a>
               </c:if>
            </c:forEach>
            <a class="page-next" onclick="UserMylike(${nextpage })">下一页<i></i></a>
        </div>
    </div>
</body>
</html>