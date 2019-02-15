package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;

public class HelpDeskReplyListAction implements Action {

	private static HelpDeskReplyListAction helpDeskReplyListAction;
	
	static {
		helpDeskReplyListAction = new HelpDeskReplyListAction();
	}
	
	private HelpDeskReplyListAction(){}
	
	public static HelpDeskReplyListAction getHelpDeskReplyListAction() {
		return helpDeskReplyListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String list = HomeAdminServiceImpl.getHomeAdminService().memoList(seq); 
		return list;
	}

}
