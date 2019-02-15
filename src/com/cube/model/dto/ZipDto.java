package com.cube.model.dto;

public class ZipDto {
	private String zip1;
	private String zip2;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	public String getZip1() {
		return zip1;
	}
	public void setZip1(String zip1) {
		this.zip1 = zip1;
	}
	public String getZip2() {
		return zip2;
	}
	public void setZip2(String zip2) {
		this.zip2 = zip2;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public ZipDto(String zip1, String zip2, String sido, String gugun, String dong, String bunji) {
		super();
		this.zip1 = zip1;
		this.zip2 = zip2;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
	}
	public ZipDto() {
		super();
	}	
	
	
}
