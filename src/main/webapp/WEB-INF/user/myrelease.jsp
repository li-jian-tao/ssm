<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.model{width:600px;}
.model label{font-size: 20px;color: #991c1c;}
.width{width:100px;}
.fileinput-button {position: relative;display: inline-block;overflow: hidden;}
.fileinput-button input{position:absolute;right: 0px;top: 0px;opacity: 0;ms-filter: 'alpha(opacity=0)';}
</style>
<script type="text/javascript">
function addVedio(){
	$('#addmodel').show();
}
function addHidden(){
    $('#addmodel').hide();
}
function add() {
    var $name = $("input[name=title]").val();
    var $pid = $("select[name=category_id]").val();
    var page = '<%= session.getAttribute("page")%>'; 
    if($name == '') {
        alert("文章标题未填写！");
        addVedio();
        return;
    }
    else if($pid == '') {
        alert("文章类型未选择！");
        addVedio();    
        return;
    }
    else{
        $("#addCategory").submit();
    }
}
</script>
</head>
<body>
	<div class="templatemo-content-widget no-padding">
		<div class="templatemo-flex-row flex-content-row  margin-bottom-30 ">
			<button class="templatemo-blue-button " onclick="addVedio()"
				style="margin: 0 auto;">
				<i class="fa-video-camera fa fa-lg "></i> 视频类
			</button>
			<button class="templatemo-blue-button " onclick="toPublishPic()"
				style="margin: 0 auto;">
				<i class="fa-camera-retro fa fa-lg "></i> 图文类
			</button>
		</div>
		<div class="panel panel-default table-responsive ">
			<table class="table table-striped table-bordered templatemo-user-table">
				<thead>
					<tr align="center">
						<td>编号</td>
						<td>文章题目</td>
						<td>文章简介</td>
						<td>发布时间</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list" varStatus="status">
						<tr align="center" valign="middle">
							<td>${status.index+1 }</td>
							<td>${list.title }</td>
							<td>${list.summary }</td>
							<td>${list.releaseDate }</td>
							<td><button class=" edit_btn" onclick="editBtn()" value="${list.id }">
									<i class="fa fa-pencil fa-lg" title="修改"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page-icon">
	        <a class="page-next" onclick="UserMyrelease(${prepage })">上一页</a>
	        <c:forEach var="pages" begin="${start }" end="${end }">
	           <c:if test="${page==pages }">	               
	              <a onclick="UserMyrelease(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
	           </c:if>
	           <c:if test="${page!=pages }">                  
                  <a onclick="UserMyrelease(${pages })">${pages }</a>
               </c:if>
	        </c:forEach>
	        <a class="page-next" onclick="UserMyrelease(${nextpage })">下一页<i></i></a>
		</div>
	</div>
</body>
<div class="modal" id="addmodel">
    <div class="templatemo-content-widget white-bg col-4 model ">
        <i class="fa fa-times" onclick="addHidden()"></i>
        <br>
        <label>视频类文章发布</label>
        <br>
        <div class="table-responsive">
        <form action="addByArticle?id=${page }" class="templatemo-login-form" method="post" id="addCategory" enctype="multipart/form-data">
            <table class="table">
                <tbody>
                    <tr>
                        <td class="width">文章标题：</td>
                        <td><input type="text" class="form-control" placeholder="添加文章标题"
                            name="title"></td>
                    </tr>
                    <tr>
                        <td>文章概要：</td>
                        <td><input type="text" class="form-control" placeholder="添加文章概要"
                            name="summary"></td>
                    </tr>
                    <tr>
                        <td>文章分类：</td>
                        <td>
                            <select name="category_id" class="form-control"  style="width:100%;" id="pid" onchange="pidchange()">
                                 <option value="">请选择文章类型</option>
                                 <c:forEach items="${categorys }" var="parents">
                                     <option value="${parents.id }">${parents.name }</option>
                                 </c:forEach>
                             </select>
                        </td>
                    </tr>
                    <tr>
                        <td>上传文件：</td>
                        <td>
                            <div class="btn btn-success fileinput-button">
	                            <span>上传文件</span>
	                            <input type="file" name="fileToUpload" id="fileToUpload"
	                            class="form-control" data-buttonName="btn-primary"
	                            data-buttonBefore="true" data-icon="false">
	                        </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button id="addate" type="button" class="btn  btn-success addBtn" onclick="add()">发布</button>
        </form>
        </div>
    </div>
</div>
</html>