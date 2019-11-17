package com.wdf.actions;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.UserDao;
import com.wdf.entity.User;
import com.wdf.entity.VerificationEmail;
import com.wdf.utility.TLSEmail;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 570456006444505983L;
	private User user = new User();
	private UserDao userdao = new UserDao();
	private String fname, lname, email, password, cpassword = fname = lname = email = password = "";
	private String message = "";
	int i = 0;

	public String execute() {
		
		try {
			user.setReg(fname, lname, email, password);
			i = userdao.insert(user);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (i < 1) {
			addActionError("Unable to create account.");
			return "error";
		} else {
			addActionMessage(
					"User account has been created successfully. An email will be sent to you shortly with further instruction.");
			VerificationEmail Vemail = new VerificationEmail();
			Vemail.setName(fname + " " + lname);
			Vemail.setEmail(email);
			Vemail.setLink("localhost:8080/mp2v2/verify?email="+email);
			Vemail.setSubject("Verification Email for " + Vemail.getName() );
			try {
				TLSEmail.sendTLSEmail(Vemail);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}

	}
	
	public void validate() {
		System.out.println(this.getPassword());

	    if (this.getFname().length() == 0) {
	        addFieldError("fname", "First name is required.");
	    }

	    if (this.getEmail().length() == 0) {
	        addFieldError("email", "Email is required.");
	    }
	    
	    if (!Pattern.matches("^(.+)@(.+)$",this.getEmail())) {
			addFieldError("email", "Email is not valid.");
	    }

	    if (this.getPassword().length() < 8) {
	        addFieldError("password", "Password should be at least 8 characters long.");
	    }
	    
		Pattern pattern;
	    Matcher matcher;
		final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(this.getPassword());
	    if (matcher.matches()) {
	    	addFieldError("password", "Password is not strong enough.");
	    }	    
	    if (!this.getPassword().equals(this.getCpassword())) {
	    	addFieldError("cpassword", "Passwords should match.");
	    }
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
