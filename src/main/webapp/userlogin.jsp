<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validateForm() {
  let x = document.forms["loginForm"]["uname"].value;
  let y = document.forms["loginForm"]["pass"].value;
  if (x == "" ) {
    alert("username cannot be empty");
    return false;
  }
  if (y == "" ) {
    alert("password cannot be empty");
    return false;
 }
}

</script>
</head>
<body>

<h1>User Login Form</h1>
<form name="loginForm" action="validate" onsubmit="validateForm()" method="post" >
	Enter Name : <input type="text" name="uname"><br><br> 
	Enter Password : <input type="password" name="pass"><br><br>
	<input type="submit">
</form>

<p> Don't have an account,<a href="signUp.jsp">click here</a></p>
</body>
</html>
