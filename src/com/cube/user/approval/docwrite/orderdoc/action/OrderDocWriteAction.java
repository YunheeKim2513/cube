package com.cube.user.approval.docwrite.orderdoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.OrderdocDto;
import com.cube.model.dto.SigndocDto;
import com.cube.user.approval.docwrite.model.service.OrderDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.SignDocUserServiceImpl;
import com.cube.user.approval.docwrite.model.service.VacDocUserServiceImpl;

public class OrderDocWriteAction implements Action {

private static OrderDocWriteAction orderDocWriteAction;
	
	static {
		orderDocWriteAction = new OrderDocWriteAction();
	}
	
	private OrderDocWriteAction() {}
	
	
	
	public static OrderDocWriteAction getOrderDocWriteAction() {
		return orderDocWriteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderdocDto orderdocDto = new OrderdocDto();
		orderdocDto.setDoc_code("O02");
		orderdocDto.setDoc_name("품의서");
		orderdocDto.setConfirmlist1(request.getParameter("orderconfirm0"));
		orderdocDto.setConfirmlist2(request.getParameter("orderconfirm1"));
		orderdocDto.setConfirmlist3(request.getParameter("orderconfirm2"));
		orderdocDto.setConfirmlistname1(request.getParameter("orderconfirms0"));
		orderdocDto.setConfirmlistname2(request.getParameter("orderconfirms1"));
		orderdocDto.setConfirmlistname3(request.getParameter("orderconfirms2"));
		orderdocDto.setDoc_date(request.getParameter("daytext"));
		orderdocDto.setDoc_receiver(request.getParameter("receiveinputbox"));
		orderdocDto.setDoc_reference(request.getParameter("referenceinputbox"));
		orderdocDto.setDoc_file(request.getParameter("orderfilename"));
		orderdocDto.setDoc_subject(request.getParameter("ordersubject"));
		orderdocDto.setOrderdoc_content(request.getParameter("ir1"));
		orderdocDto.setDoc_state("결재 진행중");
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		orderdocDto.setDoc_dep(employeesDto.getDepartment_name());
		orderdocDto.setEmployee_id(employeesDto.getEmployee_id());
		orderdocDto.setDoc_writer((employeesDto.getGarde_name()+" "+employeesDto.getName()));
		String act = request.getParameter("act");
		if("orderupdate".equals(act)){
			orderdocDto.setDoc_seq(request.getParameter("docseq"));
			int cnt = OrderDocUserServiceImpl.getOrderDocUserService().updatesuccess(orderdocDto);
		} else {
			int cnt = OrderDocUserServiceImpl.getOrderDocUserService().writesuccess(orderdocDto);
		}
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(orderdocDto.getDoc_code(), employeesDto.getEmployee_id());
		orderdocDto.setDoc_seq(seq);
		request.setAttribute("orderdocwrite", orderdocDto);
		String admin = request.getParameter("admin");
		if("admin".equals(admin)){
			return "/pages/admin_confirm/view/approval_orderdocview.jsp";
		} else 
			return "/pages/user_approval/view/approval_orderdocview.jsp";
	}
}
