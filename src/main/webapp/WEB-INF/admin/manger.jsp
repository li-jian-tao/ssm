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
<div class="templatemo-content col-1 white-bg">

     <div class="templatemo-top-nav-container">
         <div class="row">
             <nav class="templatemo-top-nav col-lg-12 col-md-12">
                 <ul class="text-uppercase">
                     <li class="secondTitle" onclick="showArticleManger()">正常资讯</li>
                     <li class="active secondTitle" onclick="showArticleCheck(1)">资讯审核</li>
                     <li class="secondTitle" onclick="showReportCheck(1)">举报处理</li>

                 </ul>
             </nav>
         </div>
     </div>
    <div class="showSomething3">
    <div class="OpTitle">
             <div class="form-group">

                 <div class="input-group" style="background-color:#fff;border: 1px solid;border-radius: 10px;color:#858585;padding-left: 30px;">
                     <button onclick="showArticleCheck(1)" class="fa fa-search"></button>
                     <input type="text" class="form-control" placeholder="Search"
                         width="200px;" name="srch-term" id="srch-term">
                 </div>
                 <select class="form-control  selectStyle" id="sel">
                     <c:if test="${cid==0 }">                     
                         <option value="0" selected="selected" onclick="showArticleCheck(1)">请选择所属栏目</option>
                     </c:if>
                     <c:if test="${cid!=0 }">                     
                         <option value="0" onclick="showArticleCheck(1)">请选择所属栏目</option>
                     </c:if>
                     <c:forEach items="${categorys }" var="categorys">                     
                        <c:if test="${cid==categorys.id }">
                            <option value="${categorys.id }" selected="selected" onclick="showArticleCheck(1)">${categorys.name }</option>
                        </c:if>
                        <c:if test="${cid!=categorys.id }">
                            <option value="${categorys.id }" onclick="showArticleCheck(1)">${categorys.name }</option>
                        </c:if>
                     </c:forEach>
                 </select>
                 <select class="form-control  selectStyle" id="state">
                     <option value="0" onclick="showArticleCheck(1)">请选择审核状态</option>
                     <option value="-1" onclick="showArticleCheck(1)">未通过</option>
                     <option value="1" onclick="showArticleCheck(1)">审核通过</option>
                     <option value="2" onclick="showArticleCheck(1)">待审核</option>
                 </select>
             </div>
     </div>
     <div class="templatemo-content-container">
         <div class="panel panel-default table-responsive">
             <table
                 class="table table-striped table-bordered templatemo-user-table">
                 <thead>
                     <tr align="center">
                        <td>编号</td>
                         <td>资讯名称</td>
                         <td>所属栏目</td>
                         <td>作者</td>
                         <td>发布时间</td>
                         <td>审核状态</td>
                         <td>操作</td>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach items="${list }" var="list" varStatus="status">
                     <tr align="center" valign="middle">
                         <td>${status.index+1 }</td>
                         <td>${list.title }</td>
                         <td>${list.category.name }</td>
                         <td>${list.user.nickname }</td>
                         <td>${list.releaseDate }</td>
                         <c:if test="${list.state=='0'||list.state==null }">
                            <td>待初步审核</td>
                         </c:if>
                         <c:if test="${list.state=='1' }">
                            <td>初步审核通过</td>
                         </c:if>
                         <c:if test="${list.state=='-1' }">
                            <td>初步审核没通过</td>
                         </c:if>
                         <c:if test="${list.state=='99'||list.state=='2'||list.state=='-2' }">
                            <td>举报审核中</td>
                         </c:if>
                         <c:if test="${list.state!='99'&&list.state!='2'&&list.state!='-2' }">
                         <td><i class="fa fa-check fa-lg" title="通过" onclick="updateState(${list.id},1,${page })"
                             style="color: green;"></i> <i class="fa fa-times fa-lg"
                             title="不通过" onclick="updateState(${list.id},-1,${page })"
                             style="position: unset; color: red; background: none;"></i></td>
                          </c:if>
                          <c:if test="${list.state=='99'||list.state=='2'||list.state=='-2' }">
                          <td><i class="fa fa-check fa-lg" title="通过"
                             style="color: #bec6be;"></i> <i class="fa fa-times fa-lg"
                             title="不通过"
                             style="position: unset; color: #bec6be; background: none;"></i></td>
                          </c:if>
                     </tr>
                </c:forEach>
                 </tbody>
             </table>
         </div>
         <div class="page-icon">
            <a class="page-next" onclick="showArticleCheck(${prepage })">上一页</a>
            <c:forEach items="${pagecount }" var="pages">
                  <c:if test="${page==pages }">                
                  <a onclick="showArticleCheck(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
                </c:if>
                <c:if test="${page!=pages }">   
                  <a onclick="showArticleCheck(${pages })">${pages }</a>
                  </c:if>
            </c:forEach>
            <a class="page-next" onclick="showArticleCheck(${nextpage })">下一页<i></i></a>
        </div>
     </div>
 </div>
</div>
     
</body>
</html>