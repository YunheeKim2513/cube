package com.cube.user.approval.senddoc.withdrawdoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.senddoc.model.service.WithDrawDocUserServiceImpl;

public class WithDrawDocListAction implements Action {

	private static WithDrawDocListAction withDrawDocListAction;
	
	static {
		withDrawDocListAction = new WithDrawDocListAction(); 
	}
	
	WithDrawDocListAction(){}
	
	
	public static WithDrawDocListAction getWithDrawDocListAction() {
		return withDrawDocListAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> withdrawdoclist = new ArrayList<Doc_info_detailDto>();
		withdrawdoclist = WithDrawDocUserServiceImpl.getWithDrawDocUserService().withdrawdoclist(employeesDto.getEmployee_id());
		request.setAttribute("withdrawdoclist", withdrawdoclist);
		return "/pages/user_approval/approval_userwithdrawdoc.jsp";
	}

}
