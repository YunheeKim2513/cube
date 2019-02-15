package com.cube.user.diligence.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.user.diligence.model.service.DiligenceServiceImpl;
import com.cube.util.Encoder;

public class UserDiligenceTimeAction implements Action{

	
	private static UserDiligenceTimeAction userDiligenceTimeAction;
	
	static{
		userDiligenceTimeAction = new UserDiligenceTimeAction();
	}
	
	private UserDiligenceTimeAction(){};
	
	public static UserDiligenceTimeAction getUserDiligenceTimeAction() {
		return userDiligenceTimeAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String intime =request.getParameter("intime");
		String user_diligence =request.getParameter("user_diligence");
		
		
	
		EmployeesDto employeesDto = (EmployeesDto)session.getAttribute("userInfo");
		
	
		
		User_timeDto user_timeDto = new User_timeDto();
		user_timeDto.setEmployee_id(employeesDto.getEmployee_id());
		user_timeDto.setUsercheckin_time(intime);
		user_timeDto.setUser_diligence(user_diligence);
		

		 DiligenceServiceImpl.getDiligenceServiceImpl().intime(user_timeDto);
		 
		 session.setAttribute("user_timeDto", user_timeDto);

		return "/pages/user_diligence/user_diligence_time.jsp";//리턴할게 없어
	}

	
	
}
