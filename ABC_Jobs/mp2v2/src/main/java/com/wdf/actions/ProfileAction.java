package com.wdf.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.ProfileDao;
import com.wdf.entity.Profile;

public class ProfileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361198269497509966L;
	String email = "";
	Profile profile;
	ProfileDao profiledao;
	String firstname, lastname, jobrole, employer, location = firstname = lastname = jobrole = employer = location = "";
	int i = 0;

//	Getting the profile info to populate the profile page
	@org.apache.struts2.interceptor.validation.SkipValidation
	public String get() {
		try {

			profile = new Profile();
			profiledao = new ProfileDao();
			profile = (Profile) profiledao.getByEmail(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

//	Trigger update profile form
	@org.apache.struts2.interceptor.validation.SkipValidation
	public String edit() {
		try {

			profile = new Profile();
			profiledao = new ProfileDao();
			profile = (Profile) profiledao.getByEmail(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "edit";
	}

//	Update profile form
	public String update() {
		try {
			profile = new Profile();
			profiledao = new ProfileDao();
			profile = (Profile) profiledao.getByEmail(email);

			profile.setFirstName(firstname);
			profile.setLastName(lastname);
			profile.setLocation(location);
			profile.setEmployer(employer);
			profile.setJobrole(jobrole);

			i = profiledao.update(profile);
			if(i > 0) {
				System.out.println(profile.toString());
			}
			System.out.println("from update");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update";
	}

//	Getter and Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ProfileDao getProfiledao() {
		return profiledao;
	}

	public void setProfiledao(ProfileDao profiledao) {
		this.profiledao = profiledao;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// Validation of profile form
	public void validate() {

	}

}
