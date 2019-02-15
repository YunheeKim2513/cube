package com.cube.user.diligence.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.EmployeesDto;
import com.cube.util.Encoder;
import com.cube.util.MovePage;

@WebServlet("/userdiligence")
public class UserDiligenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
	/*	String intime = Encoder.isoToUtf(request.getParameter("intime"));
		String outtime = Encoder.isoToUtf(request.getParameter("outtime"));
		//System.out.println(outtime);
		String user_diligence = request.getParameter("user_diligence");*/
		String path = "";
		String root = request.getContextPath();
		
		if("user_diligence_time".equals(act)){
			
			path="/pages/user_diligence/user_diligence_time.jsp";
			MovePage.redirect(root + path, response);
			
		}else if("getstarttime".equals(act)){
			path=CubeActionFactory.getDiligenceTimeAction().action(request, response);
			MovePage.forward(path, request, response);
			
			
		}else if("getendtime".equals(act)){
		
			path=CubeActionFactory.getUserDiligenceOutTimeAction().action(request, response);
			MovePage.forward(path, request, response);
			
		} else if("xml".equals(act)){
			
		
			path=CubeActionFactory.getUserDiligenceXmlAction().action(request, response);
			MovePage.forward(path, request, response);
			
		}
		
		
	}

}
