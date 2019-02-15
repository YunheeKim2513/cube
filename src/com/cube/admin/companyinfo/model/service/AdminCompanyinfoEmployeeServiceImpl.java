package com.cube.admin.companyinfo.model.service;

import java.util.List;

import com.cube.admin.companyinfo.model.dao.AdminCompanyinfoEmployeeDaoImpl;
import com.cube.model.dto.*;

public class AdminCompanyinfoEmployeeServiceImpl implements AdminCompanyinfoEmployeeService {

	private static AdminCompanyinfoEmployeeService adminCompanyinfoEmployeeService;

	static {
		adminCompanyinfoEmployeeService = new AdminCompanyinfoEmployeeServiceImpl();
	}

	private AdminCompanyinfoEmployeeServiceImpl() {
	}

	public static AdminCompanyinfoEmployeeService getAdminCompanyinfoEmployeeService() {
		return adminCompanyinfoEmployeeService;
	}

	@Override
	public int sign_up(Employees_detailDto employees_detailDto) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().sign_up(employees_detailDto);
	}

	@Override
	public List<DepartmentsDto> departlist() {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departlist();
	}

	@Override
	public List<GradesDto> gradelist() {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradelist();
	}

	@Override
	public List<EmployeesListDto> emplist() {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().emplist();
	}

	@Override
	public List<EmployeesListDto> firelist() {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().firelist();
	}

	@Override
	public void departwrite(String id, String name) {
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departwrite(id, name);
	}

	@Override
	public void departdelete(String id) {
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().departdelete(id);
	}

	@Override
	public void gradewrite(String id, String name) {
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradewrite(id, name);
	}

	@Override
	public void gradedelete(String id) {
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().gradedelete(id);
	}

	@Override
	public int empupdate(EmployeesListDto employeesListDto) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().empupdate(employeesListDto);
	}

	@Override
	public void firedelete(String id) {
		AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().firedelete(id);
	}

	@Override
	public int fireupdate(EmployeesListDto employeesListDto) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().fireupdate(employeesListDto);
	}

	@Override
	public EmployeesListDto searchid(String id) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().searchid(id);
	}

	@Override
	public EmployeesListDto searchfireid(String id) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().searchfireid(id);
	}

	@Override
	public int idCheck(String id) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().idCheck(id);
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().zipSearch(dong);
	}

	@Override
	public List<String> grouplist() {
		return AdminCompanyinfoEmployeeDaoImpl.getAdminCompanyinfoEmployeeDao().grouplist();
	}
	
}
