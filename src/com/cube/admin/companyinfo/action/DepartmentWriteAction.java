package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.util.Encoder;

public class DepartmentWriteAction implements Action {
	private static DepartmentWriteAction departmentWriteAction;
	static {
		departmentWriteAction=new DepartmentWriteAction();
	}
	
	public static DepartmentWriteAction getDepartmentWriteAction() {
		return departmentWriteAction;
	}
	private DepartmentWriteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("department_id");
		//System.out.println("id : "+id);
		String name=Encoder.isoToEuc(request.getParameter("department_name"));
		//System.out.println("name : "+name);
		AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().departwrite(id,name);
		
		return "/depart?act=list";
	}

}
