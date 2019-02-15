package com.cube.user.approval.senddoc.savedoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.Doc_info_detailDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.approval.senddoc.model.service.SaveDocUserServiceImpl;

public class SaveDocListAction implements Action {

	private static SaveDocListAction saveDocListAction;
	
	static {
		saveDocListAction = new SaveDocListAction();
	}
	
	private SaveDocListAction(){}
	
	
	
	public static SaveDocListAction getSaveDocListAction() {
		return saveDocListAction;
	}



	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		System.out.println(seq);
		if(seq!=null){
		SaveDocUserServiceImpl.getSaveDocUserService().savedoc(seq);
		}
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		List<Doc_info_detailDto> savedoclist = new ArrayList<Doc_info_detailDto>();
		savedoclist = SaveDocUserServiceImpl.getSaveDocUserService().savedoclist(employeesDto.getEmployee_id());
		request.setAttribute("savedoclist", savedoclist);
		return "/pages/user_approval/approval_usersavedoc.jsp";
	}

}
