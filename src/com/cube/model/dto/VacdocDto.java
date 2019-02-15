package com.cube.model.dto;

public class VacdocDto extends Doc_info_detailDto{

	 private String vacdoc_start;
	 private String vacdoc_end;      //DB 데이터타입 : date
	 private String vacdoc_kind;  //DB 데이터타입 : date
	 private String vacdoc_content;
	 private String vacdoc_route;
	 
	 
	public String getVacdoc_route() {
		return vacdoc_route;
	}
	public void setVacdoc_route(String vacdoc_route) {
		this.vacdoc_route = vacdoc_route;
	}
	public String getVacdoc_end() {
		return vacdoc_end;
	}
	public String getVacdoc_start() {
		return vacdoc_start;
	}
	public void setVacdoc_start(String vacdoc_start) {
		this.vacdoc_start = vacdoc_start;
	}
	public String getVac_end() {
		return vacdoc_end;
	}
	public void setVacdoc_end(String vacdoc_end) {
		this.vacdoc_end = vacdoc_end;
	}
	public String getVacdoc_kind() {
		return vacdoc_kind;
	}
	public void setVacdoc_kind(String vacdoc_kind) {
		this.vacdoc_kind = vacdoc_kind;
	}
	public String getVacdoc_content() {
		return vacdoc_content;
	}
	public void setVacdoc_content(String vacdoc_content) {
		this.vacdoc_content = vacdoc_content;
	}
	 
}
