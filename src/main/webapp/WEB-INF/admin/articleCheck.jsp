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
                     <c:forEach items="${categorys }" var="categorys" begin="6">                     
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
	                 <c:if test="${state==-1 }">
	                      <option value="-1" onclick="showArticleCheck(1)" selected="selected">未通过</option>
	                 </c:if>
	                 <c:if test="${state==1 }">
	                      <option value="1" onclick="showArticleCheck(1)" selected="selected">审核通过</option>
	                 </c:if>
	                 <c:if test="${state==2 }">
	                      <option value="2" onclick="showArticleCheck(1)" selected="selected">待审核</option>
	                 </c:if>
	                 <c:if test="${state!=-1 }">
                          <option value="-1" onclick="showArticleCheck(1)">未通过</option>
                     </c:if>
                     <c:if test="${state!=1 }">
                          <option value="1" onclick="showArticleCheck(1)">审核通过</option>
                     </c:if>
                     <c:if test="${state!=2 }">
                          <option value="2" onclick="showArticleCheck(1)">待审核</option>
                     </c:if>
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
                            <td>待审核</td>
                         </c:if>
                         <c:if test="${list.state=='1' }">
                            <td>审核通过</td>
                         </c:if>
                         <c:if test="${list.state=='-1' }">
                            <td>没通过</td>
                         </c:if>

                         <td><i class="fa fa-check fa-lg" title="通过" onclick="updateState(${list.id},1,${page })"
                             style="color: green;"></i> <i class="fa fa-times fa-lg"
                             title="不通过" onclick="updateState(${list.id},-1,${page })"
                             style="position: unset; color: red; background: none;"></i></td>

                     </tr>
                </c:forEach>
                 </tbody>
             </table>
         </div>
         <div class="page-icon">
            <a class="page-next" onclick="showArticleCheck(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
                <c:if test="${page==pages }">
                  <a onclick="showAllCategory(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
                </c:if>
                <c:if test="${page!=pages }">
                  <a onclick="showAllCategory(${pages })">${pages }</a>
                </c:if>                
            </c:forEach>
            <a class="page-next" onclick="showArticleCheck(${nextpage })">下一页<i></i></a>
        </div>
     </div>
</body>
</html>