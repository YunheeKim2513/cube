package com.cube.model.dto;

public class BiztripdocDto extends Doc_info_detailDto{

	 private String biztripdoc_start;
	 private String biztripdoc_end;
	 private String biztripdoc_place;
	 private String biztripdoc_content;
	 private String biztripdoc_route;
	 
	public String getBiztripdoc_route() {
		return biztripdoc_route;
	}
	public void setBiztripdoc_route(String biztripdoc_route) {
		this.biztripdoc_route = biztripdoc_route;
	}
	public String getBiztripdoc_start() {
		return biztripdoc_start;
	}
	public void setBiztripdoc_start(String biztripdoc_start) {
		this.biztripdoc_start = biztripdoc_start;
	}
	public String getBiztripdoc_end() {
		return biztripdoc_end;
	}
	public void setBiztripdoc_end(String biztripdoc_end) {
		this.biztripdoc_end = biztripdoc_end;
	}
	public String getBiztripdoc_place() {
		return biztripdoc_place;
	}
	public void setBiztripdoc_place(String biztripdoc_place) {
		this.biztripdoc_place = biztripdoc_place;
	}
	public String getBiztripdoc_content() {
		return biztripdoc_content;
	}
	public void setBiztripdoc_content(String biztripdoc_content) {
		this.biztripdoc_content = biztripdoc_content;
	}
	 
}
