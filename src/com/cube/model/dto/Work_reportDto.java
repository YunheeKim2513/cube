package com.cube.model.dto;

public class Work_reportDto extends Doc_info_detailDto{
	
	 private String workdoc_open;
	 private String workdoc_daycontent;   //DB 데이터타입 : CLOB
	 private String workdoc_nextcontent;   //DB 데이터타입 : CLOB
	 private String confirmlist;
	 private String workdoc_kind;
	 private String workdoc_finaltime;
	 
	 
	public String getWorkdoc_finaltime() {
		return workdoc_finaltime;
	}
	public void setWorkdoc_finaltime(String workdoc_finaltime) {
		this.workdoc_finaltime = workdoc_finaltime;
	}
	public void setWorkdoc_kind(String workdoc_kind) {
		this.workdoc_kind = workdoc_kind;
	}
	public String getWorkdoc_kind() {
		return workdoc_kind;
	}
	public String getWorkdoc_open() {
		return workdoc_open;
	}
	public void setWorkdoc_open(String workdoc_open) {
		this.workdoc_open = workdoc_open;
	}
	public String getConfirmlist() {
		return confirmlist;
	}
	public void setConfirmlist(String confirmlist) {
		this.confirmlist = confirmlist;
	}
	public String getWorkdoc_daycontent() {
		return workdoc_daycontent;
	}
	public void setWorkdoc_daycontent(String workdoc_daycontent) {
		this.workdoc_daycontent = workdoc_daycontent;
	}
	public String getWorkdoc_nextcontent() {
		return workdoc_nextcontent;
	}
	public void setWorkdoc_nextcontent(String workdoc_nextcontent) {
		this.workdoc_nextcontent = workdoc_nextcontent;
	}

}
