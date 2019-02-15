package com.cube.admin.businesssupport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.model.dto.VacdocDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.util.Encoder;


public class ConfirmDocSelectAction implements Action{

	private static ConfirmDocSelectAction confirmDocSelectAction;
	
	static {
		confirmDocSelectAction = new ConfirmDocSelectAction();
	}
	
	private ConfirmDocSelectAction(){}
	
	public static ConfirmDocSelectAction getConfirmDocSelectAction() {
		return confirmDocSelectAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dockind = Encoder.isoToUtf(request.getParameter("dockind"));
		String seq = request.getParameter("seq");
		int confirmcheck = 0;
		confirmcheck = CommonServiceImpl.getCommonServiceImpl().confirmcheck(seq);
		if("기안서".equals(dockind)){
			SigndocDto signdocDto = new SigndocDto();
			signdocDto = CommonServiceImpl.getCommonServiceImpl().signview(seq);
			signdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist1()));
			signdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist2()));
			signdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(signdocDto.getConfirmlist3()));
			signdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("signdocwrite", signdocDto);
			return "/pages/admin_confirm/view/approval_signdocview.jsp?docview=";
		} else if("품의서".equals(dockind)){
			OrderdocDto orderdocDto = new OrderdocDto();
			orderdocDto = CommonServiceImpl.getCommonServiceImpl().orderview(seq);
			orderdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist1()));
			orderdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist2()));
			orderdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(orderdocDto.getConfirmlist3()));
			orderdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("orderdocwrite", orderdocDto);
			return "/pages/admin_confirm/view/approval_orderdocview.jsp?docview=";
		} else if("휴가계".equals(dockind)){
			VacdocDto vacdocDto = new VacdocDto();
			vacdocDto = CommonServiceImpl.getCommonServiceImpl().vacview(seq);
			vacdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist1()));
			vacdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist2()));
			vacdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(vacdocDto.getConfirmlist3()));
			vacdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("vacdocwrite", vacdocDto);
			return "/pages/admin_confirm/view/approval_vacdocview.jsp?docview=";
		} else if("출장신청서".equals(dockind)){
			BiztripdocDto biztripdocDto = new BiztripdocDto();
			biztripdocDto = CommonServiceImpl.getCommonServiceImpl().bizview(seq);
			biztripdocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist1()));
			biztripdocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist2()));
			biztripdocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztripdocDto.getConfirmlist3()));
			biztripdocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("biztripdocwrite", biztripdocDto);
			return "/pages/admin_confirm/view/approval_biztripdocview.jsp?docview=";
		} else if("출장보고서".equals(dockind)){
			Biztrip_reportDto biztrip_reportDto = new Biztrip_reportDto();
			biztrip_reportDto = CommonServiceImpl.getCommonServiceImpl().breportview(seq);
			biztrip_reportDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist1()));
			biztrip_reportDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist2()));
			biztrip_reportDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(biztrip_reportDto.getConfirmlist3()));
			biztrip_reportDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("biztrip_report", biztrip_reportDto);
			return "/pages/admin_confirm/view/approval_biztrip_reportview.jsp?docview=";
		} else if("사직서".equals(dockind)){
			DeaddocDto deaddocDto = new DeaddocDto();
			deaddocDto = CommonServiceImpl.getCommonServiceImpl().deadview(seq);
			deaddocDto.setConfirmlistname1(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist1()));
			deaddocDto.setConfirmlistname2(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist2()));
			deaddocDto.setConfirmlistname3(SignDocUserServiceImpl.getSignDocUserService().confirmname(deaddocDto.getConfirmlist3()));
			deaddocDto.setConfirmlist_ok(confirmcheck);
			request.setAttribute("deaddocwrite", deaddocDto);
			return "/pages/admin_confirm/view/approval_deaddocview.jsp?docview=";
		} else
			return "/index.jsp";
		
	}

}
