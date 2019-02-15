package com.cube.admin.companyinfo.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.*;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class AdminCompanyinfoEmployeeDaoImpl implements AdminCompanyinfoEmployeeDao {

	private static AdminCompanyinfoEmployeeDao adminCompanyinfoEmployeeDao;
	
	static{
		adminCompanyinfoEmployeeDao= new AdminCompanyinfoEmployeeDaoImpl();
	}
	
	private AdminCompanyinfoEmployeeDaoImpl(){}
	
	public static AdminCompanyinfoEmployeeDao getAdminCompanyinfoEmployeeDao() {
		return adminCompanyinfoEmployeeDao;
	}

	//사원 등록
	@Override
	public int sign_up(Employees_detailDto employees_DetailDto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("insert all into employees (employee_id,department_id,grade_id,name,pass,group_standard,email1,email2,gender,hp1,hp2,hp3,working) \n");
			sql.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?) \n");
			sql.append("into employees_detail (employee_id,zip1,zip2,addr1,addr2,marriage,hire_date, save_folder, origin_picture, save_picture) \n");
			sql.append("values (?,?,?,?,?,?,sysdate,?,?,?) \n");
			sql.append("select * from dual \n");
			pstmt=conn.prepareStatement(sql.toString());
			int idx=1;
			pstmt.setString(idx++, employees_DetailDto.getEmployee_id());
			pstmt.setString(idx++, employees_DetailDto.getDepartment_id());
			pstmt.setString(idx++, employees_DetailDto.getGrade_id());
			pstmt.setString(idx++, employees_DetailDto.getName());
			pstmt.setString(idx++, employees_DetailDto.getPass());
			pstmt.setString(idx++, employees_DetailDto.getGroup_standard());
			pstmt.setString(idx++, employees_DetailDto.getEmail1());
			pstmt.setString(idx++, employees_DetailDto.getEmail2());
			pstmt.setString(idx++, employees_DetailDto.getGender());
			pstmt.setString(idx++, employees_DetailDto.getHp1());
			pstmt.setString(idx++, employees_DetailDto.getHp2());
			pstmt.setString(idx++, employees_DetailDto.getHp3());
			pstmt.setString(idx++, "y");
			
			pstmt.setString(idx++, employees_DetailDto.getEmployee_id());
			pstmt.setString(idx++, employees_DetailDto.getZip1());
			pstmt.setString(idx++, employees_DetailDto.getZip2());
			pstmt.setString(idx++, employees_DetailDto.getAddr1());
			pstmt.setString(idx++, employees_DetailDto.getAddr2());
			pstmt.setString(idx++, employees_DetailDto.getMarrige());
			pstmt.setString(idx++, employees_DetailDto.getSave_folder());
			pstmt.setString(idx++, employees_DetailDto.getOrigin_picture());
			pstmt.setString(idx++, employees_DetailDto.getSave_picture());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return result;
	}


	//사원 리스트
	@Override
	public List<EmployeesListDto> emplist() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EmployeesListDto> list=new ArrayList<EmployeesListDto>();
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, d.department_id, d.department_name, g.grade_id, g.grade_name, nvl(e.email1,' ') email1, nvl(e.email2,' ') email2, nvl(e.gender,' ') gender, nvl(e.group_standard,' ') group_standard, "
					+ "e.name, nvl(e.hp1,' ') hp1, nvl(e.hp2,' ') hp2, nvl(e.hp3,' ') hp3, ed.hire_date, nvl(ed.hn1,' ') hn1, nvl(ed.hn2,' ') hn2, nvl(ed.hn3,' ') hn3, nvl(ed.marriage,' ') marriage, "
//					+ "e.name, e.hp1, e.hp2, e.hp3, ed.hire_date, ed.hn1, ed.hn2, ed.hn3, ed.marriage, "					
					+ "nvl(ed.zip1,' ') zip1, nvl(ed.zip2,' ') zip2, nvl(ed.addr1,' ') addr1, nvl(ed.addr2,' ') addr2 \n");
