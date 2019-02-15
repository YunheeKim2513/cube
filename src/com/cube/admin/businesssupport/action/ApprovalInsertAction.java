package com.cube.admin.businesssupport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;


public class ApprovalInsertAction implements Action{

	private static ApprovalInsertAction approvalInsertAction;
	
	static {
		approvalInsertAction = new ApprovalInsertAction();
	}
	
	private ApprovalInsertAction(){}
	
	public static ApprovalInsertAction getApprovalInsertAction() {
		return approvalInsertAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmployeesDto> confirmlist = new ArrayList<EmployeesDto>();
		confirmlist = SignDocUserServiceImpl.getSignDocUserService().confirmlistview();
		List<Confirmlist_infoDto> list = new ArrayList<Confirmlist_infoDto>();
		list = SignDocUserServiceImpl.getSignDocUserService().confirmlist();
		request.setAttribute("confirmlist", list);
		request.setAttribute("confirmlistview", confirmlist);
		return "/pages/admin_confirm/admin_confirmlist.jsp";
	}

}
