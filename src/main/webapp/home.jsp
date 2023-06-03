<html>
<head>
<script>
function validateForm() {
  let x = document.forms["myForm"]["uname"].value;
  let y = document.forms["myForm"]["pass"].value;
  if (x == "" || y=="") {
    alert("Kindly fill all the fields");
    return false;
  }
}
</script>
</head>
<body>
<h2>Welcome to Admin Login !!!</h2>
<h5>*Login to access Admin Portal </h5>
<form name="myForm" action="getAdmin" onsubmit="return validateForm()" method="post" >
	 Name :      
	<input type="text" name="uname"><br><br>
	 password :
	<input type="password" name="pass"><br><br>
	<input type="submit">  
</form>

</body>
</html>


