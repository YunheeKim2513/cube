package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.NoticeDto;

public class HomeNoticeCompliteAction implements Action{

	private static HomeNoticeCompliteAction homeNoticeCompliteAction;

	static{
		homeNoticeCompliteAction = new HomeNoticeCompliteAction();
	}

	private HomeNoticeCompliteAction(){}

		public static HomeNoticeCompliteAction getHomeNoticeCompliteAction() {
		return homeNoticeCompliteAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		HomeAdminServiceImpl.getHomeAdminService().noticeComplite(seq);
		NoticeDto noticeDto = new NoticeDto();
		noticeDto = HomeAdminServiceImpl.getHomeAdminService().noticeview(seq);
		request.setAttribute("noticeDto", noticeDto);
		return "/pages/helpdesk/helpdesk_view.jsp";
	}

}
