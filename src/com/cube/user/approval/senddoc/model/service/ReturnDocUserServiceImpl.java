package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.senddoc.model.dao.ReturnDocUserDaoImpl;

public class ReturnDocUserServiceImpl implements ReturnDocUserService {

	private static ReturnDocUserService returnDocUserService;
	
	static {
		returnDocUserService = new ReturnDocUserServiceImpl();
	}
	
	private ReturnDocUserServiceImpl(){}
	
	
	public static ReturnDocUserService getReturnDocUserService() {
		return returnDocUserService;
	}

	@Override
	public List<Doc_info_detailDto> returndoclist(String employee_id) {
		return ReturnDocUserDaoImpl.getReturnDocUserDao().returndoclist(employee_id);
	}


}
