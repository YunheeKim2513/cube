package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.user.approval.main.model.service.MainUserServiceImpl;

public class ConfirmDocListManageAction implements Action {

	private static ConfirmDocListManageAction confirmDocListManageAction;
	
	static {
		confirmDocListManageAction = new ConfirmDocListManageAction();
	}
	
	private ConfirmDocListManageAction(){}
	
	public static ConfirmDocListManageAction getConfirmDocListManageAction() {
		return confirmDocListManageAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Doc_info_detailDto> doclist = new ArrayList<Doc_info_detailDto>();
		doclist = MainUserServiceImpl.getMainUserService().bapprovallist();
		request.setAttribute("doclist", doclist);
		return "/pages/admin_confirm/confirm_docmanage.jsp";
	}

}
