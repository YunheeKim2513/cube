package com.cube.user.schedule.allsearch.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.action.Action;
import com.cube.model.dto.ScheduleDto;
import com.cube.user.schedule.model.dao.ScheduleSearchUserDaoImpl;
import com.cube.user.schedule.model.service.ScheduleSearchUserServiceImpl;

public class AllSearchListAction implements Action{
	private static AllSearchListAction allSearchListAction;
	static {
		allSearchListAction=new AllSearchListAction();
	}
	
	public static AllSearchListAction getAllSearchListAction() {
		return allSearchListAction;
	}
	private AllSearchListAction(){}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("AllSearchListAction");
		String list=ScheduleSearchUserServiceImpl.getScheduleSearchUserService().list();
		return list;
	}

}
