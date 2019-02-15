package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;

public interface AllScheduleUserService {
	List<ScheduleDto> list();
	int write(ScheduleDto scheduleDto);
	void update(int seq, String subject,String content,String kind,String start,String end);
	int delete(int seq);
	ScheduleDto view(int seq);
}
