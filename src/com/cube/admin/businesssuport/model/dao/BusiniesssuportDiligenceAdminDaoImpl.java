package com.cube.admin.businesssuport.model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.cube.model.dto.Admin_timeDto;
import com.cube.model.dto.Admin_timeSelectDto;
import com.cube.model.dto.DiligencegroupDto;
import com.cube.model.dto.EmployeeDilDto;
import com.cube.model.dto.EmployeesDto;
import com.cube.model.dto.HappyDayDto;
import com.cube.model.dto.User_timeDto;
import com.cube.model.dto.User_timeworkDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class BusiniesssuportDiligenceAdminDaoImpl implements BusiniesssuportDiligenceAdminDao {
	private static BusiniesssuportDiligenceAdminDaoImpl businiesssuportDiligenceAdminDaoImpl;

	static{
		businiesssuportDiligenceAdminDaoImpl = new BusiniesssuportDiligenceAdminDaoImpl();
	}

	private BusiniesssuportDiligenceAdminDaoImpl(){}

		public static BusiniesssuportDiligenceAdminDaoImpl getBusiniesssuportDiligenceAdminDaoImpl() {
		return businiesssuportDiligenceAdminDaoImpl;
	}
		
	@Override
	public List<DiligencegroupDto> diligencekind() {
		List<DiligencegroupDto> list = new ArrayList<DiligencegroupDto>();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			
			sql = "select group_standard \n";
			sql += "from diligencegroup \n";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				DiligencegroupDto diligencegroupDto = new DiligencegroupDto();
				diligencegroupDto.setGroup_standard(rs.getString("group_standard"));
				
				list.add(diligencegroupDto);
			}
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return list;
	}

	@Override
	public void diligencekindin(String diligencegrouptext, String diligenceselect) {
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			sql = "insert into diligencegroup(group_standard) values (?||?)\n";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, diligenceselect);
			pstmt.setString(2, diligencegrouptext);
			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void diligencetimein(Admin_timeDto admin_timeDto, EmployeesDto employeesDto) {
	
		 
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		System.out.println("diligencetimein dao에 들어왔어");
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			
			sql = "insert into admin_time(admintime_seq, endtime, endhour, endmin, starthour, starttime, startmin, group_standard, employee_id) values (admintime_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)\n";
			System.out.println("diligencetimein sql문 수행");
			pstmt = conn.prepareStatement(sql);
			
			int idx=0;
			System.out.println("diligencetimein getEmployee_id===="+admin_timeDto.getGroup_standard());
			
			
			pstmt.setString(++idx, admin_timeDto.getEndtime());
			pstmt.setString(++idx, admin_timeDto.getEndhour());
			pstmt.setString(++idx, admin_timeDto.getEndmin());
			pstmt.setString(++idx, admin_timeDto.getStarthour());
			pstmt.setString(++idx, admin_timeDto.getStarttime());
			pstmt.setString(++idx, admin_timeDto.getStartmin());
			pstmt.setString(++idx, admin_timeDto.getGroup_standard());
			pstmt.setString(++idx, employeesDto.getEmployee_id());
			
			System.out.println("diligencetimein sql값을 넣기");
			pstmt.executeUpdate();
			System.out.println("diligencetimein sql값 db에 넣기 성공");
			conn.commit();
			System.out.println("diligencetimein sql값 db에 넣기 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("diligencetimein sql값 db에 넣기 성공");
		}finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<Admin_timeSelectDto> diligenceselect() {
		
		List<Admin_timeSelectDto> list = new ArrayList<Admin_timeSelectDto>();
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
		
			StringBuffer sql = new StringBuffer();
			
			sql.append("select admintime_seq, endtime||endhour||':'||endmin as endcon, starttime||starthour||':'||startmin as startcon, group_standard from admin_time \n");
			sql.append("order by admintime_seq");
					
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
			Admin_timeSelectDto admin_timeSelectDto = new Admin_timeSelectDto();
			
			admin_timeSelectDto.setAdmintime_seq(rs.getString("admintime_seq"));
			admin_timeSelectDto.setEndset(rs.getString("endcon"));
			admin_timeSelectDto.setStartset(rs.getString("startcon"));
			admin_timeSelectDto.setGroupStandard(rs.getString("group_standard"));
			
			list.add(admin_timeSelectDto);
			
			}
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return list;
	}

	@Override
	public void diligenceDelete(int deldteseq) {
	
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			sql = "DELETE FROM admin_time WHERE admintime_seq = ? \n";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deldteseq);
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
	}

	
	
	@Override
	public void diligenceAllDelete(int admintime_seq) {
		

		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			sql = "DELETE FROM admin_time WHERE admintime_seq = ? \n";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, admintime_seq);
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public List<EmployeeDilDto> employeeDilDtolist() {//수정중... 
		
		List<EmployeeDilDto> employeeDilDtolist = new ArrayList<EmployeeDilDto>();
		
	
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
		
			StringBuffer sql = new StringBuffer();
			
			sql.append("select distinct d.department_name, g.grade_name, e.working, e.name, e.employee_id, e.group_standard, \n");
			sql.append("(select count(case when starthour <=(select to_number(starthour) from admin_time where group_standard=e.group_standard) \n");
			sql.append("and starthour>=0 and startmin >= (select to_number(startmin) from admin_time where group_standard=e.group_standard) and startmin >= 0 then '정상출근' end) \n");
			sql.append("from user_timework where employee_id = e.employee_id) as thetime, \n");
			sql.append("(select count(case when not(starthour <=(select to_number(starthour) from admin_time where group_standard=e.group_standard) \n");
			sql.append("and starthour>=0 and startmin >= (select to_number(startmin) from admin_time where group_standard=e.group_standard) and startmin >= 0) then '지각' end) \n");
			sql.append("from user_timework where employee_id = e.employee_id) as timelate \n");
			sql.append("from employees e, departments d, grades g \n");
			sql.append("where e.department_id = d.department_id and e.grade_id = g.grade_id \n");
				
			
			pstmt = conn.prepareStatement(sql.toString());
				
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			EmployeeDilDto employeeDilDto = new EmployeeDilDto();
			
			
			employeeDilDto.setDepartment_name(rs.getString("department_name"));
			employeeDilDto.setGarde_name(rs.getString("grade_name"));
			employeeDilDto.setWorking(rs.getString("working"));
			employeeDilDto.setName(rs.getString("name"));
			//employeeDilDto.setStarttime(rs.getString("starttime"));
			employeeDilDto.setNomal_limit(rs.getString("thetime"));
		/*	employeeDilDto.setStarthour(rs.getString("starthour"));
			employeeDilDto.setStartmin(rs.getString("startmin"));
			employeeDilDto.setEndhour(rs.getString("endhour"));
			employeeDilDto.setEndmin(rs.getString("endmin"));*/
			employeeDilDto.setEndtime(rs.getString("timelate"));
			employeeDilDto.setEmployee_id(rs.getString("employee_id"));
			employeeDilDto.setGroup_standard(rs.getString("group_standard"));//근태그룹이름
			
			
			employeeDilDtolist.add(employeeDilDto);
			
			}
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		
		return employeeDilDtolist;
	}

	@Override
	public Admin_timeDto admin_timeStandard() {
	
		Admin_timeDto admin_timeDto = new Admin_timeDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("select group_standard, starttime, starthour, startmin from admin_time");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){

				admin_timeDto.setGroup_standard(rs.getString("group_standard"));
				admin_timeDto.setStarttime(rs.getString("starttime"));
				admin_timeDto.setStarthour(rs.getString("starthour"));
				admin_timeDto.setStartmin(rs.getString("startmin"));

			}
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return admin_timeDto;
	}

	@Override
	public Admin_timeDto admin_timeDto() {
		
		Admin_timeDto admin_timeDto = new Admin_timeDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("select starttime, starthour, startmin from admin_time");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){

				admin_timeDto.setStarttime(rs.getString("starttime"));
				admin_timeDto.setStarthour(rs.getString("starthour"));
				admin_timeDto.setStartmin(rs.getString("startmin"));
				
			}
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return admin_timeDto;
	}

	@Override
	public void inHappyDay(HappyDayDto happyDayDto) {

		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			String sql="";
			sql = "insert into happyday(happy_code, happy_name, happy_start, happy_end, employee_id) values(happyday_seq.nextval, ?, ?, ?, ?) \n";
			
			pstmt = conn.prepareStatement(sql);
			int idx=0;
			
			pstmt.setString(++idx, happyDayDto.getHappy_name());
			pstmt.setString(++idx, happyDayDto.getHappy_stat());
			pstmt.setString(++idx, happyDayDto.getHappy_end());
			pstmt.setString(++idx, happyDayDto.getEmployee_id());
			
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public List<HappyDayDto> happyDayDto() {
			
		List<HappyDayDto> happyDayDtolist = new ArrayList<HappyDayDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("select happy_code, happy_name, happy_start, happy_end from happyday");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				HappyDayDto happyDayDto = new HappyDayDto();
				
				happyDayDto.setHappy_code(rs.getString("happy_code"));
				happyDayDto.setHappy_name(rs.getString("happy_name"));
				happyDayDto.setHappy_stat(rs.getString("happy_start"));
				happyDayDto.setHappy_end(rs.getString("happy_end"));
				
				
				happyDayDtolist.add(happyDayDto);
			}
			System.out.println(happyDayDtolist);
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return happyDayDtolist;
	}

	@Override
	public void delHappyday(int happyday_seq) {
		// TODO Auto-generated method stub
		
	}

	
	


}
