package com.wdf.actions;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.entity.User;
import com.wdf.utility.MD5;
import com.wdf.dao.*;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7164958494835190250L;
	private User user = new User();
	private UserDao userDao = new UserDao();
	private String email, password = setEmail("");
	
	public String execute() {
		try {
			System.out.println(MD5.getMd5(this.password));
			user = (User)userDao.getByEmail(this.email);
			System.out.println(user.getPassword());
			if(user.getPassword().equals(MD5.getMd5(this.password))) {
				addActionMessage(
						"Welcome back, "+user.getName());
				return "success";
			}else {
				addActionError("We could not find any registered user matching the login details.");
				return "error";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("We could not find any registered user matching the login details.");
		}
		return "error";
	}
	
	public void validate() {
		if(this.getEmail().length() == 0) {
			addFieldError("email", "Email is required.");
		}
		if(this.getEmail().length() == 0) {
			addFieldError("password", "Password is required.");
		}
	}
	
	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		this.email = email;
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
