package com.cube.user.schedule.all.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class AllDeleteAction implements Action{
	private static AllDeleteAction allDeleteAction;
	static {
		allDeleteAction=new AllDeleteAction();
	}
	public static AllDeleteAction getAllDeleteAction() {
		return allDeleteAction;
	}
	private AllDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
