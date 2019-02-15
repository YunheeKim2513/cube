package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;

public class EmployeeMoveUpdateAction implements Action {

	private static EmployeeMoveUpdateAction employeeMoveUpdateAction;
	static {
		employeeMoveUpdateAction = new EmployeeMoveUpdateAction();
	}

	public static EmployeeMoveUpdateAction getEmployeeMoveUpdateAction() {
		return employeeMoveUpdateAction;
	}

	private EmployeeMoveUpdateAction() {
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("EmployeeMoveUpdateAction");
		String id=request.getParameter("id");
		EmployeesListDto employeesListDto=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().searchid(id);
		List<DepartmentsDto> dlist=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departlist();
		List<GradesDto> glist= AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradelist();
		List<String> grlist=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().grouplist();
		request.setAttribute("empupdate", employeesListDto);
		request.setAttribute("departlist", dlist);
		request.setAttribute("gradelist", glist);
		request.setAttribute("grouplist", grlist);
		return "/pages/admin_companyinfo/employee_update.jsp";
	}

}
