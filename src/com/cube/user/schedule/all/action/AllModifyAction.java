package com.cube.user.schedule.all.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class AllModifyAction implements Action{
	private static AllModifyAction allModifyAction;
	static {
		allModifyAction=new AllModifyAction();
	}
	public static AllModifyAction getAllModifyAction() {
		return allModifyAction;
	}
	private AllModifyAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
