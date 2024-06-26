<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books</title>
    </head>
<body>
	<table>
	    <tr>
			<th>ID</th>
	        <th>Title</th>
	        <th>Description</th>
			
	    </tr>
	    <c:forEach var="book" items="${books}">
	        <tr>
				<td><c:out value="${book.id}"/></td>
	            <td><c:out value="${book.title}"/></td>
	            <td><c:out value="${book.description}"/></td>
	        </tr>
	    </c:forEach>
	</table>
</body>
