<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{position: relative;}
.showMyUser{padding: 5px;width: 200px;background: #224952;position: absolute;border-radius: 10px;color: white;}
.showMyUser span{width: 180px;height: 25px;font-size: 14px;padding: 10px;}
.pwd{width: 60px;border:none;border-radius:0;box-shadow: 0px 0px 0px 0px;outline: none;background-color:transparent;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	$("body").delegate(".fa-eye-slash","click",function (){
	    $(this).parent("td").children(".pwd").attr("type","text");
	    $(this).removeClass("fa-eye-slash");
	    $(this).addClass("fa-eye");
	});
	$("body").delegate(".pw","mouseout",function (){
	    $(this).children(".pwd").attr("type","password");
	    $(this).children("i").removeClass("fa-eye");
	    $(this).children("i").addClass("fa-eye-slash");
	});
});
$("body").delegate("table","mouseout",function(){
	$(".showMyUser").hide();
}); 
$("body").delegate(".showUser","mousemove",function(e) {  
	var t = $("table").find("tr").width();
	var xx = e.originalEvent.x || e.originalEvent.layerX || 0; 
	var yy = e.originalEvent.y || e.originalEvent.layerY || 0;
	if(xx>1.1*t){
		$(".showMyUser").css({"top":yy+20,"left":xx-220});
	} else {
		$(".showMyUser").css({"top":yy+20,"left":xx+20});
	}
	$(".showMyUser").hide();
	$(eval("user"+$(this).next().val())).show();
}); 
</script>
</head>
<body onmousemove="mousemove(event)">
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
                    <td>用户名称</td>
                    <td>账号</td>
                    <td>密码</td>
                    <td>发布数量</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList }" var="userList" varStatus="status">
                <tr align="center" valign="middle" class="showUser">
                    <td>${status.index+1 }</td>
                    <td>${userList.nickname }</td>
                    <td>${userList.account }</td>
                    <td class="pw">
                        <input type="password" value="${userList.password}" readonly="readonly" class="pwd">
                        &nbsp;<i class="fa fa-eye-slash" style="color: green;cursor: pointer;"></i>
                    </td>
                    <td>${userList.COUNT}</td>
                    <td>
                    <i class="iconfont icon-edit-1-copy" title="查看详情" onclick="checkReport(${report.article.id},${page })"></i>
                    
                </tr>
                <input type="hidden" value="${userList.id}">
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page-icon">
            <a class="page-next" onclick="showUserManager(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
                <c:if test="${page==pages }">
                  <a onclick="showUserManager(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
                </c:if>
                <c:if test="${page!=pages }">
                  <a onclick="showUserManager(${pages })">${pages }</a>
                </c:if>                
            </c:forEach>
            <a class="page-next" onclick="showUserManager(${nextpage })">下一页<i></i></a>
        </div>
</div>
</body>
<!-- 举报模态框 -->
<c:forEach items="${maps}" var="item" >
	<div class="showMyUser" id="user${item.key }" style="display: none;">
	<span>发布的文章：</span>
	<br>
	<c:forEach items="${item.value}" var="value">
	   <span>${value.title }</span>	
	   <br>	
	</c:forEach>
	</div>
</c:forEach>
</html>