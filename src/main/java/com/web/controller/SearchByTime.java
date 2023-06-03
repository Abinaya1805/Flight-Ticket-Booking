package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class SearchByTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminname= (String) session.getAttribute("uname");
		if(adminname!=null) {
			ResultSet rs;

			String timeParam = request.getParameter("time").trim();
			DateFormat formatter = new SimpleDateFormat("HH:mm");
			Time timeValue = null;
			try {
				timeValue = new java.sql.Time(formatter.parse(timeParam).getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<include src='.header.jsp'></include>");
			out.println("<h1>Flight Details </h1>");
		
			out.println("<a href='bookings.jsp'>  Back </a><br><br>" );
			try {
				Connection con = new DBConnection().getDBConn();
				String sql = "select * from booking where booked_time =? ";
				 PreparedStatement stmt = con.prepareStatement(sql);
				 stmt.setTime(1, timeValue);
				 rs = stmt.executeQuery();
				 
				 out.println("<table cellspacing='0' width='650px' border='1'>");
		            out.println("<tr>");
		            out.println("<td> Ticket ID </td>");
		            out.println("<td> Flight ID </td>");
		            out.println("<td> User Name </td>");		     
		            out.println("<td> Ticket Count </td>");
		            out.println("<td> Booked Time </td>");		        
		            out.println("</tr>");
		            
		            while(rs.next()) {
		            	out.println("<tr>");
		                out.println("<td>"  + rs.getInt("ticket_id")   +  "</td>");
		                out.println("<td>"  + rs.getString("fid")   +  "</td>");  
		                out.println("<td>"  + rs.getString("username")   +  "</td>");  
		                out.println("<td>"  + rs.getString("ticketcount")   +  "</td>");
		                out.println("<td>"  + rs.getTime("booked_time")   +  "</td>");
		                
		                out.println("</tr>");
		            }
		            out.println("</table>");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				out.println("<font color='red'>  Record Failed   </font>");  
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("home.jsp");
			req.forward(request, response);
		}
	}
}
