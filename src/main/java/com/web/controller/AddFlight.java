package com.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DBConnection;

public class AddFlight extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminname= (String) session.getAttribute("uname");
		if(adminname!=null) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String from = request.getParameter("from");
			String to = request.getParameter("to");		
			Float duration = Float.parseFloat(request.getParameter("duration"));
			Double price = Double.parseDouble(request.getParameter("price"));
			
			String timeParam = request.getParameter("time").trim();
			DateFormat formatter = new SimpleDateFormat("HH:mm");
			Time timeValue = null;
			try {
				timeValue = new java.sql.Time(formatter.parse(timeParam).getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			Connection con = new DBConnection().getDBConn();
			try {
				String query = "Insert into flight(fid,fname,fromcity,tocity,ftime,duration,ticket) values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setString(3, from);
				stmt.setString(4, to);
				stmt.setTime(5, timeValue);
				stmt.setFloat(6, duration);
				stmt.setDouble(7, price);
				int executeUpdate = stmt.executeUpdate();
				if(executeUpdate>0) {
					RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp");
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
		else {
			RequestDispatcher req = request.getRequestDispatcher("home.jsp");
			req.forward(request, response);
		}
	}

}
