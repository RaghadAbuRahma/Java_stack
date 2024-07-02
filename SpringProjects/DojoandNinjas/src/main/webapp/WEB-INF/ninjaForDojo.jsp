<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo Page</title>
</head>
<body>

<h1><c:out value="${dojo.name}"></c:out>  Ninjas:</h1>

<table>
	
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</tr>
	
	<c:forEach var="Oneninja"  items="${dojo.ninjas}">
	<tr>		
       <td><c:out value="${Oneninja.firstName}"/></td>
       <td><c:out value="${Oneninja.lastName}"/></td>
       <td><c:out value="${Oneninja.age}"/></td>
	</tr>
	</c:forEach>
</table>
</body>