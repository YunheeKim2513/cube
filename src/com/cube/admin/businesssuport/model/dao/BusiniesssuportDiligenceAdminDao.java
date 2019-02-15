package com.cube.admin.businesssuport.model.dao;

import java.util.List;

import com.cube.model.dto.Admin_timeDto;
import com.cube.model.dto.Admin_timeSelectDto;
import com.cube.model.dto.DiligencegroupDto;
import com.cube.model.dto.EmployeeDilDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;


public interface BusiniesssuportDiligenceAdminDao {
	List<DiligencegroupDto> diligencekind();
	void diligencekindin(String diligencegrouptext, String diligenceselect);
	void diligencetimein(Admin_timeDto admin_timeDto,  EmployeesDto employeesDto);
	List<Admin_timeSelectDto> diligenceselect();

	void diligenceDelete(int deldteseq);
	
	
	void diligenceAllDelete(int admintime_seq);
	
	List<EmployeeDilDto> employeeDilDtolist();

	
	Admin_timeDto admin_timeStandard();
	
	Admin_timeDto admin_timeDto();
	
	
	//User_timeworkDto user_timeworkDto();
	
	
	void inHappyDay(HappyDayDto happyDayDto);//ÈÞÀÏ ÀÔ·Â 
	
	List<HappyDayDto> happyDayDto();//ÈÞÀÏ »Ì¾Æ³»±â
	
	
	void delHappyday(int happyday_seq);
	

}
