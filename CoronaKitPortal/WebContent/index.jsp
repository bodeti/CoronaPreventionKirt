<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Corona Prevention Kit Portal</h1>

<h2>Admin</h2>
	  
     
     <form action="login" method="doLogin">
		
		Username : <input type="text" name="user"><br/><br/> 
        Password : <input type="password" name ="pass"><br/><br/> 
      
       <br/> <input type ="submit" value="Login">  ${Login}   
        
        
       
	
	<h2>Visitor</h2>
	
		<a href="newUser.jsp"> New User </a> 
     
</body>