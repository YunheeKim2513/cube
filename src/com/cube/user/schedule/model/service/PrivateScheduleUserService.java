package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;

public interface PrivateScheduleUserService {
	List<ScheduleDto> list(String id);
	void write(ScheduleDto scheduleDto);
	void modify(ScheduleDto scheduleDto);
	void delete(int seq);
	ScheduleDto view(int seq);//session에서 로그인한 id 얻어오기
}
