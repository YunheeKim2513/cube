package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.MemoDto;

public class HelpDeskReplyModifyAction implements Action {

	private static HelpDeskReplyModifyAction helpDeskReplyModifyAction;
	
	static {
		helpDeskReplyModifyAction = new HelpDeskReplyModifyAction();
	}
	
	private HelpDeskReplyModifyAction(){}
	
	public static HelpDeskReplyModifyAction getHelpDeskReplyModifyAction() {
		return helpDeskReplyModifyAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		MemoDto memoDto = new MemoDto();
		memoDto.setNotice_seq(seq);
		memoDto.setMemo_seq(mseq);
		memoDto.setMemo_content(request.getParameter("mcontent"));
		HomeAdminServiceImpl.getHomeAdminService().memoModify(memoDto);
		String list = HomeAdminServiceImpl.getHomeAdminService().memoList(seq);
		return list;
	}

}
