package com.cube.user.businessreport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.user.businessreport.model.service.MyWorkreportUserServiceImpl;

public class MyWorkreportCheckListAction implements Action {

	private static MyWorkreportCheckListAction myWorkreportCheckListAction;
	
	static {
		myWorkreportCheckListAction = new MyWorkreportCheckListAction();
	}
	
	private MyWorkreportCheckListAction(){}
	
	public static MyWorkreportCheckListAction getMyWorkreportCheckListAction() {
		return myWorkreportCheckListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		if("usermyworkcheck".equals(act)){
			List<Work_reportDto> work_reportlist = new ArrayList<Work_reportDto>();
			work_reportlist = MyWorkreportUserServiceImpl.getMyWorkreportUserService().mywork_reportlist(employeesDto.getEmployee_id());
			request.setAttribute("work_reportlist", work_reportlist);
			return "/pages/user_workreport/workreport_usermyworkcheck.jsp";
		} else if("receiveworkcheck".equals(act)){
			List<Work_reportDto> work_reportlist = new ArrayList<Work_reportDto>();
			work_reportlist = MyWorkreportUserServiceImpl.getMyWorkreportUserService().receivework_reportlist(employeesDto.getEmployee_id(), employeesDto.getDepartment_name());
			request.setAttribute("work_reportlist", work_reportlist);
			return "/pages/user_workreport/workreport_receiveworkcheck.jsp";
		} else
			return "/index.jsp";
	}
}
