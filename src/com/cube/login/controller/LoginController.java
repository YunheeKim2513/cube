package com.cube.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.EmployeesDto;
import com.cube.util.MovePage;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String act = request.getParameter("act");
		String path ="";
		String root =request.getContextPath();
		
		if("loginPage".equals(act)){//처음 로그인 페이지 접속
			path="pages/loginpage/login.jsp";
			MovePage.redirect(path, response);
		}else if("loginInfo".equals(act)){//로그인 뒤 오늘 곳
			System.out.println("로그인액션으로 가는 컨트롤");
			path = CubeActionFactory.getLoginAdminAction().action(request, response);
			MovePage.forward(path, request, response);
			
		}else if("logout".equals(act)){

				path=CubeActionFactory.getLogoutAdminAction().action(request, response);
				MovePage.forward(path, request, response);
				
			
		}

	
	}

}
