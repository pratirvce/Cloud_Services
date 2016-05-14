<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
   <Body background="cust.png">
<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

 
        <H1><font color ="Black">CustomerDetails</font></H1>

        <% 
            Connection connection = DriverManager.getConnection(
        "jdbc:mysql://cloudservice.csa2yphklgn8.us-east-1.rds.amazonaws.com:3306/classicmodels",
        "root", "cloud007");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from customers") ; 
        %>

        <TABLE BORDER="1">
            <TR>
                <TH>CustomerNumber</TH>
                <TH>CustomerName</TH>
                <TH>ContactLastName</TH>
                <TH>ContactFirstName</TH>
                <TH>Phone</TH>
                <TH>AddressLine1</TH>
                <TH>AddressLine2</TH>
                <TH>City</TH>
                <TH>State</TH>
                <TH>PostalCode</TH>
                <TH>Country</TH>
                <TH>SalesRepEmpNumber</TH>
                <TH>CreditLimiit</TH>
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></TD>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></td>
                <TD> <%= resultset.getString(7) %></TD>
                <TD> <%= resultset.getString(8) %></TD>
                <TD> <%= resultset.getString(9) %></TD>
                <TD> <%= resultset.getString(10) %></TD>
                <TD> <%= resultset.getString(11) %></td>
                <TD> <%= resultset.getString(12) %></TD>
                <TD> <%= resultset.getString(13) %></TD>
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>