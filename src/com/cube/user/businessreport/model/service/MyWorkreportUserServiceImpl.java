package com.cube.user.businessreport.model.service;

import java.util.List;

import com.cube.model.dto.Work_reportDto;
import com.cube.user.businessreport.model.dao.MyWorkreportUserDaoImpl;

public class MyWorkreportUserServiceImpl implements MyWorkreportUserService {

	private static MyWorkreportUserService myWorkreportUserService;
	
	static {
		myWorkreportUserService = new MyWorkreportUserServiceImpl();
	}
	
	private MyWorkreportUserServiceImpl(){}
	
	public static MyWorkreportUserService getMyWorkreportUserService() {
		return myWorkreportUserService;
	}

	@Override
	public void workinsert(Work_reportDto work_reportDto) {
		MyWorkreportUserDaoImpl.getMyWorkreportUserDao().workinsert(work_reportDto);
	}

	@Override
	public String worktime(String seq) {
		return MyWorkreportUserDaoImpl.getMyWorkreportUserDao().worktime(seq);
	}

	@Override
	public List<Work_reportDto> mywork_reportlist(String employee_id) {
		return MyWorkreportUserDaoImpl.getMyWorkreportUserDao().mywork_reportlist(employee_id);
	}

	@Override
	public List<Work_reportDto> receivework_reportlist(String employee_id, String department_name) {
		return MyWorkreportUserDaoImpl.getMyWorkreportUserDao().receivework_reportlist(employee_id, department_name);
	}

	@Override
	public Work_reportDto work_report_view(String seq) {
		return MyWorkreportUserDaoImpl.getMyWorkreportUserDao().work_report_view(seq);
	}

	@Override
	public void workupdate(Work_reportDto work_reportDto) {
		MyWorkreportUserDaoImpl.getMyWorkreportUserDao().workupdate(work_reportDto);
	}
}
