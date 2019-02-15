package com.cube.model.dto;

public class NoticeDto {
	
	  private int notice_seq;
	  private String employee_id;
	  private String notice_subject;
	  private String notice_content;
	  private String notic_writer;
	  private String notice_state;
	  private String employee_dep;
	  private String notice_date;
	  private String notice_complite;
	  
	  
	  
	public void setNotice_complite(String notice_complite) {
		this.notice_complite = notice_complite;
	}
	public String getNotice_complite() {
		return notice_complite;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getEmployee_dep() {
		return employee_dep;
	}
	public void setEmployee_dep(String employee_dep) {
		this.employee_dep = employee_dep;
	}
	public String getNotice_state() {
		return notice_state;
	}
	public void setNotice_state(String notice_state) {
		this.notice_state = notice_state;
	}
	public String getNotic_writer() {
		return notic_writer;
	}
	public void setNotic_writer(String notic_writer) {
		this.notic_writer = notic_writer;
	}
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getNotice_subject() {
		return notice_subject;
	}
	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}  

}
