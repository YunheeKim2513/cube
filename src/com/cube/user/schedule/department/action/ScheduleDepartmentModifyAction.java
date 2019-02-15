package com.cube.user.schedule.department.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;

public class ScheduleDepartmentModifyAction implements Action{
	private static ScheduleDepartmentModifyAction scheduleDepartmentModifyAction;
	static{
		scheduleDepartmentModifyAction=new ScheduleDepartmentModifyAction();
	}
	
	public static ScheduleDepartmentModifyAction getScheduleDepartmentModifyAction() {
		return scheduleDepartmentModifyAction;
	}
	private ScheduleDepartmentModifyAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
