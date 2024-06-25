<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Count</title>
</head>
<body>
	<h2>
					You have visited <a href="/">The Counter</a>
					<c:out value="${count}"></c:out>
					times
				</h2>
				<h3><a href="/">Test another visit?</a>

</body>
</html>