package com.cube.user.schedule.vacation.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.VacationListDto;
import com.cube.user.schedule.model.dao.VacationScheduleUserDaoImpl;

public class VacationXmlAction implements Action {
	private static VacationXmlAction vacationXmlAction;
	static{
		vacationXmlAction=new VacationXmlAction();
	}
	
	public static VacationXmlAction getVacationXmlAction() {
		return vacationXmlAction;
	}
	private VacationXmlAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<VacationListDto> list=VacationScheduleUserDaoImpl.getVacationScheduleUserDao().vacationlist();
		request.setAttribute("vacationlist", list);
		return "/xml/schedule_vacation.jsp";
	}

}
