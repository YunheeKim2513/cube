package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.util.Encoder;
import com.sun.corba.se.impl.javax.rmi.CORBA.Util;


public class DiligenceHappyDaySetAction implements Action{


	private static DiligenceHappyDaySetAction diligenceHappyDaySetAction;
	
	static{
		diligenceHappyDaySetAction = new DiligenceHappyDaySetAction();
	}
	
	private DiligenceHappyDaySetAction(){};
	
	public static DiligenceHappyDaySetAction getDiligenceHappyDaySetAction() {
		return diligenceHappyDaySetAction;
	}

	
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("action 도착?");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		
		String happy_start = request.getParameter("happy_start");
		String happy_end =request.getParameter("happy_end");
		String happytext =  Encoder.isoToUtf(request.getParameter("happytext"));
		
		System.out.println(happy_start+"----"+employeesDto.getEmployee_id()+"----"+happy_end+"----"+happytext);
		
		
		HappyDayDto happyDayDto = new HappyDayDto();
		
		happyDayDto.setHappy_stat(happy_start);
		happyDayDto.setHappy_end(happy_end);
		happyDayDto.setHappy_name(happytext);
		happyDayDto.setEmployee_id(employeesDto.getEmployee_id());
		
		
		BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().inHappyDay(happyDayDto);
	/*	
		List<HappyDayDto> happyDayDtolist = BusiniesssuportDiligenceAdminDaoImpl.getBusiniesssuportDiligenceAdminDaoImpl().happyDayDto();
		
		System.out.println("액션인데 리스트 있음?"+happyDayDtolist);
		
		request.setAttribute("happydaydto", happyDayDtolist);
		*/
		return "/pages/admin_diligence/admin_diligence_happyday.jsp";
	}

}
