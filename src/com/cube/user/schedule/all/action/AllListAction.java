package com.cube.user.schedule.all.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;
import com.cube.user.schedule.model.service.AllScheduleUserServiceImpl;

public class AllListAction implements Action{
	private static AllListAction allListAction;
	static {
		allListAction=new AllListAction();
	}
	public static AllListAction getAllListAction() {
		return allListAction;
	}
	private AllListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ScheduleDto> schedulelist=AllScheduleUserServiceImpl.getAllScheduleUserService().list();
		List<DepartmentsDto> departmentDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departlist();
		List<EmployeesListDto> employeesListDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().emplist();
		request.setAttribute("slist", schedulelist);
		request.setAttribute("dlist", departmentDto);
		request.setAttribute("elist", employeesListDto);
		return "/pages/user_schedule/schedule_all.jsp";
	}

}
