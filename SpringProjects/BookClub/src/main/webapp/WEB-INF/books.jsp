<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Welcome ${loggedUser.userName}</h1>
   <a href="/logout">Log Out</a>
   <a href="/newForm">+ Add a book to my shelf!</a>
   <p>Books from everyone's shelves:</p>
   <table>
	<tr>
		<th>Title</th>
		<th>Number Of Pages</th>
		<th>Description</th>
		<th>Posted by</th>
		<th>Action</th>
		
		<c:forEach var="book" items="${otherBooks}">
		    <tr>
		        <td>
		            <a href="/details/${book.id}"><c:out value="${book.title}"/></a>
		        </td>
		        <td><c:out value="${book.numberOfPages}"/></td>
		        <td><c:out value="${book.description}"/></td>
		        <td><c:out value="${book.user.userName}"/></td>
				<c:choose>
		            <c:when test="${book.user.id == loggedUser.id}">
		                <td><a href="/books/${book.id}/edit">edit</a></td>
		            </c:when>
		            <c:when test="${book.user.id != loggedUser.id && book.borrower == null}">
		                <td><a href="/borrow/${book.id}">Borrow</a></td>
		            </c:when>
		            <c:when test="${book.borrower != null && book.user.id != loggedUser.id}">
		                <td style="color: red">Borrowed</td>
		            </c:when>
		            <c:otherwise>
		                <td></td>
		            </c:otherwise>
		       </c:choose>
		    </tr>
		</c:forEach>

   </table>
   <table>
   <tr>
   	<th>Title</th>
   	<th>Number Of Pages</th>
   	<th>Description</th>
   	<th>Posted by</th>
   	<th>Action</th>
   	<c:forEach var="book" items="${borrowedBooks}">
   		<tr>	
   			<td>
   				<a href="/details/${book.id}"><c:out value="${book.title}"/></a>
   			</td>
   			<td><c:out value="${book.numberOfPages}"/></td>
   			<td><c:out value="${book.description}"/></td>
   			<td><c:out value="${book.user.userName}"/></td>
   			<td><a href="/return/${book.id}">return</a></td>
   		</tr>
   	</c:forEach>
   	
   	
     </table>
   
   
 
</body>
</html>