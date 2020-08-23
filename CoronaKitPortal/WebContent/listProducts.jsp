<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoronaKitPortal</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	
				
	  
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
					<th>Action</th>
				</tr>
				<c:forEach items="${products }" var="product">
					<tr>
						<td>${product.productId }</td>
						<td>${product.productName }</td>
						<td>${product.productCost }</td>
						<td>${product.productDescription }</td>
						<td>
							<a href="deleteProduct?pid=${product.productId }">DELETE</a>
							<span>|</span>
							<a href="editProduct?pid=${product.productId }">EDIT</a>
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>