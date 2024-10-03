package com.watchcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.watchcart.model.User;

public class LoginDao {
	Connection con =null;
	PreparedStatement st=null;
	//Method for authenticate valid user.
	public boolean checkLogin(User user) {
		boolean flag = false;
		con = DbConnection.getConnection();
		try {
			st = con.prepareStatement("select `user_email`,`password` from user where user_email=? && password =?;");
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//Method for getting user details by email and password.
	
	public User getUserByEmailPassword(String email,String password) {
		User user=new User();
		try {
			con = DbConnection.getConnection();
			st= con.prepareStatement("select * from user where user_email=?&&password=?;");
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs= st.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("user_phone"));
				user.setAddress(rs.getString("user_address"));
				user.setUserType(rs.getString("user_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
