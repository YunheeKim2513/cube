package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.util.Encoder;

public class GradeWriteAction implements Action {
	private static GradeWriteAction gradeWriteAction;
	static{
		gradeWriteAction=new GradeWriteAction();
	}
	
	public static GradeWriteAction getGradeWriteAction() {
		return gradeWriteAction;
	}
	private GradeWriteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("grade_id");
		//System.out.println("id : "+id);
		String name=Encoder.isoToEuc(request.getParameter("grade_name"));
		//System.out.println("name : "+name);
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradewrite(id, name);
		return "/grade?act=list";
	}

}
