package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;

public class DiligenceGroupSelectAction implements Action{
//������ �μ��� ���� �˻�
	private static DiligenceGroupSelectAction diligenceGroupSelectAction;

	static{
		diligenceGroupSelectAction = new DiligenceGroupSelectAction();
	}

	private DiligenceGroupSelectAction(){}

		public static DiligenceGroupSelectAction getDiligenceGroupSelectAction() {
		return diligenceGroupSelectAction;
	}



		@Override
		public String action(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			 HttpSession session = request.getSession();
			 session.getAttribute("userInfo");
			 
			 System.out.println(" DiligenceGroupSelectAction ������� ���� ����?");
		 
			
			
			
			
			//���� ��ü ����Ʈ 
			 BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligenceselect();
			 
			// request.setAttribute("admin_timeselectlist", list2);
			
			
			return "/pages/admin_diligence/admin_diligence_time.jsp";//��� ���� ó���ϰ� ������ ���
			
			
		}
}
