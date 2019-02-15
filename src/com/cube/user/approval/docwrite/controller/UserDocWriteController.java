package com.cube.user.approval.docwrite.controller;

import java.io.IOException;
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
@WebServlet("/userdocwrite")
public class UserDocWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "";
		if("approval_signdocwrite".equals(act)||"approval_orderdocwrite".equals(act)){
			path = CubeActionFactory.getSignDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("docconfirmnum".equals(act)){
			path = CubeActionFactory.getSignDocWriteConfirmlistAction().action(request, response);
			MovePage.redirect(root+path, response);
		} else if("signregistor".equals(act)){
			path = CubeActionFactory.getSignDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("orderregistor".equals(act)){
			path = CubeActionFactory.getOrderDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("approval_vacdoc".equals(act)){
			path = CubeActionFactory.getVacDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("vacregistor".equals(act)){
			path = CubeActionFactory.getVacDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("approval_biztripdoc".equals(act) ||"approval_biztrip_report".equals(act)){
			path = CubeActionFactory.getBiztripDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("biztripregistor".equals(act)){
			path = CubeActionFactory.getBiztripDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("triprepotregistor".equals(act)){
			path = CubeActionFactory.getBiztripreportDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("approval_deaddoc".equals(act)){
			path = CubeActionFactory.getDeadDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("deadregistor".equals(act)){
			path = CubeActionFactory.getDeadDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}
}