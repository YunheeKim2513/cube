package com.cube.admin.businesssuport.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cube.admin.businesssuport.model.dao.BusiniesssuportApprivalAdminDaoImpl;
import com.cube.admin.businesssuport.model.dao.BusiniesssuportDiligenceAdminDao;
import com.cube.admin.businesssuport.model.dao.BusiniesssuportDiligenceAdminDaoImpl;

import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.Admin_timeDto;
import com.cube.model.dto.Admin_timeSelectDto;
import com.cube.model.dto.DiligencegroupDto;
import com.cube.model.dto.EmployeeDilDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.user.diligence.model.service.DiligenceService;

public class BusiniesssuportDiligenceAdminServiceImpl implements BusiniesssuportDiligenceAdminService {
	private static BusiniesssuportDiligenceAdminServiceImpl businiesssuportDiligenceAdminServiceImpl;

	static{
		businiesssuportDiligenceAdminServiceImpl = new BusiniesssuportDiligenceAdminServiceImpl();
	}

	private BusiniesssuportDiligenceAdminServiceImpl(){}

		public static BusiniesssuportDiligenceAdminServiceImpl getBusiniesssuportDiligenceAdminServiceImpl() {
		return businiesssuportDiligenceAdminServiceImpl;
	}
		
	@Override
	public List<DiligencegroupDto> diligencekind() {
	
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligencekind();
	}

	@Override
	public void diligencekindin(String diligencegrouptext, String diligenceselect) {
		
		  BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligencekindin(diligencegrouptext, diligenceselect);
		  
		
	}

	@Override
	public void diligencetimein(Admin_timeDto admin_timeDto, EmployeesDto employeesDto) {
	
		
		BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligencetimein(admin_timeDto, employeesDto);
		
	}

	@Override
	public List<Admin_timeSelectDto> diligenceselect() {
		
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligenceselect();
	}

	@Override
	public void diligenceDelete(int deldteseq) {
		BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligenceDelete(deldteseq);

	}

	
	@Override
	public void diligenceAllDelete(int admintime_seq) {
		// deligence 리스트 삭제 
		BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().diligenceAllDelete(admintime_seq);
		
	}

	@Override
	public List<EmployeeDilDto> employeeDilDtolist() {
		
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().employeeDilDtolist();
		
	}

	@Override
	public Admin_timeDto admin_timeStandard() {
		
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().admin_timeStandard();
	}

	@Override
	public Admin_timeDto admin_timeDto() {
		
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().admin_timeDto();
	}

	@Override
	public void inHappyDay(HappyDayDto happyDayDto) {
		
	BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().inHappyDay(happyDayDto);	
		
	}

	@Override
	public List<HappyDayDto> happyDayDto() {
		
		return BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().happyDayDto();
	}

	@Override
	public void delHappyday(int happyday_seq) {
		// TODO Auto-generated method stub
		
	}


	
		
}
