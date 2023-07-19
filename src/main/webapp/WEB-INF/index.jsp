<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td><a href="travels/${travel.id}"><c:out value="${travel.name}"/></a></td>
					<td><c:out value="${travel.vendor}"/></td>
					<td>$<c:out value="${travel.amount}"/></td>
					<td><a href="travels/${travel.id}/edit">Edit</a></td>
					<td>
						<form action="/travels/${travel.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr/>
	<h2>Add an expense:</h2>
	<form:form action = "/travels/add" mode="post" modelAttribute="travel">
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
</body>
</html>