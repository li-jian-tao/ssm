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

<div class="templatemo-content col-1 white-bg">

    <div class="demo">
        <nav class="navbar navbar-default navbar-mobile bootsnav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navbar-menu">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav" data-in="fadeInDown"
                    data-out="fadeOutUp">
                    <c:forEach items="${category }" var="cate">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                    data-toggle="dropdown">${cate.name }</a>
	                    <ul class="dropdown-menu">
	                       <c:forEach items="${cate.cates }" var="cates">
	                        <li onclick="showArticles(${cates.id })"><a href="#">${cates.name}</a></li>
	                        </c:forEach>
	                    </ul>
                    </li>
                    </c:forEach>                
                </ul>
            </div>
        </nav>
    </div>

    <div class=" col-1 white-bg">
        <div style="height: 50px;">
            <!-- <form class="templatemo-search-form" role="search"> -->
                <div class="form-group">

                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search"
                            width="200px;" name="search-name" id="search">
                    </div>
                    <select class="form-control  selectStyle" id="selectStyle">
                        <option value="">请选择查询分类</option>
                        <option value="nickname">按作者</option>
                        <option value="title">按标题</option>
                    </select>
                </div>
            <!-- </form> -->
        </div>
        
        <div class="showSomething">
            <div class="templatemo-content-widget orange-bg marginStyle">
            </div>
        </div> 
        
    </div>
</div>

</body>
</html>