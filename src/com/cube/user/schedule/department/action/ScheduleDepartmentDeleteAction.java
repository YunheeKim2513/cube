package com.cube.user.schedule.department.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class ScheduleDepartmentDeleteAction implements Action{
	private static ScheduleDepartmentDeleteAction scheduleDepartmentDeleteAction;
	static{
		scheduleDepartmentDeleteAction=new ScheduleDepartmentDeleteAction();
	}
	
	public static ScheduleDepartmentDeleteAction getScheduleDepartmentDeleteAction() {
		return scheduleDepartmentDeleteAction;
	}
	private ScheduleDepartmentDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
