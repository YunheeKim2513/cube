package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class EmployeeViewAction implements Action{

	private static EmployeeViewAction employeeViewAction;
	static{
		employeeViewAction=new EmployeeViewAction();
	}
	
	public static EmployeeViewAction getEmployeeViewAction() {
		return employeeViewAction;
	}
	private EmployeeViewAction(){}

	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
