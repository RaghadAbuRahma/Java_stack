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
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Welcome ${loggedUser.userName}</h1>
   <a href="/logout">Log Out</a>
   
   <h1>All projects:</h1>
   <table>
       <tr>
           <th>Project</th>
           <th>Due Date</th>
           <th>Actions</th>
       </tr>
       <c:forEach var="project" items="${otherProjects}">
           <tr>
               <td><c:out value="${project.name}"/></td>
               <td><c:out value="${project.dueDate}"/></td>
			   <td><a href="/joinProject/${project.id}?projectId=${project.id}">Join Team</a></td>
			   
           </tr>
       </c:forEach>
   </table>

   <h1>My projects:</h1>
   <table>
       <tr>
           <th>Project</th>
           <th>Due Date</th>
           <th>Actions</th>
       </tr>
       <c:forEach var="project" items="${myProjects}">
           <tr>
               <td><c:out value="${project.name}"/></td>
               <td><c:out value="${project.dueDate}"/></td>
			   <c:if test = "${project.lead.id != loggedUser.id}">	
					<td><a href="/leaveProject/${project.id}">Leave Team</a></td>
			  	</c:if>
			   <c:if test = "${project.lead.id == loggedUser.id}">	
			   		<td><a href="/joinProject/${project.id}?projectId=${project.id}">edit</a></td>
			   </c:if>
           </tr>
       </c:forEach>
   </table>

</body>
</html>