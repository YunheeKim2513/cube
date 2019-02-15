package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class MoveZipcheckAction implements Action {
	private static MoveZipcheckAction moveZipcheckAction;
	static {
		moveZipcheckAction = new MoveZipcheckAction();
	}
	
	public static MoveZipcheckAction getMoveZipcheckAction() {
		return moveZipcheckAction;
	}
	private MoveZipcheckAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/pages/admin_companyinfo/zipsearch.jsp";
	}

}
