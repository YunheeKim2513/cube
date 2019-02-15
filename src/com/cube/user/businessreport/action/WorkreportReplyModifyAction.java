package com.cube.user.businessreport.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.common.model.service.CommonServiceImpl;
import com.cube.model.dto.Work_report_replyDto;

public class WorkreportReplyModifyAction implements Action {

	private static WorkreportReplyModifyAction workreportReplyModifyAction;
	
	static {
		workreportReplyModifyAction = new WorkreportReplyModifyAction();
	}
	
	private WorkreportReplyModifyAction(){}
	
	public static WorkreportReplyModifyAction getWorkreportReplyModifyAction() {
		return workreportReplyModifyAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		String seq = request.getParameter("seq");
		Work_report_replyDto work_report_replyDto = new Work_report_replyDto();
		work_report_replyDto.setDoc_seq(seq);
		work_report_replyDto.setWmseq(mseq);
		work_report_replyDto.setContent(request.getParameter("mcontent"));
		CommonServiceImpl.getCommonServiceImpl().memoModify(work_report_replyDto);
		String list = CommonServiceImpl.getCommonServiceImpl().memoList(seq);
		return list;
	}

}
