package com.cube.user.businessreport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;

public class WorkreportReplyDeleteAction implements Action {

	private static WorkreportReplyDeleteAction workreportReplyDeleteAction;
	
	static {
		workreportReplyDeleteAction = new WorkreportReplyDeleteAction();
	}
	
	private WorkreportReplyDeleteAction(){}
	
	public static WorkreportReplyDeleteAction getWorkreportReplyDeleteAction() {
		return workreportReplyDeleteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		String seq = request.getParameter("seq");
		CommonServiceImpl.getCommonServiceImpl().memoDelete(mseq);
		String list = CommonServiceImpl.getCommonServiceImpl().memoList(seq);
		return list;
	}

}
