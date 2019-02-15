package com.cube.common.model.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cube.common.model.dao.CommonDaoImpl;
import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.model.dto.VacdocDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.model.dto.Work_report_replyDto;


public class CommonServiceImpl implements CommonService {

	
	private static  CommonServiceImpl commonServiceImpl;
	
	static{
		commonServiceImpl = new CommonServiceImpl();
		
	}
	
	public static CommonServiceImpl getCommonServiceImpl() {
		return commonServiceImpl;
	}

	private CommonServiceImpl(){}

	@Override
	public String seq(String doccode, String eid) {
		return CommonDaoImpl.getCommonDaoImpl().seq(doccode, eid);
	}

	@Override
	public SigndocDto signview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().signview(seq);
	}

	@Override
	public OrderdocDto orderview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().orderview(seq);
	}

	@Override
	public VacdocDto vacview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().vacview(seq);
	}

	@Override
	public BiztripdocDto bizview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().bizview(seq);
	}

	@Override
	public Biztrip_reportDto breportview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().breportview(seq);
	}

	@Override
	public DeaddocDto deadview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().deadview(seq);
	}

	@Override
	public String confirmname(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().confirmname(seq);
	}

	@Override
	public int confirmcheck(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().confirmcheck(seq);
	}

	@Override
	public int confirmnames(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().confirmnames(seq);
	}

	@Override
	public void docstate(String seq) {
		CommonDaoImpl.getCommonDaoImpl().docstate(seq);
	}

	@Override
	public void docdead(String seq, String docwriteid) {
		CommonDaoImpl.getCommonDaoImpl().docdead(seq, docwriteid);
	}

	@Override
	public void docstatecancel(String seq) {
		CommonDaoImpl.getCommonDaoImpl().docstatecancel(seq);
	}

	@Override
	public Work_reportDto work_reportview(String seq) {
		return CommonDaoImpl.getCommonDaoImpl().work_reportview(seq);
	}

	@Override
	public void memowrite(Work_report_replyDto work_report_replyDto) {
		CommonDaoImpl.getCommonDaoImpl().memowrite(work_report_replyDto);
	}

	@Override
	public String memoList(String seq) {
		List<Work_report_replyDto> list = new ArrayList<Work_report_replyDto>();
		list = CommonDaoImpl.getCommonDaoImpl().memoList(seq);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		for(Work_report_replyDto work_report_replyDto :list){
			JSONObject jobj = new JSONObject();
			jobj.put("mseq", work_report_replyDto.getWmseq());
			jobj.put("seq",work_report_replyDto.getDoc_seq());
			jobj.put("mname", work_report_replyDto.getMwriter());
			jobj.put("mcontent", work_report_replyDto.getContent());
			jobj.put("mlogtime", work_report_replyDto.getWmlogtime());
			jobj.put("mid", work_report_replyDto.getMid());
			jarray.add(jobj);
		}
		json.put("memolist", jarray);
		return json.toJSONString();
	}

	@Override
	public void memoDelete(int mseq) {
		CommonDaoImpl.getCommonDaoImpl().memoDelete(mseq);
	}

	@Override
	public void memoModify(Work_report_replyDto work_report_replyDto) {
		CommonDaoImpl.getCommonDaoImpl().memoModify(work_report_replyDto);		
	}

	@Override
	public void docvac(VacdocDto vacdocDto) {
		CommonDaoImpl.getCommonDaoImpl().docvac(vacdocDto);
	}

	@Override
	public void docbiztrip(BiztripdocDto biztripdocDto) {
		CommonDaoImpl.getCommonDaoImpl().docbiztrip(biztripdocDto);
	}
}
