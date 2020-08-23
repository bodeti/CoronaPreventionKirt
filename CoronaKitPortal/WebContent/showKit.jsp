<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Page</title>
</head>
<body>

	
<h1>${msg}</h1>
	<h2>Show Kit Products<h2></h2>  <br/>
	
		
		
		
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Quantity</th>
					<th>Sub Total</th>
					
				</tr>
				
					<tr>
						<td>${pid}</td>
						<td>${product.productName }</td>
						<td>${product.productCost }</td>
						<td>10</td>
						<td>1000.00</td>
							
						</td>
					</tr>
				
			</table>
		
		

</body>
</html>