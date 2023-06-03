package com.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.DBConnection;

public class SignupValidation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String)request.getParameter("name");
		String username =(String) request.getParameter("username");
		String password = (String)request.getParameter("password");
		String mobile = (String)request.getParameter("mobile");
		String email = (String)request.getParameter("email");
		Connection con = new DBConnection().getDBConn();
		try {
			String query = "Insert into User values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, mobile);
			stmt.setString(5, email);
			
			int executeUpdate = stmt.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("Added Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("Not Added :(");
			}
		} 
		catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}
