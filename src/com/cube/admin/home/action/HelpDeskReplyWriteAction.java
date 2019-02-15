package com.cube.admin.home.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cube.action.Action;
import com.cube.admin.home.model.service.HomeAdminServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.MemoDto;

public class HelpDeskReplyWriteAction implements Action {

	private static HelpDeskReplyWriteAction helpDeskReplyWriteAction;
	
	static {
		helpDeskReplyWriteAction = new HelpDeskReplyWriteAction();
	}
	
	private HelpDeskReplyWriteAction(){}
	
	public static HelpDeskReplyWriteAction getHelpDeskReplyWriteAction() {
		return helpDeskReplyWriteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		MemoDto memoDto = new MemoDto();
		int seq = Integer.parseInt(request.getParameter("seq"));
		memoDto.setNotice_seq(seq);
		if(!request.getParameter("mcontent").isEmpty()){
			memoDto.setMemo_content(request.getParameter("mcontent"));
			memoDto.setMemo_writer("["+employeesDto.getDepartment_name()+"]\n"+employeesDto.getGarde_name()+"\n"+employeesDto.getName());
			memoDto.setEmployee_id(employeesDto.getEmployee_id());
			HomeAdminServiceImpl.getHomeAdminService().memoWrite(memoDto);
		}
		String json = HomeAdminServiceImpl.getHomeAdminService().memoList(seq);
		return json;
	}
}
