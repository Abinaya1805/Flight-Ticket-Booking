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

public class viewFlights extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminname= (String) session.getAttribute("uname");
		if(adminname!=null) {
			ResultSet rs;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<include src='.header.jsp'></include>");
			out.println("<h1>Flight Details </h1>");
		
			out.println("<a href='adminhome.jsp'>  Back </a><br><br>" );
			try {
				Connection con = new DBConnection().getDBConn();
				String sql = "select * from flight";
				 Statement stmt = con.createStatement();
				 rs = stmt.executeQuery(sql);
				 out.println("<table cellspacing='0' width='650px' border='1'>");
		            out.println("<tr>");
		            out.println("<td> Flight ID </td>");
		            out.println("<td> Name </td>");
		            out.println("<td> From City </td>");
		            out.println("<td> To City </td>");
		            out.println("<td> Time </td>");
		            out.println("<td> Duration </td>");
		            out.println("<td> Ticket </td>");
		            out.println("<td> Available </td>");
		            out.println("<td> Booked </td>");
		            out.println("<td> Delete </td>");
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
		               
		                out.println("<td>"  + "<a href='Delete?id=" +  rs.getString("fid")  + "'> Delete </a>" + "</td>");
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
