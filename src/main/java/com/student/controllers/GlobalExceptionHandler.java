package com.student.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.student.exceptions.BookNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private String exceptionPage="exception.jsp";
	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(exceptionPage);
		mv.addObject("ERROR_MSG", "Null Pointer Exception occured." + ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(value=IOException.class)
	public ModelAndView handleIOException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(exceptionPage);
		mv.addObject("ERROR_MSG", "IO Exception occured." + ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(value=SQLException.class)
	public ModelAndView handleSQLException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(exceptionPage);
		mv.addObject("ERROR_MSG", "SQL Exception occured." + ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(value=BookNotFoundException.class)
	public ModelAndView handleBookNotFoundException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(exceptionPage);
		mv.addObject("ERROR_MSG", ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(exceptionPage);
		mv.addObject("ERROR_MSG", "Exception occured." + ex.getMessage());
		return mv;
	}
}
