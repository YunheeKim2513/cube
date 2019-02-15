package com.cube.user.diligence.model.dao;

import java.util.List;

import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;

public interface DiligenceDao {
	
	void intime(User_timeDto user_timeDto); 
	void outtime(User_timeDto user_timeDto2);


	//void intimework(User_timeworkDto user_timeworkDto);
	void outtimework(User_timeworkDto user_timeworkDto);
	
	List<User_timeDto> list(String id);
}
