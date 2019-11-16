<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting...</title>
</head>
<body>
	<s:actionmessage cssClass="alert alert-success" theme="bootstrap" />
	<p>Click <a href="index.jsp">here</a> if you are not redirected within 5 seconds.</p>
	<script>
		setTimeout(function() {
			document.location = "index.jsp";
		}, 3000); // <-- this is the delay in milliseconds
	</script>
</body>
</html>