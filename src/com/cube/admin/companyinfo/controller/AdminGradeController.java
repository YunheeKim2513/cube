package com.cube.admin.companyinfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.MovePage;

@WebServlet("/grade")
public class AdminGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("AdminGradeController");
		String root = request.getContextPath();
		String act = request.getParameter("act");
		//System.out.println("act : "+act);
		String path="/index.jsp";
		if("write".equals(act)){
			//System.out.println("service write");
			path=CubeActionFactory.getGradeWriteAction().action(request, response);
			//System.out.println("path : "+path);
			MovePage.redirect(root+path, response);
		} else if("delete".equals(act)){
			//System.out.println("service delete");
			path=CubeActionFactory.getGradeDeleteAction().action(request, response);
			//System.out.println("path : "+path);
			MovePage.redirect(root+path, response);
		} else if("list".equals(act)){
			//System.out.println("service list");
			path=CubeActionFactory.getGradeListAction().action(request, response);
			//System.out.println("path : "+path);
			MovePage.forward(path, request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
