package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DBConnection;

public class Delete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		String name= (String) ses.getAttribute("uname");
		if(name!=null) {
			response.setContentType("text/html");
			PrintWriter out =  response.getWriter();
			String id = request.getParameter("id");
			PreparedStatement pstmt;
			try {
				Connection con = new DBConnection().getDBConn();
				pstmt = con.prepareStatement("delete from flight where fid=?");
				pstmt.setString(1, id);
				out.println("<font color='green'>  Record Deleted   </font>");
				 
			}
			catch (SQLException ex) {
		          System.out.println(ex.getMessage());
	            out.println("<font color='red'>  Deletion Failed   </font>");
	
	       }
		}
		else {
        	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        	rd.forward(request, response); 
        }
	}

}
