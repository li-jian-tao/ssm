
$(function(){
	// 加载 indexContent页面
	var getIndexNum = sessionStorage.getItem("tabLiNum");
	$('.title').eq(getIndexNum).addClass('active').siblings().removeClass('active');
	if($('.title').eq(getIndexNum).text().trim()=="主页"){
		$(".templatemo-content").load('indexContent');
	}
	if($('.title').eq(getIndexNum).text().trim()=="资讯栏目"){
		$(".templatemo-content").load('showCategory');
	}
	if($('.title').eq(getIndexNum).text().trim()=="热门文章"){
		$(".templatemo-content").load('showHotArticle');
	}

	if($('.title').eq(getIndexNum).text().trim()=="个人管理"){
		$(".templatemo-content").load('showUserInfo');
	}
	if($('.title').eq(getIndexNum).text()=="资讯管理"){
		$(".templatemo-content").load('admin/categoryMangar.jsp');
	}
	if($('.title').eq(getIndexNum).text()=="栏目管理"){
		$(".templatemo-content").load('admin/categoryMangar');
	}

	if($('.title').eq(getIndexNum).text().trim()=="退出系统"){
		window.location.href='login';
		$(this).addClass("active");
		var num = $(this).index();
		sessionStorage.setItem("tabLiNum",num);
	}
	$('.title').click(function(){
		// 移除所有标签的active
		$('.title').removeClass("active");
		
		if($(this).text().trim()=="主页"){
			$(".templatemo-content").load('indexContent');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
		if($(this).text().trim()=="资讯栏目"){
			$(".templatemo-content").load('showCategory');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
		if($(this).text().trim()=="热门文章"){
			$(".templatemo-content").load('showHotArticle');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}

		if($(this).text().trim()=="个人管理"){
			$(".templatemo-content").load('showUserInfo');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
		if($(this).text()=="资讯管理"){
			$(".templatemo-content").load('admin/categoryMangar.jsp');
			$(this).addClass("active");

		}
		if($(this).text()=="栏目管理"){
			$(".templatemo-content").load('admin/categoryMangar');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}

		if($(this).text().trim()=="退出系统"){
			window.location.href='login';
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
	});
	
	$('.mobile-menu-icon').click(function(){
		$('.templatemo-left-nav').slideToggle();				
	});
	
	// 按照资讯作者或者资讯标题 查找资讯，模糊查询
	$(document).on("keydown", function(event) {
		// 回车查询
		if(event.keyCode == 13 || event.which == 13) {
			// console.log("进入回车登录");
			// 获取下拉列表中选择内容：按作者/按名称
			var $type = $("#selectStyle").val();
			// 获取用户输入内容
			var $value = $("#search").val();
			
			// 如果按作者查询，并且输入了查询内容
			if($type == 'nickname' && $value != '') {
				$('.showSomething').load('findArticlesByNickname?nickname=' + $value);
			}
			// 如果按标题查询，并且输入了查询内容
			if($type == 'title' && $value != '') {
				console.log("标题模糊查询");
				$('.showSomething').load('findArticlesByTitle?title=' + $value);
			}
		}
	});
	
});
//function report(id){
//	location.reload('index');
//}
function toPublishPic(){
	$('.templatemo-content-container').load('publishpicture');
}
function toPublishVid(){
	$('.templatemo-content-container').load('publishvideo');
}
function colserelese (id) {
	$('.templatemo-content-container').load('showUserArticles?id='+id);
}
/*function addcolserelese (id) {
	$('.templatemo-content-container').load('addByArticle?id='+id);
}*/
function showHot () {
	console.log("ghjk");
	$('.templatemo-content').load('hotShow.html');
	console.log("ghjk");

}

// 点击二级栏目，加载此二级栏目的所有文章
function showArticles(id) {
	$(".showSomething").load('acticleShow?category_id='+id);
}
// 点击标题，显示文章详情
function showDetail (id) {
	$('.showSomething').load('articleDetail?detail_id='+id);
}
// 点击个人信息管理，
function UserInfo(){
	$(".showUserinfo").load('userinfo');
}
// 点击个人发布管理，
function UserMyrelease(id){
	$(".showUserinfo").load('showUserArticles?id='+id);
}
//点击个人点赞管理，
function UserMylike(id){
	$(".showUserinfo").load('showUserLikes?id='+id);
}
