package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.*;

public class EmployeeMoveWriteAction implements Action {

	private static EmployeeMoveWriteAction employeeMoveWriteAction;
	static {
		employeeMoveWriteAction = new EmployeeMoveWriteAction();
	}

	public static EmployeeMoveWriteAction getEmployeeMoveWriteAction() {
		return employeeMoveWriteAction;
	}

	private EmployeeMoveWriteAction() {
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("EmployeeMoveWriteAction");
		List<DepartmentsDto> dlist=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departlist();
		List<GradesDto> glist=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().gradelist();
		List<String> grlist=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().grouplist();
		request.setAttribute("departlist", dlist);
		request.setAttribute("gradelist", glist);
		request.setAttribute("grouplist", grlist);
		
		//System.out.println("departmentlist size : "+dlist.size());
		//System.out.println("gradelist size : "+glist.size());
		
		return "/pages/admin_companyinfo/employee_signup.jsp";
	}

}
