package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbConnection.DBConnection;

public class AvailableFlight extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("uname");
		if(user!=null) {
			ResultSet rs;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<include src='.header.jsp'></include>");
			out.println("<h1>Flight Details </h1>"); 
			out.println("<a href='userhome.jsp'>  Back </a><br><br>" );
			try {
				Connection con = new DBConnection().getDBConn();
				String sql = "select * from flight";
				 Statement stmt = con.createStatement();
				 rs = stmt.executeQuery(sql);
				 out.println("<table cellspacing='0' width='650px' border='1'>");
		            out.println("<tr>");
		            out.println("<td> <b>Flight ID</b> </td>");
		            out.println("<td> <b>Name </b></td>");
		            out.println("<td> <b>From City</b>  </td>");
		            out.println("<td> <b>To City</b>  </td>");
		            out.println("<td> <b>Time</b> </td>");
		            out.println("<td> <b>Duration</b>  </td>");
		            out.println("<td> <b>Ticket </b> </td>");
		            out.println("<td> <b>Available</b>  </td>");
		            out.println("<td> <b>Booked</b>  </td>");
		            
		            out.println("</tr>");
		            
		            while(rs.next()) {
		            	out.println("<tr>");
		                out.println("<td>"  + rs.getInt("fid")   +  "</td>");
		                out.println("<td>"  + rs.getString("fname")   +  "</td>");  
		                out.println("<td>"  + rs.getString("fromcity")   +  "</td>");  
		                out.println("<td>"  + rs.getString("toCity")   +  "</td>");
		                out.println("<td>"  + rs.getTime("ftime")   +  "</td>");
		                out.println("<td>"  + rs.getString("duration")   +  "</td>");  
		                out.println("<td>"  + rs.getString("ticket")   +  "</td>");  
		                out.println("<td>"  + rs.getInt("available")   +  "</td>");  
		                out.println("<td>"  + rs.getInt("booked")   +  "</td>");  
		               
		                out.println("</tr>");
		            }
		            out.println("</table>");
		            out.println("<h5>note : the maximum seat capacity is 60</h5>");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				out.println("<font color='red'>  Record Failed   </font>");  
			}
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("userlogin.jsp");
			req.forward(request, response);
		}
	}
}
