<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class=" col-1 light-gray-bg">
    <div class="templatemo-top-nav-container">
        <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
                <ul class="text-uppercase">
                    <li class="secondTitle" onclick="UserInfo()" style="cursor: pointer;">个人信息</li>
                    <li class="secondTitle" onclick="UserMyrelease(1)" style="cursor: pointer;">我的发布</li>
                    <li class="secondTitle"><a href="browshistory.html">浏览记录</a></li>
                    <li class="secondTitle" onclick="UserMylike(1)" style="cursor: pointer;">我的点赞</li>
                    <li class="secondTitle"><a href="mycollect.html">我的收藏</a></li>
                    <li class="secondTitle"><a href="myreport.html">我的举报</a></li>

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