package com.cube.user.schedule.model.dao;

import java.sql.*;
import java.util.*;

import com.cube.model.dto.ScheduleDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class ScheduleSearchUserDaoImpl implements ScheduleSearchUserDao {
	private static ScheduleSearchUserDao scheduleSearchUserDao;
	static {
		scheduleSearchUserDao=new ScheduleSearchUserDaoImpl();
	}
	
	public static ScheduleSearchUserDao getScheduleSearchUserDao() {
		return scheduleSearchUserDao;
	}
	private ScheduleSearchUserDaoImpl(){}
	
	@Override
	public List<ScheduleDto> list() {
		List<ScheduleDto> list=new ArrayList<ScheduleDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, e.name, d.department_id, d.department_name, \n");
			sql.append("	g.grade_id, g.grade_name, s.schedule_subject, s.schedule_content, s.schedule_seq, \n");
			sql.append("	s.schedule_startdate, nvl(s.schedule_starttime,' ') schedule_starttime, schedule_enddate, \n");
			sql.append("	nvl(s.schedule_endtime,' ') schedule_endtime, s.schedule_kind, nvl(s.schedule_participant,' ') schedule_participant \n");
			sql.append("from schedule s, employees e, employees_detail ed, \n");
			sql.append("	departments d, grades g \n");
			sql.append("where e.employee_id=ed.employee_id \n");
			sql.append("	and e.employee_id=s.employee_id \n");
			sql.append("	and e.department_id=d.department_id \n");
			sql.append("	and e.grade_id=g.grade_id \n");
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()){
				ScheduleDto scheduleDto=new ScheduleDto();
				scheduleDto.setSchedule_seq(rs.getInt("schedule_seq"));
				scheduleDto.setEmployee_id(rs.getString("employee_id"));
				scheduleDto.setName(rs.getString("name"));
				scheduleDto.setDepartment_id(rs.getString("department_id"));
				scheduleDto.setDepartment_name(rs.getString("department_name"));
				scheduleDto.setGrade_id(rs.getString("grade_id"));
				scheduleDto.setGrade_name(rs.getString("grade_name"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_starttime(rs.getString("schedule_starttime"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
				scheduleDto.setSchedule_endtime(rs.getString("schedule_endtime"));
				scheduleDto.setSchedule_kind(rs.getString("schedule_kind"));
				scheduleDto.setSchedule_participant(rs.getString("schedule_participant"));
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
	public List<ScheduleDto> search(Map<String,String> map) {
		List<ScheduleDto> list=new ArrayList<ScheduleDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try { 
			//System.out.println("kind : "+map.get("kind"));
			//System.out.println("start : "+map.get("start"));
			//System.out.println("end : "+map.get("end"));
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, e.name, d.department_id, d.department_name, \n");
			sql.append("	g.grade_id, g.grade_name, s.schedule_subject, s.schedule_content, \n");
			sql.append("	s.schedule_startdate, nvl(s.schedule_starttime,' ') schedule_starttime, s.schedule_enddate, \n");
			sql.append("	nvl(s.schedule_endtime,' ') schedule_endtime, s.schedule_kind, nvl(s.schedule_participant,' ') schedule_participant \n");
			sql.append("from schedule s, employees e, employees_detail ed, \n");
			sql.append("	departments d, grades g \n");
			sql.append("where e.employee_id=ed.employee_id \n");
			sql.append("	and e.employee_id=s.employee_id \n");
			sql.append("	and e.department_id=d.department_id \n");
			sql.append("	and e.grade_id=g.grade_id \n");
			sql.append("	and s.schedule_kind=? \n");
			sql.append("	and s.schedule_startdate>=? \n");
			sql.append("	and s.schedule_enddate<=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("kind"));
			pstmt.setString(2, map.get("start"));
			pstmt.setString(3, map.get("end"));
			rs=pstmt.executeQuery();
			while(rs.next()){
				ScheduleDto scheduleDto=new ScheduleDto();
				scheduleDto.setEmployee_id(rs.getString("employee_id"));
				scheduleDto.setName(rs.getString("name"));
				scheduleDto.setDepartment_id(rs.getString("department_id"));
				scheduleDto.setDepartment_name(rs.getString("department_name"));
				scheduleDto.setGrade_id(rs.getString("grade_id"));
				scheduleDto.setGrade_name(rs.getString("grade_name"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_starttime(rs.getString("schedule_starttime"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
				scheduleDto.setSchedule_endtime(rs.getString("schedule_endtime"));
				scheduleDto.setSchedule_kind(rs.getString("schedule_kind"));
				scheduleDto.setSchedule_participant(rs.getString("schedule_participant"));
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
	public void update(Map<String,String> map) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("update schedule \n");
			sql.append("set schedule_subject=?, schedule_content=?, \n");
			sql.append("	schedule_startdate=?, schedule_enddate=?, schedule_kind=? \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			String subject=map.get("subject");
			String content=map.get("content");
			String start=map.get("start");
			String end=map.get("end");
			String seq=map.get("seq");
			String kind=map.get("kind");
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, start);
			pstmt.setString(4, end);
			pstmt.setString(5, kind);
			pstmt.setString(6, seq);
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
			sql.append("select schedule_seq, schedule_subject, schedule_content, schedule_kind, schedule_startdate, schedule_enddate \n");
			sql.append("from schedule \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs=pstmt.executeQuery();
			if(rs.next()){
				scheduleDto=new ScheduleDto();
				scheduleDto.setSchedule_seq(rs.getInt("schedule_seq"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
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
