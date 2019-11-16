package com.wdf.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1161958165691844071L;
	
	private String message;
	
	public String execute() {
		return "success";
		
	}
	public String login() {
		return "login";
	}
	public String register() {
		return "register";
	}
	
	public String profile() {
		return "profile";
	}
	
	public String search() {
		return "search";
	}
	
	public String passwordRetrieval() {
		return "passwordretrieval";
	}
	public String passwordRetrievalTrigger() {
		return "passwordretrievaltrigger";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
