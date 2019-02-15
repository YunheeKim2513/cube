package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.DeaddocDto;
import com.cube.user.approval.docwrite.model.dao.DeadDocUserDaoImpl;

public class DeadDocUserServiceImpl implements DeadDocUserService {

	private static DeadDocUserService deadDocUserService;
	
	static{
		deadDocUserService = new DeadDocUserServiceImpl();
	}
	
	private DeadDocUserServiceImpl(){}
	
	public static DeadDocUserService getDeadDocUserService() {
		return deadDocUserService;
	}

	@Override
	public int writesuccess(DeaddocDto deaddocDto) {
		return DeadDocUserDaoImpl.getDeadDocUserDao().writesuccess(deaddocDto);
	}

	@Override
	public int updatesuccess(DeaddocDto deaddocDto) {
		return DeadDocUserDaoImpl.getDeadDocUserDao().updatesuccess(deaddocDto);
	}

}
