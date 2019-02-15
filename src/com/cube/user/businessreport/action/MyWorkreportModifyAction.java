package com.cube.user.businessreport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.Work_reportDto;
import com.cube.user.businessreport.model.service.MyWorkreportUserServiceImpl;
import com.cube.util.Encoder;

public class MyWorkreportModifyAction implements Action {

	private static MyWorkreportModifyAction myWorkreportWriteAction;
	
	static {
		myWorkreportWriteAction = new MyWorkreportModifyAction();
	}
	
	private MyWorkreportModifyAction(){}
	
	public static MyWorkreportModifyAction getMyWorkreportWriteAction() {
		return myWorkreportWriteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Work_reportDto work_reportDto = new Work_reportDto();
		work_reportDto.setDoc_code("W07");
		work_reportDto.setDoc_name("업무보고");
		work_reportDto.setDoc_state("작성완료");
		work_reportDto.setWorkdoc_kind(Encoder.isoToEuc(request.getParameter("workreportkind")));
		work_reportDto.setDoc_date(request.getParameter("daytext"));
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		work_reportDto.setDoc_writer(employeesDto.getGarde_name()+" "+employeesDto.getName());
		work_reportDto.setDoc_dep(employeesDto.getDepartment_name());
		work_reportDto.setConfirmlist(request.getParameter("eids")); //보고 받는 자
		work_reportDto.setWorkdoc_open(Encoder.isoToEuc(request.getParameter("workviewkind")));
		work_reportDto.setDoc_subject(Encoder.isoToEuc(request.getParameter("worksubject")));
		work_reportDto.setWorkdoc_daycontent(Encoder.isoToEuc(request.getParameter("daycontent")));
		work_reportDto.setWorkdoc_nextcontent(Encoder.isoToEuc(request.getParameter("nextcontent")));
		work_reportDto.setDoc_file(Encoder.isoToEuc(request.getParameter("workfilename")));
		work_reportDto.setEmployee_id(employeesDto.getEmployee_id());
		MyWorkreportUserServiceImpl.getMyWorkreportUserService().workinsert(work_reportDto);
		String seq = CommonServiceImpl.getCommonServiceImpl().seq(work_reportDto.getDoc_code(), employeesDto.getEmployee_id());
		work_reportDto.setDoc_seq(seq);
		String worktime=MyWorkreportUserServiceImpl.getMyWorkreportUserService().worktime(seq);
		String worktimes[] = worktime.split("@");
		work_reportDto.setDoc_writetime(worktimes[0]);
		work_reportDto.setWorkdoc_finaltime(worktimes[1]);
		request.setAttribute("work_reportDto", work_reportDto);
		return "/pages/user_workreport/workreport_usermyworkreportview.jsp";
	}
}
