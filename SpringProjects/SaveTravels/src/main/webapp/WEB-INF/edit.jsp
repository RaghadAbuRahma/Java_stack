<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travel Expenses</title>
</head>
<body>




<h1>Edit Travel Expense:</h1>
<a href="/expenses">Go Back</a>
<form:form action="/expenses/${id}" method="post" modelAttribute="expense">
	<input type="hidden" name="_method" value="put">

    <p>
        <form:label path="expense_att">Expense Name:</form:label>
        <form:errors path="expense_att"/>
        <form:input path="expense_att" />
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input  tybe="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>