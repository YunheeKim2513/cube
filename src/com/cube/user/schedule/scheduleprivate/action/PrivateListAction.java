package com.cube.user.schedule.scheduleprivate.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;
import com.cube.user.schedule.model.service.PrivateScheduleUserServiceImpl;

public class PrivateListAction implements Action{
	private static PrivateListAction privateListAction;
	static{
		privateListAction=new PrivateListAction();
	}
	
	public static PrivateListAction getPrivateListAction() {
		return privateListAction;
	}
	private PrivateListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("PrivateListAction");
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
		return "/pages/user_schedule/schedule_private.jsp";
	}

}
