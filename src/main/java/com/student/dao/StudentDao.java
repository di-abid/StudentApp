package com.student.dao;

import com.student.pojo.Student;

public interface StudentDao {
	public int saveStudent(Student s);
	public void saveUser(Student s);
	public Student getStudentDetails(String user);
}
