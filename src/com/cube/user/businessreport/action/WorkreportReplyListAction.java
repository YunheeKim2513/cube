package com.cube.user.businessreport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;

public class WorkreportReplyListAction implements Action {

	private static WorkreportReplyListAction workreportReplyListAction;
	
	static {
		workreportReplyListAction = new WorkreportReplyListAction();
	}
	
	private WorkreportReplyListAction(){}
	
	public static WorkreportReplyListAction getWorkreportReplyListAction() {
		return workreportReplyListAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String list = CommonServiceImpl.getCommonServiceImpl().memoList(seq); 
		return list;
	}

}
