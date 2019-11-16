package com.wdf.entity;

public class VerificationEmail extends Email{
	public String emailBody() {
		return "<p>Dear " + getName() +",<br>"+
		"Please click the following <a href=\""+ this.getLink() +"\">link</a> to verify your email.<br>"+
		"ABC Jobs"
		;
	}
}
