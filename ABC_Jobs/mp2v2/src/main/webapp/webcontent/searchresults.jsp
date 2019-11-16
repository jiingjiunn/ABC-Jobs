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
		<h2>Search Results</h2>
		<s:if test="dataset==true">

			<s:iterator value="profilelist">
				<div class="card profile mb-1">
					<div class="card-body">
						<div class="row px-3">
							<div>
								<h5 class="card-title">
									<s:property value="firstName" />
									<s:property value="lastName" />
								</h5>
								<h6 class="card-subtitle mb-2 text-muted">
									<s:property value="jobrole" />
									at
									<s:property value="employer" />
								</h6>
								<p class="card-text">
									<s:property value="location" />
								</p>
							</div>
							<div class="ml-auto">
								<a href="getProfile.action?email=<s:property value="email"/>">
									<button class="btn btn-primary">View Profile</button>
								</a>

							</div>

						</div>
					</div>
				</div>
			</s:iterator>

		</s:if>
		<s:else>
			<div class="card nodata">
				<p class="text-center">Search query does not match any profile.</p>
			</div>
		</s:else>
	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>