<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function close1(page){
     $('.note').css("display","block");
     $('.note_back').css("display","block");
     $('.note').load('showUserNote?page='+page);
}
</script>
</head>
<body>
    <div class="note_main">
        <i class="fa fa-times" onclick="close1(${page })"></i>
        <div class="head">
            <div class="title dtitle">
                <h1>${userNoteRelated.userNote.title }</h1>
                <br>
                <br>
                <p>发布时间： ${userNoteRelated.noteDate }</p>
            </div>
        </div>
        <c:if test="${userNoteRelated.user.nickname==null }">
            <div class="content dcontent">
	            ${userNoteRelated.userNote.content }
	            <div style="float: right;width:250px;height: 80px;">
                    <p>${userNoteRelated.other.nickname }</p>
                    <p>日期：${changeDate }</p>
                </div>
	        </div>
        </c:if>
        <c:if test="${userNoteRelated.user.nickname!=null }">
	        <div class="content dcontent">
	            <p>尊敬的 ${userNoteRelated.user.nickname }，你好：</p>
	            <p style="text-indent:2em;">${userNoteRelated.userNote.content }</p>
	            <div style="float: right;width:250px;height: 80px;">
		            <p>${userNoteRelated.other.nickname }</p>
		            <p>日期：${changeDate }</p>
	            </div>
	        </div>
	    </c:if>
    </div>
</body>
</html>