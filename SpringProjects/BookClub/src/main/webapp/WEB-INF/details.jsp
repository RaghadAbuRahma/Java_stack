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
    <title>Book's Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<body>
		<a href="/goback">back to the shelves</a>
	<h1>Title: <c:out value="${book.title}"/><h1>
	<h2>Number of Pages: <c:out value="${book.numberOfPages}"/></h2>
	<c:if test = "${book.user.id == loggedUser.id}">
		<p> You read <c:out value="${book.title}"/>, and  Here are your added description </p>
	</c:if>
	<c:if test = "${book.user.id != loggedUser.id}">
		<p><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> and  Here are thier added description </p>
		</c:if>
	<h3>Description: <c:out value="${book.description}"/></h3>
	
	<c:if test = "${book.user.id == loggedUser.id}">	
		
	<form:form action="/books/${book.id}/edit" method="post">
	    <input type="submit" value="edit book">
		
	</form:form>
	<form:form action="/books/${book.id}/delete" method="post">
			    <input type="submit" value="delete">
				
			</form:form>
	</c:if>


 
</body>
</html>