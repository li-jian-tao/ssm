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
<div class="templatemo-content-widget white-red-bg">
    <h2 style="margin-bottom: 10px; color: #d9534f">
        视频类型资讯发布
        <button class="colse_btn" onclick="colserelese(${page })">
            <i class="fa fa-times-circle fa-lg"></i>
        </button>
    </h2>
    <form action="addByArticle?id=${page }" class="templatemo-login-form" method="post"
        enctype="multipart/form-data">


        <div class="row form-group">
            <div class="col-lg-12  form-group">
                <label class="control-label" for="inputWithSuccess">文章标题</label>
                <input type="text" class="form-control" name="title" id="inputWithSuccess">
            </div>
        </div>
        <div class="row form-group">
            <div class="col-lg-12  form-group">
                <label class="control-label" for="inputWithSuccess">文章摘要</label>
                <input type="text" class="form-control" name="summary" id="inputWithSuccess">
            </div>
        </div>
        <div class="row form-group">
            <div class="col-lg-6 col-md-6 form-group">
                <label class="control-label templatemo-block">文章分类</label> 
                <select class="form-control" name="category_id">
                <c:forEach items="${categorys }" var="cate" begin="11" end="14">
                    <option value="${cate.id }">${cate.name }</option>
                </c:forEach>
                </select>
            </div>
            <div class="col-lg-6">
                <label class="control-label templatemo-block">File
                    Input</label>
                <!-- <input type="file" name="fileToUpload" id="fileToUpload" class="margin-bottom-10"> -->
                <input type="file" name="fileToUpload" id="fileToUpload"
                    class="filestyle" data-buttonName="btn-primary"
                    data-buttonBefore="true" data-icon="false">
            </div>
        </div>

        <div id="editor"></div>
        <div class="form-group text-right">
            <button onclick="addcolserelese(${page })" type="submit" class="templatemo-blue-button">发布</button>
            <button type="reset" class="templatemo-white-button">清空</button>
        </div>
    </form>
</div>
</body>
</html>