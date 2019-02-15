package com.cube.admin.companyinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.model.dto.GradesDto;

public class GradeListAction implements Action{
	private static GradeListAction gradesListAction;
	static {
		gradesListAction =new GradeListAction();
	}
	
	public static GradeListAction getGradesListAction() {
		return gradesListAction;
	}

	private GradeListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GradesDto> list= AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradelist();
		//System.out.println("gradelist size : "+list);
		request.setAttribute("gradelist", list);
		return "/pages/admin_companyinfo/grade_manage.jsp";
	}

}
