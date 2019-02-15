package com.cube.user.schedule.all.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.AllScheduleUserServiceImpl;

public class AllXmlAction implements Action {
	private static AllXmlAction allXmlAction;
	static{
		allXmlAction=new AllXmlAction();
	}
	
	public static AllXmlAction getAllXmlAction() {
		return allXmlAction;
	}
	private AllXmlAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ScheduleDto> scheduleDto=AllScheduleUserServiceImpl.getAllScheduleUserService().list();
		request.setAttribute("schedulelist", scheduleDto);
		return "/xml/schedule.jsp";
	}

}
