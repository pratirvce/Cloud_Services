<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
   <BODY background="cust.png">
<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

 
        <H1>The tableName Database Table </H1>

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
                <TH>OfficeCode</TH>
                <TH>City</TH>
                <TH>Phone</TH>
                <TH>AddressLine1</TH>
                <TH>AddressLine2</TH>
                <TH>State</TH>
                <TH>Country</TH>
                <TH>PostalCode</TH>
                <TH>Territory</TH>
                
                
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></TD>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
                <TD> <%= resultset.getString(7) %></TD>
                <TD> <%= resultset.getString(8) %></TD>
                <TD> <%= resultset.getString(9) %></TD>
                
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>