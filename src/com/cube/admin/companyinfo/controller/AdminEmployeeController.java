package com.cube.admin.companyinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.util.MovePage;

@WebServlet("/emp")
public class AdminEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("doGet");
		//System.out.println("AdminEmployeeController");
		String root = request.getContextPath();
		String act = request.getParameter("act");
		//System.out.println("act : " + act);
		String path = "/index.jsp";
		if ("mvwrite".equals(act)) {
			//System.out.println("service mvwrite");
			path = CubeActionFactory.getEmployeeMoveWriteAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("write".equals(act)) {
			//System.out.println("service write");
			path = CubeActionFactory.getEmployeeWriteAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.redirect(root + path, response);
		} else if ("list".equals(act)) {
			//System.out.println("service list");
			path = CubeActionFactory.getEmployeeListAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("mvupdate".equals(act)) {
			//System.out.println("service mvupdate");
			path = CubeActionFactory.getEmployeeMoveUpdateAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("update".equals(act)) {
			//System.out.println("service update");
			path = CubeActionFactory.getEmployeeUpdateAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("firelist".equals(act)) {
			//System.out.println("service firelist");
			path = CubeActionFactory.getEmployeeFireListAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("firedelete".equals(act)) {
			//System.out.println("service firedelete");
			path = CubeActionFactory.getEmployeeFireDeleteAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("mvfireupdate".equals(act)) {
			//System.out.println("service mvfireupdate");
			path = CubeActionFactory.getEmployeeMoveFireUpdateAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("fireupdate".equals(act)) {
			//System.out.println("service fireupdate");
			path = CubeActionFactory.getEmployeeFireUpdateAction().action(request, response);
			//System.out.println("path : " + path);
			MovePage.forward(path, request, response);
		} else if ("mvidck".equals(act)) {
			//System.out.println("service mvidck");
			path = CubeActionFactory.getMoveIdcheckAction().action(request, response);
			MovePage.redirect(root + path, response);
		} else if ("idcheck".equals(act)) {
			//System.out.println("service idcheck");
			path = CubeActionFactory.getIdcheckAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if ("mvzip".equals(act)) {
			System.out.println("service mvzip");
			path = CubeActionFactory.getMoveZipcheckAction().action(request, response);
			MovePage.redirect(root + path, response);
		} else if ("zipsearch".equals(act)) {
			//System.out.println("service zipsearch");
			path = CubeActionFactory.getZipcheckAction().action(request, response);
			MovePage.forward(path, request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("EUC-KR");
		
		doGet(request, response);
	}

}
