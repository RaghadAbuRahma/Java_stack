<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Omikuji</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">

    </head>
<body>
<h1>Send an Omikuji!</h1>
	    
	 <div class="formm">
	    <form action="/omikuji/new" method="post">
			<div>
	        <label>Pick any number from 5 to 25</label>
	        <input type="number" min="5" max="25" value="5" name="number">
			</div>
			<div>
	        <label>Enter the name of any city.</label>
	        <input type="text" name="city">		
			</div>
			<div>	
			<label>Enter the name of any real person:</label>
			<input type="text" name="person">
			</div>
			<div>
			<label>Enter professional endeavor or hobby:</label>
			<input type="text" name="hobby">
			</div>
			<div>
			<label>Enter any type of living thing.</label>
			<input type="text" name="living_thing">
			</div>
			<div>
			<label>Say something nice to someone:</label>
			<textarea name="smth_nice"></textarea>
			</div>
			
			<h3>Send and show  a friend</h3>
	        <input class="btn1" type="submit" value="Send">
	    </form>
	</div>
	    
	

</body>
</html>
