<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎光临看点资讯</title>

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
            var $nickname = $("input[name=nickname]").val();
            var $account = $("input[name=account]").val();
            var $password = $("input[name=password]").val();
            var $repwd = $("input[name=repwd]").val();
            if($nickname == '') {
                alert("昵称不能为空！");
                return;
            }
            if($account == '') {
                alert("账号不能为空！");
                return;
            }
            if($password == '') {
                alert("密码不能为空！");
                return;
            }
            if($repwd == '') {
                alert("确认密码不能为空！");
                return;
            }
            if($password != $repwd) {
                alert("两次密码不一致！");
                return;
            }
            $('form').submit();
        });
    });
</script>


</head>
<body class="light-gray-registerbg">
    <div
        style="float: left; margin-top: 10%; margin-left: 15%; width: 30%;">
        <div
            class="templatemo-content-widget templatemo-login-widget white-bg">
            <header class="text-center">
                <!-- <div class="square"></div> -->
                <h1>新用户注册</h1>
                <font style="color:red;">${msg }</font>
            </header>
            <div style="color: red;font-size:14px;margin-bottom: 10px; " align="center"></div>
            <form action="userRegister" class="templatemo-login-form" method="post">
            
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-user fa-fw"></i>
                        </div>
                        <input type="text" class="form-control" placeholder="请输入昵称" name="nickname">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-user fa-fw"></i>
                        </div>
                        <input type="text" class="form-control" placeholder="请输入账号" name="account">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-eye-slash fa-fw"></i>
                        </div>
                        <input type="password" class="form-control" placeholder="请输入密码" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-eye-slash fa-fw"></i>
                        </div>
                        <input type="password" class="form-control" placeholder="请确认密码" name="repwd">
                    </div>
                </div>
                
                <div class="form-group">
                    <input type="button" class="templatemo-green-button width-100"
                        value="注册">
                </div>
            </form>
        </div>
        <div
            class="templatemo-content-widget templatemo-login-widget templatemo-register-widget white-bg">
            <p>
                已有账号? <strong><a href="login" class="green-text">去登录!</a></strong>
            </p>
        </div>
    </div>
</body>
</html>