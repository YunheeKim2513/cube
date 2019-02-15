package com.cube.user.approval.docwrite.deaddoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.DeaddocDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.dao.DeadDocUserDaoImpl;
import com.cube.user.approval.docwrite.model.service.DeadDocUserServiceImpl;

public class DeadDocWriteAction implements Action {

	private static DeadDocWriteAction deadDocWriteAction;
	
	static {
		deadDocWriteAction = new DeadDocWriteAction(); 
	}
	
	private DeadDocWriteAction(){}
	
	
	
	public static DeadDocWriteAction getDeadDocWriteAction() {
		return deadDocWriteAction;
	}



	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeaddocDto deaddocDto = new DeaddocDto();
		deaddocDto.setDoc_code("D06");
		deaddocDto.setDoc_name("사직서");
		deaddocDto.setConfirmlist1(request.getParameter("deadconfirm0"));
		deaddocDto.setConfirmlist2(request.getParameter("deadconfirm1"));
		deaddocDto.setConfirmlist3(request.getParameter("deadconfirm2"));
		deaddocDto.setConfirmlistname1(request.getParameter("deadconfirms0"));
		deaddocDto.setConfirmlistname2(request.getParameter("deadconfirms1"));
		deaddocDto.setConfirmlistname3(request.getParameter("deadconfirms2"));
		deaddocDto.setDoc_date(request.getParameter("daytext"));
		deaddocDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		deaddocDto.setDoc_reference(request.getParameter("referenceinputbox"));
		deaddocDto.setDoc_file(request.getParameter("deadfilename"));
		deaddocDto.setDoc_subject(request.getParameter("deadsubject"));
		deaddocDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		deaddocDto.setDoc_dep(employeesDto.getDepartment_name());
		deaddocDto.setEmployee_id(employeesDto.getEmployee_id());
		deaddocDto.setDoc_writer((employeesDto.getGarde_name()+" "+employeesDto.getName()));
		deaddocDto.setDeaddoc_startdate(request.getParameter("deadstart"));
		deaddocDto.setDeaddoc_enddate(request.getParameter("deadend"));
		deaddocDto.setDeaddoc_content(request.getParameter("content"));
		deaddocDto.setDeaddoc_currentwork(request.getParameter("currentwork"));
		String act = request.getParameter("act");
		if("deadupdate".equals(act)){
			deaddocDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = DeadDocUserServiceImpl.getDeadDocUserService().updatesuccess(deaddocDto);
		} else {
			int cnt = DeadDocUserDaoImpl.getDeadDocUserDao().writesuccess(deaddocDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(deaddocDto.getDoc_code(), employeesDto.getEmployee_id());
		deaddocDto.setDoc_seq(seq);
		request.setAttribute("deaddocwrite", deaddocDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_deaddocview.jsp";
		} else 
			return "/pages/user_approval/view/approval_deaddocview.jsp";
	}

}
