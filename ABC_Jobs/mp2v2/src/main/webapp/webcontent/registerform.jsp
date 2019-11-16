<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

</head>

<body>
	<s:include value="/webcontent/header.jsp"/>
	<div class="container main">
		<h2>Create a new account</h2>
		<p></p>
		<s:form action="register.action" 
			cssClass="form-vertical" validate="true" theme="bootstrap">
			<s:textfield label="First Name" cssClass="form-control" name="fname" />
			<s:textfield label="Last Name" cssClass="form-control" name="lname" />
			<s:textfield label="Email" cssClass="form-control" name="email" />
			<s:password label="Password" cssClass="form-control" name="password" />
			<s:password label="Confirm Password" cssClass="form-control"
				name="cpassword" />
			<s:submit cssClass="btn btn-primary" align="right"
				value="Create Account" />

		</s:form>
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror cssClass="alert alert-danger" theme="bootstrap"/>
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="welcome">
				<s:actionmessage cssClass="alert alert-success" theme="bootstrap" />
			</div>
		</s:if>
	</div>

	<s:include value="/webcontent/footer.jsp" />
</body>
</html>