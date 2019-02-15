package com.cube.user.schedule.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.MovePage;

@WebServlet("/schedule_private")
public class UserPrivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("UserPrivateController");
		String root=request.getContextPath();
		String act=request.getParameter("act");
		//System.out.println("act : "+act);
		String path="index.jsp";
		String message="";
		if("list".equals(act)){
			//System.out.println("service list");
			path=CubeActionFactory.getPrivateListAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if("write".equals(act)){
			//System.out.println("service write");
			path=CubeActionFactory.getPrivateWriteAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.redirect(path, response);
		} else if("modify".equals(act)){
			
		} else if("delete".equals(act)){
			
		} else if("xml".equals(act)){
			//System.out.println("service xml");
			path=CubeActionFactory.getPrivateXmlAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if("".equals(act)){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost");
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
