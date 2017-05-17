package com.student.dao;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String userId;
	private boolean isAdminUser;
	
	public boolean getIsAdminUser() {
		return isAdminUser;
	}
	public void setIsAdminUser(boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
	
}
