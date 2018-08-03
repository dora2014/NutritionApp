<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Food</title>
</head>
<body>
 
 	Hello, <b><i> ${user}</i></b>
 
 	<form action="searchFood" method="get">
		<label for="food"></label> 			
		<input id="food" name="foodString" type="text" />
		<br /> 
		<input type="submit" value="Search" />
	</form>
 
 
 	<br/>
	<form action="index.jsp" method="get">
		<button type="submit">Logout</button>
	</form>
	<br/><br/>
		
</body>
</html>