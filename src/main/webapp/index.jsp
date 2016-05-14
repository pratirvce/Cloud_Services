<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Register to Order Management</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="style.css">
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
	<div class="wrapper">
	<div class="header">
		<h1>Order Management</h1>
	</div>
	
	<div class="container">
		<div class="instruction">
<div class="col-xs-11 col-md-10" id="tabs">
<ul class="navbar navbar-inverse">
  <li class="list-group-item list-group-item-success"  class="active"><a href="#login">LOGIN</a></li>
  <li class="list-group-item list-group-item-danger" role="presentation"><a href="#register">REGISTER</a></li>
</ul>
 
  <div id="login">
  	<% 
  	if("Invalid username or password".equalsIgnoreCase((String)session.getAttribute("error"))){ %>
  		<h6> Invalid user name or password. Please try again.</h6>
  	<%} %>
    <form role="form" method="post" action="LoginController">
    <div class ="form-group">
    	<label for="email">Email:</label>
    	<input type="text" class="form-control" name="email" id="email" placeholder="Your email address"/>
    	</div>
    	<div class= "form-group">
    	<label for="password">Password:</label>
    	<input type="password" class="form-control" name="password" id="password" placeholder="Your password"/>
    	</div>
    	<input type="submit" class="btn btn-success" value="Login">
    </form>
    </div>
  <div class ="form-group" id="register">
  	<form role="form" method="post" action="RegistrationController">
  		<label for="fullname">Full Name:</label><br/>
    	<input type="text" name="fullname" id="fullname" class="form-control" class="fullname" placeholder="Your full name"/>
    	<br/>
    	<label for="email">Email:</label><br/>
    	<input type="text" name="email" id="email" class="form-control"  placeholder="Your email address"/>
    	<br/>
    	<label for="password">Password:</label><br/>
    	<input type="password" name="password" id="password" class="form-control"  placeholder="Your password"/>
    	<br/>
    	<label for="gender">Gender:</label><br/>
    	<select name="gender" id="gender" class="form-control" >
    		<option value="Male">Male</option>
    		<option value="Male">Female</option>
    	</select>
    	<br/>
    	<label for="birthdate">Birth Date:</label><br/>
    	<input type="text" name="birthdate" id="birthdate" class="form-control"  placeholder="Your birth date"/>
    	<br/>
    	<input type="submit" class="btn btn-success" value="Register">
  	</form>
  </div>
</div>
		</div>
	</div>
	
	</div>
</body>
</html>