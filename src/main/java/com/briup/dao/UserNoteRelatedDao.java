package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserNoteRelated;

@Mapper
public interface UserNoteRelatedDao {
	void addByUserNoteRelated(UserNoteRelated userNoteRelated);
	void addByUserNoteRelatedPack(UserNoteRelated userNoteRelated);
	void addAllUserNoteRelatedPack(UserNoteRelated userNoteRelated);
	List<UserNoteRelated> findByUserNoteRelatedId(Integer uid);
	List<UserNoteRelated> UserNoteRelatedSize(Integer state,Integer uid);
	UserNoteRelated findByUserNoteId(Integer id);
	UserNoteRelated findByUserNoteAndArtcle(Integer unid,Integer aid,Integer uid);
	void updateByNoteState(int state,int nid);
	void deleteNote(Integer nid); 
}
