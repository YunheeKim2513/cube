package com.cube.admin.home.model.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cube.admin.home.model.dao.HomeAdminDaoImpl;
import com.cube.model.dto.MemoDto;
import com.cube.model.dto.NoticeDto;

public class HomeAdminServiceImpl implements HomeAdminService {

	private static HomeAdminService homeAdminService;
	
	static {
		homeAdminService = new HomeAdminServiceImpl();
	}
	
	private HomeAdminServiceImpl(){}
	
	public static HomeAdminService getHomeAdminService() {
		return homeAdminService;
	}

	@Override
	public void noticwriter(NoticeDto noticeDto) {
		HomeAdminDaoImpl.getHomeAdminDao().noticwriter(noticeDto);
	}

	@Override
	public int noticeseq(String employee_id) {
		return HomeAdminDaoImpl.getHomeAdminDao().noticeseq(employee_id);
	}

	@Override
	public NoticeDto noticeview(int seq) {
		return HomeAdminDaoImpl.getHomeAdminDao().noticeview(seq);
	}

	@Override
	public List<NoticeDto> noList() {
		return HomeAdminDaoImpl.getHomeAdminDao().noList();
	}

	@Override
	public String memoList(int seq) {
		List<MemoDto> memolist = new ArrayList<MemoDto>();
		memolist = HomeAdminDaoImpl.getHomeAdminDao().memoList(seq);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		for(MemoDto memoDto : memolist){
			JSONObject jobj = new JSONObject();
			jobj.put("mseq", memoDto.getMemo_seq());
			jobj.put("seq", memoDto.getNotice_seq());
			jobj.put("mname", memoDto.getMemo_writer());
			jobj.put("mcontent", memoDto.getMemo_content());
			jobj.put("mlogtime", memoDto.getMemo_logtime());
			jobj.put("mid", memoDto.getEmployee_id());
			jarray.add(jobj);
		}
		json.put("memolist", jarray);
		return json.toJSONString();
	}

	@Override
	public void memoWrite(MemoDto memoDto) {
		HomeAdminDaoImpl.getHomeAdminDao().memoWrite(memoDto);
	}

	@Override
	public void memoDelete(int mseq) {
		HomeAdminDaoImpl.getHomeAdminDao().memoDelete(mseq);
	}

	@Override
	public void memoModify(MemoDto memoDto) {
		HomeAdminDaoImpl.getHomeAdminDao().memoModify(memoDto);
	}

	@Override
	public void noticeUpdate(NoticeDto noticeDto) {
		HomeAdminDaoImpl.getHomeAdminDao().noticeUpdate(noticeDto);
	}

	@Override
	public void noticeComplite(int seq) {
		HomeAdminDaoImpl.getHomeAdminDao().noticeComplite(seq);
	}

}
