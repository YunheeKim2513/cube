package com.cube.model.dto;

public class MemoDto extends NoticeDto{
       
	  private String employee_id;
	  private int memo_seq;
	  private String memo_logtime;
	  private String memo_subject;
	  private String memo_content;
	  private String memo_writer;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public int getMemo_seq() {
		return memo_seq;
	}
	public void setMemo_seq(int memo_seq) {
		this.memo_seq = memo_seq;
	}
	public String getMemo_logtime() {
		return memo_logtime;
	}
	public void setMemo_logtime(String memo_logtime) {
		this.memo_logtime = memo_logtime;
	}
	public String getMemo_subject() {
		return memo_subject;
	}
	public void setMemo_subject(String memo_subject) {
		this.memo_subject = memo_subject;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	public String getMemo_writer() {
		return memo_writer;
	}
	public void setMemo_writer(String memo_writer) {
		this.memo_writer = memo_writer;
	}
	  
	  
}
