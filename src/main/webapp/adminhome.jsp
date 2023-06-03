
<%@ include file="header.jsp"%>

<% 
  HttpSession session2 = request.getSession();
String name = (String)session2.getAttribute("name");

if(name!=null){
%>
<div><h2>Hello Admin</h2></div>
<div><h3>Welcome to the Flight Booking System</h3></div>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	rd.forward(request,response);
}
%>




