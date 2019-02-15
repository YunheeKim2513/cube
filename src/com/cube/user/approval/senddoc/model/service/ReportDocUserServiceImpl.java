package com.cube.user.approval.senddoc.model.service;

import java.util.List;

import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.senddoc.model.dao.ReportDocUserDaoImpl;

public class ReportDocUserServiceImpl implements ReportDocUserService {
	
	private static ReportDocUserService reportDocUserService;
	
	static {
		reportDocUserService = new ReportDocUserServiceImpl();
	}
	
	private ReportDocUserServiceImpl() {}
	
	
	
	public static ReportDocUserService getReportDocUserService() {
		return reportDocUserService;
	}
	
	@Override
	public List<Doc_info_detailDto> reportlist(String employee_id) {
		return ReportDocUserDaoImpl.getReportDocUserDao().reportlist(employee_id);
	}

}
