package com.wdf.actions;

import java.sql.SQLException;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.UserDao;
import com.wdf.entity.User;
import com.wdf.utility.MD5;

public class PasswordRetrievalAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5544024382486057582L;
	private String code = "";
	private String password = "";
	private String cpassword = "";
	private String email = "";

	private int i = 0;

	public String execute() {

		try {
			UserDao userdao = new UserDao();
			User user = new User();
			user = (User) userdao.getByEmail(this.getEmail());
			if (user.getCode().contentEquals(this.getCode()))
				;
			{
				i = userdao.updateField("password", MD5.getMd5(this.getPassword()), this.getEmail());
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (i == 1) {
			addActionMessage("Password has been updated successfully.");
			return "success";
		} else {
			addActionMessage(
					"Some error has prevented the password to be resetted. Please contact the administrator for more information.");
			return "success";
		}

	}

	public void validate() {
		if (this.getEmail().length() == 0) {
			addFieldError("email", "Email is required.");
		}
		if (this.getPassword().length() == 0) {
			addFieldError("password", "Password is required.");
		}
		if (this.getCpassword().length() == 0) {
			addFieldError("cpassword", "Password is required.");
		}
		if (!this.cpassword.equals(this.password)) {
			addFieldError("cpassword", "Passwords should match.");
		}
		if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", this.getPassword())) {
			addFieldError("password", "Password is not strong enough.");
		}
	}

	public String getCpassword() {
		return cpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
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
