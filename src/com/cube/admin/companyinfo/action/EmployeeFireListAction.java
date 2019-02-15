package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.model.dto.EmployeesListDto;

public class EmployeeFireListAction implements Action{
	private static EmployeeFireListAction employeeFireListAction;
	static{
		employeeFireListAction=new EmployeeFireListAction();
	}
	
	public static EmployeeFireListAction getEmployeeFireListAction() {
		return employeeFireListAction;
	}
	private EmployeeFireListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("EmployeeFireListAction");
		List<EmployeesListDto> list=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().firelist();
		//System.out.println("list size : "+list.size());
		request.setAttribute("firelist", list);
		return "/pages/admin_companyinfo/employee_firelist.jsp";
	}

}
