package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.model.dto.Admin_timeDto;
import com.cube.model.dto.EmployeesDto;

public class DiligenceGroupInsertAction implements Action{
//������ �μ��� ���� �˻�
	private static DiligenceGroupInsertAction diligenceGroupInsertAction;

	static{
		diligenceGroupInsertAction = new DiligenceGroupInsertAction();
	}

	private DiligenceGroupInsertAction(){}

		public static DiligenceGroupInsertAction getDiligenceGroupInsertAction() {
		return diligenceGroupInsertAction;
	}



		@Override
		public String action(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			HttpSession session = request.getSession();
			EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
			
			System.out.println("������� ������ ���ϴ�? ���� ȸ�����̵�?"+employeesDto.getEmployee_id());
			
			String endtime = request.getParameter("endtime");
			String endhour = request.getParameter("endhour");
			String endmin = request.getParameter("endmin");
			String starthour = request.getParameter("starthour");
			String starttime =request.getParameter("starttime");
			String startmin = request.getParameter("startmin");
			String group_standard = request.getParameter("diligencelist");
			  
			if(employeesDto==null)
			         System.out.println("��");
			

			Admin_timeDto admin_timeDto = new Admin_timeDto();
		
			admin_timeDto.setEndhour(endhour);
			admin_timeDto.setEndmin(endmin);
			admin_timeDto.setEndtime(endtime);
			admin_timeDto.setStarthour(starthour);
			admin_timeDto.setStartmin(startmin);
			admin_timeDto.setStarttime(starttime);
			admin_timeDto.setGroup_standard(group_standard);
			
			System.out.println("DiligenceGroupInsertAction�Ķ���Ͱ� �޾ƿ���");
			BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().diligencetimein(admin_timeDto, employeesDto);
			System.out.println("DiligenceGroupInsertAction���񽺱��� ����");
			
			return "/pages/admin_diligence/admin_diligence_time.jsp";//��� ���� ó���ϰ� ������ ���
		}
}
