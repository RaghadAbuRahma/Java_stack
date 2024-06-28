<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <table>
		<tr>
			<th>Burger Name</th>
			<th>Resturant Name</th>
			<th>Rating (out of 5)</th>	
		</tr>
		<tr>
			    <c:forEach var="burger" items="${burgers}">
			        <tr>
						<td><c:out value="${burger}"/></td>
			        </tr>
			    </c:forEach>
		</tr>
		</table>
		
		<form action='/login' method='GET'>
			<label>Email:</label>
				<input type="text" name='email'>
			<label>Password:</label>
				<input type='text' name='password'>
				<input type='submit' value='login'>
		</form>
	
</body>
</html>
