<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books</title>
		<link rel="stylesheet" type="text/CSS" href="/CSS/style.css">

    </head>
<body>
	<table>
	    <tr>
			<th>ID</th>
	        <th>Title</th>
	        <th>Description</th>
			<th>Pages</th>
			
	    </tr>
	    <c:forEach var="book" items="${books}">
	        <tr>
				<td><c:out value="${book.id}"/></td>
				<td><a href="/books/${book.id}">${book.title }</a></td>
	            <td><c:out value="${book.description}"/></td>
				<td><c:out value="${book.numberOfPages}"/></td>
				
	        </tr>
	    </c:forEach>
	</table>
</body>
