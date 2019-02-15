package com.cube.user.approval.docwrite.deaddoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;

public class DeadDocWritePaperViewAction implements Action{

	private static DeadDocWritePaperViewAction deadDocWritePaperViewAction;
	
	static {
		deadDocWritePaperViewAction = new DeadDocWritePaperViewAction();
	}
	
	private DeadDocWritePaperViewAction(){}
	
	public static DeadDocWritePaperViewAction getDeadDocWritePaperViewAction() {
		return deadDocWritePaperViewAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String admin = request.getParameter("admin");
		List<Confirmlist_infoDto> list = new ArrayList<Confirmlist_infoDto>();
		List<EmployeesDto> confirmlist = new ArrayList<EmployeesDto>();
		list = SignDocUserServiceImpl.getSignDocUserService().confirmlist();
		confirmlist = SignDocUserServiceImpl.getSignDocUserService().confirmlistview();
		request.setAttribute("confirmlist", list);
		request.setAttribute("confirmlistview", confirmlist);
		if("deaddocupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			DeaddocDto deaddocDto = new DeaddocDto();
			deaddocDto = CommonServiceImpl.getCommonServiceImpl().deadview(seq);
			deaddocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist1()));
			deaddocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist2()));
			deaddocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist3()));
			deaddocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("deaddocwrite", deaddocDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_deaddocupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_deaddocupdate.jsp";
		} else 
			return "/pages/user_approval/write/approval_deaddocwrite.jsp";
	}
	
}
