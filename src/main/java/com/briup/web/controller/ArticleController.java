package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.bean.UserComment;
import com.briup.bean.UserCommentary;
import com.briup.bean.UserLike;
import com.briup.bean.UserReport;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUseLikeService;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.service.Impl.IUserCommentService;
import com.briup.service.Impl.IUserCommentaryService;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.document;
import com.github.pagehelper.PageInfo;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService service;
	
	@Autowired
	private IUseLikeService userlikeservice;
	
	@Autowired
	private IUserCollectionService usercollectionservice;
	
	@Autowired
	private IUserReportService userreportservice;
	
	@Autowired
	private IUserCommentaryService usercommentaryservice;
	
	@RequestMapping("showHotArticle")
	public String showHotArticle(
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByHotArticle();
		session.setAttribute("list", list);
		return "user/hotArticle";
	}

	@RequestMapping("acticleShow")
	public String acticleShow(Integer category_id, 
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByCategoryId(category_id);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}

	@RequestMapping("findArticlesByTitle")
	public String acticleLike1(String title,
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByArticleTitle(title);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}
	
	@RequestMapping("findArticlesByNickname")
	public String acticleLike2(String nickname,
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByArticleAuthor(nickname);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}
	
	@RequestMapping("articleDetail")
	public String articleDetail(Integer detail_id,
			HttpSession session,HttpServletRequest request) {
		Article article = service.findByArticle(detail_id);
		String path="G:\\v\\video\\";
		int index = article.getContent().indexOf(".");
		String newStr = article.getContent().substring(index + 1);
		document document = new document();
		if(newStr.equals("doc")) {
			System.out.println("doc");
			List<String> readFileContent = document.readFileContent(path+article.getContent());
			session.setAttribute("readFileContent", readFileContent);
		} else if(newStr.equals("img")||newStr.equals("mp4")||newStr.equals("wmv")){
			System.out.println("wmv");
			String newpath = path+article.getContent();
			session.setAttribute("path", newpath);
		}
		service.updateByClickTimes(article.getClickTimes(), detail_id);
		User user = (User) session.getAttribute("user");
		UserLike userLike = userlikeservice.findByUserLike(user.getId(), article.getId());
		UserCollection userCollection = usercollectionservice.findByUserCollection(user.getId(), article.getId());
		UserReport userReport = userreportservice.findByUserReport(user.getId(), article.getId());
		List<UserCommentary> allUserComment = usercommentaryservice.allUserCommentary(user.getId(),article.getId());
		session.setAttribute("userLike", userLike);
		session.setAttribute("userCollection", userCollection);
		session.setAttribute("userReport", userReport);
		session.setAttribute("article", article);
		session.setAttribute("format", newStr);
		session.setAttribute("userComment", allUserComment);
		return "user/articleDetail";
	}
	
	@RequestMapping("showUserArticles")
	public String showUserArticles(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/myrelease";	
	}
	
	@RequestMapping("addByArticle")
	public String addByArticle(Article article,Integer id,Integer category_id,MultipartFile fileToUpload,
			HttpSession session,HttpServletRequest request) throws Exception {
		User user = (User) session.getAttribute("user");
		Category category = new Category();
		category.setId(category_id);
		article.setUser(user);
		article.setCategory(category);
		service.addByArticle(article,fileToUpload);
		String fileName = fileToUpload.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "redirect:/showUserArticles?id="+id;
	}
	
}
