<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validateFlight() {
  let x = document.forms["flightform"]["fid"].value;
  if (x == "" ) {
    alert("Kindly enter Flight ID to search");
    return false;
  }
}
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
<% 
  HttpSession session2 = request.getSession();
String uname = (String)session2.getAttribute("uname");

if(uname!=null){
%>
<a href="adminhome.jsp">back</a>
<h2>Search Bookings based on Flight Number</h2>
<form name="flightform" action="searchByFlight" onsubmit="return validate()">
Enter Flight Number : <input type='number' name ="fid"><br><br>
<input type="submit">
</form>
<h2>Search Bookings based on Time</h2>
<form name="timeform" action="searchByTime">
Enter Time : <input type='time' name ="time"><br><br>
<input type="submit">
</form>
</body>
</html>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
	rd.forward(request,response);
}
%>
