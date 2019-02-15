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

@WebServlet("/userdocupdate")
public class UserDocUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		if("signdocupdate".equals(act)||"orderdocupdate".equals(act)){
			path = CubeActionFactory.getSignDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("signupdate".equals(act)){
			path = CubeActionFactory.getSignDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("orderupdate".equals(act)){
			path = CubeActionFactory.getOrderDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("vacdocupdate".equals(act)){
			path = CubeActionFactory.getVacDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("vacupdate".equals(act)){
			path = CubeActionFactory.getVacDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("biztripdocupdate".equals(act) ||"biztrip_reportupdate".equals(act)){
			path = CubeActionFactory.getBiztripDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("biztripupdate".equals(act)){
			path = CubeActionFactory.getBiztripDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("triprepotupdate".equals(act)){
			path = CubeActionFactory.getBiztripreportDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("deaddocupdate".equals(act)){
			path = CubeActionFactory.getDeadDocWritePaperViewAction().action(request, response);
			MovePage.forward(path, request, response);
		} else if("deadupdate".equals(act)){
			path = CubeActionFactory.getDeadDocWriteAction().action(request, response);
			MovePage.forward(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(GroupwareConstance.ENCODING);
		doGet(request, response);
	}

}
