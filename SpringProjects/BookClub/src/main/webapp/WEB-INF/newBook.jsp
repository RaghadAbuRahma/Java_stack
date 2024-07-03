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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<h1>Add a Book to Your Shelf!</h1>
<a href="/goback">back to the shelves</a>

<form:form action="/newBook" method="post" modelAttribute="book">
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors class="error" path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="numberOfPages">Number Of Pages: </form:label>
        <form:errors path="numberOfPages"/>
        <form:input  path="numberOfPages"/>
    </p>
	<p>
	        <form:label path="language">language: </form:label>
	        <form:errors path="language"/>
	        <form:input  path="language"/>
	    </p>
	 
 
    <input type="submit" value="Submit"/>
</form:form>


 
</body>
</html>