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
    <title>Book Club
	</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Book Club</h1>
	<h3>A place for friends to share thoughts on books.</h3>
	
	<h1>Register</h1>
	<form:form action="/register" methpd="post" modelAttribute="newUser">
		<form:label path="userName">User Name:</form:label>
		<form:errors path="userName"/>
		<form:input path="userName"/>
		<form:label path="email">Email:</form:label>
		<form:errors path="email"/>
		<form:input type="email" path="email"/>
		<form:label path="password">Password:</form:label>
		<form:errors path="password"/>
		<form:input type="password" path="password"/>
		<form:label path="confirm">Confirm Password:</form:label>
		<form:errors path="confirm"/>
		<form:input type="password" path="confirm"/>
		<input type="submit" value="Create account">
	</form:form>
		
		<h1>Login</h1>
		<form:form action="/login" methpd="post" modelAttribute="login">
			<form:label path="email">Email:</form:label>
			<form:errors path="email"/>
			<form:input type="email" path="email"/>
			<form:label path="password">Password:</form:label>
			<form:errors path="password"/>
			<form:input type="password" path="password"/>
			<input type="submit" value="login">


			</form:form>
			
		
   
</body>
</html>

