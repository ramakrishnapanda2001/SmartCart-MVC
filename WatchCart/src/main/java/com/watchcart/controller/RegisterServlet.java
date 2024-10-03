package com.watchcart.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchcart.dao.RegisterDao;
import com.watchcart.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	public void init() {
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String address = req.getParameter("addressbox");
		
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setAddress(address);
		
		RegisterDao rdao = new RegisterDao();
		
		if(rdao.addUser(user)==true) {
			req.setAttribute("message","User added Successfully");
		}
		
		
	}
	public void destroy() {
		
	}
}
