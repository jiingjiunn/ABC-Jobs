<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/popper.js/1.14.3/popper.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="webcontent/css/main.css" />
<link href="webcontent/css/iconic/open-iconic-bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<header>
		<!-- navbar brand -->
		<nav class="navbar navbar-expand-md navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="index">ABC Jobs</a>

				<s:form cssClass="form-inline mr-auto" action="search"
					theme="simple">
					<div class="input-group">
						<s:textfield cssClass="form-control" type="search"
							placeholder="Search" name="query"></s:textfield>
						<div class="input-group-append">
							<s:submit cssClass="btn btn-outline-secondary" value="Search"></s:submit>
						</div>
					</div>
				</s:form>

				<!--  
				<form class="form-inline mr-auto" action="search" method="get">
					<div class="input-group">
						<input class="form-control" type="search" placeholder="Search"
							name="query">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit">
								<span class="oi oi-magnifying-glass"></span>
							</button>
						</div>
					</div>
				</form>
-->


				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarContent">
					<span class="navbar-toggler-icon"></span>
				</button>

				<!-- collapsible nav content -->
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link disabled" href="#">Jobs</a></li>
						<li class="nav-item"><a class="nav-link" href="profileLink">User
								Profile</a></li>
					</ul>
					<div class="dropdown-divider"></div>
					<ul class="navbar-nav">
						<s:if test="%{#session.login}">
							<li class="nav-item"><a class="nav-link"
								href='getProfile?email=<s:property value="#session.email"/>'><s:property
										value="#session.name" /></a></li>
							<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
						</s:if>
						<s:else>
							<li class="nav-item"><a class="nav-link" href="loginLink">Login</a></li>
							<li class="nav-item"><a class="nav-link" href="registerLink">Register</a></li>
						</s:else>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>