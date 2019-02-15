package com.cube.user.diligence.model.service;

import java.util.List;

import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.user.diligence.model.dao.DiligenceDaoImpl;

public class DiligenceServiceImpl implements DiligenceService {
	private static DiligenceServiceImpl diligenceServiceImpl;
	
	static{
		diligenceServiceImpl = new DiligenceServiceImpl();
	}
	
	private DiligenceServiceImpl(){};
	
	public static DiligenceServiceImpl getDiligenceServiceImpl() {
		return diligenceServiceImpl;
	}

	@Override
	public void intime(User_timeDto user_timeDto) {
	
		 DiligenceDaoImpl.getDiligenceDaoImpl().intime(user_timeDto);
	}

	
	
	@Override
	public void outtime(User_timeDto user_timeDto2) {
		 DiligenceDaoImpl.getDiligenceDaoImpl().outtime(user_timeDto2);
		
	}

/*	@Override
	public void intimework(User_timeworkDto user_timeworkDto) {
		DiligenceDaoImpl.getDiligenceDaoImpl().intimework(user_timeworkDto);
		
	}*/

	@Override
	public void outtimework(User_timeworkDto user_timeworkDto) {
		DiligenceDaoImpl.getDiligenceDaoImpl().outtimework(user_timeworkDto);
		
	}

	@Override
	public List<User_timeDto> list(String id) {
		return DiligenceDaoImpl.getDiligenceDaoImpl().list(id);
	}

	
	

}
