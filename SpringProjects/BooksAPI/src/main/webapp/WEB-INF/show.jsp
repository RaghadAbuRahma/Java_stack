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
  
	<h1><c:out value="${title}"></c:out></h1>
	<h3>Description: <c:out value="${desc}"></c:out></h3>
	<h4>Language: <c:out value="${lan}"></c:out></h4>
	<h4>Number of Pages: <c:out value="${num}"></c:out></h4>
	<h1><c:out value="${book.title}"></c:out></h1>
<!--	<p><c:out value="${book.description}"></c:out></p>
	<p><c:out value="${book.language}"></c:out></p>
	<p><c:out value="${book.numberOfPages}"></c:out></p>
	-->
	
</body>
</html>
