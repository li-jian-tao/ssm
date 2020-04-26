package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserNote;
import com.briup.bean.UserNoteRelated;
import com.briup.dao.ArticleDao;
import com.briup.dao.UserNoteRelatedDao;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.util.dateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserNoteRelatedServiceImpl implements IUserNoteRelatedService{

	@Autowired
	private UserNoteRelatedDao dao;
	
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public void addByUserNoteRelated(UserNoteRelated userNoteRelated,UserNote userNote,Integer aid) {
		User other = new User();
		other.setId(1);
		Article article = new Article();
		article.setId(aid);
		dateTime dateTime = new dateTime();
		userNoteRelated.setUserNote(userNote);
		userNoteRelated.setOther(other);
		userNoteRelated.setState(0);
		userNoteRelated.setArticle(article);
		userNoteRelated.setNoteDate(dateTime.NowDate());
		dao.addByUserNoteRelated(userNoteRelated);
	}

	@Override
	public PageInfo<UserNoteRelated> findByUserNoteRelatedId(Integer uid,Integer page) {
		PageHelper.startPage(page,4);
		System.out.println(uid);
		List<UserNoteRelated> list = dao.findByUserNoteRelatedId(uid);
		PageInfo<UserNoteRelated> pageInfo = new PageInfo<UserNoteRelated>(list);
		return pageInfo;
	}

	@Override
	public int UserNoteRelatedSize(Integer uid) {
		List<UserNoteRelated> size = dao.UserNoteRelatedSize(0, uid);
		return size.size();
	}

	@Override
	public UserNoteRelated findByUserNoteId(Integer id) {
		UserNote userNote = new UserNote();
		UserNoteRelated userNoteRelated = dao.findByUserNoteId(id);
		String content = userNoteRelated.getUserNote().getContent();
		Article article = userNoteRelated.getArticle();
		System.out.println(article);
		if(article!=null) {
			Article findByArticle = articleDao.findByArticle(article.getId());
			String title = findByArticle.getTitle();
			StringBuilder stringBuilder = new StringBuilder(content);
			int index=stringBuilder.indexOf("文章");
			stringBuilder.insert(index+2,"《"+title+"》");
			String co = ""+stringBuilder;
			userNote.setTitle(userNoteRelated.getUserNote().getTitle());
			userNote.setContent(co);
			userNoteRelated.setUserNote(userNote);
		}
		return userNoteRelated;
	}

	@Override
	public void addByUserNoteRelatedPack(UserNoteRelated userNoteRelated,
			UserNote userNote) {
		User other = new User();
		other.setId(1);
		dateTime dateTime = new dateTime();
		userNoteRelated.setUserNote(userNote);
		userNoteRelated.setOther(other);
		userNoteRelated.setState(0);
		userNoteRelated.setNoteDate(dateTime.NowDate());
		dao.addByUserNoteRelatedPack(userNoteRelated);
	}

	@Override
	public UserNoteRelated findByUserNoteAndArtcle(Integer unid, Integer aid,Integer uid) {
		UserNoteRelated noteAndArtcle = dao.findByUserNoteAndArtcle(unid, aid, uid);
		return noteAndArtcle;
	}

	@Override
	public void updateByNoteState(int nid) {
		dao.updateByNoteState(1, nid);
	}

	@Override
	public void deleteNote(Integer nid) {
		dao.deleteNote(nid);
	}

}
