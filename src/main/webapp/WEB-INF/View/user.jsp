<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<h1>${msg}</h1>
<form action="/DprontoTest/createUser" method="post" modelAttribute="user">
 first Name:<input type="text" name="username"><br>
 last Name:<input type="text" name="password"><br>
 
 
<input type="submit" value="AddUSer">


</form>
<br>



</body>
</html>