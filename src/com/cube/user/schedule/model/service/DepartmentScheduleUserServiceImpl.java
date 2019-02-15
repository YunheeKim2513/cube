package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.DepartmentScheduleUserDaoImpl;

public class DepartmentScheduleUserServiceImpl implements DepartmentScheduleUserService {
	private static DepartmentScheduleUserService departmentScheduleUserService;
	static {
		departmentScheduleUserService=new DepartmentScheduleUserServiceImpl();
	}
	
	public static DepartmentScheduleUserService getDepartmentScheduleUserService() {
		return departmentScheduleUserService;
	}
	private DepartmentScheduleUserServiceImpl(){}
	@Override
	public List<ScheduleDto> list(String id) {
		return DepartmentScheduleUserDaoImpl.getDepartmentScheduleUserDao().list(id);
	}
	@Override
	public void write(ScheduleDto scheduleDto) {
		DepartmentScheduleUserDaoImpl.getDepartmentScheduleUserDao().write(scheduleDto);
	}
	@Override
	public void modify(ScheduleDto scheduleDto) {
		DepartmentScheduleUserDaoImpl.getDepartmentScheduleUserDao().modify(scheduleDto);
	}
	@Override
	public void delete(int seq) {
		DepartmentScheduleUserDaoImpl.getDepartmentScheduleUserDao().delete(seq);
	}
	@Override
	public ScheduleDto view(int seq) {
		return DepartmentScheduleUserDaoImpl.getDepartmentScheduleUserDao().view(seq);
	}
}
