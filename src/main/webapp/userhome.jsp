
<%@ include file="userheader.jsp"%>



<% 
  HttpSession session2 = request.getSession();
String uname = (String)session2.getAttribute("uname");

if(uname!=null){
%>
<div><h2>Hello User </h2></div>
<div><h3>Welcome to the Flight Booking System !!!</h3></div>

</html>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
	rd.forward(request,response);
}
%>
