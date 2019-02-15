package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.Biztrip_reportDto;
import com.cube.user.approval.docwrite.model.dao.BiztripreportDocUserDaoImpl;

public class BiztripreportDocUserServiceImpl implements BiztripreportDocUserService {
	
	private static BiztripreportDocUserService biztripreportDocUserService;
	
	static {
		biztripreportDocUserService = new BiztripreportDocUserServiceImpl();
	}
	
	private BiztripreportDocUserServiceImpl(){}
	
	public static BiztripreportDocUserService getBiztripreportDocUserService() {
		return biztripreportDocUserService;
	}

	@Override
	public int writesuccess(Biztrip_reportDto biztrip_reportDto) {
		return BiztripreportDocUserDaoImpl.getBiztripreportDocUserDao().writesuccess(biztrip_reportDto);
	}

	@Override
	public int updatesuccess(Biztrip_reportDto biztrip_reportDto) {
		return BiztripreportDocUserDaoImpl.getBiztripreportDocUserDao().updatesuccess(biztrip_reportDto);
	}

}
