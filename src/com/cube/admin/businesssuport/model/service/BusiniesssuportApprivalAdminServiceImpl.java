package com.cube.admin.businesssuport.model.service;

import java.util.List;

import com.cube.admin.businesssuport.model.dao.BusiniesssuportApprivalAdminDaoImpl;
import com.cube.model.dto.Doc_info_detailDto;

public class BusiniesssuportApprivalAdminServiceImpl implements BusiniesssuportApprivalAdminService {

	private static BusiniesssuportApprivalAdminService businiesssuportApprivalAdminService;
	
	static{
		businiesssuportApprivalAdminService = new BusiniesssuportApprivalAdminServiceImpl();
	}
	
	private BusiniesssuportApprivalAdminServiceImpl() {}
	
	public static BusiniesssuportApprivalAdminService getBusiniesssuportApprivalAdminService() {
		return businiesssuportApprivalAdminService;
	}

	@Override
	public void confirmlistinsert(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3) {
		BusiniesssuportApprivalAdminDaoImpl.getBusiniesssuportApprivalAdminDao().confirmlistinsert(confirmname, confirmlist1, confirmlist2, confirmlist3);
	}

	@Override
	public void confirmlistupdate(String confirmname, String confirmlist1, String confirmlist2, String confirmlist3) {
		BusiniesssuportApprivalAdminDaoImpl.getBusiniesssuportApprivalAdminDao().confirmlistupdate(confirmname, confirmlist1, confirmlist2, confirmlist3);
	}

	@Override
	public void confirmlistdelete(String confirmcode) {
		BusiniesssuportApprivalAdminDaoImpl.getBusiniesssuportApprivalAdminDao().confirmlistdelete(confirmcode);
	}

	@Override
	public List<Doc_info_detailDto> doclist() {
		return BusiniesssuportApprivalAdminDaoImpl.getBusiniesssuportApprivalAdminDao().doclist();
	}

}
