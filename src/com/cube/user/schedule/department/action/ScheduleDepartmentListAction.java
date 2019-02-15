package com.cube.user.schedule.department.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;
import com.cube.user.schedule.model.service.PrivateScheduleUserServiceImpl;

public class ScheduleDepartmentListAction implements Action{
	private static ScheduleDepartmentListAction scheduleDepartmentListAction;
	static{
		scheduleDepartmentListAction=new ScheduleDepartmentListAction();
	}
	
	public static ScheduleDepartmentListAction getScheduleDepartmentListAction() {
		return scheduleDepartmentListAction;
	}
	private ScheduleDepartmentListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("ScheduleDepartmentListAction");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		//System.out.println("id : "+id);
		List<ScheduleDto> schedulelist=PrivateScheduleUserServiceImpl.getPrivateScheduleUserService().list(id);
		List<DepartmentsDto> departmentDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departlist();
		List<EmployeesListDto> employeesListDto=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().emplist();
		//System.out.println("schedulelist size : "+schedulelist.size());
		request.setAttribute("slist", schedulelist);
		request.setAttribute("dlist", departmentDto);
		request.setAttribute("elist", employeesListDto);
		return "/pages/user_schedule/schedule_department.jsp";
	}

}
