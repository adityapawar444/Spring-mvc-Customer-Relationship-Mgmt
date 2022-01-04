<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>CRM</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
<link>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/add-customer-style.css">
<link>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST">

		<form:hidden path="id" />

		<table>
			<tr>
				<td><label>Name : </label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><label>Email : </label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><label>Contact : </label></td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Save" type="submit" class="save"></input></td>
			</tr>

		</table>


	</form:form>

	<div style=""></div>

	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Home</a>
	</p>

</body>


</html>