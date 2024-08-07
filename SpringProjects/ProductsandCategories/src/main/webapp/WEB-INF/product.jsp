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
	<h1><c:out value="${product.name}"/></h1>
	
	<h3>Categories: </h3>
	<c:forEach var="category" items="${joinedCategories}">
		<h3> <c:out value="${category.name}"/> </h3>
	</c:forEach>
	
	<h3>Add category:</h3>
	
		<form action="/product/${product.id}/joinCategory" method="post">
	    	<p>
				<select name="categoryId">
					<c:forEach var="category" items="${otherCategories}">
							<option  value="${category.id}">
							 <c:out value="${category.name}"/>
						 </option>
					</c:forEach>	
				<select>
	   	 	</p>
			<input type="submit" value="Submit">
	</form> 
	
</body>
</html>