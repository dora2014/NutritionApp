<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
	
	<b><i>${user}</i> DashBoard </b>

	<br/>
	<br/>
	<b>Food: ${foodName}</b>
	<br/> <b>${foodResultVAlue}</b>
	
	<c:set var="foodHistory" scope="session" value="${foodResultVAlue}" />
	<br/>
	<br/>
	<br/><br/><a href="search-food.jsp">Back to search</a>	

</body>
</html>