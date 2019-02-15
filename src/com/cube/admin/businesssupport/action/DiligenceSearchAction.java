package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssuport.model.service.BusiniesssuportDiligenceAdminServiceImpl;
import com.cube.model.dto.Admin_timeDto;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeeDilDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.User_timeDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;

public class DiligenceSearchAction implements Action{
//관리자 부서별 결재 검색
	private static DiligenceSearchAction diligenceSearchAction;

	static{
		diligenceSearchAction = new DiligenceSearchAction();
	}

	private DiligenceSearchAction(){}

		public static DiligenceSearchAction getDiligenceSearchAction() {
		return diligenceSearchAction;
	}



		@Override
		public String action(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			  HttpSession session = request.getSession();
		      EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		
		       List<EmployeeDilDto> employeelist = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().employeeDilDtolist();
		      
		       request.setAttribute("employeelist", employeelist);
		       
		       
		       Admin_timeDto admin_timeStandard = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().admin_timeStandard();
		       
		       
		       request.setAttribute("admin_timeStandard", admin_timeStandard);
		       
		       Admin_timeDto admin_timeDto = BusiniesssuportDiligenceAdminServiceImpl.getBusiniesssuportDiligenceAdminServiceImpl().admin_timeDto();
		       
		       request.setAttribute("admin_timeDtolist", admin_timeDto);
		       
			return "/pages/admin_diligence/admin_diligence_search.jsp";//모든 것을 처리하고 보내는 뷰단
		}
}
