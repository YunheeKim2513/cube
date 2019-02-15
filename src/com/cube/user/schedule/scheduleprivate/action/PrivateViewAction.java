package com.cube.user.schedule.scheduleprivate.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class PrivateViewAction implements Action{
	private static PrivateViewAction privateViewAction;
	static{
		privateViewAction=new PrivateViewAction();
	}
	
	public static PrivateViewAction getPrivateViewAction() {
		return privateViewAction;
	}
	private PrivateViewAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

}
