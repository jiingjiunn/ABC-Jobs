<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:include value="/webcontent/header.jsp" />
	<div class="container main">
		<h3>Edit Profile</h3>
		<s:form action="updateProfile">
			<s:hidden name="email" value="%{#session.email}" />
			<s:textfield label="First Name" name="firstname"
				cssClass="form-control" value="%{profile.firstName}"></s:textfield>
			<s:textfield label="Last Name" name="lastname"
				cssClass="form-control" value="%{profile.lastName}"></s:textfield>
			<s:textfield label="Job Role" name="jobrole" cssClass="form-control"
				value="%{profile.jobrole}"></s:textfield>
			<s:textfield label="Employer" name="employer" cssClass="form-control"
				value="%{profile.employer}"></s:textfield>
			<s:textfield label="Location" name="location" cssClass="form-control"
				value="%{profile.location}"></s:textfield>
			<s:submit cssClass="btn btn-primary" value="Update Information"></s:submit>
		</s:form>
	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>