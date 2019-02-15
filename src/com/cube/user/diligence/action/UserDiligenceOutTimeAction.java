package com.cube.user.diligence.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;

import com.cube.action.Action;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.user.diligence.model.service.DiligenceServiceImpl;
import com.cube.util.Encoder;

public class UserDiligenceOutTimeAction implements Action{

	
	private static UserDiligenceOutTimeAction userDiligenceOutTimeAction;
	
	static{
		userDiligenceOutTimeAction = new UserDiligenceOutTimeAction();
	}
	
	private UserDiligenceOutTimeAction(){};
	
	public static UserDiligenceOutTimeAction getUserDiligenceOutTimeAction() {
		return userDiligenceOutTimeAction;
	}

	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String outtime = request.getParameter("outtime");
		String intime =request.getParameter("intime");
		String user_diligence =request.getParameter("user_diligence");
		
		
		String[] outtimea =outtime.split(" ");
		System.out.println(outtimea[0]);
		System.out.println(outtimea[1]);
		String[] outtimeb = outtimea[1].split(":");
		
		
		String[] intimea =intime.split(" ");
		System.out.println(intimea[0]);
		System.out.println(intimea[1]);
		String[] intimeb = intimea[1].split(":");
		
		

		
		EmployeesDto employeesDto = (EmployeesDto)session.getAttribute("userInfo");
		
	
		//User_timeDto user_timeDto = (User_timeDto)session.getAttribute("user_timeDto");
		
		//user_timeDto.setUsercheckin_time(user_timeDto.getUsercheckin_time());
		
		
		User_timeDto user_timeDto2 = new User_timeDto();
		user_timeDto2.setEmployee_id(employeesDto.getEmployee_id());
		user_timeDto2.setUsercheckout_time(outtime);
		user_timeDto2.setUser_diligence(user_diligence);
		
		
		 DiligenceServiceImpl.getDiligenceServiceImpl().outtime(user_timeDto2);
		 
		 
			User_timeworkDto user_timeworkDto = new User_timeworkDto();
			
			user_timeworkDto.setStarthour(intimeb[0]);
			user_timeworkDto.setStarttime(intimea[0]);
			user_timeworkDto.setStartmin(intimeb[1]);
			user_timeworkDto.setEndtime(outtimea[0]);
			user_timeworkDto.setEndhour(outtimeb[0]);
			user_timeworkDto.setEndmin(outtimeb[1]);
			user_timeworkDto.setEmployee_id(employeesDto.getEmployee_id());
			user_timeworkDto.setGroup_standard(employeesDto.getGroup_standard());
			
			DiligenceServiceImpl.getDiligenceServiceImpl().outtimework(user_timeworkDto);
			

		 
		return "/pages/user_diligence/user_diligence_time.jsp";//리턴할게 없어
	}

	
	
}
