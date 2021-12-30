<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>CRM</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customerList}">

					<tr>
						<td>${tempCustomer.name}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.contact}</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

</body>


</html>