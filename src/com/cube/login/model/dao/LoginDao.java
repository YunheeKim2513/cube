package com.cube.login.model.dao;


import com.cube.model.dto.EmployeesDto;


public interface LoginDao {
	
	EmployeesDto loginProcess(String employee_id, String pass);

	
}
