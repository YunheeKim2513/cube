package com.cube.user.schedule.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.ScheduleDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class DepartmentScheduleUserDaoImpl implements DepartmentScheduleUserDao {
	private static DepartmentScheduleUserDao departmentScheduleUserDao;
	static {
		departmentScheduleUserDao=new DepartmentScheduleUserDaoImpl();
	}
	
	public static DepartmentScheduleUserDao getDepartmentScheduleUserDao() {
		return departmentScheduleUserDao;
	}
	private DepartmentScheduleUserDaoImpl(){}
	@Override
	public List<ScheduleDto> list(String id) {
		List<ScheduleDto> list=new ArrayList<ScheduleDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			sql.append("	schedule_startdate, schedule_starttime, schedule_enddate, schedule_endtime, \n");
			sql.append("	schedule_participant, schedule_kind, schedule_department \n");
			sql.append("from schedule \n");
			sql.append("where schedule_kind='부서' \n");
			sql.append("	and schedule_department=(select d.department_id \n");
			sql.append("		 					 from employees e, departments d \n");
			sql.append("							 where e.department_id=d.department_id \n");
			sql.append("		      				 and e.employee_id=?) \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ScheduleDto scheduleDto=new ScheduleDto();
				scheduleDto.setEmployee_id(rs.getString("employee_id"));
				scheduleDto.setSchedule_seq(rs.getInt("schedule_seq"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_starttime(rs.getString("schedule_starttime"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
				scheduleDto.setSchedule_endtime(rs.getString("schedule_endtime"));
				scheduleDto.setSchedule_participant(rs.getString("schedule_participant"));
				scheduleDto.setSchedule_kind(rs.getString("schedule_kind"));
				scheduleDto.setSchedule_kind(rs.getString("schedule_department"));
				list.add(scheduleDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void write(ScheduleDto scheduleDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			String s=new String();
			s="select d.department_id \n";
			s+="from employees e, departments d \n";
			s+="where e.department_id=d.department_id \n";
			s+="		and e.employee_id=? \n";
			pstmt=conn.prepareStatement(s);
			pstmt.setString(1, scheduleDto.getEmployee_id());
			rs=pstmt.executeQuery();
			String depart_id="";
			if(rs.next()){
				depart_id=rs.getString("department_id");
			}
			pstmt.close();
			
			StringBuffer sql=new StringBuffer();
			sql.append("insert into schedule(employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			sql.append("				schedule_startdate, schedule_enddate, \n");
			sql.append("				schedule_department, schedule_kind) \n");
			sql.append("values(?, schedule_seq.nextval, ?, ?, ?, ?, ?, '부서') \n");
			pstmt=conn.prepareStatement(sql.toString());
			int idx=0;
			pstmt.setString(++idx, scheduleDto.getEmployee_id());
			pstmt.setString(++idx, scheduleDto.getSchedule_subject());
			pstmt.setString(++idx, scheduleDto.getSchedule_content());
			pstmt.setString(++idx, scheduleDto.getSchedule_startdate());
			pstmt.setString(++idx, scheduleDto.getSchedule_enddate());
			pstmt.setString(++idx, depart_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
	}

	@Override
	public void modify(ScheduleDto scheduleDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("update schedule \n");
			sql.append("set schedule_subject=?, schedule_content=?, \n");
			sql.append("	schedule_startdate=?, schedule_starttime=?, \n");
			sql.append("	schedule_enddate=?, schedule_endtime=?, schedule_participant=? \n");
			sql.append("where employee_id=? and schedult_kind='department' \n");
			pstmt=conn.prepareStatement(sql.toString());
			int idx=1;
			pstmt.setString(idx++, scheduleDto.getSchedule_subject());
			pstmt.setString(idx++, scheduleDto.getSchedule_content());
			pstmt.setString(idx++, scheduleDto.getSchedule_startdate());
			pstmt.setString(idx++, scheduleDto.getSchedule_starttime());
			pstmt.setString(idx++, scheduleDto.getSchedule_enddate());
			pstmt.setString(idx++, scheduleDto.getSchedule_endtime());
			pstmt.setString(idx++, scheduleDto.getSchedule_participant());
			pstmt.setString(idx++, scheduleDto.getEmployee_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void delete(int seq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("delete schedule \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public ScheduleDto view(int seq) {
		ScheduleDto scheduleDto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			sql.append("         schedule_startdate, schedule_starttime, \n");
			sql.append("         schedule_enddate, schedule_endtime, schedule_participant, schedule_kind \n");
			sql.append("from schedule \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs=pstmt.executeQuery();
			if(rs.next()){
				scheduleDto.setEmployee_id(rs.getString("employee_id"));
				scheduleDto.setSchedule_seq(rs.getInt("schedule_seq"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_starttime(rs.getString("schedule_starttime"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
				scheduleDto.setSchedule_endtime(rs.getString("schedule_endtime"));
				scheduleDto.setSchedule_participant(rs.getString("schedule_participant"));
				scheduleDto.setSchedule_kind(rs.getString("schedule_kind"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return scheduleDto;
	}
}
