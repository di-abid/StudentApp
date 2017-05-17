package com.student.pojo;

import org.springframework.stereotype.Component;

@Component
public class SemesterSubjects {
	private int semNo;
	private String branch;
	private String subject;
	private String subjectCode;
	
	
	/**
	 * @return the subjectCode
	 */
	public String getSubjectCode() {
		return subjectCode;
	}
	/**
	 * @param subjectCode the subjectCode to set
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	/**
	 * @return the semNo
	 */
	public int getSemNo() {
		return semNo;
	}
	/**
	 * @param semNo the semNo to set
	 */
	public void setSemNo(int semNo) {
		this.semNo = semNo;
	}
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
