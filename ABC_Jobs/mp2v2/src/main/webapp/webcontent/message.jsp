<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting...</title>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/popper.js/1.14.3/popper.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="webcontent/css/main.css" />
<script src="https://kit.fontawesome.com/c79997b7ac.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container text-center p-6">
		<h6 class="display-6">
			<s:actionmessage cssStyle="list-style-type: none" theme="simple"/>
			Click <a href="indexLink">here</a> if you are not redirected within
				5 seconds.
		</h6>

	</div>

	<script>
		setTimeout(function() {
			document.location = "/mp2v2/index.jsp";
		}, 3000); // <-- this is the delay in milliseconds
	</script>
</body>
</html>