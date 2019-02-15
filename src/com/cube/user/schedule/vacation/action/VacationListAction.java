package com.cube.user.schedule.vacation.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;
import com.cube.user.schedule.model.service.VacationScheduleUserServiceImpl;

public class VacationListAction implements Action{
	private static VacationListAction vacationListAction;
	static {
		vacationListAction =new VacationListAction();
	}
	public static VacationListAction getVacationListAction() {
		return vacationListAction;
	}
	private VacationListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ScheduleDto> schedulelist=VacationScheduleUserServiceImpl.getVacationScheduleUserService().list();
		List<DepartmentsDto> departmentDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departlist();
		List<EmployeesListDto> employeesListDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().emplist();
		request.setAttribute("slist", schedulelist);
		request.setAttribute("dlist", departmentDto);
		request.setAttribute("elist", employeesListDto);
		return "/pages/user_schedule/schedule_vacation.jsp";
	}

}
