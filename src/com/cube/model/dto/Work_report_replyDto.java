package com.cube.model.dto;

public class Work_report_replyDto extends Work_reportDto {

	 private int wmseq; 
     private String content;
     private String mwriter;
     private String wmlogtime;
     private String mid;
     
     
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getWmlogtime() {
		return wmlogtime;
	}
	public void setWmlogtime(String wmlogtime) {
		this.wmlogtime = wmlogtime;
	}
	public String getMwriter() {
		return mwriter;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWmseq() {
		return wmseq;
	}
	public void setWmseq(int wmseq) {
		this.wmseq = wmseq;
	}
}
