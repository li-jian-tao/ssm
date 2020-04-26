
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
		UserMyrelease(1);
	}
	if($('.title').eq(getIndexNum).text().trim()=="资讯管理"){
		$(".templatemo-content").load('manger');
	}
	if($('.title').eq(getIndexNum).text().trim()=="栏目管理"){
		$(".templatemo-content").load('showAllCategory?page=1');
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
			UserMyrelease(1);
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
		if($(this).text().trim()=="资讯管理"){
			$(".templatemo-content").load('manger');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}
		if($(this).text().trim()=="栏目管理"){
			$(".templatemo-content").load('showAllCategory?page=1');
			$(this).addClass("active");
			var num = $(this).index();
			sessionStorage.setItem("tabLiNum",num);
		}

		if($(this).text().trim()=="退出系统"){
			window.location.href='login';
			$(this).addClass("active");
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
function showHot () {
	console.log("ghjk");
	$('.templatemo-content').load('hotShow.html');
	console.log("ghjk");
}

// 点击二级栏目，加载此二级栏目的所有文章
function showArticles(id) {
	$(".showSomething").load('acticleShow?category_id='+id);
}
//点击标题，显示文章详情
function showAllCategory(page) {
	$(".templatemo-content").load('showAllCategory?page='+page);
}
//删除正常咨询管理
function deleteCategory(id){
	$('.templatemo-content').load('deleteCategory?id='+id);
	alert("成功删除");
}
//修改咨询管理
function updateCategory(id){
	$('.templatemo-content').load('findCategory?id='+id);
	setTimeout("updateShow()",100); 
}

//查看举报管理
function checkReport(id,page){
	$(".showSomething3").load('checkReport?id='+id+'&page='+page);
	setTimeout("editBtn3()",100);
}

//查看举报管理
function findReport(id,page){
	$(".showUserinfo").load('findReport?id='+id+'&page='+page);
	setTimeout("editBtn()",100); 
}

// 点击标题，显示文章详情
function showDetail(id) {
	$('.showSomething').load('articleDetail?detail_id='+id);
}
function showDetail2(id) {
	$('.showSomething2').load('articleDetail?detail_id='+id);
}
$("#srch-term").on("keydown", function(event) {
	if(event.keyCode == 13 || event.which == 13) {
		showArticleCheck(1);
	}
});
//点击正常咨询审核
function showArticleCheck(page){
	var id = $("#sel").val();
	var state = $("#state").val();
	var name = $("#srch-term").val();
	if(typeof(id) == "undefined"&&typeof(state) == "undefined"){
		$('.showSomething3').load('showArticleCheck?id=0&state=0&name=0&page='+page);
	} else if(typeof(id) == "undefined"){
		$('.showSomething3').load('showArticleCheck?id=0&state='+state+'&name=0&page='+page);
	} else if(typeof(state) == "undefined"){
		$('.showSomething3').load('showArticleCheck?id='+id+'&state=0&name=0&page='+page);		
	}
	else{
		$('.showSomething3').load('showArticleCheck?id='+id+'&state='+state+'&name='+name+'&page='+page);
	}
}

//点击正常举报审核
function showReportCheck(page){
	var name = $("#srch-term").val();
	$('.showSomething3').load('showReportCheck?name='+name+'&page='+page);
}

//修改正常咨询管理
function updateState(id,st,page){
	var cid = $("#sel").val();
	var state = $("#state").val();
	var name = $("#srch-term").val();
	$('.showSomething3').load('updateArticleManger?id='+id+'&st='+st+'&page='+page+'&cid='+cid+'&state='+state+'&name='+name);
}
//修改举报咨询管理
function updateReportState(id,st,page){
	var name = $("#srch-term").val();
	$('.showSomething3').load('updateArticleManger?id='+id+'&st='+st+'&page='+page+'&name='+name);
}
//点击正常咨询管理
function showArticleManger(){
	$('.showSomething3').load('showArticleManger');
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
//点击个人收藏管理，
function UserMycollection(id){
	$(".showUserinfo").load('showUserCollections?id='+id);
}
//点击个人举报管理，
function UserMyreport(id){
	$(".showUserinfo").load('showUserReports?id='+id);
}
//删除正常短信管理
function deleteNodeDeail(id,page){
	$('.note').css("display","block");
    $('.note_back').css("display","block");
	$('.note').load('deleteNote?id='+id+'&page='+page);
}
