<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/CSS" href="/CSS/style.css">

</head>
<body>
<h1>Welcome To Ninja Gold!</h1>
<div class="yourGold">
       <h2>Your Gold: <c:out value="${count}"></c:out></h2>
       <div class="container">
           <div class="farm">
               <h1>Farm</h1>
               <p>(earns 10-20 gold)</p>
               <form action="/process_money" method="post">
                   <input type="hidden" name="which_form" value="farm">
                   <input type="submit" name="gold" value="Find Gold!">
               </form>
           </div>
           <div class="Cave">
               <h1>Cave</h1>
               <p>(earns 5-10 gold)</p>
               
               <form action="/process_money" method="post">
                   <input type="hidden" name="which_form" value="cave">
               
                   <input type="submit" name="gold" value="Find Gold!">
               </form>
           </div>
           <div class="House">
               <h1>House</h1>
               <p>(earns 2-5 gold)</p>
               <form action="/process_money" method="post">
                   <input type="hidden" name="which_form" value="house">
                 
                   <input type="submit" name="gold" value="Find Gold!">
               </form>
           </div>
           <div class="Quest">
               <h1>Quest</h1>
               <p>(earns/takes 0 - 50 gold)</p>
               <form action="/process_money" method="post">
                   <input type="hidden" name="which_form" value="quest">

                   <input type="submit" name="gold" value="Find Gold!">
               </form>
			
			 
			   <div class="activities">
				<c:forEach var="activity" items="${activities}">
					<c:if test="${activity.contains('earned')}">
						<p style="color: green;"><c:out value="${activity}"/></p>
					</c:if>
					<c:if test="${activity.contains('lost')}">
						<p style="color: red;"><c:out value="${activity}"/></p>
					</c:if>
				</c:forEach>
			   </div>
		
				
				
           </div>
</div>
</div>

</body>
</html>