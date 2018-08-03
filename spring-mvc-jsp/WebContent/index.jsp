<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
     <h3>Welcome!</h3>
 	
    <form action="login" method="post">
    	<label for="user">User Name</label>
     	<input id="user" name="userName" type="text"/><br/>
     	<label for="psw">Password</label>
		<input id="psw" name="password" type="password"/><br/>
		<input type="submit" value="send"/>
     </form>
 
 	<br/><br/><a href="sign-up.jsp">Or Sign up click here</a>
 
</body>
</html>