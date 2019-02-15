package com.cube.user.approval.docwrite.vacdoc.action;

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
import com.cube.model.dto.VacdocDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;

public class VacDocWritePaperViewAction implements Action{

	private static VacDocWritePaperViewAction vacDocWritePaperViewAction;
	
	static {
		vacDocWritePaperViewAction = new VacDocWritePaperViewAction();
	}
	
	private VacDocWritePaperViewAction(){}
	
	public static VacDocWritePaperViewAction getVacDocWritePaperViewAction() {
		return vacDocWritePaperViewAction;
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
		if("vacdocupdate".equals(act)){
			String seq = request.getParameter("seq");
			int confirmcheck = 0;
			confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
			VacdocDto vacdocDto = new VacdocDto();
			vacdocDto = CommonServiceImpl.getCommonServiceImpl().vacview(seq);
			vacdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist1()));
			vacdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist2()));
			vacdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist3()));
			vacdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("vacdocwrite", vacdocDto);
			if("admin".equals(admin)){
				return "/pages/admin_confirm/updatewrite/approval_vacdocupdate.jsp";
			} else 
				return "/pages/user_approval/updatewrite/approval_vacdocupdate.jsp";
		} else 
			return "/pages/user_approval/write/approval_vacdocwrite.jsp";
	}
	
}
