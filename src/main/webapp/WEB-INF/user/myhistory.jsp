<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	//点击个人浏览记录，
    $(".box").children("ul").mouseover(function(e){
	    var val = $(".box").children(".act");
	    var left = val.offset().left;
	    var lock = true;
	    if(e.pageX>left&&lock==true){
            $(".box").children(".act").stop(true).animate({left:"120px"});
            lock = true;
        }
	    if(left-val.width()<e.pageX&&e.pageX<left&&lock==true){
	   	  	$(".box").children(".act").stop(true).animate({left:"60px"});
	   	  	lock = true;
		}
	    if(e.pageX<left-val.width()&&lock==true){
            $(".box").children(".act").stop(true).animate({left:"0px"});
            lock = true;
        }
        lock = false;
    })
    $(".box").children("ul").mouseout(function(){
    	$(".box").children(".act").stop(true).animate({left:"120px"});
    })
    
    
})
$("#before").click(function(event){
	var before = $("#before").text();
	UserHistory(before);
	if(event){
		$(".box").children(".act").css("left","0px");
	}
})
$("#center").click(function(event){
    var center = $("#center").text();
    UserHistory(center);
    if(event){
        $(".box").children(".act").css("left","60px");
    }
})
$("#after").click(function(event){
    var after = $("#after").text();
    UserHistory(after);
    if(event){
        $(".box").children(".act").css("left","120px");
    }
})
</script>
<style type="text/css">
.main{
    height: 28px;
    width: 80%;
    margin: 0 auto;
}
.box{
    height: 28px;
    width: 180px;
    background: #3c7f86;
    float:right;
    border-radius: 18px;
    position: relative;
}
.box ul{
    position:absolute;
    top:0px;
    left:0px;
    z-index: 99;
}
.box ul li{
    float: left;
    cursor: pointer;
    font-size: 14px;
    display:block;
    height: 28px;
    width: 60px;
    color: white;
    line-height: 28px;
    text-align: center;
}
.act{
    position:absolute;
    top:0px;
    left:120px;
    height:28px;
    width:60px;
    z-index:10;
    border-radius: 18px;
    background: #9ebfcc;
}
</style>
</head>
<body>
<div class="templatemo-content-widget no-padding">
    <div class="main">
        <div class="box">
            <ul>
	            <li id="after">${after }</li>
	            <li id="center">${center }</li>
	            <li id="before">${before }</li>
	        </ul>
	        <div class="act"></div>
        </div>
    </div>
	<div style="text-align:center">  
	     <img src="../history/${chartURL}" >  
	</div>
</div>
</body>
</html>