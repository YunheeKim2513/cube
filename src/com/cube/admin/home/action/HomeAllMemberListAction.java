package com.cube.admin.home.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class HomeAllMemberListAction implements Action{

	
	private static HomeAllMemberListAction homeAllMemberListAction;

	static{
		homeAllMemberListAction = new HomeAllMemberListAction();
	}

	private HomeAllMemberListAction(){}

		public static HomeAllMemberListAction getHomeAllMemberListAction() {
		return homeAllMemberListAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		return null;
	}

}
