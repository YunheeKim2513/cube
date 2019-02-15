package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.dao.BusiniesssuportDiligenceAdminDaoImpl;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.util.Encoder;


public class DiligenceHappyDaySearchAction implements Action{


	private static DiligenceHappyDaySearchAction diligenceHappyDaySearchAction;
	
	static{
		diligenceHappyDaySearchAction = new DiligenceHappyDaySearchAction();
	}
	
	private DiligenceHappyDaySearchAction(){};
	
	public static DiligenceHappyDaySearchAction getDiligenceHappyDaySearchAction() {
		return diligenceHappyDaySearchAction;
	}

	
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("action 도착?");
				
		List<HappyDayDto> happyDayDtolist = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().happyDayDto();
		
		//System.out.println("액션인데 리스트 있음?"+happyDayDtolist);
		
		request.setAttribute("happydaydto", happyDayDtolist);
		
		return "/pages/admin_diligence/admin_diligence_happyday.jsp";
	}

}
