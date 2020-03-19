<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function editBtn() {
        $('.showMyReport').show();
    }
</script>
<style type="text/css">
.model{width:400px;}
.form-group input{border:1px solid #108e5fc4;}
.width{width:20%;float: left;margin-right: 4%;padding:0 4px; border:1px solid #108e5fc4; color: #108e5fc4;line-height: 34px;}
</style>
</head>
<body>

<div class="templatemo-content-widget no-padding">
    <div class="panel panel-default table-responsive">
        <div class="tableTitle">
            <div class="square"></div>
            举报记录
        </div>
        <table
            class="table table-striped table-bordered templatemo-user-table">

            <thead>
                <tr align="center">
                    <td>编号</td>
                    <td>文章题目</td>
                    <td>举报时间</td>
                    <td>当前状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="list" varStatus="status">
                    <tr align="center" valign="middle">
                        <td>${status.index+1 }</td>
                        <td>${list.article.title }</td>
                        <td>${list.reportDate }</td>
                        <c:if test="${list.state==0 }">                        
                            <td>审核中</td>
                        </c:if>
                        <c:if test="${list.state==1 }">                        
                            <td>已处理</td>
                        </c:if>
                    <td><button class="show_btn" onclick="findReport(${list.id},${page })">
                            <i class="fa fa-eye  fa-lg " title="查看"></i>
                        </button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page-icon">
            <a class="page-next" onclick="UserMyreport(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
               <c:if test="${page==pages }">                   
                  <a onclick="UserMyreport(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
               </c:if>
               <c:if test="${page!=pages }">                  
                  <a onclick="UserMyreport(${pages })">${pages }</a>
               </c:if>
            </c:forEach>
            <a class="page-next" onclick="UserMyreport(${nextpage })">下一页<i></i></a>
        </div>
</div>

<!-- 举报模态框 -->
<div class="modal showMyReport">
    <div class="templatemo-content-widget white-bg col-2 model">
        <i class="fa fa-times" onclick="modelHidden()"></i>
        <br>
        <div class="table-responsive">
            <form>
                <div class="form-group">
                    <label for="">举报文章标题</label> <input type="text"
                        class="form-control" readonly="readonly" placeholder="${userReport.article.title }">
                </div>
                <div class="form-group">
                    <label for="">举报理由</label> <input type="text"
                        class="form-control" readonly="readonly"
                        placeholder="${userReport.reportContent }">
                </div>
                <div class="form-group">
                    <label for="">举报类型</label> 
                    <br>
                    <c:forEach items="${strings }" var="type">
                    <div class="form-control width">
	                    <i class="fa fa-check fa-lg"></i>
	                   ${type }
                    </div>
                    </c:forEach>
                </div>
                <br>
                <div class="form-group">
                <br>
                    <label for="">举报时间</label> <input type="text"
                        class="form-control" readonly="readonly"
                        placeholder="${userReport.reportDate }">
                </div>
                <div class="form-group">
                    <label for="">处理结果</label> <input type="text"
                        class="form-control" readonly="readonly" placeholder="${userReport.processContent }">
                </div>
                <div class="form-group">
                    <label for="">处理时间</label> <input type="text"
                        class="form-control" readonly="readonly"
                        placeholder="${userReport.processDate }">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>