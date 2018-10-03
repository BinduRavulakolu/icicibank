<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%@include file="header.jsp" %>
<form:form action="login" method="post" modelAttribute="customer">
<label>CustomerId</label>
<form:input type="number" path="customerId" />
<br><br>
<label>Password</label>
<form:input type="password" path="password" />
<br><br>
<input type="submit" value="submit"/>
</form:form>
</body>
</html>
