package com.cube.user.approval.receivedoc.nodoc.action;

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
import com.cube.user.approval.receivedoc.model.service.NoDocUserServiceImpl;

public class NoDocListAction implements Action {
	private static NoDocListAction noDocListAction;
	
	static{
		noDocListAction = new NoDocListAction();
	}

	private NoDocListAction(){}
	
	public static NoDocListAction getNoDocListAction() {
		return noDocListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> nolistapprovallist = new ArrayList<Doc_info_detailDto>();
		nolistapprovallist = NoDocUserServiceImpl.getNoDocUserService().nolistapprovallist(employeesDto.getEmployee_id());
		request.setAttribute("nolistapprovallist", nolistapprovallist);
		return "/pages/user_approval/approval_usernodoc.jsp";
	}
	
	
}
