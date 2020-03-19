package com.briup.web.controller;

import java.util.List;
import java.util.Map;

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
import com.briup.bean.UserCommentary;
import com.briup.bean.UserLike;
import com.briup.bean.UserReport;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.ICategoryService;
import com.briup.service.Impl.IUseLikeService;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.service.Impl.IUserCommentaryService;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.document;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService service;
	
	@Autowired
	private ICategoryService cservice;
	
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
		document document = new document();
		List<String> readFileContent = document.readFileContent(path+article.getContent());
		session.setAttribute("readFileContent", readFileContent);
		service.updateByClickTimes(article.getClickTimes(), null, detail_id);
		User user = (User) session.getAttribute("user");
		UserLike userLike = userlikeservice.findByUserLike(user.getId(), article.getId());
		UserCollection userCollection = usercollectionservice.findByUserCollection(user.getId(), article.getId());
		UserReport userReport = userreportservice.findByUserReport(user.getId(), article.getId());
		List<UserCommentary> allUserComment = usercommentaryservice.allUserCommentary(user.getId(),article.getId());
		session.setAttribute("userLike", userLike);
		session.setAttribute("userCollection", userCollection);
		session.setAttribute("userReport", userReport);
		session.setAttribute("article", article);
		session.setAttribute("userComment", allUserComment);
		return "user/articleDetail";
	}
	
	@RequestMapping("showUserArticles")
	public String showUserArticles(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
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
		String fileName = fileToUpload.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		service.addByArticle(article,fileToUpload);
		if(suffix.equals("doc")||suffix.equals("docx")) {
			session.setAttribute("msg", "发布成功");
		} else {
			session.setAttribute("msg", "上传的文件类型有误");
		}
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "index";
	}
	
	@RequestMapping("manger")
	public String manger(HttpSession session) {
		PageInfo<Article> pageInfo = service.AllArticle(0, 0, null, 1);
		List<Category> categorys = cservice.findByCategorys();
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, 1, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", 1);
		session.setAttribute("list", pageInfo.getList());
		session.setAttribute("cid", 0);
		session.setAttribute("state", 0);
		session.setAttribute("categorys", categorys);
		return "admin/manger";
	}
	
	@RequestMapping("showArticleCheck")
	public String showArticleCheck(Integer id,Integer state,String name,Integer page,
			HttpSession session,HttpServletRequest request) {
		if(name.equals("0")) {
			name=null;
		}
		PageInfo<Article> pageInfo = service.AllArticle(id, state, name,page);
		List<Category> categorys = cservice.findByCategoryChildren();
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", page);
		session.setAttribute("list", pageInfo.getList());
		session.setAttribute("categorys", categorys);
		session.setAttribute("cid", id);
		session.setAttribute("state", state);
		return "admin/articleCheck";
	}
	
	@RequestMapping("updateArticleManger")
	public String updateArticleManger(Integer id,Integer st,Integer page,Integer cid,Integer state,String name,
			HttpSession session,HttpServletRequest request) {
		service.updateByClickTimes(null, st, id);
		if(cid==null) {
			List<UserReport> list = userreportservice.findByUserReportArticleId(id);
			for (UserReport userReport : list) {
				userreportservice.updateByProcess(userReport,st);
			}
			return "redirect:/showReportCheck?name="+name+"&page="+page;
		} else {
			return "redirect:/showArticleCheck?id="+cid+"&state="+state+"&name="+name+"&page="+page;
		}
	}
	
}
