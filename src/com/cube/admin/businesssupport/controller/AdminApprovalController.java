package com.cube.admin.businesssupport.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.*;

@WebServlet("/adminapproval")
public class AdminApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String docview = request.getParameter("docview");
		String path = "";
		String result = "";
		if("admin_confirmlist".equals(act)){
			path=CubeActionFactory.getApprovalInsertAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("admin_confirmlists".equals(act)){
			result=CubeActionFactory.getApprovalUpdateAction().action(request, response);
			response.setContentType("text/plain; charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println(result);
		} else if("admin_confirmlistdelete".equals(act)){
			result=CubeActionFactory.getApprovalUpdateAction().action(request, response);
			response.setContentType("text/plain; charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println(result);
		} else if("confirm_docmanage".equals(act)){
			path=CubeActionFactory.getConfirmDocListManageAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("viewarticle".equals(act)){
			path = CubeActionFactory.getConfirmDocSelectAction().action(request, response);
			MovePage.forward(path+docview, request, response);
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
