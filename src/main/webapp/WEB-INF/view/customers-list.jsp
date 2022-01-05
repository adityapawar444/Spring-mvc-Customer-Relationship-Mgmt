<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>

<title>CRM</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
<link>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div>
		<hr>
		<p>
			Welcome
			<security:authentication property="principal.username" />
			You have logged in as:
			<security:authentication property="principal.authorities" />
		</p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="Logout" class="add-button" />
		</form:form>
		<hr>

	</div>


	<div id="container">



		<div id="content">

			<security:authorize access="hasRole('ADMINISTRATOR')">
				<form:form action="search" method="GET">
							Search Customer : <input type="text" value="" name="queryName" />
					<input type="submit" value="Search" class="add-button" />
				</form:form>


				<input type="button" value="Add Customer" class="add-button"
					onclick="window.location.href='addCustomerForm'; return false;" />
			</security:authorize>

			<!--  add our html table here -->

			<c:if test="${queryName != null}">
				<p>Showing result for "${queryName}"</p>
			</c:if>

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

					<security:authorize access="hasRole('ADMINISTRATOR')">
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
					</security:authorize>
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

	<hr>
	<c:if test="${queryName != null}">
		<a href="${pageContext.request.contextPath}/customer/list">Home</a>
	</c:if>

</body>


</html>