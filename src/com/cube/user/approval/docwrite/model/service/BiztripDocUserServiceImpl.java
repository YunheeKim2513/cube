package com.cube.user.approval.docwrite.model.service;

import com.cube.model.dto.BiztripdocDto;
import com.cube.user.approval.docwrite.model.dao.BiztripDocUserDaoImpl;

public class BiztripDocUserServiceImpl implements BiztripDocUserService {
	private static BiztripDocUserService biztripDocUserService;
	
	static {
		biztripDocUserService = new BiztripDocUserServiceImpl();
	}
	
	private BiztripDocUserServiceImpl(){}
	
	public static BiztripDocUserService getBiztripDocUserService() {
		return biztripDocUserService;
	}

	@Override
	public int writesuccess(BiztripdocDto biztripdocDto) {
		return BiztripDocUserDaoImpl.getBiztripDocUserDao().writesuccess(biztripdocDto);
	}

	@Override
	public int updatesuccess(BiztripdocDto biztripdocDto) {
		return BiztripDocUserDaoImpl.getBiztripDocUserDao().updatesuccess(biztripdocDto);
	}

}
