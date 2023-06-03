<%--
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
 --%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("userid");
	String driver = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "Admin";
	String userid = "root";
	String password = "ayanibA@1805";
	try {
		Class.forName(driver);
		} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
%>
<!DOCTYPE html>
<html>
<body>

<h1>Flight Details : </h1>
<table border="1">
<tr>
<td>Flight ID</td>
<td>Name</td>
<td>From City</td>
<td>To city</td>
<td>Time</td>
<td>Duration</td>
<td>Ticket</td>
<td>Action</td>
</tr>
<%
try{
	connection = DriverManager.getConnection(connectionUrl+database, userid, password);
	statement=connection.createStatement();
	String sql ="select * from flight";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
%>
<tr>
	<td><%=resultSet.getInt("fid") %></td>
	<td><%=resultSet.getString("fname") %></td>
	<td><%=resultSet.getString("fromcity") %></td>
	<td><%=resultSet.getString("tocity") %></td>
	<td><%=resultSet.getTime("ftime") %></td>
	<td><%=resultSet.getInt("duration") %></td>
	<td><%=resultSet.getInt("ticket") %></td>
	<td>
		<form action="delRow">
		<input type="text" name="fid" hidden=true value="<% resultSet.getInt("fid"); %>" />
		<input type="submit" value="Delete" />
		</form>
	</td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

</body>
</html>