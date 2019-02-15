package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.model.dto.VacationListDto;
import com.cube.user.schedule.model.dao.VacationScheduleUserDaoImpl;

public class VacationScheduleUserServiceImpl implements VacationScheduleUserService {
	private static VacationScheduleUserService vacationScheduleUserService;
	static {
		vacationScheduleUserService=new VacationScheduleUserServiceImpl();
	}
	
	public static VacationScheduleUserService getVacationScheduleUserService() {
		return vacationScheduleUserService;
	}
	private VacationScheduleUserServiceImpl(){}
	@Override
	public List<ScheduleDto> list() {
		return VacationScheduleUserDaoImpl.getVacationScheduleUserDao().list();
	}
	@Override
	public List<VacationListDto> vacationlist() {
		return VacationScheduleUserDaoImpl.getVacationScheduleUserDao().vacationlist();
	}
	
	
}