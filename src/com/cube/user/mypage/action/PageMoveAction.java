package com.cube.user.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.admin.companyinfo.model.service.AdminCompanyinfoEmployeeServiceImpl;
import com.cube.model.dto.DepartmentsDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.EmployeesListDto;
import com.cube.model.dto.GradesDto;

public class PageMoveAction implements Action{

	
	private static PageMoveAction pageMoveAction;
	static{
		pageMoveAction=new PageMoveAction();
	}
	
	public static PageMoveAction getPageMoveAction() {
		return pageMoveAction;
	}
	private PageMoveAction(){
	
	}

	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
	
		EmployeesDto login=(EmployeesDto)session.getAttribute("userInfo");
		 String id= login.getEmployee_id();
		EmployeesListDto employeesListDto=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().searchid(id);
		List<DepartmentsDto> dlist=AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departlist();
		List<GradesDto> glist= AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradelist();
		List<String> grlist=AdminCompanyinfoEmployeeServiceImpl.getAdminCompanyinfoEmployeeService().grouplist();
		request.setAttribute("myupdate", employeesListDto);
		request.setAttribute("departlist", dlist);
		request.setAttribute("gradelist", glist);
		request.setAttribute("grouplist", grlist);
		
		
		return "/pages/mypage/user_mypage.jsp";
	}
	
	
}
