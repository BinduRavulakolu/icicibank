<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<%-- <form action="edit" method="post">
<label>Customer id:</label>
<input type="number" value="${customer.customerId}" name="custId" readonly/>
<br><br>
<label>Customer Name:</label>
<input type="text" name="custName" value="${customer.customerName}" required/>
<br><br>
<label>Password :</label>
<input type="password" name="password" value="${customer.password}" required/>
<br><br>

<label>Email :</label>
<input type="email" name="email" value="${customer.email}" required />
<br><br>
<label>Address :</label>
<input type="text" name="address" value="${customer.address}" required />
<br><br>
<label>DateOfBirth:</label>
<input type="date" name="dob" value="${customer.dateOfBirth}" required />
<br><br>
<input type="submit" value="edit"/>
</form>  --%>

	<form:form action="edit" method="post" modelAttribute="customer">
		<form:label path="customerId">Customer id:</form:label>
		<form:input type="number" path="customerId"  />
		<br>
		<br>
		<form:label path="customerName">Customer Name:</form:label>
		<form:input type="text" path="customerName"  />
		<br>
		<br>
		<form:label path="password">Password :</form:label>
		<form:input type="password" path="password"  />
		<br>
		<br>

		<form:label path="email">Email :</form:label>
		<form:input type="email" path="email"  />
		<br>
		<br>
		<form:label path="address">Address :</form:label>
		<form:input type="text" path="address"  />
		<br>
		<br>
		<form:label path="dateOfBirth">DateOfBirth:</form:label>
		<form:input path="dateOfBirth"  />
		<br>
		<br>
		<input type="submit" value="edit" />
	</form:form>


</body>
</html>