package com.cube.user.schedule.model.dao;

import java.util.List;

import com.cube.model.dto.ScheduleDto;

public interface PrivateScheduleUserDao {
	List<ScheduleDto> list(String id);
	void write(ScheduleDto scheduleDto);
	void modify(ScheduleDto scheduleDto);
	void delete(int seq);
	ScheduleDto view(int seq);//session���� �α����� id ������
}
