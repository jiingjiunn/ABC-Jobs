<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<s:include value="/webcontent/header.jsp" />
	<div class="container main">
		<div class="container form">
			<h2>Login</h2>
			<s:form action="login" theme="bootstrap" cssClass="form-vertical">
				<s:textfield label="Email" name="email" />
				<s:password label="Password" name="password" />
				<s:submit value="Login" cssClass="btn btn-primary" />
			</s:form>
			<p>Forgotten password? Click <a href="passwordRetrievalTriggerLink">here</a>.</p>
			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror cssClass="alert alert-danger" theme="bootstrap" />
				</div>
			</s:if>
		</div>
	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>