package com.cube.user.mypage.model.dao;

import com.cube.model.dto.EmployeesListDto;

public interface MypageUserDao {
	EmployeesListDto searchid(String id);//��� ���� ���� â�� �Ѹ� �ش� ����� ����
	
	int empupdate(EmployeesListDto employeesListDto);//��� ���� ����

}
