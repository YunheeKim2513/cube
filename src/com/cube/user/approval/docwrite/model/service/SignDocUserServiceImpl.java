package com.cube.user.approval.docwrite.model.service;

import java.util.List;

import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.SigndocDto;
import com.cube.user.approval.docwrite.model.dao.SignDocUserDaoImpl;

public class SignDocUserServiceImpl implements SignDocUserService {
	
	private static SignDocUserService signDocUserService;
	
	static {
		signDocUserService = new SignDocUserServiceImpl();
	}
	
	private SignDocUserServiceImpl() {}
	
	
	
	public static SignDocUserService getSignDocUserService() {
		return signDocUserService;
	}



	@Override
	public List<Confirmlist_infoDto> confirmlist() {
		return SignDocUserDaoImpl.getSignDocUserDao().confirmlist();
	}



	@Override
	public Confirmlist_infoDto confirmlist_infoDto(String confirmname) {
		return SignDocUserDaoImpl.getSignDocUserDao().confirmlist_infoDto(confirmname);
	}



	@Override
	public List<EmployeesDto> confirmlistview() {
		return SignDocUserDaoImpl.getSignDocUserDao().confirmlistview();
	}



	@Override
	public int writesuccess(SigndocDto signdocDto) {
		return SignDocUserDaoImpl.getSignDocUserDao().writesuccess(signdocDto);
	}



	@Override
	public String confirmname(String confirmname1) {
		return SignDocUserDaoImpl.getSignDocUserDao().confirmname(confirmname1);
	}



	@Override
	public int updatesuccess(SigndocDto signdocDto) {
		return SignDocUserDaoImpl.getSignDocUserDao().updatesuccess(signdocDto);
	}

}
