<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var getTNum = sessionStorage.getItem("tNum");
if($('.secondTitle').eq(getTNum).text().trim()=="我的发布"){
    $(".showUserinfo").load('showUserArticles?id=1');
}

</script>
</head>
<body>
<div class=" col-1 light-gray-bg">
    <div class="templatemo-top-nav-container">
        <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
                <ul class="text-uppercase">
                    <li class="secondTitle" onclick="UserInfo()" style="cursor: pointer;">个人信息</li>
                    <li class="active secondTitle" onclick="UserMyrelease(1)" style="cursor: pointer;">我的发布</li>
                    <li class="secondTitle" onclick="UserHistory()" style="cursor: pointer;">浏览记录</li>
                    <li class="secondTitle" onclick="UserMylike(1)" style="cursor: pointer;">我的点赞</li>
                    <li class="secondTitle" onclick="UserMycollection(1)" style="cursor: pointer;">我的收藏</li>
                    <li class="secondTitle" onclick="UserMyreport(1)" style="cursor: pointer;">我的举报</li>
                    <li class="secondTitle" onclick="UserMydown(1)" style="cursor: pointer;">我的下载</li>

                </ul>
            </nav>
        </div>
    </div>
    <div class="templatemo-content-container">
        <div class="showUserinfo">
   
	    </div>
	</div>
</div>
</body>
</html>