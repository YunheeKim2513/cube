package com.cube.common.model.service;

import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.model.dto.VacdocDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.model.dto.Work_report_replyDto;

public interface CommonService {
	String seq(String doccode, String eid);
	SigndocDto signview(String seq);
	OrderdocDto orderview(String seq);
	VacdocDto vacview(String seq);
	BiztripdocDto bizview(String seq);
	Biztrip_reportDto breportview(String seq);
	DeaddocDto deadview(String seq);
	Work_reportDto work_reportview(String seq);
	String confirmname(String seq);
	int confirmcheck(String seq);
	int confirmnames(String seq);
	void docstate(String seq);
	void docdead(String seq, String docwriteid);
	void docstatecancel(String seq);
	void memowrite(Work_report_replyDto work_report_replyDto);
	String memoList(String seq);
	void memoDelete(int mseq);
	void memoModify(Work_report_replyDto work_report_replyDto);
	void docvac(VacdocDto vacdocDto);
	void docbiztrip(BiztripdocDto biztripdocDto);
}
