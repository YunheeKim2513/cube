package com.cube.model.dto;

public class OrderdocDto extends Doc_info_detailDto{
      
	  private String orderdoc_seq;
	  private String orderdoc_content;
	public String getOrderdoc_seq() {
		return orderdoc_seq;
	}
	public void setOrderdoc_seq(String orderdoc_seq) {
		this.orderdoc_seq = orderdoc_seq;
	}
	public String getOrderdoc_content() {
		return orderdoc_content;
	}
	public void setOrderdoc_content(String orderdoc_content) {
		this.orderdoc_content = orderdoc_content;
	}
	  
}
