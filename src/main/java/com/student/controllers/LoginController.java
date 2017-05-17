package com.student.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.User;
import com.student.pojo.Student;
import com.student.services.LoginService;
import com.student.services.StudentService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	StudentService stdService;
	
	@Autowired
	User user;
	
	@Autowired
	Student std;
	
	@RequestMapping("getLoginPage")
	public String getLoginPage(){
		return "login.jsp";
	}
	
	 @RequestMapping("logout")
     public String logout(HttpServletRequest request){
         HttpSession httpSession = request.getSession();
         httpSession.invalidate();
         return "redirect:/";
     }
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("usn")String usn, @RequestParam("password")String pw,
			HttpSession session){
		ModelAndView mv = new ModelAndView();
		if(usn.isEmpty() || pw.isEmpty()){
			mv.addObject("ErrorMsg", "USN/Password cannot be empty");
			mv.setViewName("login.jsp");
			return mv;
		}
		
		user = loginService.doLogin(usn, pw);
		if(user == null){
			mv.addObject("ErrorMsg", "User Doesn't Exist,Contact Admin Dept");
			mv.setViewName("login.jsp");
			return mv;
		}
		session.setAttribute("user", user);
		mv.setViewName("home.jsp");
		System.out.println("IS ADMIN? " + user.getIsAdminUser());
		if(user.getIsAdminUser() == true){
			mv.setViewName("adminhome.jsp");
		}else{
			std = stdService.getStudentDetails(user.getUserId());
		}
		mv.addObject("user", user);
		
		mv.addObject("student", std);
		return mv;
		
	}
	
	@RequestMapping("home")
	public ModelAndView getHomePage(@RequestParam("user")String usn){
		ModelAndView mv = new ModelAndView();
		/*user = loginService.getUser(usn);
		mv.addObject("user", user);*/
		if(usn.equalsIgnoreCase("admin")){
			mv.setViewName("adminhome.jsp");
		}else{
			std = stdService.getStudentDetails(user.getUserId());
			mv.addObject("student", std);
			mv.setViewName("home.jsp");
		}
		return mv;
	}
	
	/*@ModelAttribute
	public void addAttribute(Model model,@RequestParam("usn")String usn, @RequestParam("password")String pw){
		System.out.println("add Attribute Called");
		user = loginService.doLogin(usn, pw);
		model.addAttribute("user", user);
	}*/
}


