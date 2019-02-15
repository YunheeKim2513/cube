package com.cube.user.schedule.scheduleprivate.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class PrivateModifyAction implements Action{
	private static PrivateModifyAction privateModifyAction;
	static{
		privateModifyAction=new PrivateModifyAction();
	}
	
	public static PrivateModifyAction getPrivateModifyAction() {
		return privateModifyAction;
	}
	private PrivateModifyAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

}
