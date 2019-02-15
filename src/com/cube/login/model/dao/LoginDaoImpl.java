package com.cube.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cube.model.dto.EmployeesDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;


public class LoginDaoImpl implements LoginDao{



	private static LoginDaoImpl loginDaoImpl;
	
	static{
		loginDaoImpl = new LoginDaoImpl();
	}
	
	private LoginDaoImpl() {}

	

	public static LoginDaoImpl getLoginDaoImpl() {
		return loginDaoImpl;
	}


	

	@Override
	public EmployeesDto loginProcess(String employee_id, String pass) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeesDto employeesDto = new EmployeesDto();//전역변수
		
		try {
			
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("select e.employee_id, e.department_id, e.pass, e.name, d.department_name, g.grade_name, e.group_standard, e.email1, e.email2,  t.save_picture,  t.save_folder, e.working \n");
			sql.append("from employees e, departments d, grades g, employees_detail t \n");
			sql.append("where d.department_id = e.department_id and e.grade_id=g.grade_id and e.employee_id = t.employee_id \n");
			sql.append("and e.employee_id = ? and e.pass = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, employee_id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				employeesDto.setEmployee_id(rs.getString("employee_id"));
				employeesDto.setDepartment_id(rs.getString("department_id"));
				employeesDto.setPass(rs.getString("pass"));
				employeesDto.setName(rs.getString("name"));
				employeesDto.setDepartment_name(rs.getString("department_name"));
				employeesDto.setGarde_name(rs.getString("grade_name"));
				employeesDto.setGroup_standard(rs.getString("group_standard"));
				employeesDto.setEmail1(rs.getString("email1"));
				employeesDto.setEmail2(rs.getString("email2"));
				employeesDto.setSave_picture(rs.getString("save_picture"));
				employeesDto.setSave_folder(rs.getString("save_folder"));
				employeesDto.setWorking(rs.getString("working"));
				
				System.out.println(employeesDto.getGroup_standard());
				
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return employeesDto;
		
	}

}
