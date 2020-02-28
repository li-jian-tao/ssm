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
	<!-- Main content -->

	<div class="templatemo-content-widget no-padding">
		<div class="templatemo-flex-row flex-content-row  margin-bottom-30 ">

			<button class="templatemo-blue-button " onclick="toPublishVid()"
				style="margin: 0 auto;">
				<i class="fa-video-camera fa fa-lg "></i> 视频类
			</button>

			<button class="templatemo-blue-button " onclick="toPublishPic()"
				style="margin: 0 auto;">
				<i class="fa-camera-retro fa fa-lg "></i> 图文类
			</button>

		</div>
		<div class=".templatemo-content-container"></div>

		<div class="panel panel-default table-responsive ">


			<table
				class="table table-striped table-bordered templatemo-user-table">

				<thead>
					<tr align="center">
						<td>编号</td>
						<td>文章题目</td>
						<td>文章简介</td>
						<td>发布时间</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list" varStatus="status">
						<tr align="center" valign="middle">
							<td>${status.index+1 }</td>
							<td>${list.title }</td>
							<td>${list.summary }</td>
							<td>${list.releaseDate }</td>
							<td><button class=" edit_btn" onclick="editBtn()" value="${list.id }">
									<i class="fa fa-pencil fa-lg" title="修改"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="page-icon">
	        <a class="page-next" onclick="UserMyrelease(${prepage })">上一页</a>
	        <c:forEach var="pages" begin="${start }" end="${end }">
	           <c:if test="${page==pages }">	               
	              <a onclick="UserMyrelease(${pages })" style="color:#fff;background: #61ae82;">${pages }</a>
	           </c:if>
	           <c:if test="${page!=pages }">                  
                  <a onclick="UserMyrelease(${pages })">${pages }</a>
               </c:if>
	        </c:forEach>
	        <a class="page-next" onclick="UserMyrelease(${nextpage })">下一页<i></i></a>
		</div>
	</div>
	<!-- 注册结束 -->
</body>
</html>