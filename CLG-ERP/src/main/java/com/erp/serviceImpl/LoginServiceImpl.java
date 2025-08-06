package com.erp.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erp.model.User;
import com.erp.service.LoginService;

@Repository
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void saveUser(User user) {
	    String sql = "INSERT INTO users (first_name,middle_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, user.getFirstName());
	        stmt.setString(2, user.getMiddleName());
	        stmt.setString(3, user.getLastName());
	        stmt.setString(4, user.getEmail());
	        stmt.setString(5, user.getPassword());
	        stmt.setString(6, "student"); 
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error saving user", e);
	    }
	}
	
	

}
