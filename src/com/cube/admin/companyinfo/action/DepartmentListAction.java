package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.model.dto.DepartmentsDto;

public class DepartmentListAction implements Action{
	private static DepartmentListAction departmentListAction;
	static {
		departmentListAction =new DepartmentListAction();
	}
	
	public static DepartmentListAction getDepartmentListAction() {
		return departmentListAction;
	}

	private DepartmentListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DepartmentsDto> list=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departlist();
		request.setAttribute("departlist", list);
		return "/pages/admin_companyinfo/department_manage.jsp";
	}

}
