package com.cube.user.schedule.allsearch.action;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.schedule.model.service.ScheduleSearchUserServiceImpl;

public class AllSearchDeleteAction implements Action{
	private static AllSearchDeleteAction allSearchDeleteAction;
	static {
		allSearchDeleteAction=new AllSearchDeleteAction();
	}
	
	public static AllSearchDeleteAction getAllSearchDeleteAction() {
		return allSearchDeleteAction;
	}
	private AllSearchDeleteAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("AllSearchDeleteAction");
		int seq=Integer.parseInt(request.getParameter("seq"));
		ScheduleSearchUserServiceImpl.getScheduleSearchUserService().delete(seq);
		String delete=ScheduleSearchUserServiceImpl.getScheduleSearchUserService().list();
		//System.out.println(delete);
		return delete;
	}
}
