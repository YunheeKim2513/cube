package com.cube.model.dto;

public class SigndocDto extends Doc_info_detailDto{
   
	private String signdoc_seq;
	private String signdoc_content;
	public String getSigndoc_seq() {
		return signdoc_seq;
	}
	public void setSigndoc_seq(String signdoc_seq) {
		this.signdoc_seq = signdoc_seq;
	}
	public String getSigndoc_content() {
		return signdoc_content;
	}
	public void setSigndoc_content(String signdoc_content) {
		this.signdoc_content = signdoc_content;
	}
}
