package com.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class BookTickets extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String name= (String) ses.getAttribute("uname");
		if(name!=null) {
			String uname = request.getParameter("uname");
			Integer fid = Integer.parseInt(request.getParameter("fid"));
			Integer ticketcount = Integer.parseInt(request.getParameter("tcount"));
			String timeParam = request.getParameter("time");
			DateFormat formatter = new SimpleDateFormat("HH:mm");
			Time timeValue = null;
			
			try {
				timeValue = new java.sql.Time(formatter.parse(timeParam).getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			Integer[] current = new Integer[2];
			getcurrentAvailable(fid,current);
			Integer currAvailabe = current[0];
	        Integer currBooked = current[1];
	        
	        if(currAvailabe>0 && currBooked<60 && currAvailabe-ticketcount>=0 && currBooked+ticketcount<=60) {
	        	addBooking(uname,fid,ticketcount,timeValue); 
	    		updateFlights(fid,ticketcount,current);
	    		RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
	        	rd.forward(request, response); 
	        }
	        else {
	        	RequestDispatcher rd = request.getRequestDispatcher("overflow.jsp");
	        	rd.forward(request, response); 
	        }
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("userlogin.jsp");
			req.forward(request, response);
		}
	}
	public static void addBooking(String uname,Integer fid,Integer ticketcount,Time timeValue) {
		Connection con = new DBConnection().getDBConn();
		try {
			String query = "Insert into booking(fid,username,ticketcount,booked_time) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, fid);
			stmt.setString(2, uname);
			stmt.setInt(3, ticketcount);
			stmt.setTime(4, timeValue);
			stmt.executeUpdate();
		} 
		catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	public static void updateFlights(Integer fid,Integer count,Integer[] current)  {
		
		        Connection connection = new DBConnection().getDBConn();
		        String sql = "UPDATE flight SET available = ?, booked = ? WHERE fid = ?";
		        getcurrentAvailable(fid,current);
		        Integer currAvailabe = current[0];
		        Integer currBooked = current[1];
		        Integer newAvailable = currAvailabe-count;
		        Integer newBooking = currBooked+count; 
		        try (
		             PreparedStatement statement = connection.prepareStatement(sql)) {

		            statement.setInt(1, newAvailable);
		            statement.setInt(2,newBooking );
		            statement.setInt(3, fid);  

		            int rowsAffected = statement.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println("Table updated successfully.");
		            } else {
		                System.out.println("No rows updated.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		public static void getcurrentAvailable(Integer fid,Integer[] current) {
			Connection conn = new DBConnection().getDBConn();
			String query = "select available,booked from flight where fid=?";
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, fid);
				ResultSet rs = ps.executeQuery();
			
				if(rs.next()) {
					current[0] = rs.getInt(1);  //available
					current[1] = rs.getInt(2);  //booked
					
				}
				else {
					System.out.println("result set is empty");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			

	}

}
