package com.cube.login.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.factory.CubeActionFactory;
import com.cube.login.model.service.LoginServiceImpl;
import com.cube.model.dto.EmployeesDto;
import com.cube.util.MovePage;
import com.cube.util.ParameterCheck;


public class LogoutAdminAction implements Action{

	
	private static LogoutAdminAction logoutAdminAction;
	
	static{
		logoutAdminAction = new LogoutAdminAction();
	}
	
	private LogoutAdminAction(){};

	
	public static LogoutAdminAction getLogoutAdminAction() {
		return logoutAdminAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
	
		session.removeAttribute("userInfo");
		
		
		
	
				return "pages/loginpage/login.jsp";
			

		
	};

}
