package com.cube.user.approval.main.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class ApprovalMainAction implements Action {

	private static ApprovalMainAction approvalMainAction;
	
	static {
		approvalMainAction = new ApprovalMainAction();
	}
	
	private ApprovalMainAction() {}
	
	
	
	public static ApprovalMainAction getApprovalMainAction() {
		return approvalMainAction;
	}



	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/pages/user_approval/approval_main.jsp";
	}

}
