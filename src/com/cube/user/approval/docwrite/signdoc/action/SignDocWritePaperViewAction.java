package com.cube.user.approval.docwrite.signdoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;

public class SignDocWritePaperViewAction implements Action{

	private static SignDocWritePaperViewAction signDocWritePaperViewAction;
	
	static {
		signDocWritePaperViewAction = new SignDocWritePaperViewAction();
	}
	
	private SignDocWritePaperViewAction(){}
	
	public static SignDocWritePaperViewAction getSignDocWritePaperViewAction() {
		return signDocWritePaperViewAction;
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
		if("signdocupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			SigndocDto signdocDto = new SigndocDto();
			signdocDto = CommonServiceImpl.getCommonServiceImpl().signview(seq);
			signdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist1()));
			signdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist2()));
			signdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist3()));
			signdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("signdocwrite", signdocDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_signdocupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_signdocupdate.jsp";
		} else if("orderdocupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			OrderdocDto orderdocDto = new OrderdocDto();
			orderdocDto = CommonServiceImpl.getCommonServiceImpl().orderview(seq);
			orderdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist1()));
			orderdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist2()));
			orderdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist3()));
			orderdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("orderdocwrite", orderdocDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_orderdocupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_orderdocupdate.jsp";
		} else{
			if("approval_signdocwrite".equals(act)){
				return "/pages/user_approval/write/approval_signdocwrite.jsp";
			} else if("approval_orderdocwrite".equals(act)){
				return "/pages/user_approval/write/approval_orderdocwrite.jsp";
			} else
				return "/index.jsp";
		}
	}
	
}
