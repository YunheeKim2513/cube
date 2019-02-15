package com.cube.user.schedule.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class CompanyModifyAction implements Action{
	private static CompanyModifyAction companyModifyAction;
	static {
		companyModifyAction=new CompanyModifyAction();
	}
	
	public static CompanyModifyAction getCompanyModifyAction() {
		return companyModifyAction;
	}
	private CompanyModifyAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
