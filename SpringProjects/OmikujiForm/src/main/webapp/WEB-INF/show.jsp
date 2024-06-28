<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/style1.css">
        <title>Omikuji</title>
    </head>
<body>
	
	<h1>Here's Your Omikuji!</h1>
<div class="container">
	<div class="formm">
		<h3> In <c:out value="${number}"></c:out> years, you will live in <c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as your roommate, selling
			<c:out value="${hobby}"></c:out> for living. The next time you see a <c:out value="${living_thing}"></c:out>, you will have good luck. Also, <c:out value="${smth_nice}"></c:out></h3>
	</div>
	<div class="a">
		<a href="/omikuji/goback">Go Back!</a>
	</div>
</div>

</body>
</html>