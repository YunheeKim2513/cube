package com.cube.user.schedule.model.service;

import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.model.dto.VacationListDto;

public interface VacationScheduleUserService {
	List<ScheduleDto> list();
	List<VacationListDto> vacationlist();
}