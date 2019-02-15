package com.cube.user.schedule.allsearch.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.schedule.model.service.ScheduleSearchUserServiceImpl;

public class AllSearchViewAction implements Action{
	private static AllSearchViewAction allSearchViewAction;
	static {
		allSearchViewAction=new AllSearchViewAction();
	}
	
	public static AllSearchViewAction getAllSearchViewAction() {
		return allSearchViewAction;
	}
	private AllSearchViewAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq=Integer.parseInt(request.getParameter("seq"));
		//System.out.println("seq : "+seq);
		String view=ScheduleSearchUserServiceImpl.getScheduleSearchUserService().view(seq);
		return view;
	}

}
