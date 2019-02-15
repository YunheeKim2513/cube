package com.cube.login.model.service;


import com.cube.model.dto.EmployeesDto;

public interface LoginService {

	
	EmployeesDto loginProcess(String employee_id, String pass);

	
}
