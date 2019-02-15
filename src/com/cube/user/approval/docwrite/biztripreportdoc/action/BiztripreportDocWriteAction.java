package com.cube.user.approval.docwrite.biztripreportdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Biztrip_reportDto;
import com.cube.model.dto.BiztripdocDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.docwrite.model.dao.VacDocUserDaoImpl;
import com.cube.user.approval.docwrite.model.service.BiztripDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.BiztripreportDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.VacDocUserServiceImpl;

public class BiztripreportDocWriteAction implements Action {

	private static BiztripreportDocWriteAction biztripreportDocWriteAction;
	
	static{
		biztripreportDocWriteAction = new BiztripreportDocWriteAction();
	}
	
	private BiztripreportDocWriteAction(){}
	
	
	public static BiztripreportDocWriteAction getBiztripreportDocWriteAction() {
		return biztripreportDocWriteAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Biztrip_reportDto biztrip_reportDto = new Biztrip_reportDto();
		biztrip_reportDto.setDoc_code("B04");
		biztrip_reportDto.setDoc_name("출장보고서");
		biztrip_reportDto.setConfirmlist1(request.getParameter("biztripconfirm0"));
		biztrip_reportDto.setConfirmlist2(request.getParameter("biztripconfirm1"));
		biztrip_reportDto.setConfirmlist3(request.getParameter("biztripconfirm2"));
		biztrip_reportDto.setConfirmlistname1(request.getParameter("biztripconfirms0"));
		biztrip_reportDto.setConfirmlistname2(request.getParameter("biztripconfirms1"));
		biztrip_reportDto.setConfirmlistname3(request.getParameter("biztripconfirms2"));
		biztrip_reportDto.setDoc_date(request.getParameter("daytext"));
		biztrip_reportDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		biztrip_reportDto.setDoc_reference(request.getParameter("referenceinputbox"));
		biztrip_reportDto.setDoc_file(request.getParameter("biztripfilename"));
		biztrip_reportDto.setDoc_subject(request.getParameter("biztripsubject"));
		biztrip_reportDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		biztrip_reportDto.setDoc_dep(employeesDto.getDepartment_name());
		biztrip_reportDto.setEmployee_id(employeesDto.getEmployee_id());
		biztrip_reportDto.setDoc_writer((employeesDto.getGarde_name()+" "+employeesDto.getName()));
		biztrip_reportDto.setBiztrip_report_start(request.getParameter("biztripstart"));
		biztrip_reportDto.setBiztrip_report_end(request.getParameter("biztripend"));
		biztrip_reportDto.setBiztrip_report_content(request.getParameter("content"));
		biztrip_reportDto.setBiztrip_report_route(request.getParameter("route"));
		String act = request.getParameter("act");
		if("triprepotupdate".equals(act)){
			biztrip_reportDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = BiztripreportDocUserServiceImpl.getBiztripreportDocUserService().updatesuccess(biztrip_reportDto);
		} else {
			int cnt = BiztripreportDocUserServiceImpl.getBiztripreportDocUserService().writesuccess(biztrip_reportDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(biztrip_reportDto.getDoc_code(), employeesDto.getEmployee_id());
		biztrip_reportDto.setDoc_seq(seq);
		request.setAttribute("biztrip_report", biztrip_reportDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_biztrip_reportview.jsp";
		} else 
			return "/pages/user_approval/view/approval_biztrip_reportview.jsp";
	}

}
