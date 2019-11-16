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
		<div class= "card profile">
			<div class="row">
				<div class="col-12  col-sm-4 col-lg-3">
					<img class="profilepic" alt="profilepic"
						src="https://www.payal.co.uk/wp-content/uploads/image_carousel_thumbs/Dummy-profile-picture-nx3mkaougs1i6vxuvb4p5i72go7eap7qkoqrv1pd8k.png">
				</div>
				<div class="col-12  col-sm-8 col-lg-9">
					<table class="profile-info">
						<tbody>
							<tr>
								<th>Name</th>
								<td><s:property value="profile.firstName" /> <s:property value="profile.lastName" /></td>
							</tr>
							<tr>
								<th>Job</th>
								<td><s:property value="profile.jobrole" /> at <s:property value="profile.employer" /></td>
							</tr>
							<tr>
								<th>Location</th>
								<td><s:property value="profile.location" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<s:property value="firstName" />
		</div>

	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>