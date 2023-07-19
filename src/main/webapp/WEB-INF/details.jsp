<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<h1>Expense Details</h1>
	<h2>Expense Name: <c:out value="${travel.name}"/></h2>
	<h3>Description: <c:out value="${travel.description}"/></h3>
	<h2>Vendor: <c:out value="${travel.vendor}"/></h2>
	<h2>Amount: $<c:out value="${travel.amount}"/></h2>
	<a href="/travels">Return Home</a>
</body>
</html>