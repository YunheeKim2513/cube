package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.VacdocDto;
import com.cube.user.approval.docwrite.model.dao.VacDocUserDaoImpl;

public class VacDocUserServiceImpl implements VacDocUserService {
	
	private static VacDocUserService vacDocUserService;
	
	static{
		vacDocUserService = new VacDocUserServiceImpl();
	}
	
	private VacDocUserServiceImpl(){}
	
	
	
	public static VacDocUserService getVacDocUserService() {
		return vacDocUserService;
	}

	@Override
	public int writesuccess(VacdocDto vacdocDto) {
		return VacDocUserDaoImpl.getVacDocUserDao().writesuccess(vacdocDto);
	}

	@Override
	public int updatesuccess(VacdocDto vacdocDto) {
		return VacDocUserDaoImpl.getVacDocUserDao().updatesuccess(vacdocDto);
	}

}
