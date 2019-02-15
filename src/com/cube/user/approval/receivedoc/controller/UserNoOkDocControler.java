package com.cube.user.approval.receivedoc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.GroupwareConstance;
import com.cube.util.MovePage;

@WebServlet("/usernook")
public class UserNoOkDocControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		String confirmchecknum="";
		if("approval_nook".equals(act)){
			path = CubeActionFactory.getNoDocListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("approvalok".equals(act)){
			confirmchecknum = CubeActionFactory.getNoDocSelectAction().action(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(confirmchecknum);
		} else if("approval_okok".equals(act)){
			path = CubeActionFactory.getOkDocListAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("approvalcancel".equals(act)){
			confirmchecknum = CubeActionFactory.getNoDocCancelAction().action(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(confirmchecknum);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
