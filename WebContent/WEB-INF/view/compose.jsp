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
	<h1>Compose Email</h1>
		<form:form action="sendMessage" method="post" modelAttribute="messageHelper">
			<fieldset class="form-group">
				<form:label path="fromUserID">From User ID</form:label>
				<form:input path="fromUserID" type="text" class="form-control"
					required="required" />
				<form:errors path="fromUserID" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="toUserID">To User ID</form:label>
				<form:input path="toUserID" type="text" class="form-control"
					required="required" />
				<form:errors path="toUserID" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="messageSubject">Subject</form:label>
				<form:input path="messageSubject" type="text" class="form-control"
					required="required" />
				<form:errors path="messageSubject" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="meesgaeText">Message Text</form:label>
				<form:input path="meesgaeText" type="text" class="form-control"
					required="required" />
				<form:errors path="meesgaeText" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Send</button>

		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>