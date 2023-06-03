<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
  HttpSession session2 = request.getSession();
String uname = (String)session2.getAttribute("uname");

if(uname!=null){
%>
<font color="red">
<p>We regret to say that there is no seats available !</p></font>
</body>
</html>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");
	rd.forward(request,response);
}
%>
