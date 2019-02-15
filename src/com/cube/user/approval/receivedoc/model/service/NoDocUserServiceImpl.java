package com.cube.user.approval.receivedoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.receivedoc.model.dao.NoDocUserDaoImpl;

public class NoDocUserServiceImpl implements NoDocUserService {
	
	private static NoDocUserService noDocUserService;
	
	static{
		noDocUserService = new NoDocUserServiceImpl();
	}
	
	private NoDocUserServiceImpl(){}

	public static NoDocUserService getNoDocUserService() {
		return noDocUserService;
	}

	@Override
	public List<Doc_info_detailDto> nolistapprovallist(String id) {
		return NoDocUserDaoImpl.getNoDocUserDao().nolistapprovallist(id);
	}

	@Override
	public int confirmcheck1(int confirmlist, String seq) {
		return NoDocUserDaoImpl.getNoDocUserDao().confirmcheck1(confirmlist, seq);
	}
	
	@Override
	public int confirmcheck2(int confirmlist, String seq) {
		return NoDocUserDaoImpl.getNoDocUserDao().confirmcheck2(confirmlist, seq);
	}
	
	@Override
	public int confirmcheck3(int confirmlist, String seq) {
		return NoDocUserDaoImpl.getNoDocUserDao().confirmcheck3(confirmlist, seq);
	}

	@Override
	public String name(String id) {
		return NoDocUserDaoImpl.getNoDocUserDao().name(id);
	}
}
