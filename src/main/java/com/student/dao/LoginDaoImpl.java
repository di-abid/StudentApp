package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public User doLogin(String usn, String pw) {
		// TODO Auto-generated method stub
		/*String sql1 = "SELECT * FROM USER WHERE user_id = '" + usn + "' AND user_password='"+ pw +"'";
		
		SqlRowSet set = jdbcTemplate.queryForRowSet(sql1);
		if(set.next()){
			System.out.println("Is Admin : " + set.getBoolean("user_is_admin"));
		 }*/
		
		String sql = "SELECT * FROM USER WHERE user_id = ? AND user_password = ?";
		System.out.println("Query" + sql);
		User user;
        try{
		user =  jdbcTemplate.queryForObject(sql,new Object[] { usn,pw },
                new UserMapper());
        }catch(EmptyResultDataAccessException ex){
        	ex.printStackTrace();
        	return null;
        }
		return user;
	}
	
	public User getUser(String usn) {
		// TODO Auto-generated method stub
		/*String sql1 = "SELECT * FROM USER WHERE user_id = '" + usn + "' AND user_password='"+ pw +"'";
		
		SqlRowSet set = jdbcTemplate.queryForRowSet(sql1);
		if(set.next()){
			System.out.println("Is Admin : " + set.getBoolean("user_is_admin"));
		 }*/
		
		String sql = "SELECT * FROM USER WHERE user_id = ?";
		System.out.println("Query" + sql);
		User user;
        try{
		user =  jdbcTemplate.queryForObject(sql,new Object[] { usn},
                new UserMapper());
        }catch(EmptyResultDataAccessException ex){
        	ex.printStackTrace();
        	return null;
        }
		return user;
	}
}

	class UserMapper implements RowMapper<User> {
	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User user = new User();
	      user.setUserId(rs.getString("user_id"));
	      user.setIsAdminUser(rs.getBoolean("user_is_admin"));
	      
	      return user;
	   }
	}
