package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.student.pojo.SemesterSubjects;
import com.student.pojo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatformTransactionManager pltTxnMgr;
	
	@Override
	public int saveStudent(Student s) {
		TransactionDefinition tsDef = new DefaultTransactionDefinition();
		TransactionStatus txnStatus =  pltTxnMgr.getTransaction(tsDef);
		int insert;
		try {
			String sql = "INSERT INTO STUDENT_DETAILS(std_usn,std_fname,std_mname,std_lname,std_dob,std_doj,std_branch,std_mobile,std_father_name," +
						 " std_mother_name,std_address,std_current_year,std_current_semester) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			saveUser(s);
			
			insert = jdbcTemplate.update(sql, s.getUsn(),s.getFirstName(),s.getMiddleName(),s.getLastName(),s.getDateOfBirth(),s.getDateOfJoin(),s.getBranch(),
					s.getMobile(),s.getFatherName(),s.getMotherName(),s.getAddress(),s.getCurrentYear(),s.getCurrentSemester());
			
			pltTxnMgr.commit(txnStatus);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			pltTxnMgr.rollback(txnStatus);
			throw e;
		}
		return insert;
	}
	
	@Override
	public void saveUser(Student s) throws DataAccessException {
		String sql = "INSERT INTO user(user_id,user_password,user_is_admin) VALUES(?,?,?)";
		jdbcTemplate.update(sql, s.getUsn(), s.getPassword(),"0");		
	}
	
	@Override
	public Student getStudentDetails(String user) {
		// TODO Auto-generated method stub
		Student student;
		String sql = "SELECT * FROM student_details WHERE std_usn = ?";
		try{
			student =  jdbcTemplate.queryForObject(sql,new Object[] { user },
	                new StudentMapper());
	        }catch(EmptyResultDataAccessException ex){
	        	ex.printStackTrace();
	        	return null;
	        }
			return student;
	}
	
	public SemesterSubjects getSemesterSubjects(int semNo, String branch){
		return null;
	}
}

class StudentMapper implements RowMapper<Student> {
	   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Student std = new Student();
	      std.setUsn(rs.getString("std_usn"));
	      std.setFatherName(rs.getString("std_father_name"));
	      std.setMotherName(rs.getString("std_mother_name"));
	      std.setAddress(rs.getString("std_address"));
	      std.setDateOfBirth(rs.getDate("std_dob"));
	      std.setDateOfJoin(rs.getDate("std_doj"));
	      std.setFirstName(rs.getString("std_fname"));
	      std.setLastName(rs.getString("std_lname"));
	      std.setMiddleName(rs.getString("std_mname"));
	      std.setMobile(rs.getString("std_mobile"));
	      std.setBranch(rs.getString("std_branch"));
	      std.setCurrentYear(rs.getInt("std_current_year"));
	      std.setCurrentSemester(rs.getInt("std_current_semester"));
	      return std;
	   }
}
