/**
 * 
 */

function validateForm() {
	if (!document.getElementById("register_action_fname").value
			|| !document.getElementById("register_action_email").value
			|| !document.getElementById("register_action_password").value
			|| !document.getElementById("register_action_cpassword").value) {
		document.getElementById("error").innerHTML = "Please fill in required fields.";
		return false;
	}
	if (!passwordMatch()) {
		document.getElementById("error").innerHTML = "Passwords do not match.";
		return false;
	}
	if (!passwordIsStrong()) {
		document.getElementById("error").innerHTML = "Password should be longer than 8 characters and contains alphabets, numbers and symbols."
		return false;
	}
	return true;

}

function passwordMatch() {
	if (document.getElementById("register_action_password").value === document
			.getElementById("register_action_cpassword").value) {
		return true;
	} else {
		return false;
	}
}

function passwordIsStrong() {
	var regExp = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*()]).{8,}/;
	var password = document.getElementById("register_action_password").value;
	var validPassword = regExp.test(password);

	return validPassword;
}