package com.cube.user.approval.senddoc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;

@WebServlet("/usersavedoc")
public class UserSaveDocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "";
		if("approval_usersavedoc".equals(act)){
			path = CubeActionFactory.getSaveDocListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("usersavedoc_delete".equals(act)){
			path = CubeActionFactory.getSaveDocDeleteAction().action(request, response);
			MovePage.redirect(root+path, response);
		} else if("usersavedoc_update".equals(act)){
			path = CubeActionFactory.getSaveDocUpdateAction().action(request, response);
			MovePage.redirect(root+path, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
