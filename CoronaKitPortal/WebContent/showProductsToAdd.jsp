<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Page</title>
</head>
<body>

	
<h1>${msg}</h1>
	<h2>Prepare your CoronaKit<h2></h2>  <br/>
	
		
		
		<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Description</th>
					<th>Buy</th>
				</tr>
				<c:forEach items="${products }" var="product">
					<tr>
						<td>${product.productId }</td>
						<td>${product.productName }</td>
						<td>${product.productCost }</td>
						<td>${product.productDescription }</td>
						<td>
							<a href="addToKit?pid=${product.productId }&pname=${product.productName }">Add To Kit</a>
						
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
		

</body>
</html>