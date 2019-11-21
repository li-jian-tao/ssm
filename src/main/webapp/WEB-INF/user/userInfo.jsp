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
        <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-red-bg col-2">

                <div class="MyInformation">

                    <form action="userInfo" method="post" enctype="multipart/form-data">
                        <div class="form-group" align="center">
                            <c:if test="${user.image==null }">
                                <img src="../images/bicycle.jpg" alt="Bicycle"
                                    class="img-circle img-thumbnail" width="100" height="100">
                            </c:if>
                            <c:if test="${user.image!=null }">
                                <img src="../${user.image}" alt="Bicycle"
                                    class="img-circle img-thumbnail"  width="100" height="100">
                            </c:if>
                        </div>
                        <div class="form-group">
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

                        <div class="form-group">
                            <label for="signupPhone">头像：</label> <input type="file"
                                name="file" style="width: 130px;"> <font
                                style="color: red;">${msg }</font>
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