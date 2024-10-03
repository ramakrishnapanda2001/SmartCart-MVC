package com.watchcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.watchcart.model.User;

public class RegisterDao {
	Connection con = DbConnection.getConnection();
	public boolean addUser(User user) {
		boolean flag = false;
		try {
			PreparedStatement st = con.prepareStatement("insert into user(user_name,user_email,password,user_phone,user_address) values(?,?,?,?,?)");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getPhone());
			st.setString(5, user.getAddress());
			
			if(st.executeUpdate()==1) {
				flag=true;
			}else {
				System.out.println("User not inserted");
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
}
