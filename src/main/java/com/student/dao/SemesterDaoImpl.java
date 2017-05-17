package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.pojo.SemesterSubjects;

@Repository
public class SemesterDaoImpl implements SemesterDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
 	@Override
 	public List<SemesterSubjects> getSemesterSubjects(int semNo, String branch){  
 		 return jdbcTemplate.query("select * from semester_subjects where sem_no = " + semNo +" AND sem_branch='" + branch +"'"
 				 ,new SemesterSubjectExtractor());  
 	}  
 	
 	public List<TextBook> getSubjectTextBooks(String subCode){  
		 return jdbcTemplate.query("select * from subject_textbooks where txt_sub_code = '" + subCode +"'"
				 ,new ResultSetExtractor<List<TextBook>>() {

					@Override
					public List<TextBook> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
						List<TextBook> list=new ArrayList<TextBook>();  
			        while(rs.next()){  
			        	TextBook  tb =new TextBook();  
			        	tb.setSubCode(rs.getString("txt_sub_code"));
			        	tb.setIsbn(rs.getString("txt_isbn"));
			        	tb.setBookName(rs.getString("txt_book_name"));
			        	tb.setBookAuthor(rs.getString("txt_book_author"));
			        	list.add(tb);  
			        }  
			        return list; 
			}
				});  
	} 
}

class SemesterMapper implements RowMapper<SemesterSubjects> {
	   public SemesterSubjects mapRow(ResultSet rs, int rowNum) throws SQLException {
		  SemesterSubjects ss = new SemesterSubjects();
	     ss.setSemNo(rs.getInt("sem_no"));
	     ss.setBranch(rs.getString("sem_branch"));
	      ss.setSubject(rs.getString("sem_subject"));
	     return ss;
	   }
}

class SemesterSubjectExtractor implements ResultSetExtractor<List<SemesterSubjects>>{

	@Override
	public List<SemesterSubjects> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<SemesterSubjects> list=new ArrayList<SemesterSubjects>();  
	        while(rs.next()){  
	        	SemesterSubjects ss=new SemesterSubjects();  
	        	ss.setSemNo(rs.getInt("sem_no"));
	        	ss.setBranch(rs.getString("sem_branch"));
	  	      	ss.setSubject(rs.getString("sem_subject"));
	  	      	ss.setSubjectCode(rs.getString("sem_sub_code"));
	        	list.add(ss);  
	        }  
	        return list; 
	}
	
	class SubjectTextBookExtractor implements ResultSetExtractor<List<TextBook>>{

		@Override
		public List<TextBook> extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			List<TextBook> list=new ArrayList<TextBook>();  
		        while(rs.next()){  
		        	TextBook  tb =new TextBook();  
		        	tb.setSubCode(rs.getString(""));
		        	tb.setSubCode(rs.getString(""));
		        	tb.setSubCode(rs.getString(""));
		        	tb.setSubCode(rs.getString(""));
		        	list.add(tb);  
		        }  
		        return list; 
		}	
	}
}
