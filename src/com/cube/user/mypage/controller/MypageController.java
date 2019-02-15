package com.cube.user.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.factory.CubeActionFactory;
import com.cube.model.dto.EmployeesDto;
import com.cube.user.mypage.model.dao.MypageUserDao;
import com.cube.user.mypage.model.dao.MypageUserDaoImpl;
import com.cube.util.MovePage;

@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		String path = "";
		String root = request.getContextPath();
		
		if("gomypage".equals(act)){
			
		
			path=CubeActionFactory.getPageMoveAction().action(request, response);
			MovePage.forward(path, request, response);
			
			
		}else if("mypageinsert".equals(act)){
			
			path=CubeActionFactory.getPageUpdateAction().action(request, response);
			MovePage.forward(path, request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
