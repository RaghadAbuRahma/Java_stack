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

<h1>Travel Expenses</h1>

<table>
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
		<th>Action</th>
		
    </tr>
    <c:forEach var="expense" items="${expenses}">
        <tr>
            <td>
				<a href="expenses/show/${expense.id}"><c:out value="${expense.expense_att}"/></a>
			</td>
            <td><c:out value="${expense.vendor}"/></td>
            <td><c:out value="${expense.amount}"/></td>
			<td><a href="expenses/edit/${expense.id}">Edit</a><td>
			<td>   				<form action="/expenses/delete/${expense.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
 </td>
			
        </tr>
    </c:forEach>
</table>

<h1>Add Travel Expense:</h1>
<form:form action="/new" method="post" modelAttribute="expense">
    <p>
        <form:label path="expense_att">Expense Name:</form:label>
        <form:errors path="expense_att"/>
        <form:input path="expense_att"/>
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

