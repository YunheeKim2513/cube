package com.cube.user.schedule.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.CompanyScheduleUserServiceImpl;

public class CompanyXmlAction implements Action {
	private static CompanyXmlAction companyXmlAction;
	static{
		companyXmlAction=new CompanyXmlAction();
	}
	
	public static CompanyXmlAction getCompanyXmlAction() {
		return companyXmlAction;
	}
	private CompanyXmlAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		List<ScheduleDto> scheduleDto=CompanyScheduleUserServiceImpl.getCompanyScheduleUserService().list();
		request.setAttribute("schedulelist", scheduleDto);
		return "/xml/schedule.jsp";
	}

}
