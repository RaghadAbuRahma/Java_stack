<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travel Expenses</title>
</head>
<body>

<h1>Travel Expenses</h1>
            
	<p><c:out value="${expense.expense_att}"/></p>
    <p><c:out value="${expense.vendor}"/></p>
    <p><c:out value="${expense.amount}"/></p>
	
</body>
</html>