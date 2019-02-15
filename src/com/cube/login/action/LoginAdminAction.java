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


public class LoginAdminAction implements Action{

	
	private static LoginAdminAction loginAdminAction;
	
	static{
		loginAdminAction = new LoginAdminAction();
	}
	
	private LoginAdminAction(){};

	
	public static LoginAdminAction getLoginAdminAction() {
		return loginAdminAction;
	}


	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("로그인액션1");
		String employee_id = ParameterCheck.nullToBlank(request.getParameter("username"));
		String pass = ParameterCheck.nullToBlank(request.getParameter("password"));
		
		
		
		EmployeesDto employeesDto = LoginServiceImpl.getLoginServiceImpl().loginProcess(employee_id, pass);
	
		
		
		//System.out.println(employeesDto.getEmployee_id());
		if(employeesDto != null && employee_id.equals(employeesDto.getEmployee_id()) && pass.equals(employeesDto.getPass()) && employeesDto.getWorking().equals("y")){
			
			//System.out.println(employee_id);
			//System.out.println("여기 들어는 오니?");
			HttpSession session = request.getSession();
			
			session.setAttribute("userInfo", employeesDto);
	
			//System.out.println(request.getParameter("username"));
		
	
			
			if("admin".equals(employeesDto.getEmployee_id()) && request.getParameter("password").equals(employeesDto.getPass())){

				//System.out.println("여긴 admin action");
				return "pages/home/admin_home.jsp";
				
			}else if(!(request.getParameter("username").equals("admin"))){
				
				System.out.println(employeesDto.getGroup_standard());
				
				return "pages/home/user_home.jsp";
				
			}
			
		
			
			return "pages/home/user_home.jsp";
			
		}else{

			return "pages/loginpage/login.jsp";
		}
		
		

	
		
	};

}
