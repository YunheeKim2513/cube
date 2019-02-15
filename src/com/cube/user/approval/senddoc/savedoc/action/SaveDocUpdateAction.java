package com.cube.user.approval.senddoc.savedoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.approval.senddoc.model.service.SaveDocUserServiceImpl;

public class SaveDocUpdateAction implements Action {
	
	private static SaveDocUpdateAction saveDocUpdateAction;
	
	static {
		saveDocUpdateAction = new SaveDocUpdateAction();
	}
	
	private SaveDocUpdateAction(){}
	
	public static SaveDocUpdateAction getSaveDocUpdateAction() {
		return saveDocUpdateAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		SaveDocUserServiceImpl.getSaveDocUserService().savedocupdate(seq);
		return "/usersenddoc?act=approval_userreport";
	}

}