//					+ "ed.zip1, ed.zip2, ed.addr1, ed.addr2 \n");
			sql.append("from employees e, departments d, grades g, employees_detail ed \n");
			sql.append("where e.department_id=d.department_id and e.grade_id=g.grade_id and "
					+ "e.employee_id=ed.employee_id and working=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, "y");
			rs=pstmt.executeQuery();
			while(rs.next()){
				EmployeesListDto employeesListDto=new EmployeesListDto();
				employeesListDto.setEmployee_id(rs.getString("employee_id"));
				employeesListDto.setDepartment_id(rs.getString("department_id"));
				employeesListDto.setDepartment_name(rs.getString("department_name"));
				employeesListDto.setGrade_id(rs.getString("grade_id"));
				employeesListDto.setGrade_name(rs.getString("grade_name"));
				employeesListDto.setName(rs.getString("name"));
				employeesListDto.setGroup_standard(rs.getString("group_standard"));
				employeesListDto.setHp1(rs.getString("hp1"));
				employeesListDto.setHp2(rs.getString("hp2"));
				employeesListDto.setHp3(rs.getString("hp3"));
				employeesListDto.setHn1(rs.getString("hn1"));
				employeesListDto.setHn2(rs.getString("hn2"));
				employeesListDto.setHn3(rs.getString("hn3"));
				employeesListDto.setEmail1(rs.getString("email1"));
				employeesListDto.setEmail2(rs.getString("email2"));
				employeesListDto.setZip1(rs.getString("zip1"));
				employeesListDto.setZip2(rs.getString("zip2"));
				employeesListDto.setAddr1(rs.getString("addr1"));
				employeesListDto.setAddr2(rs.getString("addr2"));
				employeesListDto.setGender(rs.getString("gender"));
				employeesListDto.setMarraige(rs.getString("marriage"));
				employeesListDto.setHire_date(rs.getString("hire_date"));
				list.add(employeesListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	//퇴사자 리스트
	@Override
	public List<EmployeesListDto> firelist() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<EmployeesListDto> list=new ArrayList<EmployeesListDto>();
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, d.department_name, g.grade_name, nvl(e.email1,' ') email1, nvl(e.email2,' ') email2, nvl(e.gender,' ') gender, nvl(e.group_standard,' ') group_standard, "
					+ "e.name, nvl(e.hp1,' ') hp1, nvl(e.hp2,' ') hp2, nvl(e.hp3,' ') hp3, ed.hire_date, nvl(ed.hn1,' ') hn1, nvl(ed.hn2,' ') hn2, nvl(ed.hn3,' ') hn3, nvl(ed.marriage,' ') marriage, "
					+ "nvl(ed.zip1,' ') zip1, nvl(ed.zip2,' ') zip2, nvl(ed.addr1,' ') addr1, nvl(ed.addr2,' ') addr2, ed.out_date \n");
			sql.append("from employees e, departments d, grades g, employees_detail ed \n");
			sql.append("where e.department_id=d.department_id and e.grade_id=g.grade_id and "
					+ "e.employee_id=ed.employee_id and working=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, "n");
			rs=pstmt.executeQuery();
			while(rs.next()){
				EmployeesListDto employeesListDto=new EmployeesListDto();
				employeesListDto.setEmployee_id(rs.getString("employee_id"));
				employeesListDto.setDepartment_name(rs.getString("department_name"));
				employeesListDto.setGrade_name(rs.getString("grade_name"));
				employeesListDto.setName(rs.getString("name"));
				employeesListDto.setHp1(rs.getString("hp1"));
				employeesListDto.setHp2(rs.getString("hp2"));
				employeesListDto.setHp3(rs.getString("hp3"));
				employeesListDto.setHn1(rs.getString("hn1"));
				employeesListDto.setHn2(rs.getString("hn2"));
				employeesListDto.setHn3(rs.getString("hn3"));
				employeesListDto.setEmail1(rs.getString("email1"));
				employeesListDto.setEmail2(rs.getString("email2"));
				employeesListDto.setZip1(rs.getString("zip1"));
				employeesListDto.setZip2(rs.getString("zip2"));
				employeesListDto.setAddr1(rs.getString("addr1"));
				employeesListDto.setAddr2(rs.getString("addr2"));
				employeesListDto.setGender(rs.getString("gender"));
				employeesListDto.setGroup_standard(rs.getString("group_standard"));
				employeesListDto.setMarraige(rs.getString("marriage"));
				employeesListDto.setHire_date(rs.getString("hire_date"));
				employeesListDto.setOut_date(rs.getString("out_date"));
				list.add(employeesListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//------------------------------------------------------------------------

	
	//부서 리스트
		@Override
		public List<DepartmentsDto> departlist() {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<DepartmentsDto> list=new ArrayList<DepartmentsDto>();
			try {
				conn=DBConnection.makeConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select department_id,department_name \n");
				sql.append("from departments \n");
				pstmt=conn.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				while(rs.next()){
					DepartmentsDto epartmentsDto=new DepartmentsDto();
					epartmentsDto.setDepartment_id(rs.getString("department_id"));
					epartmentsDto.setDepartment_name(rs.getString("department_name"));
					list.add(epartmentsDto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBClose.close(conn, pstmt, rs);
			}
			return list;
		}
	
	
	//부서 등록
	@Override
	public void departwrite(String id, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("insert into departments(department_id, department_name) \n");
			sql.append("values(?,?) \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	
	//부서삭제
	public void departdelete(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("delete departments \n");
			sql.append("where department_id=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	
	//------------------------------------------------------------------------

	//직급 리스트
		@Override
		public List<GradesDto> gradelist() {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<GradesDto> list=new ArrayList<GradesDto>();
			try {
				conn=DBConnection.makeConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select grade_id, grade_name \n");
				sql.append("from grades \n");
				pstmt=conn.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				while(rs.next()){
					GradesDto gradesDto=new GradesDto();
					gradesDto.setGrade_id(rs.getString("grade_id"));
					gradesDto.setGrade_name(rs.getString("grade_name"));
					list.add(gradesDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt, rs);
			}
			return list;
		}
		
		
	@Override
	public void gradewrite(String id, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("insert into grades(grade_id, grade_name) \n");
			sql.append("values(?,?) \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void gradedelete(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("delete grades \n");
			sql.append("where grade_id=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}


	@Override
	public int empupdate(EmployeesListDto employeesListDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			conn=DBConnection.makeConnection();
			int idx=0;
			String sql="";
			sql="update employees \n";
			sql+="set department_id=?, grade_id=?, name=?, pass=?, group_standard=?, \n";
			sql+="    gender=?, hp1=?, hp2=?, hp3=?, email1=?, email2=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++idx, employeesListDto.getDepartment_id());
			pstmt.setString(++idx, employeesListDto.getGrade_id());
			pstmt.setString(++idx, employeesListDto.getName());
			pstmt.setString(++idx, employeesListDto.getPass());
			pstmt.setString(++idx, employeesListDto.getGroup_standard());
			pstmt.setString(++idx, employeesListDto.getGender());
			pstmt.setString(++idx, employeesListDto.getHp1());
			pstmt.setString(++idx, employeesListDto.getHp2());
			pstmt.setString(++idx, employeesListDto.getHp3());
			pstmt.setString(++idx, employeesListDto.getEmail1());
			pstmt.setString(++idx, employeesListDto.getEmail2());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
			idx=0;//save_folder, origin_picture, save_picture
			sql="update employees_detail \n";
			sql+="set hn1=?, hn2=?, hn3=?, marriage=?, \n";
			sql+="    zip1=?, zip2=?, addr1=?, addr2=?, \n";
			sql+="    save_folder=?, origin_picture=?, save_picture=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++idx, employeesListDto.getHn1());
			pstmt.setString(++idx, employeesListDto.getHn2());
			pstmt.setString(++idx, employeesListDto.getHn3());
			pstmt.setString(++idx, employeesListDto.getMarraige());
			pstmt.setString(++idx, employeesListDto.getZip1());
			pstmt.setString(++idx, employeesListDto.getZip2());
			pstmt.setString(++idx, employeesListDto.getAddr1());
			pstmt.setString(++idx, employeesListDto.getAddr2());
			pstmt.setString(++idx, employeesListDto.getSave_folder());
			pstmt.setString(++idx, employeesListDto.getOrigin_picture());
			pstmt.setString(++idx, employeesListDto.getSave_picture());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result+=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return result;
	}
	@Override
	public int fireupdate(EmployeesListDto employeesListDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			conn=DBConnection.makeConnection();
			int idx=0;
			String sql="";
			sql="update employees \n";
			sql+="set department_id=?, grade_id=?, name=?, pass=?, group_standard=?, \n";
			sql+="    gender=?, hp1=?, hp2=?, hp3=?, email1=?, email2=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++idx, employeesListDto.getDepartment_id());
			pstmt.setString(++idx, employeesListDto.getGrade_id());
			pstmt.setString(++idx, employeesListDto.getName());
			pstmt.setString(++idx, employeesListDto.getPass());
			pstmt.setString(++idx, employeesListDto.getGroup_standard());
			pstmt.setString(++idx, employeesListDto.getGender());
			pstmt.setString(++idx, employeesListDto.getHp1());
			pstmt.setString(++idx, employeesListDto.getHp2());
			pstmt.setString(++idx, employeesListDto.getHp3());
			pstmt.setString(++idx, employeesListDto.getEmail1());
			pstmt.setString(++idx, employeesListDto.getEmail2());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
			idx=0;
			sql="update employees_detail \n";
			sql+="set hn1=?, hn2=?, hn3=?, marriage=?, \n";
			sql+="    zip1=?, zip2=?, addr1=?, addr2=?, \n";
			sql+="    save_folder=?, origin_picture=?, save_picture=? \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++idx, employeesListDto.getHn1());
			pstmt.setString(++idx, employeesListDto.getHn2());
			pstmt.setString(++idx, employeesListDto.getHn3());
			pstmt.setString(++idx, employeesListDto.getMarraige());
			pstmt.setString(++idx, employeesListDto.getZip1());
			pstmt.setString(++idx, employeesListDto.getZip2());
			pstmt.setString(++idx, employeesListDto.getAddr1());
			pstmt.setString(++idx, employeesListDto.getAddr2());
			pstmt.setString(++idx, employeesListDto.getSave_folder());
			pstmt.setString(++idx, employeesListDto.getOrigin_picture());
			pstmt.setString(++idx, employeesListDto.getSave_picture());
			pstmt.setString(++idx, employeesListDto.getEmployee_id());
			result+=pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return result;
	}

	
	
	@Override
	public EmployeesListDto searchid(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeesListDto employeesListDto=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, e.department_id, d.department_name, e.grade_id, g.grade_name, name, pass, nvl(e.email1,' ') email1, nvl(e.email2,' ') email2, nvl(e.gender,' ') gender, nvl(e.hp1,' ') hp1, nvl(e.hp2,' ') hp2, nvl(e.hp3,' ') hp3, working, \n");
			sql.append("		nvl(ed.zip1,' ') zip1, nvl(ed.zip2,' ') zip2, nvl(ed.addr1,' ') addr1, nvl(ed.addr2,' ') addr2, nvl(ed.hn1,' ') hn1, nvl(ed.hn2,' ') hn2, nvl(ed.hn3,' ') hn3, nvl(ed.marriage,' ') marriage, \n");
			sql.append("		save_folder, origin_picture, save_picture, nvl(e.group_standard,' ') group_standard \n");
			sql.append("from employees e, employees_detail ed, departments d, grades g \n");
			sql.append("where e.employee_id=ed.employee_id and e.grade_id=g.grade_id and e.department_id=d.department_id \n");
			sql.append("and e.employee_id=? and working=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, "y");
			rs=pstmt.executeQuery();
			if(rs.next()){
				employeesListDto=new EmployeesListDto();
				employeesListDto.setEmployee_id(rs.getString("employee_id"));
				employeesListDto.setDepartment_id(rs.getString("department_id"));
				employeesListDto.setDepartment_name(rs.getString("department_name"));
				employeesListDto.setGrade_id(rs.getString("grade_id"));
				employeesListDto.setGrade_name(rs.getString("grade_name"));
				employeesListDto.setName(rs.getString("name"));
				employeesListDto.setPass(rs.getString("pass"));
				employeesListDto.setEmail1(rs.getString("email1"));
				employeesListDto.setEmail2(rs.getString("email2"));
				employeesListDto.setGender(rs.getString("gender"));
				employeesListDto.setHp1(rs.getString("hp1"));
				employeesListDto.setHp2(rs.getString("hp2"));
				employeesListDto.setHp3(rs.getString("hp3"));
				employeesListDto.setHn1(rs.getString("hn1"));
				employeesListDto.setHn2(rs.getString("hn2"));
				employeesListDto.setHn3(rs.getString("hn3"));
				employeesListDto.setZip1(rs.getString("zip1"));
				employeesListDto.setZip2(rs.getString("zip2"));
				employeesListDto.setAddr1(rs.getString("addr1"));
				employeesListDto.setAddr2(rs.getString("addr2"));
				employeesListDto.setMarraige(rs.getString("marriage"));
				employeesListDto.setSave_folder(rs.getString("save_folder"));
				employeesListDto.setOrigin_picture(rs.getString("origin_picture"));
				employeesListDto.setSave_picture(rs.getString("save_picture"));
				employeesListDto.setGroup_standard(rs.getString("group_standard"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return employeesListDto;
	}

	@Override
	public EmployeesListDto searchfireid(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeesListDto employeesListDto=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, e.department_id, d.department_name, e.grade_id, g.grade_name, name, pass, nvl(e.email1,' ') email1, nvl(e.email2,' ') email2, nvl(e.gender,' ') gender, nvl(e.hp1,' ') hp1, nvl(e.hp2,' ') hp2, nvl(e.hp3,' ') hp3, working, \n");
			sql.append("		nvl(ed.zip1,' ') zip1, nvl(ed.zip2,' ') zip2, nvl(ed.addr1,' ') addr1, nvl(ed.addr2,' ') addr2, nvl(ed.hn1,' ') hn1, nvl(ed.hn2,' ') hn2, nvl(ed.hn3,' ') hn3, nvl(ed.marriage,' ') marriage, \n");
			sql.append("		save_folder, origin_picture, save_picture, nvl(e.group_standard,' ') group_standard \n");
			sql.append("from employees e, employees_detail ed, departments d, grades g \n");
			sql.append("where e.employee_id=ed.employee_id and e.grade_id=g.grade_id and e.department_id=d.department_id \n");
			sql.append("and e.employee_id=? and working=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, "n");
			rs=pstmt.executeQuery();
			if(rs.next()){
				employeesListDto=new EmployeesListDto();
				employeesListDto.setEmployee_id(rs.getString("employee_id"));
				employeesListDto.setDepartment_id(rs.getString("department_id"));
				employeesListDto.setDepartment_name(rs.getString("department_name"));
				employeesListDto.setGrade_id(rs.getString("grade_id"));
				employeesListDto.setGrade_name(rs.getString("grade_name"));
				employeesListDto.setName(rs.getString("name"));
				employeesListDto.setPass(rs.getString("pass"));
				employeesListDto.setEmail1(rs.getString("email1"));
				employeesListDto.setEmail2(rs.getString("email2"));
				employeesListDto.setGender(rs.getString("gender"));
				employeesListDto.setHp1(rs.getString("hp1"));
				employeesListDto.setHp2(rs.getString("hp2"));
				employeesListDto.setHp3(rs.getString("hp3"));
				employeesListDto.setHn1(rs.getString("hn1"));
				employeesListDto.setHn2(rs.getString("hn2"));
				employeesListDto.setHn3(rs.getString("hn3"));
				employeesListDto.setZip1(rs.getString("zip1"));
				employeesListDto.setZip2(rs.getString("zip2"));
				employeesListDto.setAddr1(rs.getString("addr1"));
				employeesListDto.setAddr2(rs.getString("addr2"));
				employeesListDto.setMarraige(rs.getString("marriage"));
				employeesListDto.setSave_folder(rs.getString("save_folder"));
				employeesListDto.setOrigin_picture(rs.getString("origin_picture"));
				employeesListDto.setSave_picture(rs.getString("save_picture"));
				employeesListDto.setGroup_standard(rs.getString("group_standard"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return employeesListDto;
	}

	@Override
	public void firedelete(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			String sql="";
			sql="delete employees_detail \n";
			sql+="where employee_id=? \n";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			
			sql="delete employees \n";
			sql+="where employee_id=? and working=? \n";
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, "n");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public int idCheck(String id) {
		int count = 1;
		// 도중에 insert가 실패했을 때 count가 0으로 리턴되면 중복검사한 id가 생성가능으로 되므로
		// DB에 id가 존재시 무결성 제약조건에 걸리게 된다. 그러므로 0이 아닌 수로만 초기화 시키면 상관 없다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select count(employee_id) \n";
			sql += "from employees \n";
			sql += "where employee_id=? \n";
			//System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);// 0,1
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("insert 실패");
			count = 1;
			// 도중에 insert가 실패했을 때 count가 0으로 리턴되면 중복검사한 id가 생성가능으로 되므로
			// DB에 id가 존재시 무결성 제약조건에 걸리게 된다. 그러므로 0이 아닌 수로만 초기화 시키면 상관 없다.
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		List<ZipDto> list = new ArrayList<ZipDto>();
		ZipDto zipdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select substr(zipcode, 1, instr(zipcode,'-')-1) zip1, \n";
			sql += "	substr(zipcode, instr(zipcode,'-')+1) zip2, \n";
			sql += "	sido,gugun,dong,nvl(bunji,' ') bunji \n";
			sql += "from zipcode \n";
			sql += "where dong like '%'||?||'%'";// '구로%'  
			//System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);//"%"+dong+"%"
			rs = pstmt.executeQuery();
			while (rs.next()) {
				zipdto = new ZipDto();
				zipdto.setZip1(rs.getString("zip1"));
				zipdto.setZip2(rs.getString("zip2"));
				zipdto.setSido(rs.getString("sido"));
				zipdto.setGugun(rs.getString("gugun"));
				zipdto.setDong(rs.getString("dong"));
				zipdto.setBunji(rs.getString("bunji"));
				list.add(zipdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// 도중에 insert가 실패했을 때 count가 0으로 리턴되면 중복검사한 id가 생성가능으로 되므로
			// DB에 id가 존재시 무결성 제약조건에 걸리게 된다. 그러므로 0이 아닌 수로만 초기화 시키면 상관 없다.
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<String> grouplist() {
		List<String> list=new ArrayList<String>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select group_standard \n"); 
			sql.append("from diligencegroup \n"); 
			pstmt = conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("group_standard"));
			}
		} catch (SQLException e) {
			// 도중에 insert가 실패했을 때 count가 0으로 리턴되면 중복검사한 id가 생성가능으로 되므로
			// DB에 id가 존재시 무결성 제약조건에 걸리게 된다. 그러므로 0이 아닌 수로만 초기화 시키면 상관 없다.
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

}
