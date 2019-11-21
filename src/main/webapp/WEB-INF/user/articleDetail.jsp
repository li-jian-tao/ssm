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
<div class="templatemo-content-container">
    <div class="panel panel-default no-border">

        <div class="articleTitle">
            <div onclick="colse()"> <i class="fa fa-times" style="position: unset;background: #ed5f5f;"></i></div>
            <h2>${article.title }</h2>
            <div class="articleMsg">
                <span class="badge">原创</span>
                <span style="align-content: center;">${article.user.nickname }  ${article.releaseDate }</span>
                <div class="articleOp">
                    <!-- 向右浮动 -->
                    <i class="fa fa-exclamation-triangle fa-lg report_btn fa-2x" style="cursor: pointer;"></i>
                    <i class="fa fa-heart fa-lg fa-2x" style="cursor: pointer;"></i> 
                    <i class="fa fa-thumbs-up  fa-lg fa-2x" style="cursor: pointer;"></i> 
                </div>
            </div>

        </div>
        <div class="panel-body white-red-bg">

            <div id="ArticleDetails">
                <div align="center">
                    <img src="images/indexnews.jpg">
                </div>

                <div style="font-size: 18px; text-indent: 2em; margin-top: 2em;">
                    ${article.content }
                </div>
            </div>


        </div>
    </div>
    <c:if test="${userReport.state==0||userReport==null }">
    <!-- 举报模态框 -->
    <div class="modal report">
        <div class="templatemo-content-widget white-bg col-2 model">
            <i class="fa fa-times" onclick="modelHidden()"></i>
            <div class="table-responsive">
                <form action="addUserReportState">
                    <input type="hidden" name="articleId" value="${article.id }">
                    <div class="form-group">
                        <input type="checkbox" name="box" value="抄袭">抄袭，内容并非原创
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="box" value="暴力">暴力，内容具有暴力元素
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="box" value="色情">色情，内容含有污秽思想
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="box" value="反动">反动，不符合中国治安法
                    </div>
                    <div class="form-group has-error ">
                        <textarea class="form-control" name="content" rows="5" cols="20" style="width: 100%;resize:none;"></textarea>
                    </div>
                    <div class="form-group">
                        <input onclick="report(${article.id })" class="btn btn-info" type="submit" value="举报" style="float: right;">
                    </div>
                </form>
            </div>
        </div>
    </div>
    </c:if>
</div>
<script src="js/jquery-1.11.0.min.js"></script>
<script>
    // 举报模态框
    $('.report_btn').click(function() {
        $('.report').show();
    });
    function colse(){
        $(".showSomething").load('acticleShow?category_id='+${article.category.id });
    }
    // 文档对象加载完成后
    $(function() {
        // 如果点赞状态为1，说明是点赞状态，设置颜色
        if("${userLike.state}" == 1) {
            $(".fa-thumbs-up").css("color", "#f89c19");
        } 
        // 如果收藏状态为1，说明是收藏状态，设置颜色
        if("${userCollection.state}" == 1) {
            $(".fa-heart").css("color", "red");
        } 
        // 如果举报状态为1，说明是举报状态，设置颜色
        if("${userReport.state}" == 1) {
            $(".fa-exclamation-triangle").css("color", "yellow");
        } 
    });
    
    // 点赞按钮被点击时
    $(".fa-thumbs-up").click(function() {
        // 如果当前点赞状态为null，说明从未被点赞。null 变 1
        if("${userLike.state}" == "") {
            $('.showSomething').load('addUserLikeState?articleId=' + ${article.id});
        }
        
        // 如果当前点赞状态为1，说明已点赞。1 变 2
        if("${userLike.state}" == "1") {
            $('.showSomething').load('changeUserLikeState?state=2&articleId=' + ${article.id});
        }
        // 如果当前点赞状态为2，说明点赞后取消。2 变 1
        if("${userLike.state}" == "2") {
            $('.showSomething').load('changeUserLikeState?state=1&articleId=' + ${article.id});
        }
    });

    // 收藏按钮被点击时
    $(".fa-heart").click(function() {
        // 如果当前收藏状态为null，说明从未被收藏。null 变 1
        if("${userCollection.state}" == "") {
            $('.showSomething').load('addUserCollectionState?articleId=' + ${article.id});
        }
        
        // 如果当前收藏状态为1，说明已点赞。1 变 2
        if("${userCollection.state}" == "1") {
            $('.showSomething').load('changeUserCollectionState?state=2&articleId=' + ${article.id});
        }
        // 如果当前收藏状态为2，说明点赞后取消。2 变 1
        if("${userCollection.state}" == "2") {
            $('.showSomething').load('changeUserCollectionState?state=1&articleId=' + ${article.id});
        }
    });
    
    
</script>
</body>
</html>