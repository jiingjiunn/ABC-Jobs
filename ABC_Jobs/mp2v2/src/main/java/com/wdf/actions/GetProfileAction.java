package com.wdf.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.wdf.dao.ProfileDao;
import com.wdf.entity.Profile;

public class GetProfileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361198269497509966L;
	String email = "";
	Profile profile;
	ProfileDao profiledao;
	
	public String execute() {
		try {
			System.out.println("email is " + email);
			profile = new Profile();
			profiledao = new ProfileDao();
			profile = (Profile) profiledao.getByEmail(email);
			System.out.println("profile is "+ profile.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

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
	
}
