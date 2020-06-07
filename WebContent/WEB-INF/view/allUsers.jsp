<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<title>All Users</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">

		<table class="table table-striped">
			<caption>Users Admin Console</caption>
			<caption> <a href="createUser"> Click here to create a new User </caption>
			<thead>
				<tr>
					<th>User ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Organization ID</th>
					<th>Delete User</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.userID}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.orgID}</td>
						<td><a type="button" class="btn btn-warning"
						href="deleteUser?userID=${user.userID}">Delete</</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>