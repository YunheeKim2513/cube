package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class EmployeeDeleteAction implements Action{

	private static EmployeeDeleteAction employeeDeleteAction;
	static{
		employeeDeleteAction=new EmployeeDeleteAction();
	}
	
	public static EmployeeDeleteAction getEmployeeDeleteAction() {
		return employeeDeleteAction;
	}
	private EmployeeDeleteAction(){}
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

}
