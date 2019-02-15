package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;


public class DiligenceDeleteAction implements Action{
	private static DiligenceDeleteAction diligenceDeleteAction;

	static{
		diligenceDeleteAction = new DiligenceDeleteAction();
	}

	private DiligenceDeleteAction(){}

		public static DiligenceDeleteAction getDiligenceDeleteAction() {
		return diligenceDeleteAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 session.getAttribute("userInfo");
		 
		 
		 System.out.println(" DiligenceDeleteAction 여기까지 들어는 오니1?");
		 
		 
		 //String deleteseq = Encoder.isoToUtf(request.getParameter("deleteseq"));
		 
		 int deldteseq = Integer.parseInt(request.getParameter("deleteseq"));
		 
		 System.out.println("deldteseq======"+deldteseq);
		 
		 BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligenceDelete(deldteseq);
		
//		 return "/admindiligence?act=diligencegroup";
		return "/pages/admin_diligence/admin_diligence_time.jsp";
	}

}
