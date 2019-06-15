package cn.edu.imnu.itoffter.info;

import java.sql.Date;

public class Job {
	private int jobId;
	private Company company;
	private String jobName;
	private int jobHiringnum;
	private String jobSalary;
	private String jobArea;
	private String jobDesc;
	private Date jobEnddate;
	private int jobState;
	
	public Job() {
		super();
	}
	public Job(int jobId,Company company,String jobName,int jobHiringnum,String jobSalary,String jobArea
			,String jobDesc,Date jobEnddate,int jobState) {
		super();
		this.jobId = jobId;
		this.company = company;
		this.jobName = jobName;
		this.jobHiringnum = jobHiringnum;
		this.jobSalary = jobSalary;
		this.jobArea = jobArea;
		this.jobDesc = jobDesc;
		this.jobEnddate = jobEnddate;
		this.jobState = jobState;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getJobHiringnum() {
		return jobHiringnum;
	}
	public void setJobHiringnum(int jobHiringnum) {
		this.jobHiringnum = jobHiringnum;
	}
	public String getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getJobArea() {
		return jobArea;
	}
	public void setJobArea(String jobArea) {
		this.jobArea = jobArea;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getJobEnddate() {
		return jobEnddate;
	}
	public void setJobEnddate(Date jobEnddate) {
		this.jobEnddate = jobEnddate;
	}
	public int getJobState() {
		return jobState;
	}
	public void setJobState(int jobState) {
		this.jobState = jobState;
	}

}
