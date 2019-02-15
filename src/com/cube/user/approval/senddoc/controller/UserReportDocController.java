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

@WebServlet("/userreportdoc")
public class UserReportDocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		String menu = "";
		String docview = request.getParameter("docview");
		if("reportviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "report";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} else if("allviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "all";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} else if("tempviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "temp";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} else if("approvalviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "approval";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} else if("returnviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "return";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} else if("okreturnviewarticle".equals(act)){
			path = CubeActionFactory.getReportDocSelectAction().action(request, response);
			menu = "okreturn";
			MovePage.forward(path+menu+"&docview="+docview, request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
