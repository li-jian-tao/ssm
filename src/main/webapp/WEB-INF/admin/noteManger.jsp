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

     <div class="templatemo-top-nav-container">
         <div class="row">
             <nav class="templatemo-top-nav col-lg-12 col-md-12">
                 <ul class="text-uppercase">
                     <li class="active secondTitle" onclick="">编辑信息</li>
                     <li class="secondTitle" onclick="">系统信息</li>

                 </ul>
             </nav>
         </div>
     </div>
    <div class="showSomething3">
        <div class="MyInformation" style="padding: 40px 100px;">
             <form action="addUserNote" method="post" id="sendText">
                 <div class="form-group ">
                     <label for="signupName">短信主题：</label> <input type="text"
                         name="notetitle" class="form-control" id="ntitle"
                         >
                 </div>
                 <div class="form-group">
                     <label for="signupPhone">编辑内容：</label> 
                     <input type="hidden" name="notecontent" id="ncontent" value="">
                     <script id="editor" type="text/plain" style="width:100%;height:200px;margin: 0 auto;"></script>
                 </div>
                 <button id="send" type="button" class="btn  btn-success addBtn" onclick="getContent()">发送</button>
             </form>
         </div>
         <!-- 注册结束 -->
         

    </div>
</div>
     <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
        var content = UE.getEditor('editor').getContent();
        $('#ncontent').val(content);
        $('#sendText').submit();
    }
 
</script>
</body>
</html>