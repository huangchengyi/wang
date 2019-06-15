package cn.edu.imnu.itoffter.info;

import java.util.Date;

public class ResumeBasicinfo {
	private String realName;
	private String gender;
	private Date birthday;
	private String telephone ;
	private String email;
	private String jobIntension;
	private String jobExperience;
	
	public String  getRealName() {
		return this.realName;
	}
	
	public String  getGender() {
		return this.gender;
	}
	
	public Date  getBirthday() {
		return this.birthday;
	}
	
	public String  getTelephone() {
		return this.telephone;
	}
	
	public String  getEmail() {
		return this.email;
	}
	
	public String  getJobIntension() {
		return this.jobIntension;
	}
	
	public String  getJobExperience() {
		return this.jobExperience;
	}
	
	public ResumeBasicinfo(String realName,String gender,Date birthdayDate,String telephone,String email,String jobIntension,String jobExperience) {
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthdayDate;
		this.telephone = telephone;
		this.email = email;
		this.jobIntension = jobIntension;
		this.jobExperience = jobExperience;
	}
	
	private static void  Test() {
		ResumeBasicinfo info =  new ResumeBasicinfo(null, null, null, null, null, "JOB _ INT ", "JOB _ EXP ");
		System.out.println(info.getEmail());
		System.out.println(info.getGender());
		System.out.println(info.getTelephone());
		System.out.println(info.getEmail());
		System.out.println(info.getJobExperience());
		System.out.println(info.getJobIntension());
	}
	public static void main(String[] args) {
		Test();
	}

	public String getCurrentLoc() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHeadShot() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getResidentLoc() {
		// TODO Auto-generated method stub
		return null;
	}
}
