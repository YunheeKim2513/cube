package com.cube.admin.home.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.admin.home.model.dao.HomeAdminDaoImpl;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.NoticeDto;
import com.cube.util.Encoder;

public class HomeNoticeWriteAction implements Action{

	private static HomeNoticeWriteAction homeNoticeWriteAction;
	
	static{
		homeNoticeWriteAction = new HomeNoticeWriteAction();
	}
	
	private HomeNoticeWriteAction(){}
	
	public static HomeNoticeWriteAction getHomeNoticeWriteAction() {
		return homeNoticeWriteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String user = act.substring(0, 3);
		NoticeDto noticeDto = new NoticeDto();
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String employee_id = employeesDto.getEmployee_id();
		if("helpregistor".equals(act)||"userhelpregistor".equals(act)){
			noticeDto.setEmployee_id(employee_id);
			noticeDto.setNotic_writer(employeesDto.getGarde_name()+" "+employeesDto.getName());
			noticeDto.setEmployee_dep(employeesDto.getDepartment_name());
			noticeDto.setNotice_subject(Encoder.isoToEuc(request.getParameter("helpsubject")));
			noticeDto.setNotice_content(Encoder.isoToEuc(request.getParameter("ir1")));
			noticeDto.setNotice_date(request.getParameter("daytext"));
			noticeDto.setNotice_state("작성완료");
			noticeDto.setNotice_complite(" ");
			HomeAdminDaoImpl.getHomeAdminDao().noticwriter(noticeDto);
			int seq = HomeAdminServiceImpl.getHomeAdminService().noticeseq(employee_id);
			noticeDto.setNotice_seq(seq);
			request.setAttribute("noticeDto", noticeDto);
		} else if("helpupdate".equals(act)||"userhelpupdate".equals(act)){
			int seq = Integer.parseInt(request.getParameter("seq"));
			noticeDto.setNotice_subject(Encoder.isoToEuc(request.getParameter("helpsubject")));
			noticeDto.setNotice_content(Encoder.isoToEuc(request.getParameter("ir1")));
			noticeDto.setNotice_seq(seq);
			HomeAdminServiceImpl.getHomeAdminService().noticeUpdate(noticeDto);
			noticeDto = HomeAdminServiceImpl.getHomeAdminService().noticeview(seq);
			request.setAttribute("noticeDto", noticeDto);
		}
		if("user".equals(user)){
			return "/pages/helpdesk_home/helpdesk_view.jsp";
		} else 
			return "/pages/helpdesk/helpdesk_view.jsp";
	}

}
