package com.cube.user.approval.senddoc.returndoc.action;

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
import com.cube.user.approval.senddoc.model.service.ReturnDocUserServiceImpl;

public class ReturnDocListAction implements Action {

	private static ReturnDocListAction returnDocListAction;
	
	static {
		returnDocListAction = new ReturnDocListAction();
	}
	
	private ReturnDocListAction(){}
	
	public static ReturnDocListAction getReturnDocListAction() {
		return returnDocListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> returndoclist = new ArrayList<Doc_info_detailDto>();
		returndoclist = ReturnDocUserServiceImpl.getReturnDocUserService().returndoclist(employeesDto.getEmployee_id());
		request.setAttribute("returndoclist", returndoclist);
		return "/pages/user_approval/approval_userreturn.jsp";
	}

}
