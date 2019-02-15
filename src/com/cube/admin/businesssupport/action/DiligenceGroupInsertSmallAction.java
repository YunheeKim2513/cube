package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;

public class DiligenceGroupInsertSmallAction implements Action{

	private static DiligenceGroupInsertSmallAction diligenceGroupInsertSmallAction;

	static{
		diligenceGroupInsertSmallAction = new DiligenceGroupInsertSmallAction();
	}

	private DiligenceGroupInsertSmallAction(){}

		public static DiligenceGroupInsertSmallAction getDiligenceGroupInsertSmallAction() {
		return diligenceGroupInsertSmallAction;
	}

		@Override
		public String action(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//HttpSession session = request.getSession();
			//EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
			
			
			String diligencegrouptext =request.getParameter("diligencegrouptext");
			String diligenceselect = request.getParameter("diligenceselect");
			
			System.out.println("ÇÑ±Û±úÁü???"+diligencegrouptext + diligenceselect);
			
			BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligencekindin(diligencegrouptext, diligenceselect);
			
			return "/pages/admin_diligence/admin_diligence_time.jsp";
		}

	
	
}
