package com.briup.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.bean.UserCommentary;
import com.briup.bean.UserDown;
import com.briup.bean.UserHistory;
import com.briup.bean.UserLike;
import com.briup.bean.UserNote;
import com.briup.bean.UserNoteRelated;
import com.briup.bean.UserReport;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.ICategoryService;
import com.briup.service.Impl.IUserLikeService;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.service.Impl.IUserCommentaryService;
import com.briup.service.Impl.IUserDownService;
import com.briup.service.Impl.IUserHistoryService;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.CreatePh;
import com.briup.util.dateTime;
import com.briup.util.document;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class ArticleController {
	@Value("${videofile.upload-path}")
	private String path;
	
	@Value("${imgfile.upload-path}")
	private String imgpath;

	@Autowired
	private IArticleService service;
	
	@Autowired
	private ICategoryService cservice;
	
	@Autowired
	private IUserNoteRelatedService usernoterelatedservice;
	
	@Autowired
	private IUserLikeService userlikeservice;
	
	@Autowired
	private IUserCollectionService usercollectionservice;
	
	@Autowired
	private IUserReportService userreportservice;
	
	@Autowired
	private IUserCommentaryService usercommentaryservice;
	
	@Autowired
	private IUserHistoryService userhistoryservice;
	
	@Autowired
	private IUserDownService userdownservice;
	
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
		String name=article.getContent();
		String suffix = name.substring(name.lastIndexOf(".") + 1);
		if(suffix.equals("doc")||suffix.equals("docx")) {			
			List<String> readFileContent = document.readFileContent(path+name);
			session.setAttribute("readFileContent", readFileContent);
			session.setAttribute("type", "doc");
		} else if(suffix.equals("mp4")||suffix.equals("wmv")) {
			session.setAttribute("type", "mp4");
			session.setAttribute("readFileContent", name);
		}
		service.updateByClickTimes(article.getClickTimes(), null, detail_id);
		User user = (User) session.getAttribute("user");
		UserLike userLike = userlikeservice.findByUserLike(user.getId(), article.getId());
		UserCollection userCollection = usercollectionservice.findByUserCollection(user.getId(), article.getId());
		UserReport userReport = userreportservice.findByUserReport(user.getId(), article.getId());
		List<UserCommentary> allUserComment = usercommentaryservice.allUserCommentary(user.getId(),article.getId());
		List<UserHistory> list = userhistoryservice.findHistory(user.getId(), article.getCategory().getId(), article.getId());
		if(list.size()==0) {
			Category category = new Category();
			category.setId(article.getCategory().getId());
			UserHistory userHistory = new UserHistory(user, article, category);
			userhistoryservice.addUserHistory(userHistory);
		}
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
		List<Category> children = cservice.findByCategoryChildren();
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		session.setAttribute("children", children);
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
//		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		service.addByArticle(article,fileToUpload);
		int i = service.selectArticleId();
		System.out.println("序列号"+i);
		UserNoteRelated userNoteRelated = new UserNoteRelated();
		userNoteRelated.setUser(user);
		UserNote userNote = new UserNote();
		userNote.setId(2);
		usernoterelatedservice.addByUserNoteRelated(userNoteRelated,userNote,i);
		session.setAttribute("success", "发布成功");
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
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
		Article article = service.findByArticle(id);
		System.out.println(article);
		UserNoteRelated userNoteRelated = new UserNoteRelated();
		userNoteRelated.setUser(article.getUser());
		service.updateByClickTimes(null, st, id);
		if(st==1) {
			UserNote userNote = new UserNote();
			userNote.setId(3);
			userNoteRelated.setUserNote(userNote);
			usernoterelatedservice.addByUserNoteRelated(userNoteRelated, userNote, id);
		} else if(st==-1) {
			UserNote userNote = new UserNote();
			userNote.setId(4);
			userNoteRelated.setUserNote(userNote);
			usernoterelatedservice.addByUserNoteRelated(userNoteRelated, userNote, id);
		}
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
	
	@PostMapping("/download")
	public String downLoad(String url,Integer aid,
			HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException{
        String temp[]=url.split("/");
        String filename=temp[temp.length-1];
        File file = new File(path+"\\"+filename);
        System.out.println("开始下载"+path+filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
           // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
			boolean paths;
			try {
				paths = CreatePh.processImg(path,filename,imgpath);
				if(paths == true) {
					User user = (User) session.getAttribute("user");
					Article article = new Article();
					article.setId(aid);
					String img = filename.substring(0, filename.lastIndexOf("."));
					UserDown userDown = new UserDown(dateTime.NowDate(), img+".jpg", 0, article, user);
					userdownservice.addByUserDown(userDown);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
	
}
