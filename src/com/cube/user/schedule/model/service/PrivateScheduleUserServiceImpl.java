package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.PrivateScheduleUserDaoImpl;

public class PrivateScheduleUserServiceImpl implements PrivateScheduleUserService {
	private static PrivateScheduleUserService privateScheduleUserService;
	static {
		privateScheduleUserService=new PrivateScheduleUserServiceImpl();
	}
	
	public static PrivateScheduleUserService getPrivateScheduleUserService() {
		return privateScheduleUserService;
	}
	private PrivateScheduleUserServiceImpl(){}
	@Override
	public List<ScheduleDto> list(String id) {
		return PrivateScheduleUserDaoImpl.getPrivateScheduleUserDao().list(id);
	}
	@Override
	public void write(ScheduleDto scheduleDto) {
		PrivateScheduleUserDaoImpl.getPrivateScheduleUserDao().write(scheduleDto);
	}
	@Override
	public void modify(ScheduleDto scheduleDto) {
		PrivateScheduleUserDaoImpl.getPrivateScheduleUserDao().modify(scheduleDto);
	}
	@Override
	public void delete(int seq) {
		PrivateScheduleUserDaoImpl.getPrivateScheduleUserDao().delete(seq);
	}
	@Override
	public ScheduleDto view(int seq){
		return PrivateScheduleUserDaoImpl.getPrivateScheduleUserDao().view(seq);
	}
}
