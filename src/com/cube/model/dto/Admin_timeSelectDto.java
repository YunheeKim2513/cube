package com.cube.model.dto;

public class Admin_timeSelectDto {
	private String Startset;
	private String Endset;
	private String GroupStandard;
	private String Admintime_seq;
	
	public String getAdmintime_seq() {
		return Admintime_seq;
	}
	public void setAdmintime_seq(String admintime_seq) {
		Admintime_seq = admintime_seq;
	}
	public String getStartset() {
		return Startset;
	}
	public void setStartset(String startset) {
		Startset = startset;
	}
	public String getEndset() {
		return Endset;
	}
	public void setEndset(String endset) {
		Endset = endset;
	}
	public String getGroupStandard() {
		return GroupStandard;
	}
	public void setGroupStandard(String groupStandard) {
		GroupStandard = groupStandard;
	}
} 
