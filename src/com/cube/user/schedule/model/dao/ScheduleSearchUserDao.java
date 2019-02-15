package com.cube.user.schedule.model.dao;

import java.util.List;
import java.util.Map;

import com.cube.model.dto.ScheduleDto;

public interface ScheduleSearchUserDao {
	List<ScheduleDto> list();
	List<ScheduleDto> search(Map<String,String> map);
	void update(Map<String,String> map);
	void delete(int seq);
	ScheduleDto view(int seq);
}
