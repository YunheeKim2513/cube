package com.cube.user.approval.main.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;

/**
 * Servlet implementation class GroupwareUserController
 */
@WebServlet("/userapprovalmain")
public class UserApprovalMainCtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		//response.setContentType("text/plain;charset=utf-8");
		//PrintWriter out = response.getWriter();
		//String message="";
		String path = "";
		if("approval_main".equals(act)){
			path = CubeActionFactory.getApprovalMainAction().action(request, response);
			MovePage.redirect(root+path, response);
		} else if("approval_business".equals(act)){
			path = CubeActionFactory.getApprovalBusinessAction().action(request, response);
			MovePage.forward(path, request, response);
		}  else if("approval_department".equals(act)){
			path = CubeActionFactory.getApprovalDepartmentAction().action(request, response);
			MovePage.forward(path, request, response);
		} 
		//else if("businesslist".equals(act)){
			//message = CubeActionFactory.getApprovalBusinessAction().action(request, response);
			//out.println(message);
		//}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}
}
