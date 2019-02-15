package com.cube.user.schedule.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.DepartmentsDto;
import com.cube.model.dto.EmployeesListDto;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.service.CompanyScheduleUserServiceImpl;

public class CompanyListAction implements Action{
	private static CompanyListAction companyListAction;
	static {
		companyListAction=new CompanyListAction();
	}
	
	public static CompanyListAction getCompanyListAction() {
		return companyListAction;
	}
	private CompanyListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("CompanyListAction");
		List<ScheduleDto> schedulelist=CompanyScheduleUserServiceImpl.getCompanyScheduleUserService().list();
		List<DepartmentsDto> departmentDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departlist();
		List<EmployeesListDto> employeesListDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().emplist();
		//System.out.println("schedulelist size : "+schedulelist.size());
		request.setAttribute("slist", schedulelist);
		request.setAttribute("dlist", departmentDto);
		request.setAttribute("elist", employeesListDto);
		return "/pages/user_schedule/schedule_company.jsp";
	}

}
