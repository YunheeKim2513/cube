package com.cube.user.schedule.department.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.DepartmentScheduleUserServiceImpl;

public class ScheduleDepartmentWriteAction implements Action{
	private static ScheduleDepartmentWriteAction scheduleDepartmentWriteAction;
	static{
		scheduleDepartmentWriteAction=new ScheduleDepartmentWriteAction();
	}
	
	public static ScheduleDepartmentWriteAction getScheduleDepartmentWriteAction() {
		return scheduleDepartmentWriteAction;
	}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root=request.getContextPath();
		HttpSession session=request.getSession();
		EmployeesDto employeesDto=(EmployeesDto)session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		String kind=request.getParameter("division");
		String subject=request.getParameter("schedule_subject");
		String content=request.getParameter("content");
		
		String startyear=request.getParameter("startyear");
		String startmonth=request.getParameter("startmonth");
		String startday=request.getParameter("startday");
		String endyear=request.getParameter("endyear");
		String endmonth=request.getParameter("endmonth");
		String endday=request.getParameter("endday");
		
		ScheduleDto scheduleDto=new ScheduleDto();
		scheduleDto.setEmployee_id(id);
		scheduleDto.setSchedule_kind(kind);
		scheduleDto.setSchedule_subject(subject);
		scheduleDto.setSchedule_content(content);
		scheduleDto.setSchedule_startdate(startyear+"-"+startmonth+"-"+startday);
		scheduleDto.setSchedule_enddate(endyear+"-"+endmonth+"-"+endday);
		DepartmentScheduleUserServiceImpl.getDepartmentScheduleUserService().write(scheduleDto);
		return root+"/schedule_department?act=list";
	}
}
