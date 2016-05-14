<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 	import = "org.akhila.cloudservices.rest.model.User"   
    
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login and Register to Order Management</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body background ="background.png">

	<%
			User user = (User)session.getAttribute("user");
			if(user!=null){ %>
		
		    <h2><font color="white">Welcome <% out.print(user.getFullname()); %>!!</font></h2>
		    
		    <a href="Customer.jsp">
		<button class="btn btn-info btn-lg">customer</button>&nbsp;&nbsp;
		    </a>
		    <a href="Employee.jsp"><button class="btn btn-success btn-lg">Employees</button></a> &nbsp;&nbsp;
		    <a href="OfficeDetails.jsp"><button class="btn btn-warning btn-lg">Office</button></a>&nbsp;&nbsp;
		    <a href="OrderDetails.jsp"><button class="btn btn-primary btn-lg">OrderDetails</button></a>&nbsp;&nbsp;
		    <br>
		    <br>
		    <a href="LoginController?query=logout"><button class="btn btn-danger btn-lg">Logout</button></a>
		    
		    <% }else{ %> 
		    	<h3>Your don't have permission to access this page</h3>
		    <% } %>
	
	
</body>
</html>