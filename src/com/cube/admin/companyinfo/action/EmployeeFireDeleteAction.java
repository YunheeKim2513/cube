package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;

public class EmployeeFireDeleteAction implements Action {
	private static EmployeeFireDeleteAction employeeFireDeleteAction;
	static {
		employeeFireDeleteAction=new EmployeeFireDeleteAction();
	}
	
	public static EmployeeFireDeleteAction getEmployeeFireDeleteAction() {
		return employeeFireDeleteAction;
	}
	private EmployeeFireDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("EmployeeFireDeleteAction");
		String id=request.getParameter("id");
		//System.out.println("fire employee_id : "+id);
		AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().firedelete(id);
		return "/emp?act=firelist";
	}
}
