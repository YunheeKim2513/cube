package com.cube.user.schedule.allsearch.action;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.user.schedule.model.service.ScheduleSearchUserServiceImpl;
import com.cube.util.Encoder;

public class AllSearchAction implements Action{
	private static AllSearchAction allSearchAction;
	static {
		allSearchAction=new AllSearchAction();
	}
	
	public static AllSearchAction getAllSearchAction() {
		return allSearchAction;
	}
	private AllSearchAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("AllSearchAction");
		String kind=URLDecoder.decode(request.getParameter("kind"),"UTF-8");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String s[]=start.split("-");
		String e[]=end.split("-");
		if(Integer.parseInt(s[1])<10){
			s[1]="0"+s[1];
		}
		if(Integer.parseInt(s[2])<10){
			s[2]="0"+s[2];
		}
		if(Integer.parseInt(e[1])<10){
			e[1]="0"+e[1];
		}
		if(Integer.parseInt(e[2])<10){
			e[2]="0"+e[2];
		}
		start=s[0]+"-"+s[1]+"-"+s[2];
		end=e[0]+"-"+e[1]+"-"+e[2];
		//System.out.println("kind : "+kind);
		//System.out.println("start : "+start);
		//System.out.println("end : "+end);
		String search=ScheduleSearchUserServiceImpl.getScheduleSearchUserService().search(kind,start,end);
		//System.out.println(search);
		return search;
	}

}
