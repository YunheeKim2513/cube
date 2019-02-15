package com.cube.admin.home.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.NoticeDto;

public class HomeNoticeListAction implements Action{

	private static HomeNoticeListAction homeNoticeListAction;
	
	static {
		homeNoticeListAction = new HomeNoticeListAction();
	}
	
	private HomeNoticeListAction(){}
	
	public static HomeNoticeListAction getHomeNoticeListAction() {
		return homeNoticeListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		List<NoticeDto> noticelist = new ArrayList<NoticeDto>();
		noticelist = HomeAdminServiceImpl.getHomeAdminService().noList();
		request.setAttribute("noticelist", noticelist);
		if("helpdesk_list".equals(act)){
			return "/pages/helpdesk/helpdesk_list.jsp";
		} else 
			return "/pages/helpdesk_home/helpdesk_list.jsp";
	}
}
