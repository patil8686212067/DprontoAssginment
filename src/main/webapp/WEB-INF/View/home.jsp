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
<form action="/DprontoTest/saveuser" method="post" modelAttribute="userDTO">
sr.No :<input type="text" name="srNo" ><br>
 first Name:<input type="text" name="firstName"><br>
 last Name:<input type="text" name="lastName"><br>
 
 
<input type="submit" value="AddUSer">


</form>
<br>

<form action="/DprontoTest/getSortedData" method="GET">
<input type="submit" value="ascending" name="userAction">
<input type="submit" value="descending" name="userAction">
</form>
<br>

<%-- JSTL foreach tag example to loop a HashMap in JSP --%>
 <table> <c:forEach var="entry" items="${map}"> 
 <tr><td><c:out value="${entry.key}"/></td> 
 <td><c:out value="${entry.value}"/> </td></tr> </c:forEach>
  </table>




</body>
</html>