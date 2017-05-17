package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.SemesterDao;
import com.student.dao.StudentDao;
import com.student.dao.TextBook;
import com.student.pojo.SemesterSubjects;
import com.student.pojo.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao stdDao;
	
	@Autowired
	private SemesterDao semDao;
	
	public int saveStudent(Student s){
		return stdDao.saveStudent(s);
	}
	
	public Student getStudentDetails(String userName){
		return stdDao.getStudentDetails(userName);
	}
	
	public List<SemesterSubjects> getSemSubjects(int semNo, String branch){
		return semDao.getSemesterSubjects(semNo, branch);
	}
	
	public List<TextBook> getSubjectTextBook(String subCode){
		return semDao.getSubjectTextBooks(subCode);
	}
}
