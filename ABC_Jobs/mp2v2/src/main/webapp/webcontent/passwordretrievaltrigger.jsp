<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<s:include value="/webcontent/header.jsp" />
	<div class="container main">
	<h2>Reset Password</h2>
	<s:form action="PasswordRetrievalTrigger" theme="bootstrap" cssClass="form-vertical">
		<s:textfield name="email" label="Email" cssClass="form-control"></s:textfield>
		<s:submit value="Reset Password" cssClass="btn btn-primary"></s:submit>
	</s:form>
	</div>

	<s:include value="/webcontent/footer.jsp" />
</body>
</html>