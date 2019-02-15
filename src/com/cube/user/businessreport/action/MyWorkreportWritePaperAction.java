package com.cube.user.businessreport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.user.businessreport.model.service.MyWorkreportUserServiceImpl;

public class MyWorkreportWritePaperAction implements Action {

	private static MyWorkreportWritePaperAction myWorkreportWritePaperAction;
	
	static {
		myWorkreportWritePaperAction = new MyWorkreportWritePaperAction();
	}
	
	private MyWorkreportWritePaperAction(){}
	
	public static MyWorkreportWritePaperAction getMyWorkreportWritePaperAction() {
		return myWorkreportWritePaperAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		List<EmployeesDto> confirmemployeelist = new ArrayList<EmployeesDto>();
		confirmemployeelist = SignDocUserServiceImpl.getSignDocUserService().confirmlistview();
		request.setAttribute("confirmemployeelist", confirmemployeelist);
		if("workreportupdate".equals(act)){
			String seq = request.getParameter("seq");
			Work_reportDto work_report_view = new Work_reportDto();
			work_report_view = MyWorkreportUserServiceImpl.getMyWorkreportUserService().work_report_view(seq);
			request.setAttribute("work_report_view", work_report_view);
			return "/pages/user_workreport/workreport_modify.jsp";
		} else {
			return "/pages/user_workreport/workreport_usermyworkreport.jsp";
		}
	}

}
