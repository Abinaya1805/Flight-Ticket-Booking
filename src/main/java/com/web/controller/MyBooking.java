package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbConnection.DBConnection;

public class MyBooking extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String name= (String) ses.getAttribute("uname");
		if(name!=null) {
			ResultSet rs,rs1;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String user = (String) session.getAttribute("uname");
			out.println("<h1>My Booking Details </h1>");
		
			out.println("<a href='userhome.jsp'>  Back </a><br><br>" );
			Connection con = new DBConnection().getDBConn();
			try {			
				String sql = "select * from booking where username=?";
				 PreparedStatement stmt = con.prepareStatement(sql);
				 stmt.setString(1, user);				 
				 rs = stmt.executeQuery();				 
				 out.println("<table cellspacing='0' width='650px' border='1'>");
		            out.println("<tr>");
		            out.println("<td> Ticket ID </td>");
		            out.println("<td> Ticket Count</td>");
		            out.println("<td> Flight ID </td>");
		            out.println("<td> Flight Name </td>");
		            out.println("<td> From City </td>");
		            out.println("<td> To City </td>");
		            out.println("<td> Time </td>");
		            out.println("<td> Duration </td>");
		            out.println("<td> Ticket </td>");
		            
		            out.println("</tr>");
		            
		            while(rs.next()) {
		            	out.println("<tr>");
		            	out.println("<td>"  + rs.getInt("ticket_id")   +  "</td>");
		                out.println("<td>"  + rs.getString("ticketcount")   +  "</td>"); 
		                out.println("<td>"  + rs.getInt("fid")   +  "</td>");
		                
		                Integer fid = rs.getInt("fid");
		                String flightquery = "select * from flight where fid=?";
		                PreparedStatement pstmt = con.prepareStatement(flightquery);
		                pstmt.setInt(1, fid);
		                rs1 = pstmt.executeQuery();
		               while(rs1.next()) {
			                out.println("<td>"  + rs1.getString("fname")   +  "</td>");  
			                out.println("<td>"  + rs1.getString("fromcity")   +  "</td>");  
			                out.println("<td>"  + rs1.getString("toCity")   +  "</td>");
			                out.println("<td>"  + rs1.getTime("ftime")   +  "</td>");
			                out.println("<td>"  + rs1.getString("duration")   +  "</td>");  
			                out.println("<td>"  + rs1.getString("ticket")   +  "</td>");  
			                out.println("</tr>");
			                }
		            }
		            out.println("</table>");
			}
			catch(Exception e) {
				e.printStackTrace();
				out.println("<font color='red'>  Record Failed   </font>");  
			}
		} 
		else {
			RequestDispatcher req = request.getRequestDispatcher("userlogin.jsp");
			req.forward(request, response);
		}
	}

}
