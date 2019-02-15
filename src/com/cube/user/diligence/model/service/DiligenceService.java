package com.cube.user.diligence.model.service;

import java.util.List;

import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;

public interface DiligenceService {
	void intime(User_timeDto user_timeDto);
	void outtime(User_timeDto user_timeDto2);
	
	
	void outtimework(User_timeworkDto user_timeworkDto);
	
	List<User_timeDto> list(String id);
}