package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;

public interface CompanyScheduleUserService {
	List<ScheduleDto> list();
	void write(ScheduleDto scheduleDto);
	void modify(ScheduleDto scheduleDto);
	void delete(int seq);
	ScheduleDto view(int seq);
}
