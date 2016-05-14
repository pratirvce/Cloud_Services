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
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body>
	<%
			User user = (User)session.getAttribute("user");
			if(user!=null){ %>
		
		    <h3>Welcome <% out.print(user.getFullname()); %></h3>
		    
		    <a href="webapi/customer">customer</a>
		    <a href="webapi/employee">employee</a>
		    <a href="webapi/office">office</a>
		    <a href="webapi/orderdetail/getAll">orderdetail</a>
		    <br>
		    <a href="LoginController?query=logout">Logout</a>
		    
		    <% }else{ %> 
		    	<h3>Your don't have permission to access this page</h3>
		    <% } %>
	
	
</body>
</html>