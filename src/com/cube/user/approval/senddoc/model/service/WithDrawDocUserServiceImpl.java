package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.senddoc.model.dao.WithDrawDocUserDaoImpl;

public class WithDrawDocUserServiceImpl implements WithDrawDocUserService{

	private static WithDrawDocUserService withDrawDocUserService;
	
	static {
		withDrawDocUserService = new WithDrawDocUserServiceImpl(); 
	}
	
	WithDrawDocUserServiceImpl(){}
	
	
	public static WithDrawDocUserService getWithDrawDocUserService() {
		return withDrawDocUserService;
	}

	@Override
	public List<Doc_info_detailDto> withdrawdoclist(String employee_id) {
		return WithDrawDocUserDaoImpl.getWithDrawDocUserDao().withdrawdoclist(employee_id);
	}
}
