package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.EmployeesListDto;

public class EmployeeListAction implements Action{

	private static EmployeeListAction employeeListAction;
	static{
		employeeListAction=new EmployeeListAction();
	}
	
	public static EmployeeListAction getEmployeeListAction() {
		return employeeListAction;
	}
	private EmployeeListAction(){}
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmployeesListDto> list=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().emplist();
		//System.out.println("list size : "+list.size());
		request.setAttribute("emplist", list);
		return "/pages/admin_companyinfo/employee_list.jsp";
	}

}
