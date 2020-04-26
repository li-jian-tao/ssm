<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function nodeDeail(id,page){
	 $('.note').css("display","block");
     $('.note_back').css("display","block");
     $('.note').load('showUserNoteDetail?id='+id+'&page='+page);
}
</script>
</head>
<body>
<i class="fa fa-times" onclick="close0()"></i>
    <div class="note_main">
        <div class="head">
            <div class="title">
                <a>短信通知</a>
                <button type="button" value="">全部已读</button>
                <button type="button" value="">全部未读</button>
            </div>
        </div>
        <div class="content">
            <c:forEach items="${userNoteRelated }" var="userNoteRelated">
            <div class="line">
	            <div onclick="nodeDeail(${userNoteRelated.id },${page })">
	                <div class="img">
	                    <img alt="" src="${userNoteRelated.other.image }">
	                    <c:if test="${userNoteRelated.state==0 }">
	                        <a class="state">未读</a>
	                    </c:if>
	                </div>
	                <div class="tit">
	                    <p>${userNoteRelated.userNote.title }</p>
	                </div>
	                <div class="date">
	                    <p>日期：${userNoteRelated.noteDate }</p>
	                </div>
	            </div>
                <div class="bu">
                    <button type="button" onclick="deleteNodeDeail(${userNoteRelated.id },${page })">删除</button>
                    <button type="button" value="">标记未读</button>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="page-icon">
        <a class="page-next" onclick="note(${prepage })">上一页</a>
        <c:forEach var="pages" begin="${start }" end="${end }">
            <c:if test="${page==pages }">
              <a onclick="note(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
            </c:if>
            <c:if test="${page!=pages }">
              <a onclick="note(${pages })">${pages }</a>
            </c:if>                
        </c:forEach>
        <a class="page-next" onclick="note(${nextpage })">下一页<i></i></a>
    </div>
</body>
</html>