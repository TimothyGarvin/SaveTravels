<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<h1>Edit Travel Expense</h1>
	<form:form action = "/travels/${travel.id}" mode="post" modelAttribute="travel">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="name">Expense Name:</form:label>
			<div></div>
			<form:errors path="name"/>
			<div></div>
			<form:input path="name"/>
		</div><hr/>
		<div>
			<form:label path="vendor">Vendor:</form:label>
			<div></div>
			<form:errors path="vendor"/>
			<div></div>
			<form:input path="vendor"/>
		</div><hr/>
		<div>
			<form:label path="amount">Amount:</form:label>
			<div></div>
			<form:errors path="amount"/>
			<div></div>
			<form:input path="amount"/>
		</div><hr/>
		<div>
			<form:label path="description">Description:</form:label>
			<div></div>
			<form:errors path="description"/>
			<div></div>
			<form:textarea path="description"/>
		</div><hr/>
		<div>
			<input type="submit" value="Add Expense">
		</div>
	</form:form>
	<a href="/travels">Return Home</a>
</body>
</html>