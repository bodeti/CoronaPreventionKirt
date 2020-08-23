<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Page</title>
</head>
<body>
	<!--  <h3><%=LocalDateTime.now() %></h3>-->
	<h1>Hello Visitor</h1>
	
	Please Enter Below Details  <br/><br/> 
	
	
	<form action="user" method="doUser">
		
		Name : <input type="text" name="name"><br/><br/> 
        e-Mail : <input type="email" name="email" required/></label> <br/><br/> 
        Mobile : <input type="text" name="mobile" pattern="[1-9][0-9]{9}" required/></label> <br/><br/> 
		   <br/> <input type ="submit" value="Show Products to Add"> 
	
		
	

</body>
</html>