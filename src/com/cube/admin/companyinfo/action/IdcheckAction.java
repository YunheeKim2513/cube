package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.util.Encoder;

public class IdcheckAction implements Action {
	private static IdcheckAction idcheckAction;
	static {
		idcheckAction = new IdcheckAction();
	}
	
	public static IdcheckAction getIdcheckAction() {
		return idcheckAction;
	}
	private IdcheckAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=Encoder.isoToEuc(request.getParameter("id"));
		//System.out.println(id);
		int count=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().idCheck(id);//id를 service로 보내야함
		return "/pages/admin_companyinfo/idcheck.jsp?id="+id+"&count="+count;
	}
}
