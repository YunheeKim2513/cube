package com.cube.user.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;

@WebServlet("/schedule_search")
public class UserScheduleSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet");
		//System.out.println("UserScheduleSearchController");
		String root = request.getContextPath();
		String act = request.getParameter("act");
		//System.out.println("act : " + act);
		String path = "/index.jsp";
		String message="";
		if ("list".equals(act)) {
			//System.out.println("service list");
			message=CubeActionFactory.getAllSearchListAction().action(request, response);
		} else if ("search".equals(act)) {
			//System.out.println("service search");
			message = CubeActionFactory.getAllSearchAction().action(request, response);
		} else if ("update".equals(act)) {
			//System.out.println("service update");
			message = CubeActionFactory.getAllSearchUpdateAction().action(request, response);
		} else if ("delete".equals(act)) {
			//System.out.println("service delete");
			message = CubeActionFactory.getAllSearchDeleteAction().action(request, response);
		} else if ("view".equals(act)) {
			//System.out.println("service view");
			message = CubeActionFactory.getAllSearchViewAction().action(request, response);
		}
		response.setContentType("text/plain;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.println(message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost");
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
