package com.cube.user.approval.docwrite.biztripdoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.Confirmlist_infoDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;

public class BiztripDocWritePaperViewAction implements Action{

	private static BiztripDocWritePaperViewAction biztripDocWritePaperViewAction;
	
	static {
		biztripDocWritePaperViewAction = new BiztripDocWritePaperViewAction();
	}
	
	private BiztripDocWritePaperViewAction(){}
	
	public static BiztripDocWritePaperViewAction getBiztripDocWritePaperViewAction() {
		return biztripDocWritePaperViewAction;
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
		if("biztripdocupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			BiztripdocDto biztripdocDto = new BiztripdocDto();
			biztripdocDto = CommonServiceImpl.getCommonServiceImpl().bizview(seq);
			biztripdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist1()));
			biztripdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist2()));
			biztripdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist3()));
			biztripdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("biztripdocwrite", biztripdocDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_biztripdocupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_biztripdocupdate.jsp";
		} else if("biztrip_reportupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			Biztrip_reportDto biztrip_reportDto = new Biztrip_reportDto();
			biztrip_reportDto = CommonServiceImpl.getCommonServiceImpl().breportview(seq);
			biztrip_reportDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist1()));
			biztrip_reportDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist2()));
			biztrip_reportDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist3()));
			biztrip_reportDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("biztripreportwrite", biztrip_reportDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_biztrip_reportupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_biztrip_reportupdate.jsp";
		} else{
			if("approval_biztripdoc".equals(act)){
				return "/pages/user_approval/write/approval_biztripdocwrite.jsp";
			} else if("approval_biztrip_report".equals(act)){
				return "/pages/user_approval/write/approval_biztrip_reportwrite.jsp";
			} else
				return "/index.jsp";
		}
	}
}
