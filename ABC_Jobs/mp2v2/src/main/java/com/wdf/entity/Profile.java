package com.wdf.entity;

public class Profile extends User{
	private String location = "";
	private String jobrole ="";
	private String employer = "";
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	@Override
	public String toString() {
		return "Profile [location=" + location + ", jobrole=" + jobrole + ", employer=" + employer + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
