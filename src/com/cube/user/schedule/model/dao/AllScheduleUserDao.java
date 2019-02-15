package com.cube.user.schedule.model.dao;

import java.util.List;
import java.util.Map;

import com.cube.model.dto.ScheduleDto;

public interface AllScheduleUserDao {
	List<ScheduleDto> list();
	int write(ScheduleDto scheduleDto);
	void update(Map<String, String> map);
	int delete(int seq);
	ScheduleDto view(int seq);
}
