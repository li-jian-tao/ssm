<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎光临大学生资讯平台</title>

<link
    href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700'
    rel='stylesheet' type='text/css'>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/templatemo-style.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("input[type=button]").click(function() {
            var $account = $("input[name=account]").val();
            var $password = $("input[name=password]").val();
            if($account == '') {
                alert("账号不能为空！");
                return;
            }
            if($password == '') {
                alert("密码不能为空！");
                return;
            }
            $('form').submit();
        });
    });
    
    // 键盘点击事件
    $(document).keypress(function(event) {
        // 回车事件
        if(event.keyCode == 13 || event.which == 13) {
            // 触发 登录 被点击
            $("input[type=button]").trigger("click");
        }
    });
    
</script>

</head>
<body class="light-gray-loginbg">
    <div
        style="float: right; margin-top: 10%; margin-right: 5%; width: 30%;">
        <div
            class="templatemo-content-widget templatemo-login-widget white-bg">
            <header class="text-center">
                <!-- <div class="square"></div> -->
                <h1>大学生资讯平台登录</h1>
                <font style="color:red;">${ms }</font>
            </header>
            <div style="color: red; font-size: 14px; margin-bottom: 10px;"
                align="center"></div>

            <form action="userLogin" method="post" class="templatemo-login-form">
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-users fa-fw"></i>
                        </div>
                        <input type="text" class="form-control" placeholder="请输入账号" name="account">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-key fa-fw"></i>
                        </div>
                        <input type="password" class="form-control" placeholder="请输入密码" name="password">
                    </div>
                </div>
                <div class="form-group">

                    <input type="checkbox" id="c1" name="cc" /> <label for="c1"><span></span>Remember
                        me</label>

                </div>
                <div class="form-group">
                    <input type="button" class="templatemo-blue-button width-100"
                        value="Login">
                </div>
            </form>
        </div>
        <div
            class="templatemo-content-widget templatemo-login-widget templatemo-register-widget white-bg">
            <p>
                还没有账号? <strong><a href="register" class="blue-text">去注册!</a></strong>
            </p>
        </div>
    </div>
</body>
</html>