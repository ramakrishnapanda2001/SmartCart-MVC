package com.watchcart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchcart.dao.LoginDao;
import com.watchcart.model.User;

@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		LoginDao ldao = new LoginDao();
//		if(ldao.checkLogin(user)) {
//			try {
//				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
//				rd.forward(req, res);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//		}else {
//			req.setAttribute("message", "Invalid Email or Password");
//			RequestDispatcher rd = req.getRequestDispatcher("login_page.jsp");
//			try {
//				rd.include(req, res);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//		}
		user = ldao.getUserByEmailPassword(email, password);
//		System.out.println(user.toString());
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("current-user", user);
		
		if(ldao.checkLogin(user) && user.getUserType().equals("admin")) {
			try {
				res.sendRedirect("AdminPannel.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(ldao.checkLogin(user) && user.getUserType().equals("normal")) {
			try {
				res.sendRedirect("Home.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("message", "The requested user is not found");
			RequestDispatcher rd = req.getRequestDispatcher("login_page.jsp");
			try {
				rd.include(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
