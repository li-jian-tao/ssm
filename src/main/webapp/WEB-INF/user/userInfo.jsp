<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.fileInputContainer{position:relative;}
.fileInput{overflow: hidden;width:100px;height:100px;
    position:absolute;
    top:0px;
    right:0px;
    opacity: 0;
    filter:alpha(opacity=0);
    cursor:pointer;
}
.cercle{width:100px;height:100px;border-radius: 50%;}
.imgstyle{height:100px;width:100px;}
</style>
<script type="text/javascript">
$("#file").change(function(){
    var objUrl = getObjectURL(this.files[0]) ;
    if (objUrl){
      $(".img-circle").attr("src", objUrl);
    }
});
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) {
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined){
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) {
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}
</script>

</head>
<body>

    <div class="templatemo-content-container">
        <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-red-bg col-2">
                <div class="MyInformation">
                    <form action="userInfo" method="post" enctype="multipart/form-data">
                        <div class="form-group" align="center">
	                        <div class="cercle fileInputContainer">   
	                            <c:if test="${user.image==null }">
	                                <img src="../images/bicycle.jpg" alt="Bicycle" 
	                                    class="img-circle img-thumbnail imgstyle" width="100" height="100">
	                            </c:if>
	                            <c:if test="${user.image!=null }">
	                                <img src="../${user.image}" alt="Bicycle"
	                                    class="img-circle img-thumbnail imgstyle"  width="100" height="100">
	                            </c:if>
	                            <input class="fileInput" id="file" type="file" name="file"> 
                            </div> 
                        </div>
                        <div class="form-group ">
                            <label for="signupName">昵称：</label> <input type="text"
                                name="nickname" class="form-control" id="signinInputName"
                                value="${user.nickname }">
                        </div>
                        <div class="form-group">
                            <label for="signupPhone">帐号：</label> <input type="text"
                                readonly="readonly" name="account" class="form-control"
                                id="signupPhone" value="${user.account }">
                        </div>
                        <div class="form-group">
                            <label for="signupPassword">密码：</label> <input type="password"
                                name="password" class="form-control" id="signupPassword"
                                value="${user.password }">
                        </div> 
                        <input class="btn btn-info save" type="submit" value="保存">
                    </form>
                </div>
                <!-- 注册结束 -->

            </div>


        </div>

    </div>


</body>
</html>