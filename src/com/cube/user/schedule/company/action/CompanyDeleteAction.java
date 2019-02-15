package com.cube.user.schedule.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class CompanyDeleteAction implements Action{
	private static CompanyDeleteAction companyDeleteAction;
	static {
		companyDeleteAction=new CompanyDeleteAction();
	}
	
	public static CompanyDeleteAction getCompanyDeleteAction() {
		return companyDeleteAction;
	}
	private CompanyDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
