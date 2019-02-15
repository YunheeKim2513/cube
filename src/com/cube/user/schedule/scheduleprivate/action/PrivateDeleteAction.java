package com.cube.user.schedule.scheduleprivate.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class PrivateDeleteAction implements Action{
	private static PrivateDeleteAction privateDeleteAction;
	static{
		privateDeleteAction=new PrivateDeleteAction();
	}
	
	public static PrivateDeleteAction getPrivateDeleteAction() {
		return privateDeleteAction;
	}
	private PrivateDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "";
	}

}
