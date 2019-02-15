package com.cube.user.schedule.department.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.DepartmentScheduleUserServiceImpl;

public class DepartmentXmlAction implements Action {
	private static DepartmentXmlAction departmentXmlAction;
	static{
		departmentXmlAction=new DepartmentXmlAction();
	}
	
	public static DepartmentXmlAction getDepartmentXmlAction() {
		return departmentXmlAction;
	}
	private DepartmentXmlAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		List<ScheduleDto> scheduleDto=DepartmentScheduleUserServiceImpl.getDepartmentScheduleUserService().list(id);
		request.setAttribute("schedulelist", scheduleDto);
		return "/xml/schedule.jsp";
	}

}
