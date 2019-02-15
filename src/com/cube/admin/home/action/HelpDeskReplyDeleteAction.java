package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.home.model.dao.HomeAdminDaoImpl;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;

public class HelpDeskReplyDeleteAction implements Action {

	private static HelpDeskReplyDeleteAction helpDeskReplyDeleteAction;
	
	static {
		helpDeskReplyDeleteAction = new HelpDeskReplyDeleteAction();
	}
	
	private HelpDeskReplyDeleteAction(){}
	
	public static HelpDeskReplyDeleteAction getHelpDeskReplyDeleteAction() {
		return helpDeskReplyDeleteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		HomeAdminDaoImpl.getHomeAdminDao().memoDelete(mseq);
		String list = HomeAdminServiceImpl.getHomeAdminService().memoList(seq);
		System.out.println(list);
		return list;
	}

}
