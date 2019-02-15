package com.cube.user.approval.senddoc.savedoc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.approval.senddoc.model.service.SaveDocUserServiceImpl;

public class SaveDocDeleteAction implements Action {
	
	private static SaveDocDeleteAction saveDocDeleteAction;
	
	static {
		saveDocDeleteAction = new SaveDocDeleteAction();
	}
	
	private SaveDocDeleteAction(){}
	
	public static SaveDocDeleteAction getSaveDocDeleteAction() {
		return saveDocDeleteAction;
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String dockind = request.getParameter("dockind");
		SaveDocUserServiceImpl.getSaveDocUserService().savedocdelete(seq, dockind);
		return "/usersavedoc?act=approval_usersavedoc";
	}

}
