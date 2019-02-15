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

@WebServlet("/userwithdrawdoc")
public class UserWithDrawDocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		if("approval_userwithdrawdoc".equals(act)){
			path = CubeActionFactory.getWithDrawDocListAction().action(request, response);
			MovePage.forward(path, request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
