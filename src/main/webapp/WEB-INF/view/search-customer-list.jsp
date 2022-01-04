<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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


			<form:form action="search" method="GET">
							Search Customer : <input type="text" name="queryName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<input type="button" value="Add Customer" class="add-button"
				onclick="window.location.href='addCustomerForm'; return false;" />


			<!--  add our html table here -->
			<p>Showing result for "${queryName}"</p>

			<table>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Action</th>
					<th></th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customerList}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.name}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.contact}</td>
						<td><a href="${updateLink}">Update</a> <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	<div style=""></div>

	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Home</a>
	</p>

</body>


</html>