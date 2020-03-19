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
           我的收藏
       </div>
       <table
           class="table table-striped table-bordered templatemo-user-table">

           <thead>
               <tr align="center">
                   <td>编号</td>
                   <td>文章题目</td>
                   <td>发布时间</td>
                   <td>当前状态</td>
                   <td>操作</td>
               </tr>
           </thead>
           <tbody>
               <c:forEach items="${list }" var="list" varStatus="status">
               <tr align="center" valign="middle">
                   <td>${status.index+1 }</td>
                   <td>${list.article.title }</td>
                   <td>${list.collectionDate }</td>
                   <c:if test="${list.state==1 }">                        
                       <td>已收藏</td>
                   </c:if>
                   <c:if test="${list.state==0 }">                        
                       <td>已被举报</td>
                   </c:if>
                   <td><i class="fa fa-heart fa-lg"></i><i
                       class="fa fa-heart-o fa-lg"></i></td>
               </tr>
               </c:forEach>
           </tbody>
       </table>
   </div>
   <div class="page-icon">
            <a class="page-next" onclick="UserMycollection(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
               <c:if test="${page==pages }">                   
                  <a onclick="UserMycollection(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
               </c:if>
               <c:if test="${page!=pages }">                  
                  <a onclick="UserMycollection(${pages })">${pages }</a>
               </c:if>
            </c:forEach>
            <a class="page-next" onclick="UserMycollection(${nextpage })">下一页<i></i></a>
        </div>
</div>
</body>
</html>