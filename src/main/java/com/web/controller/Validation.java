package com.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DBConnection;

public class Validation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		
		Connection con = new DBConnection().getDBConn();
		String query = "select * from User where username=? and password=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();	
			if(rs.next()) {			
				request.setAttribute("uname", uname);
				HttpSession session = request.getSession(true);
				session.setAttribute("uname", uname);
				RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);		
			}
			else {
				String errorMessage = "Invalid username or password";
	            request.setAttribute("error", errorMessage); 
				RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");			
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
