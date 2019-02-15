package com.cube.user.approval.main.action;

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
import com.cube.user.approval.main.model.service.MainUserServiceImpl;

public class ApprovalDepartmentAction implements Action {

	private static ApprovalDepartmentAction approvalDepartmentAction;
	
	static {
		approvalDepartmentAction = new ApprovalDepartmentAction();
	}
	
	private ApprovalDepartmentAction() {}
	
	
	
	public static ApprovalDepartmentAction getApprovalDepartmentAction() {
		return approvalDepartmentAction;
	}
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> depapprovallist = new ArrayList<Doc_info_detailDto>();
		depapprovallist = MainUserServiceImpl.getMainUserService().depapprovallist(employeesDto.getDepartment_name());
		request.setAttribute("depapprovallist", depapprovallist);
		return "/pages/user_approval/approval_department.jsp";
	}

}
