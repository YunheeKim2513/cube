package com.cube.user.approval.docwrite.vacdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.VacdocDto;
import com.cube.user.approval.docwrite.model.service.VacDocUserServiceImpl;

public class VacDocWriteAction implements Action {

	private static VacDocWriteAction vacDocWriteAction;
	
	static {
		vacDocWriteAction = new VacDocWriteAction(); 
	}
	
	private VacDocWriteAction(){}
	
	
	
	public static VacDocWriteAction getVacDocWriteAction() {
		return vacDocWriteAction;
	}



	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VacdocDto vacdocDto = new VacdocDto();
		vacdocDto.setDoc_code("V03");
		vacdocDto.setDoc_name("휴가계");
		vacdocDto.setConfirmlist1(request.getParameter("vacconfirm0"));
		vacdocDto.setConfirmlist2(request.getParameter("vacconfirm1"));
		vacdocDto.setConfirmlist3(request.getParameter("vacconfirm2"));
		vacdocDto.setConfirmlistname1(request.getParameter("vacconfirms0"));
		vacdocDto.setConfirmlistname2(request.getParameter("vacconfirms1"));
		vacdocDto.setConfirmlistname3(request.getParameter("vacconfirms2"));
		vacdocDto.setDoc_date(request.getParameter("daytext"));
		vacdocDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		vacdocDto.setDoc_reference(request.getParameter("referenceinputbox"));
		vacdocDto.setDoc_file(request.getParameter("vacfilename"));
		vacdocDto.setDoc_subject(request.getParameter("vacsubject"));
		vacdocDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		vacdocDto.setDoc_dep(employeesDto.getDepartment_name());
		vacdocDto.setEmployee_id(employeesDto.getEmployee_id());
		vacdocDto.setDoc_writer((employeesDto.getGarde_name()+" "+employeesDto.getName()));
		vacdocDto.setVacdoc_start(request.getParameter("vacstart"));
		vacdocDto.setVacdoc_end(request.getParameter("vacend"));
		vacdocDto.setVacdoc_kind(request.getParameter("vackind"));
		vacdocDto.setVacdoc_content(request.getParameter("content"));
		vacdocDto.setVacdoc_route(request.getParameter("route"));
		String act = request.getParameter("act");
		if("vacupdate".equals(act)){
			vacdocDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = VacDocUserServiceImpl.getVacDocUserService().updatesuccess(vacdocDto);
		} else {
			int cnt = VacDocUserServiceImpl.getVacDocUserService().writesuccess(vacdocDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(vacdocDto.getDoc_code(), employeesDto.getEmployee_id());
		vacdocDto.setDoc_seq(seq);
		request.setAttribute("vacdocwrite", vacdocDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_vacdocview.jsp";
		} else 
			return "/pages/user_approval/view/approval_vacdocview.jsp";
	}

}
