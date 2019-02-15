package com.cube.model.dto;

public class ScheduleDto extends EmployeesListDto{

	 private String employee_id;
	 private int schedule_seq;
	 private String schedule_subject;
	 private String schedule_content;
	 private String schedule_startdate;
	 private String schedule_starttime;
	 private String schedule_enddate;
	 private String schedule_endtime;
	 private String schedule_participant;
	 private String schedule_kind;
	 private String schedule_department;
	 
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public int getSchedule_seq() {
		return schedule_seq;
	}
	public void setSchedule_seq(int schedule_seq) {
		this.schedule_seq = schedule_seq;
	}
	public String getSchedule_subject() {
		return schedule_subject;
	}
	public void setSchedule_subject(String schedule_subject) {
		this.schedule_subject = schedule_subject;
	}
	public String getSchedule_content() {
		return schedule_content;
	}
	public void setSchedule_content(String schedule_content) {
		this.schedule_content = schedule_content;
	}
	public String getSchedule_startdate() {
		return schedule_startdate;
	}
	public void setSchedule_startdate(String schedule_startdate) {
		this.schedule_startdate = schedule_startdate;
	}
	public String getSchedule_starttime() {
		return schedule_starttime;
	}
	public void setSchedule_starttime(String schedule_starttime) {
		this.schedule_starttime = schedule_starttime;
	}
	public String getSchedule_enddate() {
		return schedule_enddate;
	}
	public void setSchedule_enddate(String schedule_enddate) {
		this.schedule_enddate = schedule_enddate;
	}
	public String getSchedule_endtime() {
		return schedule_endtime;
	}
	public void setSchedule_endtime(String schedule_endtime) {
		this.schedule_endtime = schedule_endtime;
	}
	public String getSchedule_participant() {
		return schedule_participant;
	}
	public void setSchedule_participant(String schedule_participant) {
		this.schedule_participant = schedule_participant;
	}
	public String getSchedule_kind() {
		return schedule_kind;
	}
	public void setSchedule_kind(String schedule_kind) {
		this.schedule_kind = schedule_kind;
	}
	public String getSchedule_department() {
		return schedule_department;
	}
	public void setSchedule_department(String schedule_department) {
		this.schedule_department = schedule_department;
	}
	
	 
}
