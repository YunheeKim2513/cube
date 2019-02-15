package com.cube.admin.home.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.GroupwareConstance;

@WebServlet("/helpdeskreply")
public class HelpDeskReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String message = "";
		if("write".equals(act)){
			message = CubeActionFactory.getHelpDeskReplyWriteAction().action(request, response);
		} else if("list".equals(act)){
			message = CubeActionFactory.getHelpDeskReplyListAction().action(request, response);
		} else if("delete".equals(act)){
			message = CubeActionFactory.getHelpDeskReplyDeleteAction().action(request, response);
		} else if("modify".equals(act)){
			message = CubeActionFactory.getHelpDeskReplyModifyAction().action(request, response);
		}
		out.println(message);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
