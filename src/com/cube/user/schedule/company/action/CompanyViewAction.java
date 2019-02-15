package com.cube.user.schedule.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class CompanyViewAction implements Action{
	private static CompanyViewAction companyViewAction;
	static {
		companyViewAction=new CompanyViewAction();
	}
	
	public static CompanyViewAction getCompanyViewAction() {
		return companyViewAction;
	}
	private CompanyViewAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
