<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#report td{height:40px;}
.model{width:800px;}
.showMyReport{font-size:16px;}
.width{width:100px;float: left;margin-right: 4px;padding:0 8px; border:1px solid #108e5fc4; color: #108e5fc4;line-height: 34px;}
.content{display:inline}
</style>
<script type="text/javascript">
function editBtn3(){
	$('#showMyReport').show();
}

</script>
</head>
<body>
<div class="OpTitle">
        <div class="form-group">
            <div class="input-group"  style="background-color:#fff;border: 1px solid;border-radius: 10px;color:#858585;padding-left: 30px;">
                <button class="fa fa-search" onclick="showReportCheck(1)"></button>
                <input type="text" class="form-control" placeholder="Search"
                    width="200px;" name="srch-term" id="srch-term">
            </div>
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
                    <td>作者</td>
                    <td>发布时间</td>
                    <td>举报数量</td>
                    <td>当前状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="report" varStatus="status">
                <tr align="center" valign="middle">
                    <td>${status.index+1 }</td>
                    <td>${report.article.title }</td>
                    <td>${report.user.nickname }</td>
                    <td>${report.article.releaseDate }</td>
                    <td>${report.article.reportNum }</td>
                    <c:if test="${report.article.state==99 }">
                          <td>资讯审核中</td>                  
                    </c:if>
                    <c:if test="${report.article.state==2 }">
                          <td>资讯显示</td>                  
                    </c:if>
                    <c:if test="${report.article.state==-2 }">
                          <td>资讯禁止</td>                  
                    </c:if>
                    <td>
                    <i class="iconfont icon-edit-1-copy" title="查看详情" onclick="checkReport(${report.article.id},${page })"></i>
                    <i class="fa fa-check fa-lg" title="通过" onclick="updateReportState(${report.article.id},2,${page })" style="color: green;"></i>
                    <i class="fa fa-times fa-lg" title="不通过" onclick="updateReportState(${report.article.id},-2,${page })" style="position: unset; color: red; background: none;"></i></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page-icon">
            <a class="page-next" onclick="showReportCheck(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
                <c:if test="${page==pages }">
                  <a onclick="showReportCheck(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
                </c:if>
                <c:if test="${page!=pages }">
                  <a onclick="showReportCheck(${pages })">${pages }</a>
                </c:if>                
            </c:forEach>
            <a class="page-next" onclick="showReportCheck(${nextpage })">下一页<i></i></a>
        </div>
</div>
</body>
<!-- 举报模态框 -->
<div class="modal showMyReport" id="showMyReport">
    <div class="templatemo-content-widget white-bg col-2 model">
        <i class="fa fa-times" onclick="modelHidden()"></i>
        <br>
        <div class="table-responsive">
            <form>
                <div class="form-group">
                    <label for="">涉嫌类型</label> 
                    <br>
                    <div class="form-control width">
                        <i class="fa fa-check fa-lg"></i>
                                                            抄袭+${str1 }
                    </div>
                    <div class="form-control width">
                        <i class="fa fa-check fa-lg"></i>
                                                            色情+${str2 }
                    </div>
                    <div class="form-control width">
                        <i class="fa fa-check fa-lg"></i>
                                                            暴力+${str3 }
                    </div>
                    <div class="form-control width">
                        <i class="fa fa-check fa-lg"></i>
                                                            反动+${str4 }
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="">涉嫌内容</label> 
                    <br>
                    <c:forEach items="${content }" var="content">
                        <span class="form-control content">${content.reportContent }</span>
                    </c:forEach>
                </div>
            </form>
        </div>
    </div>
</div>
</html>