<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<s:if test="dataset">
		<h1>test</h1>
		<s:iterator value="newsFeed">
			<div class="card">
				<div class="card-body">
					<div class="threadOwner row">
						<div class="threadOwnerPotrait rounded-circle align-self-center">
							<i class="fas fa-user"></i>
						</div>
						<div class="threadOwnerDetail mr-auto">
							<h5 class="card-title">
								<s:property value="owner" />
							</h5>
							<div class="card-subtitle text-muted">
								<s:property value="ownerRole" />
							</div>
							<div class="DateTime text-muted ">
								<small><s:property value="threadTimeStamp" /> </small>
							</div>
						</div>
					</div>
					<p class="card-text">
						<s:property value="threadContent" />
					</p>
				</div>
				<ul class="list-group list-group-flush">
					<s:iterator value="#newsFeed.replies">
						<li class="list-group-item">
							<div class="replyOwner row">
								<div class="replyPotrait rounded-circle">
									<i class="fas fa-user"></i>
								</div>
								<h6>
									<s:property value="replyOwner" />
								</h6>
							</div>
							<div class="replyText">
								<s:property value="replyMessage" />
							</div>
							<div class="DateTime text-muted">
								<small><s:property value="replyMessageTimeStamp" /></small>
							</div>
						</li>
					</s:iterator>


					<li class="list-group-item">
						<div class="replyOwner row">
							<div class="replyPotrait rounded-circle">
								<i class="fas fa-user"></i>
							</div>
							<h6>
								<s:property value="#session.name" />
							</h6>
						</div>
						<div class="replyInput input-group">
							<input type="text" class="replyInputForm form-control"
								placeholder="reply...">
							<div class="input-group-append">
								<input type="submit" class="btn btn-primary" value="reply">
							</div>
						</div>
					</li>
				</ul>
			</div>
			<s:form>
				<s:textfield value="replyToThread"></s:textfield>
				<s:submit />
			</s:form>
		</s:iterator>
		Test
	</s:if>
	<div class="card">
		<div class="card-body">
			<div class="threadOwner row">
				<div class="threadOwnerPotrait rounded-circle align-self-center">
					<i class="fas fa-user"></i>
				</div>
				<div class="threadOwnerDetail mr-auto">
					<h5 class="card-title">Harry Potter</h5>
					<div class="card-subtitle text-muted">Web Developer at
						Facebook</div>
					<div class="DateTime text-muted ">
						<small>November 30 at 3.00 PM </small>
					</div>
				</div>
			</div>
			<p class="card-text">A quick brown fox jumps over the lazy dog.</p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<div class="replyOwner row">
					<div class="replyPotrait rounded-circle">
						<i class="fas fa-user"></i>
					</div>
					<h6>Ron Weasley</h6>
				</div>
				<div class="replyText">Lorem ipsum doauemn ehresn grte eh
					diasen</div>
				<div class="DateTime text-muted">
					<small>November 30 at 3.00 PM </small>
				</div>
			</li>
			<li class="list-group-item">
				<div class="replyOwner row">
					<div class="replyPotrait rounded-circle">
						<i class="fas fa-user"></i>
					</div>
					<h6>Harry Potter</h6>
				</div>
				<div class="replyInput input-group">
					<input type="text" class="replyInputForm form-control"
						placeholder="reply...">
					<div class="input-group-append">
						<button class="btn btn-primary">Reply</button>
					</div>
				</div>
			</li>
		</ul>

	</div>
</body>
</html>