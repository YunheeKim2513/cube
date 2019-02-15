package com.cube.user.businessreport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;

@WebServlet("/usermyworkreport")
public class UserMyWorkreportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		if("myworkreport".equals(act)){
			path=CubeActionFactory.getMyWorkreportWritePaperAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("userworkwirte".equals(act)){
			path=CubeActionFactory.getMyWorkreportWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("usermyworkcheck".equals(act)){
			path=CubeActionFactory.getMyWorkreportCheckListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("receiveworkcheck".equals(act)){
			path=CubeActionFactory.getMyWorkreportCheckListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("workreportupdate".equals(act)){
			path=CubeActionFactory.getMyWorkreportWritePaperAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("userworkupdate".equals(act)){
			path=CubeActionFactory.getMyWorkreportWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
