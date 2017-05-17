package com.student.dao;

public interface LoginDao {
	public User doLogin(String usn, String pw);

	public User getUser(String usn);
}
