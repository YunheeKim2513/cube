package com.cube.admin.home.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.NoticeDto;

public class HomeNoticeViewAction implements Action{

	private static HomeNoticeViewAction homeNoticeViewAction;
	
	static {
		homeNoticeViewAction = new HomeNoticeViewAction();
	}
	
	private HomeNoticeViewAction(){}
	
	public static HomeNoticeViewAction getHomeNoticeViewAction() {
		return homeNoticeViewAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		int seq = Integer.parseInt(request.getParameter("seq"));
		NoticeDto noticeDto = new NoticeDto();
		noticeDto = HomeAdminServiceImpl.getHomeAdminService().noticeview(seq);
		request.setAttribute("noticeDto", noticeDto);
		if("noticeview".equals(act)){
			return "/pages/helpdesk/helpdesk_view.jsp";
		} else 
			return "/pages/helpdesk_home/helpdesk_view.jsp";
	}
}
