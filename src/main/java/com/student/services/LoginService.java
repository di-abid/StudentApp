package com.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.LoginDao;
import com.student.dao.User;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	
	public User doLogin(String usn, String pw){
		return loginDao.doLogin(usn, pw);
	}
	
	public User getUser(String usn){
		return loginDao.getUser(usn);
	}
}
