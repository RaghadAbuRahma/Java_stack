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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	
	<h1>New Product</h1>
	<form:form action="/createProduct" methpd="post" modelAttribute="product">
		<div>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<div>	
			<form:label path="price">Confirm Password:</form:label>
			<form:errors path="price"/>
			<form:input path="price"/>
		</div>	
			<input type="submit" value="Submit">
			
		</form:form>
   
</body>
</html>