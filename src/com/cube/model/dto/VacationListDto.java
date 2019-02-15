package com.cube.model.dto;

public class VacationListDto {
	private String employee_id;
	private String employee_name;
	private String department_name;
	private String grade_name;
	private String schedule_startdate;
	private String schedule_enddate;
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getSchedule_startdate() {
		return schedule_startdate;
	}
	public void setSchedule_startdate(String schedule_startdate) {
		this.schedule_startdate = schedule_startdate;
	}
	public String getSchedule_enddate() {
		return schedule_enddate;
	}
	public void setSchedule_enddate(String schedule_enddate) {
		this.schedule_enddate = schedule_enddate;
	}
	
}
