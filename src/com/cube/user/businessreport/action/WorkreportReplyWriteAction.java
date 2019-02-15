package com.cube.user.businessreport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.Work_report_replyDto;

public class WorkreportReplyWriteAction implements Action {

	private static WorkreportReplyWriteAction workreportReplyWriteAction;
	
	static {
		workreportReplyWriteAction = new WorkreportReplyWriteAction();
	}
	
	private WorkreportReplyWriteAction(){}
	
	public static WorkreportReplyWriteAction getWorkreportReplyWriteAction() {
		return workreportReplyWriteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		Work_report_replyDto work_report_replyDto = new Work_report_replyDto();
		String seq = request.getParameter("seq");
		work_report_replyDto.setDoc_seq(seq);
		if(!request.getParameter("mcontent").isEmpty()){
			work_report_replyDto.setContent(request.getParameter("mcontent"));
			work_report_replyDto.setMwriter("["+employeesDto.getDepartment_name()+"]\n"+employeesDto.getGarde_name()+"\n"+employeesDto.getName());
			work_report_replyDto.setMid(employeesDto.getEmployee_id());
			CommonServiceImpl.getCommonServiceImpl().memowrite(work_report_replyDto);
		}
		String json = CommonServiceImpl.getCommonServiceImpl().memoList(seq);
		return json;
	}
}
