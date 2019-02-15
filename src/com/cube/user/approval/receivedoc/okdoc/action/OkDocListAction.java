package com.cube.user.approval.receivedoc.okdoc.action;

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
import com.cube.user.approval.receivedoc.model.service.OkDocUserServiceImpl;

public class OkDocListAction implements Action {
	
	private static OkDocListAction okDocListAction;
	
	static {
		okDocListAction = new OkDocListAction();
	}
	
	private OkDocListAction(){}

	public static OkDocListAction getOkDocListAction() {
		return okDocListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> oklistapprovallist = new ArrayList<Doc_info_detailDto>();
		oklistapprovallist = OkDocUserServiceImpl.getOkDocUserService().oklistapprovallist(employeesDto.getEmployee_id());
		request.setAttribute("oklistapprovallist", oklistapprovallist);
		return "/pages/user_approval/approval_userokdoc.jsp";
	}
	
	
}
