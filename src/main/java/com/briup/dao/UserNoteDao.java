package com.briup.dao;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserNote;

@Mapper
public interface UserNoteDao {
	void addByUserNote(UserNote userNote);
}
