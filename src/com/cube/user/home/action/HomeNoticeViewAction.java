package com.cube.user.home.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.businesssupport.action.DiligenceSearchAction;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.main.model.dao.MainUserDaoImpl;
import com.cube.user.approval.main.model.service.MainUserServiceImpl;

public class HomeNoticeViewAction implements Action{

	
	private static HomeNoticeViewAction homeNoticeViewAction;

	static{
		homeNoticeViewAction = new HomeNoticeViewAction();
	}

	private HomeNoticeViewAction(){}

		public static HomeNoticeViewAction getHomeNoticeViewAction() {
		return homeNoticeViewAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		
		
		List<Doc_info_detailDto> bapprovallist = MainUserDaoImpl.getMainUserDao().bapprovallist();
		
		request.setAttribute("bapprovallist", bapprovallist);
		
		return "/pages/home/user_home.jsp";
	}

}
