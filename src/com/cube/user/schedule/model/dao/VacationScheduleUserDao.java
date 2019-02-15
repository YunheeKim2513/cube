package com.cube.user.schedule.model.dao;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.model.dto.VacationListDto;

public interface VacationScheduleUserDao {
	List<ScheduleDto> list();
	List<VacationListDto> vacationlist();
}