package com.cube.user.schedule.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.MovePage;

@WebServlet("/schedule_vacation")
public class UserVacationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root=request.getContextPath();
		String act=request.getParameter("act");
		String path="index.jsp";
		String message="";
		if("list".equals(act)){
			//System.out.println("service list");
			path=CubeActionFactory.getVacationListAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if("xml".equals(act)){
			path=CubeActionFactory.getVacationXmlAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("".equals(act)){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
