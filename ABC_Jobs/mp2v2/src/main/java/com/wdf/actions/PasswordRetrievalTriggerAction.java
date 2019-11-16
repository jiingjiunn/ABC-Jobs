package com.wdf.actions;

import java.sql.SQLException;
import javax.mail.MessagingException;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.UserDao;
import com.wdf.entity.PasswordRetrievalEmail;
import com.wdf.entity.User;
import com.wdf.utility.RandomString;
import com.wdf.utility.TLSEmail;

public class PasswordRetrievalTriggerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5544024382486057582L;
	private String code = "";
	private String email = "";

	public String execute() {

//		Generating security code
		RandomString random = new RandomString();
		String verifystring = random.getRandomString(6);

//		Inserting security code into database
		UserDao userdao = new UserDao();
		User user = new User();
		try {
			user = (User) userdao.getByEmail(email);
			if(user == null) {
				addActionMessage("Some error is preventing password reset.");
				return "success";
			}
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			int i = -1;
			i = userdao.updateField("code", verifystring, email);
			if (i == 0) {
				addActionMessage("Some error is preventing password reset.");
				return "success";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		Sending email with the security code.
		PasswordRetrievalEmail remail = new PasswordRetrievalEmail();
		remail.setEmail(email);
		remail.setSubject("Reset Password for" + email + " on ABC Jobs");
		remail.setCode(verifystring);
		remail.setName(user.getName());
		remail.setLink("http://localhost:8080/mp2v2/passwordRetrievalLink");

		try {
			TLSEmail.sendTLSEmail(remail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage("Password has been updated successfully");
		return "success";
	}

	public void validate() {
		if (this.getEmail().length() == 0) {
			addFieldError("email", "Email is required.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
