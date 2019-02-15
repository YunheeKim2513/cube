package com.cube.user.approval.main.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.main.model.service.MainUserServiceImpl;

public class ApprovalBusinessAction implements Action {
	
	private static ApprovalBusinessAction approvalBusinessAction;
	
	static {
		approvalBusinessAction = new ApprovalBusinessAction();
	}
	
	private ApprovalBusinessAction() {}
	
	
	
	public static ApprovalBusinessAction getApprovalBusinessAction() {
		return approvalBusinessAction;
	}
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Doc_info_detailDto> bapprovallist = new ArrayList<Doc_info_detailDto>();
		bapprovallist = MainUserServiceImpl.getMainUserService().bapprovallist();
		request.setAttribute("bapprovallist", bapprovallist);
		return "/pages/user_approval/approval_business.jsp";
		//String json =MainUserServiceImpl.getMainUserService().bapprovallist();
		//return json;
	}

}
