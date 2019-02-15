package com.cube.user.schedule.department.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class ScheduleDepartmentViewAction implements Action{
	private static ScheduleDepartmentViewAction scheduleDepartmentViewAction;
	static{
		scheduleDepartmentViewAction=new ScheduleDepartmentViewAction();
	}
	
	public static ScheduleDepartmentViewAction getScheduleDepartmentViewAction() {
		return scheduleDepartmentViewAction;
	}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
