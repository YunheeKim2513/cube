package com.cube.model.dto;

public class EmployeeDilDto {

	   private String employee_id;
	   private String department_id;
	   private String department_name;
	   private String grade_id;
	   private String name;
	   private String working;
	   private String garde_name;
	   private String nomal_limit;//정상출근
	   private String group_standard;//근태 그룹 저장
	   private String endtime;
	   private String endhour;
	   private String endmin;
	   private String starttime;
	   private String starthour;
	   private String startmin;
		   
		   
		   
	   
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEndhour() {
		return endhour;
	}
	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}
	public String getEndmin() {
		return endmin;
	}
	public void setEndmin(String endmin) {
		this.endmin = endmin;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStarthour() {
		return starthour;
	}
	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}
	public String getStartmin() {
		return startmin;
	}
	public void setStartmin(String startmin) {
		this.startmin = startmin;
	}

	public String getGroup_standard() {
		return group_standard;
	}
	public void setGroup_standard(String group_standard) {
		this.group_standard = group_standard;
	}

	public String getEmployee_id() {
		return employee_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWorking(String working) {
		this.working = working;
	}
	public void setGarde_name(String garde_name) {
		this.garde_name = garde_name;
	}
	public void setNomal_limit(String nomal_limit) {
		this.nomal_limit = nomal_limit;
	}

	public String getGrade_id() {
		return grade_id;
	}
	public String getName() {
		return name;
	}
	public String getWorking() {
		return working;
	}
	public String getGarde_name() {
		return garde_name;
	}
	public String getNomal_limit() {
		return nomal_limit;
	}

	
}
