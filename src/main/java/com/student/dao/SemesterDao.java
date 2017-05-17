package com.student.dao;

import java.util.List;

import com.student.pojo.SemesterSubjects;

public interface SemesterDao {
	public List<SemesterSubjects> getSemesterSubjects(int semNo, String branch);

	public List<TextBook> getSubjectTextBooks(String subCode);
}
