package com.cube.admin.companyinfo.model.service;

import java.util.List;

import com.cube.model.dto.*;


public interface AdminCompanyinfoEmployeeService {
	int sign_up(Employees_detailDto employees_detailDto);//사원등록
	List<EmployeesListDto> emplist();//사원리스트     사원정보+부서이름+직급이름 (+ -> 조인)
	EmployeesListDto searchid(String id);//사원 정보 수정 창에 뿌릴 해당 사원의 정보
	int empupdate(EmployeesListDto employeesListDto);//사원 정보 수정
	
	List<EmployeesListDto> firelist();//퇴사자 리스트
	void firedelete(String id);//퇴사자 삭제
	EmployeesListDto searchfireid(String id);//퇴사자 정보 수정 창에 뿌릴 해당 사원의 정보
	int fireupdate(EmployeesListDto employeesListDto);//퇴사자 정보 수정
	
	int idCheck(String id);//select count(id) from member where id='two_hands';
	List<ZipDto> zipSearch(String dong);//
	
	void departwrite(String id, String name);//부서 등록
	List<DepartmentsDto> departlist();//부서 리스트
	void departdelete(String id);//부서 삭제
	
	void gradewrite(String id, String name);//직급 등록
	List<GradesDto> gradelist();//직급 리스트
	void gradedelete(String id);//직급 삭제
	
	List<String> grouplist();

}
