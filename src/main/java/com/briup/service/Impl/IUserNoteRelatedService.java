package com.briup.service.Impl;

import com.briup.bean.UserNote;
import com.briup.bean.UserNoteRelated;
import com.github.pagehelper.PageInfo;

public interface IUserNoteRelatedService {
	public void addByUserNoteRelated(UserNoteRelated userNoteRelated,UserNote userNote,Integer aid);
	public void addByUserNoteRelatedPack(UserNoteRelated userNoteRelated,UserNote userNote);
	public void addAllUserNoteRelatedPack(UserNote userNote);
	public PageInfo<UserNoteRelated> findByUserNoteRelatedId(Integer uid,Integer page);
	public int UserNoteRelatedSize(Integer uid);
	public UserNoteRelated findByUserNoteId(Integer id);
	public UserNoteRelated findByUserNoteAndArtcle(Integer unid,Integer aid,Integer uid);
	public void updateByNoteState(int nid);
	public void deleteNote(Integer nid); 
}
