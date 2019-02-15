package com.cube.user.mypage.model.dao;

import com.cube.model.dto.EmployeesListDto;

public interface MypageUserDao {
	EmployeesListDto searchid(String id);//사원 정보 수정 창에 뿌릴 해당 사원의 정보
	
	int empupdate(EmployeesListDto employeesListDto);//사원 정보 수정

}
