package com.wdf.entity;

public class PasswordRetrievalEmail extends Email{
	private String code = "";
	public String emailBody() {
		return "<p>Dear " + this.getName() +",<br>"+
		"Please click the following <a href=\""+ this.getLink() +"\">link</a> to reset your password.<br>"+
		"Please use the following code:<br><h1><strong>"+ 
		this.getCode() +
		"</strong></h1><br> as your security code.<br>"+
		"ABC Jobs"
		;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
