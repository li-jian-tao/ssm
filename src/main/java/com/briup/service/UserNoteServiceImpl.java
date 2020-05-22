package com.briup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserNote;
import com.briup.dao.UserNoteDao;
import com.briup.service.Impl.IUserNoteService;

@Service
public class UserNoteServiceImpl implements IUserNoteService{
	@Autowired
	private UserNoteDao dao;

	@Override
	public void addByUserNote(UserNote userNote) {
		dao.addByUserNote(userNote);
	}

}
