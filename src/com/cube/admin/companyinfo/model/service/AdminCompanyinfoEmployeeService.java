package com.cube.admin.companyinfo.model.service;

import java.util.List;

import com.cube.model.dto.*;


public interface AdminCompanyinfoEmployeeService {
	int sign_up(Employees_detailDto employees_detailDto);//������
	List<EmployeesListDto> emplist();//�������Ʈ     �������+�μ��̸�+�����̸� (+ -> ����)
	EmployeesListDto searchid(String id);//��� ���� ���� â�� �Ѹ� �ش� ����� ����
	int empupdate(EmployeesListDto employeesListDto);//��� ���� ����
	
	List<EmployeesListDto> firelist();//����� ����Ʈ
	void firedelete(String id);//����� ����
	EmployeesListDto searchfireid(String id);//����� ���� ���� â�� �Ѹ� �ش� ����� ����
	int fireupdate(EmployeesListDto employeesListDto);//����� ���� ����
	
	int idCheck(String id);//select count(id) from member where id='two_hands';
	List<ZipDto> zipSearch(String dong);//
	
	void departwrite(String id, String name);//�μ� ���
	List<DepartmentsDto> departlist();//�μ� ����Ʈ
	void departdelete(String id);//�μ� ����
	
	void gradewrite(String id, String name);//���� ���
	List<GradesDto> gradelist();//���� ����Ʈ
	void gradedelete(String id);//���� ����
	
	List<String> grouplist();

}
