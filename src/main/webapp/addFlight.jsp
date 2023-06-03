<%@ include file="header.jsp"%>
<script>
function validateAddForm() {
  let id = document.forms["addForm"]["id"].value;
  let name = document.forms["addForm"]["name"].value;
  let from = document.forms["addForm"]["from"].value;
  let to = document.forms["addForm"]["to"].value;
  let time = document.forms["addForm"]["time"].value;
  let duration = document.forms["addForm"]["duration"].value;
  let price = document.forms["addForm"]["price"].value;
  if (id==0 || name=="" || from == "" || to=="" || date=="" || time=="" || duration==0 || price==0) {
    alert("All Fields are Mandatorily Filled");
    return false;
  }
}
</script>
<% 
  HttpSession session2 = request.getSession();
String name = (String)session2.getAttribute("name");

if(name!=null){
%>

<div>
<h2> ADD FLIGHT </h2> 
<form name="addForm" action="addFlight" onsubmit="return validateAddForm()" method="post">
	Flight Id* : <input type="number" name='id'><br><br>
	Flight Name* : <input type="text" name='name'><br><br>
	From City* : <input type="text" name='from'><br><br>
	To City* : <input type="text" name='to'><br><br>
	Time* : <input type="time" name='time'><br><br>
	Travel Duration* : <input type="number" name='duration'><br><br>	
	Ticket Price* : <input type="number" name='price'><br><br>
	<input type="submit" value="Add"> 
</form>
</div>
<% 
} else {
	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	rd.forward(request,response);
}
%>
