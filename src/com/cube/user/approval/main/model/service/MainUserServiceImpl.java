package com.cube.user.approval.main.model.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cube.common.model.dao.CommonDaoImpl;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.main.model.dao.MainUserDaoImpl;

public class MainUserServiceImpl implements MainUserService {

	private static MainUserService mainUserService;
	
	static{
		mainUserService = new MainUserServiceImpl();
	}
	
	private MainUserServiceImpl(){}
	
	public static MainUserService getMainUserService() {
		return mainUserService;
	}

//	@Override
//	public String bapprovallist() {
//		List<Doc_info_detailDto> list = new ArrayList<Doc_info_detailDto>();
//		list = MainUserDaoImpl.getMainUserDao().bapprovallist();
//		JSONObject json = new JSONObject();
//		JSONArray jarray = new JSONArray();
//		for(Doc_info_detailDto doc_info_detailDto :list){
//			JSONObject jobj = new JSONObject();
//			jobj.put("doc_seq", doc_info_detailDto.getDoc_seq());
//			jobj.put("doc_name",doc_info_detailDto.getDoc_name());
//			jobj.put("doc_date", doc_info_detailDto.getDoc_date());
//			jobj.put("doc_writer", doc_info_detailDto.getDoc_writer());
//			jobj.put("doc_dep", doc_info_detailDto.getDoc_dep());
//			jobj.put("confirmname", doc_info_detailDto.getConfirmname());
//			jobj.put("doc_state", doc_info_detailDto.getDoc_state());
//			jobj.put("doc_subject", doc_info_detailDto.getDoc_subject());
//			jobj.put("confirm_state", doc_info_detailDto.getConfirm_state());
//			jobj.put("confirm_complite_date", doc_info_detailDto.getConfirmokdate());
//			jarray.add(jobj);
//		}
//		json.put("bapprovallist", jarray);
//		return json.toJSONString();
//	}
	
	@Override
	public List<Doc_info_detailDto> bapprovallist() {
		return MainUserDaoImpl.getMainUserDao().bapprovallist();
	}

	@Override
	public List<Doc_info_detailDto> depapprovallist(String dep) {
		return MainUserDaoImpl.getMainUserDao().depapprovallist(dep);
	}

}
