package com.cube.user.schedule.allsearch.action;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.schedule.model.service.ScheduleSearchUserServiceImpl;

public class AllSearchUpdateAction implements Action{
	private static AllSearchUpdateAction allSearchUpdateAction;
	static {
		allSearchUpdateAction=new AllSearchUpdateAction();
	}
	
	public static AllSearchUpdateAction getAllSearchUpdateAction() {
		return allSearchUpdateAction;
	}
	private AllSearchUpdateAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("AllSearchUpdateAction");
		int seq=Integer.parseInt(request.getParameter("seq"));
		String subject=URLDecoder.decode(request.getParameter("subject"),"UTF-8");
		String content=URLDecoder.decode(request.getParameter("content"),"UTF-8");
		String kind=URLDecoder.decode(request.getParameter("kind"),"UTF-8");
		String start=request.getParameter("startdate");
		String end=request.getParameter("enddate");
		ScheduleSearchUserServiceImpl.getScheduleSearchUserService().update(seq,subject,content,kind,start,end);
		String update=ScheduleSearchUserServiceImpl.getScheduleSearchUserService().list();
		//System.out.println(kind);
		//System.out.println(start);
		//System.out.println(end);
		//System.out.println(subject);
		//System.out.println(content);
		return update;
	}

}
