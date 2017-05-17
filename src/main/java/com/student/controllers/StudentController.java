package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.TextBook;
import com.student.exceptions.BookNotFoundException;
import com.student.pojo.SemesterSubjects;
import com.student.pojo.Student;
import com.student.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService stdService;
	
	@RequestMapping("addStudent")
	public String getAddStudentPage(){
		return "addStudent.jsp";
	}
	
	@RequestMapping("updateStudent")
	public String getUpdateStudentPage(){
		return "updateStudent.jsp";
	}
	
	
	@RequestMapping(value="saveStudent", method=RequestMethod.POST)
	public ModelAndView saveStudentDetails(@ModelAttribute("student") Student student,BindingResult result){
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()){
			mv.setViewName("addStudent.jsp");
			System.out.println("Has Binding errors");
			return mv;
		}
		System.out.println("Inside saveStudentDetails...");
		int insertVal = stdService.saveStudent(student);
		
		if(insertVal > 0){
			mv.addObject("StatusMessage", "Student Details Saved Successfully..");
		}else{
			mv.addObject("StatusMessage", "Error occured while saving student details..");
		}
		mv.setViewName("addStudent.jsp");
		return mv;
	}
	
	@RequestMapping("getSemSubjects")
	public @ResponseBody ModelAndView getSemesterSubjects(@RequestParam("currentSem")int currSem,@RequestParam("branch") String branch){
		ModelAndView mv = new ModelAndView();
		System.out.println("Semester : " + currSem+ ",Branch : " + branch);
		List<SemesterSubjects> ss = stdService.getSemSubjects(currSem, branch);
		
		for(SemesterSubjects s : ss){
			System.out.println("sem no : " + s.getSemNo());
		}
		System.out.println("list "  + ss);
		mv.addObject("SemSubjects", ss);
		mv.setViewName("semSubjects.jsp");
		return mv;
	}
	
	@RequestMapping("getSubTextBooks")
	public @ResponseBody ModelAndView getSubjectTextBooks(@RequestParam("subjectCode") String subCode) throws BookNotFoundException{
		
		List<TextBook> books = stdService.getSubjectTextBook(subCode);
		if(books == null || books.isEmpty()){
			throw new BookNotFoundException(subCode);
		}
		return new ModelAndView("subjectTextBook.jsp", "subjectTextBooks", books);
	}
	
	@RequestMapping("getBookDetails")
	public @ResponseBody ModelAndView getBookDetails(){
		System.out.println("In book details........");
		return new ModelAndView("bookdetail.jsp");
	}
	
	@RequestMapping("getStudentDetails")
	public ModelAndView getStudent(@RequestParam("usn")String usn){
		ModelAndView mv = new ModelAndView();
		Student st = stdService.getStudentDetails(usn);
		mv.addObject("student", st);
		System.out.println("USN:" + usn);
		mv.setViewName("updateStudent.jsp");
		return mv;
	}
	
	
	
}
