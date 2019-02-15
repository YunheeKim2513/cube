package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.senddoc.model.dao.SaveDocUserDaoImpl;

public class SaveDocUserServiceImpl implements SaveDocUserService {

	private static SaveDocUserService saveDocUserService;
	
	static{
		saveDocUserService = new SaveDocUserServiceImpl();
	}
	
	private SaveDocUserServiceImpl(){}
	
	public static SaveDocUserService getSaveDocUserService() {
		return saveDocUserService;
	}

	@Override
	public List<Doc_info_detailDto> savedoclist(String employee_id) {
		return SaveDocUserDaoImpl.getSaveDocUserDao().savedoclist(employee_id);
	}

	@Override
	public void savedoc(String seq) {
		SaveDocUserDaoImpl.getSaveDocUserDao().savedoc(seq);
	}

	@Override
	public void savedocdelete(String seq, String dockind) {
		SaveDocUserDaoImpl.getSaveDocUserDao().savedocdelete(seq, dockind);
	}

	@Override
	public void savedocupdate(String seq) {
		SaveDocUserDaoImpl.getSaveDocUserDao().savedocupdate(seq);
	}


}
