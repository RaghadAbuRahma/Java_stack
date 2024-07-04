<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-danger">Home Page</h1>
		<a href="/newProduct">New Product</a>
		<a href="/newCategory">New Category</a>
		
		<div class="row">
			<div class="col-6">
				<table class="table table-bordered text-center">
					<thead>
					   <tr>
					     <th>Products:</th>
						</tr>
					</thead>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><a href="/product/${product.id}"><c:out value="${product.name}"/></a></td>
						</tr>
					</c:forEach>
	
				</table>
			</div>	
			<div class="col-6 ">
				<table class="table table-bordered text-center">
					<thead>
					   <tr>
					     <th>Categories:</th>
						</tr>
					</thead>
						<c:forEach var="category" items="${categories}">
							<tr>
								<td><a href="/category/${category.id}"><c:out value="${category.name}"/></a></td>
							</tr>		
						</c:forEach>
				</table>
			</div>
   	</div>
</body>
</html>
