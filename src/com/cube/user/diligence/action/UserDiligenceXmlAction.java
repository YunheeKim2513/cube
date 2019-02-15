package com.cube.user.diligence.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.User_timeDto;
import com.cube.user.diligence.model.service.DiligenceServiceImpl;

public class UserDiligenceXmlAction implements Action {
	private static UserDiligenceXmlAction userDiligenceXmlAction;
	static{
		userDiligenceXmlAction=new UserDiligenceXmlAction();
	}
	

	public static UserDiligenceXmlAction getUserDiligenceXmlAction() {
		return userDiligenceXmlAction;
	}
	
	
	private UserDiligenceXmlAction(){};
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
		String id=employeesDto.getEmployee_id();
		List<User_timeDto> list=DiligenceServiceImpl.getDiligenceServiceImpl().list(id);
		request.setAttribute("timelist", list);
		return "/xml/diligencetime.jsp";
	}

}
