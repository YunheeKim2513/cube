package com.cube.user.approval.receivedoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.receivedoc.model.dao.OkDocUserDaoImpl;

public class OkDocUserServiceImpl implements OkDocUserService {
	
	private static OkDocUserService okDocUserService;
	
	static {
		okDocUserService = new OkDocUserServiceImpl();
	}
	
	private OkDocUserServiceImpl(){}

	public static OkDocUserService getOkDocUserService() {
		return okDocUserService;
	}

	@Override
	public List<Doc_info_detailDto> oklistapprovallist(String id) {
		return OkDocUserDaoImpl.getOkDocUserDao().oklistapprovallist(id);
	}
	
	
}
