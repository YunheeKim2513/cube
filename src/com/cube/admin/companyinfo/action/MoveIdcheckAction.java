package com.cube.admin.companyinfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class MoveIdcheckAction implements Action {
	private static MoveIdcheckAction moveIdcheckAction;
	static {
		moveIdcheckAction = new MoveIdcheckAction();
	}
	
	public static MoveIdcheckAction getMoveIdcheckAction() {
		return moveIdcheckAction;
	}
	private MoveIdcheckAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/pages/admin_companyinfo/idcheck.jsp";
	}

}
