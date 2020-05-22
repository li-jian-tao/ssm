<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
	function pidchange(){
		var $pid = $("select[name=parent_id]").val();
	    var $onepid = '<%= session.getAttribute("onepid")%>'; 
		if($pid == '-1'||$pid == $onepid) {
	        $("#pname").attr("type","text");
	    } else {
	    	$("#pname").attr("type","hidden");
		}
	}
	function updateadd(){
		$('#addCategory').attr('action','updateCategory');
        $('#addCategory').submit();
		alert("修改成功");
    }
   function add() {
        var $name = $("input[name=name]").val();
        var $pid = $("select[name=parent_id]").val();
        var $description = $("input[name=description]").val();
        if($name == '') {
            alert("子栏目未填写！");
            addShow();
            return;
        }
        else if($pid == '') {
            alert("父栏目未选择！");
            addShow();    
            return;
        }
        else if($pid == '-1') {
            var $pname = $("input[name=pname]").val();
        }
        var is = '<%= session.getAttribute("isSize")%>'; 
        if(!is){
            alert("所添加的父级栏目超7个");
        } else{
            $("#addCategory").attr("action","addCategory");
            $("#addCategory").submit();
        }
	}
   function updateShow() {
       $('#add').show();
       $('#addate').hide();
       $('#update').show();
       $('#oadd').hide();
       $('#oupdate').show();
	}
    function addShow() {
    	 $("input[name=name]").val('');
         $("select[name=parent_id]").val('');
         $("input[name=description]").val('');
        $('#add').show();
        $('#addate').show();
        $('#update').hide();
        $('#oadd').show();
        $('#oupdate').hide();
    }
    function addHidden() {
        $('#add').hide();
    }
    var err = '<%= session.getAttribute("err")%>'; 
    if(err!="null"){
        alert(err);
    }
</script>
</head>
<body>
<div class="templatemo-content col-1 white-bg">
    <div style="background: #ccc; padding: 1px; border-bottom: 1px #333 solid;">
        <div class="OpTitle">
            <form class="templatemo-search-form" role="search">
                <div class="form-group">
                    <div class="input-group">
                        <button type="submit" class="fa fa-search"></button>
                        <input type="text" class="form-control" placeholder="Search"
                            width="200px;" name="srch-term" id="srch-term">
                    </div>
                    <select class="form-control  selectStyle">
                        <option value="">请选择查询分类</option>
                        <option value="html">一级标题</option>
                        <option value="plain">二级标题</option>
                    </select>
                </div>
            </form>
            <button class="btn  btn-success addBtn" onclick="addShow()">新增</button>
        </div>
    </div>
    <div class="category">
        <div class="panel panel-default table-responsive">
            <table
                class="table table-striped table-bordered templatemo-user-table">
                <thead>
                    <tr align="center">
                        <td>编号</td>
                        <td>栏目名称</td>
                        <td>所属栏目</td>
                        <td>标题描述</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${category }" var="cate" varStatus="status">
                    <tr align="center" valign="middle">
                        <td>${status.index+1 }</td>
                        <td>${cate.name }</td>
                        <td>${cate.cate.name }</td>
                        <td>${cate.description }</td>
                        <td><i class="iconfont icon-edit-1-copy" title="修改" onclick="updateCategory(${cate.id})"></i> <i
                            class="iconfont icon-shanchu" title="删除" onclick="deleteCategory(${cate.id})"></i></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page-icon">
            <a class="page-next" onclick="showAllCategory(${prepage })">上一页</a>
            <c:forEach var="pages" begin="${start }" end="${end }">
                <c:if test="${page==pages }">
                  <a onclick="showAllCategory(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
                </c:if>
                <c:if test="${page!=pages }">
                  <a onclick="showAllCategory(${pages })">${pages }</a>
                </c:if>                
            </c:forEach>
            <a class="page-next" onclick="showAllCategory(${nextpage })">下一页<i></i></a>
        </div>
    </div>
</div>
</body>
<div class="modal" id="add">
    <div class="templatemo-content-widget white-bg col-3 model ">
        <i class="fa fa-times" onclick="addHidden()"></i>
        <br>
        <br>
        <div class="table-responsive">
        <form action="" class="templatemo-login-form" method="post" id="addCategory">
            <input type="hidden" class="form-control" name="id" value="${oneid }">
            <table class="table">
                <tbody>
                    <tr>
                        <td>子栏目：</td>
                        <td><input type="text" class="form-control" placeholder="添加二级栏目"
                            name="name" value="${onename }"></td>

                    </tr>
                    <tr>
                        <td>父栏目：</td>
                        <td>
                            <select name="parent_id" class="form-control"  style="width:100%;" id="pid" onchange="pidchange()">
			                     <option value="">请选择父栏目</option>
			                     <c:forEach items="${categoryParent }" var="parents">
			                         <c:if test="${onepid==parents.id }">
			                             <option value="${parents.id }" selected>${parents.name }</option>
			                         </c:if>
			                         <c:if test="${onepid!=parents.id }">
				                        <option value="${parents.id }">${parents.name }</option>
			                         </c:if>
			                     </c:forEach>
			                     <option value="-1" id="oadd">添加其他父栏目</option>
			                     <option value="${onepid }" id="oupdate">修改当前父栏目：${onepname }</option>
			                 </select>
			                 <input type="hidden" class="form-control" placeholder="输入父栏目" id="pname"
                            name="pname">
                            </td>
                    </tr>
                    <tr>
                        <td>描述：</td>
                        <td><input type="text" class="form-control" placeholder="添加描述"
                            name="description" value="${onedescription }"></td>
                    </tr>
                </tbody>
            </table>
            <button id="addate" type="button" class="btn  btn-success addBtn" onclick="add()">保存</button>
            <button id="update" type="button" class="btn  btn-success addBtn" onclick="updateadd()">修改并保存</button>
        </form>
        </div>
    </div>
</div>
</html>