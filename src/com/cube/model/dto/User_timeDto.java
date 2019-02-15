package com.cube.model.dto;

public class User_timeDto extends EmployeesDto{

	private int user_time_seq;
	private String employee_id;
	private String usercheckin_date;
	private String usercheckout_date;
	private String usercheckout_time;
	private String usercheckin_time;
	private String user_diligence;
	
	
	
	public String getUser_diligence() {
		return user_diligence;
	}
	public void setUser_diligence(String user_diligence) {
		this.user_diligence = user_diligence;
	}
	public int getUser_time_seq() {
		return user_time_seq;
	}
	public void setUser_time_seq(int user_time_seq) {
		this.user_time_seq = user_time_seq;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getUsercheckin_date() {
		return usercheckin_date;
	}
	public void setUsercheckin_date(String usercheckin_date) {
		this.usercheckin_date = usercheckin_date;
	}
	public String getUsercheckout_date() {
		return usercheckout_date;
	}
	public void setUsercheckout_date(String usercheckout_date) {
		this.usercheckout_date = usercheckout_date;
	}
	public String getUsercheckin_time() {
		return usercheckin_time;
	}
	public void setUsercheckin_time(String usercheckin_time) {
		this.usercheckin_time = usercheckin_time;
	}
	public String getUsercheckout_time() {
		return usercheckout_time;
	}
	public void setUsercheckout_time(String usercheckout_time) {
		this.usercheckout_time = usercheckout_time;
	}
	

	
}
	

