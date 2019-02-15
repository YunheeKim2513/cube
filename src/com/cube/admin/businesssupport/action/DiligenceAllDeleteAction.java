package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;


public class DiligenceAllDeleteAction implements Action{
	private static DiligenceAllDeleteAction diligenceAllDeleteAction;

	static{
		diligenceAllDeleteAction = new DiligenceAllDeleteAction();
	}

	private DiligenceAllDeleteAction(){}

		public static DiligenceAllDeleteAction getDiligenceAllDeleteAction() {
		return diligenceAllDeleteAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 session.getAttribute("userInfo");
		 
		 
		 System.out.println(" DiligenceAllDeleteAction 여기까지 들어는 오니1?");
		 
		 
		 int admintime_seq = Integer.parseInt(request.getParameter("admintime_seq"));
		 
		 System.out.println("deldteseq======"+admintime_seq);
		 
		 BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligenceDelete(admintime_seq);

		return "/pages/admin_diligence/admin_diligence_time.jsp";
	}

}
