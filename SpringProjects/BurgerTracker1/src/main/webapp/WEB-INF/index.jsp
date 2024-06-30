<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Burgers</title>
    </head>
<body>
	
	<h1>Burger Tracker</h1>

    <table>
		<tr>
			<th>Burger Name</th>
			<th>Resturant Name</th>
			<th>Rating (out of 5)</th>	
		</tr>
		<tr>
			    <c:forEach var="burger" items="${burgers}">
			        <tr>
						<td><c:out value="${burger.burger_name}"/></td>
						<td><c:out value="${burger.resturant_name}"/></td>
						<td><c:out value="${burger.rating}"/></td>
			        </tr>
			    </c:forEach>
		</tr>
		</table>
		
		<h1>Add a burger:</h1>
		
		<form:form action="/new" method="post" modelAttribute="burger">
		    <p>
		        <form:label path="burger_name">Burger Name</form:label>
	       		<form:errors path="burger_name"/>
	        	<form:input  path="burger_name"/>
		    </p>
		    <p>
		        <form:label path="resturant_name">Resturant Name</form:label>
		        <form:errors path="resturant_name"/>
	        	<form:textarea path="resturant_name"/>
		    </p>
		    <p>
		        <form:label path="rating">Rating</form:label>
		        <form:errors path="rating"/>
				<form:input path="rating"/>
		    </p>
		    
		    <input type="submit" value="Submit"/>
		</form:form>    
	
</body>
</html>
