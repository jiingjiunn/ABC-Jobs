<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:property value="profile.getName" />'s Profile</title>
</head>
<body>
	<s:include value="/webcontent/header.jsp" />
	<div class="container main">
		<div class="row">
			<div class="profile p-2 col-12 col-sm-4">
				<div class="mx-3 d-flex flex-column align-items-center">
					<div class="potrait">
						<img class="profilepic" alt="profilepic"
							src="https://www.payal.co.uk/wp-content/uploads/image_carousel_thumbs/Dummy-profile-picture-nx3mkaougs1i6vxuvb4p5i72go7eap7qkoqrv1pd8k.png">
					</div>
					<div class="name">
						<h5>
							<s:property value="profile.firstName" />
							<s:property value="profile.lastName" />
						</h5>
					</div>
					<div class="job">
						<s:property value="profile.jobrole" />
						at
						<s:property value="profile.employer" />
					</div>
					<div class="location">
						<s:property value="profile.location" />
					</div>
					<s:if test="%{#session.email==profile.email}">
						<a href="editProfile?email=<s:property value="#session.email"/>"><i class="fas fa-pencil-alt"></i>Edit
							Profile</a>
					</s:if>
				</div>
			</div>
			<div class="col-12 col-sm-8 m-0 ">
				<div class="card personal p-4 mb-2">
					<h3>About</h3>
					Feature under construction
					<s:if test="%{#session.email==profile.email}">
						<a href="editProfile"><i class="fas fa-pencil-alt"></i>Edit
							About</a>
					</s:if>
				</div>
				<div class="card personal p-4 mb-2">
					<h3>Career</h3>
					Feature under construction
					<s:if test="%{#session.email==profile.email}">
						<a href="editProfile"><i class="fas fa-pencil-alt"></i>Edit
							Career</a>
					</s:if>
				</div>
				<div class="card personal p-4 mb-2">
					<h3>Education</h3>
					Feature under construction
					<s:if test="%{#session.email==profile.email}">
						<a href="editProfile"><i class="fas fa-pencil-alt"></i>Edit
							Education</a>
					</s:if>
				</div>
			</div>
		</div>

	</div>
	<s:include value="/webcontent/footer.jsp" />
</body>
</html>