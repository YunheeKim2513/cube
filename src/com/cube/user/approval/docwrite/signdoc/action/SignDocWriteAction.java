package com.cube.user.approval.docwrite.signdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.SigndocDto;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.VacDocUserServiceImpl;


public class SignDocWriteAction implements Action {
	
	private static SignDocWriteAction signDocWriteAction;
	
	static {
		signDocWriteAction = new SignDocWriteAction();
	}
	
	private SignDocWriteAction() {}
	
	
	
	public static SignDocWriteAction getSignDocWriteAction() {
		return signDocWriteAction;
	}



	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SigndocDto signdocDto = new SigndocDto();
		signdocDto.setDoc_code("S01");
		signdocDto.setDoc_name("기안서");
		signdocDto.setConfirmlist1(request.getParameter("signconfirm0"));
		signdocDto.setConfirmlist2(request.getParameter("signconfirm1"));
		signdocDto.setConfirmlist3(request.getParameter("signconfirm2"));
		signdocDto.setConfirmlistname1(request.getParameter("signconfirms0"));
		signdocDto.setConfirmlistname2(request.getParameter("signconfirms1"));
		signdocDto.setConfirmlistname3(request.getParameter("signconfirms2"));
		signdocDto.setDoc_date(request.getParameter("daytext"));
		signdocDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		signdocDto.setDoc_reference(request.getParameter("referenceinputbox"));
		signdocDto.setDoc_file(request.getParameter("signfilename"));
		signdocDto.setDoc_subject(request.getParameter("signsubject"));
		signdocDto.setSigndoc_content(request.getParameter("ir1"));
		signdocDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		signdocDto.setDoc_dep(employeesDto.getDepartment_name());
		signdocDto.setEmployee_id(employeesDto.getEmployee_id());
		signdocDto.setDoc_writer(employeesDto.getGarde_name()+" "+employeesDto.getName());
		String act = request.getParameter("act");
		if("signupdate".equals(act)){
			signdocDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = SignDocUserServiceImpl.getSignDocUserService().updatesuccess(signdocDto);
		} else {
			int cnt = SignDocUserServiceImpl.getSignDocUserService().writesuccess(signdocDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(signdocDto.getDoc_code(), employeesDto.getEmployee_id());
		signdocDto.setDoc_seq(seq);
		request.setAttribute("signdocwrite", signdocDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_signdocview.jsp";
		} else 
			return "/pages/user_approval/view/approval_signdocview.jsp";
	}
}
