package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;

public class DepartmentDeleteAction implements Action{
	private static DepartmentDeleteAction departmentDeleteAction;
	static {
		departmentDeleteAction =new DepartmentDeleteAction();
	}
	
	public static DepartmentDeleteAction getGradesDeleleAction() {
		return departmentDeleteAction;
	}

	private DepartmentDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departdelete(id);
		return "/depart?act=list";
	}

}
