package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.NoticeDto;

public class HomeNoticemvUpdateAction implements Action{

	private static HomeNoticemvUpdateAction homeNoticemvUpdateAction;
	
	static {
		homeNoticemvUpdateAction = new HomeNoticemvUpdateAction();
	}
	
	private HomeNoticemvUpdateAction(){}
	
	public static HomeNoticemvUpdateAction getHomeNoticemvUpdateAction() {
		return homeNoticemvUpdateAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		NoticeDto noticeupdate = new NoticeDto();
		noticeupdate = HomeAdminServiceImpl.getHomeAdminService().noticeview(seq);
		request.setAttribute("noticeupdate",noticeupdate);
		return "/pages/helpdesk/helpdesk_updatepage.jsp";
	}

}
