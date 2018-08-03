<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
     <h3>Please enter information</h3>
  	<br/>
    <form action="signUpUser" method="post">
    	<label for="user">User Name</label>
     	<input id="user" name="userName" type="text"/><br/>
     	<label for="psw">Password</label>
		<input id="psw" name="password" type="password"/><br/>
		<label for="fn">First Name</label>
		<input id="fn" name="firstName" type="text"/><br/>
		<label for="ln">Last Name</label>
		<input id="ln" name="lastName" type="text"/><br/>
		<label for="zp">Zip Code</label>
		<input id="zp" name="zipCode" type="text"/><br/>
		<br/>
		<input type="submit" value="send"/>
     </form>
 
</body>
</html>