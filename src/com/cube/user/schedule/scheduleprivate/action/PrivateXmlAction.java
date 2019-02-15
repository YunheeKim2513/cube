package com.cube.user.schedule.scheduleprivate.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.PrivateScheduleUserServiceImpl;

public class PrivateXmlAction implements Action {
	private static PrivateXmlAction privateXmlAction;
	static{
		privateXmlAction=new PrivateXmlAction();
	}
	
	public static PrivateXmlAction getPrivateXmlAction() {
		return privateXmlAction;
	}
	private PrivateXmlAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		List<ScheduleDto> scheduleDto=PrivateScheduleUserServiceImpl.getPrivateScheduleUserService().list(id);
		request.setAttribute("schedulelist", scheduleDto);
		return "/xml/schedule.jsp";
	}
}
