package com.cube.user.schedule.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.AllScheduleUserDaoImpl;

public class AllScheduleUserServiceImpl implements AllScheduleUserService {
	private static AllScheduleUserService allScheduleUserService;
	static {
		allScheduleUserService=new AllScheduleUserServiceImpl();
	}
	
	public static AllScheduleUserService getAllScheduleUserService() {
		return allScheduleUserService;
	}
	private AllScheduleUserServiceImpl(){}
	
	@Override
	public List<ScheduleDto> list() {
		return AllScheduleUserDaoImpl.getAllScheduleUserDao().list();
	}

	@Override
	public int write(ScheduleDto scheduleDto) {
		return AllScheduleUserDaoImpl.getAllScheduleUserDao().write(scheduleDto);
	}

	@Override
	public void update(int seq, String subject,String content,String kind,String start,String end) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("seq", seq+"");
		map.put("subject", subject);
		map.put("content", content);
		map.put("kind", kind);
		map.put("start", start);
		map.put("end", end);
		AllScheduleUserDaoImpl.getAllScheduleUserDao().update(map);
	}

	@Override
	public int delete(int seq) {
		return AllScheduleUserDaoImpl.getAllScheduleUserDao().delete(seq);
	}

	@Override
	public ScheduleDto view(int seq) {
		return AllScheduleUserDaoImpl.getAllScheduleUserDao().view(seq);
	}
	
}
