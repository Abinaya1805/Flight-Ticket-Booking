<%@ include file="userheader.jsp"%>
<script>
function validateForm() {
	  let x = document.forms["bookingForm"]["uname"].value;
	  let y = document.forms["bookingForm"]["fid"].value;
	  if (x == "" ) {
	    alert("username cannot be empty");
	    return false;
	  }
	  if (y == "" ) {
	    alert("Kindly enter Flight ID");
	    return false;
	 }
	}

</script>
<body>
<% 
  HttpSession session2 = request.getSession();
String uname = (String)session2.getAttribute("uname");

if(uname!=null){
%>
<h2>Ticket Booking</h2>
<p>Kindly refer the availability of flights <u><a href="available"> here </a></u></p>
<form method ="post" action="bookTickets" name="bookingForm" onsubmit="return validateForm()">
Enter UserName : <input type="text" name="uname"><br><br>
Enter FlightID : <input type="text" name="fid"><br><br>
Enter Number of Tickets : <input type="number" name="tcount"><br><br>
Enter Current Time : <input type="time" name="time"><br><br>
<input type="submit" value="Book Ticket"> 

</form>
</body>
</html>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
	rd.forward(request,response);
}
%>
