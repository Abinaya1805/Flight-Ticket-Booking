<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>

function validateTime() {
	  
	  let y = document.forms["timeform"]["time"].value;
	  if (y == "" ) {
	    alert("Kindly enter Time to search");
	    return false;
	 }
	}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="userhome.jsp">back</a>
<% 
  HttpSession session2 = request.getSession();
String uname = (String)session2.getAttribute("uname");

if(uname!=null){
%>
<h2>Search Flights based on Time</h2>
<form name="timeform" action="flightsByTime">
Enter Time : <input type='time' name ="time"><br><br>
<input type="submit">
</form>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
	rd.forward(request,response);
}
%>
</body>
</html>