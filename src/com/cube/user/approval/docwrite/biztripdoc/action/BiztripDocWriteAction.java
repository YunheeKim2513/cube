package com.cube.user.approval.docwrite.biztripdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.dao.VacDocUserDaoImpl;
import com.cube.user.approval.docwrite.model.service.BiztripDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.OrderDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.VacDocUserServiceImpl;

public class BiztripDocWriteAction implements Action {

	private static BiztripDocWriteAction biztripDocWriteAction;
	
	static{
		biztripDocWriteAction = new BiztripDocWriteAction();
	}
	
	private BiztripDocWriteAction(){}
	
	
	public static BiztripDocWriteAction getBiztripDocWriteAction() {
		return biztripDocWriteAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BiztripdocDto biztripdocDto = new BiztripdocDto();
		biztripdocDto.setDoc_code("B04");
		biztripdocDto.setDoc_name("출장신청서");
		biztripdocDto.setConfirmlist1(request.getParameter("biztripconfirm0"));
		biztripdocDto.setConfirmlist2(request.getParameter("biztripconfirm1"));
		biztripdocDto.setConfirmlist3(request.getParameter("biztripconfirm2"));
		biztripdocDto.setConfirmlistname1(request.getParameter("biztripconfirms0"));
		biztripdocDto.setConfirmlistname2(request.getParameter("biztripconfirms1"));
		biztripdocDto.setConfirmlistname3(request.getParameter("biztripconfirms2"));
		biztripdocDto.setDoc_date(request.getParameter("daytext"));
		biztripdocDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		biztripdocDto.setDoc_reference(request.getParameter("referenceinputbox"));
		biztripdocDto.setDoc_file(request.getParameter("biztripfilename"));
		biztripdocDto.setDoc_subject(request.getParameter("biztripsubject"));
		biztripdocDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		biztripdocDto.setDoc_dep(employeesDto.getDepartment_name());
		biztripdocDto.setEmployee_id(employeesDto.getEmployee_id());
		biztripdocDto.setDoc_writer((employeesDto.getGarde_name()+" "+employeesDto.getName()));
		biztripdocDto.setBiztripdoc_start(request.getParameter("biztripstart"));
		biztripdocDto.setBiztripdoc_end(request.getParameter("biztripend"));
		biztripdocDto.setBiztripdoc_content(request.getParameter("content"));
		biztripdocDto.setBiztripdoc_route(request.getParameter("route"));
		String act = request.getParameter("act");
		if("biztripupdate".equals(act)){
			biztripdocDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = BiztripDocUserServiceImpl.getBiztripDocUserService().updatesuccess(biztripdocDto);
		} else {
			int cnt = BiztripDocUserServiceImpl.getBiztripDocUserService().writesuccess(biztripdocDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(biztripdocDto.getDoc_code(), employeesDto.getEmployee_id());
		biztripdocDto.setDoc_seq(seq);
		request.setAttribute("biztripdocwrite", biztripdocDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_biztripdocview.jsp";
		} else 
			return "/pages/user_approval/view/approval_biztripdocview.jsp";
	}

}
