package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;

public class GradeDeleteAction implements Action{
	private static GradeDeleteAction gradesListAction;
	static {
		gradesListAction =new GradeDeleteAction();
	}
	
	public static GradeDeleteAction getGradesDeleteAction() {
		return gradesListAction;
	}

	private GradeDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("GradeDeleteAction");
		String id=request.getParameter("id");
		//System.out.println("grade id : "+id);
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradedelete(id);
		
		return "/grade?act=list";
	}

}
