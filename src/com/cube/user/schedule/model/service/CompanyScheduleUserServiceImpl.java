package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.CompanyScheduleUserDaoImpl;

public class CompanyScheduleUserServiceImpl implements CompanyScheduleUserService {
	private static CompanyScheduleUserService companyScheduleUserService;
	static {
		companyScheduleUserService=new CompanyScheduleUserServiceImpl();
	}
	
	public static CompanyScheduleUserService getCompanyScheduleUserService() {
		return companyScheduleUserService;
	}
	private CompanyScheduleUserServiceImpl(){}
	@Override
	public List<ScheduleDto> list() {
		return CompanyScheduleUserDaoImpl.getCompanyScheduleUserDao().list();
	}
	@Override
	public void write(ScheduleDto scheduleDto) {
		CompanyScheduleUserDaoImpl.getCompanyScheduleUserDao().write(scheduleDto);
	}
	@Override
	public void modify(ScheduleDto scheduleDto) {
		CompanyScheduleUserDaoImpl.getCompanyScheduleUserDao().modify(scheduleDto);
	}
	@Override
	public void delete(int seq) {
		CompanyScheduleUserDaoImpl.getCompanyScheduleUserDao().delete(seq);
	}
	@Override
	public ScheduleDto view(int seq) {
		return CompanyScheduleUserDaoImpl.getCompanyScheduleUserDao().view(seq);
	}
}
