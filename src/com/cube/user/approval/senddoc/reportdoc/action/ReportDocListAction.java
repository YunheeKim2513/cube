package com.cube.user.approval.senddoc.reportdoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.senddoc.model.service.ReportDocUserServiceImpl;

public class ReportDocListAction implements Action {

	private static ReportDocListAction reportDocListAction;
	
	static {
		reportDocListAction = new ReportDocListAction();
	}
	
	private ReportDocListAction(){}
	
	public static ReportDocListAction getReportDocListAction() {
		return reportDocListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> reportlist = new ArrayList<Doc_info_detailDto>();
		reportlist = ReportDocUserServiceImpl.getReportDocUserService().reportlist(employeesDto.getEmployee_id());
		request.setAttribute("reportlist", reportlist);
		return "/pages/user_approval/approval_userreport.jsp";
	}
	
}
