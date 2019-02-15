package com.cube.user.schedule.all.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class AllViewAction implements Action{
	private static AllViewAction allViewAction;
	static {
		allViewAction=new AllViewAction();
	}
	public static AllViewAction getAllViewAction() {
		return allViewAction;
	}
	private AllViewAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
