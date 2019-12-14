<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Jobs</title>
</head>
<body>
	<s:include value="/webcontent/header.jsp" />
	<div class="container main">
		<h1>News Feed</h1>
		<div class="newsfeed container">
			<s:include value="/webcontent/newsfeed.jsp" />
		</div>	
	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>