package com.cube.login.model.service;


import com.cube.login.model.dao.LoginDaoImpl;
import com.cube.model.dto.EmployeesDto;

public class LoginServiceImpl implements LoginService{

	private static LoginServiceImpl loginServiceImpl;
	
	static{
		
		loginServiceImpl = new LoginServiceImpl();
	}
	
	private LoginServiceImpl(){};
	
	
	
	public static LoginServiceImpl getLoginServiceImpl() {
		return loginServiceImpl;
	}



	@Override
	public EmployeesDto loginProcess( String employee_id, String pass) {
	
		return LoginDaoImpl.getLoginDaoImpl().loginProcess(employee_id, pass);
	}

	

}
