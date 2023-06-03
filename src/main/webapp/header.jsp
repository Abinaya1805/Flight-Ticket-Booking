<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<style>
nav {
    background-color: #fff;
    border: 1px solid #dedede;
    border-radius: 4px;
    box-shadow: 0 2px 2px -1px rgba(0, 0, 0, 0.055);
    color: #888;
    display: block;
    margin: 8px 22px 8px 22px;
    overflow: hidden;
    width: 100%; 
    margin: 0;
    padding: 0;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
}

li {
  float: left;
}
a { text-decoration: none;
color : inherit; }
li a {
  display: block;
  padding: 8px;
  background-color: #dddddd;
}
</style>
</head>
<body>
<ul>
  <li><a href="adminhome.jsp">Home</a></li>
  <li><a href="addFlight.jsp">Add Flight</a></li>
  <li><a href="viewFlights">Flight List</a></li>
  <li><a href="bookings.jsp">Bookings</a></li> 
</ul>

</body>
</html>