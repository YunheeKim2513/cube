package com.cube.user.schedule.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cube.model.dto.ScheduleDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class AllScheduleUserDaoImpl implements AllScheduleUserDao {
	private static AllScheduleUserDao allScheduleUserDao;
	static {
		allScheduleUserDao=new AllScheduleUserDaoImpl();
	}
	
	public static AllScheduleUserDao getAllScheduleUserDao() {
		return allScheduleUserDao;
	}
	private AllScheduleUserDaoImpl(){}
	
	@Override
	public List<ScheduleDto> list() {
		List<ScheduleDto> list=new ArrayList<ScheduleDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			sql.append("	schedule_startdate, nvl(schedule_starttime,'') schedule_starttime, schedule_enddate, nvl(schedule_endtime,'') schedule_endtime, \n");
			sql.append("	schedule_participant, schedule_kind \n");
			sql.append("from schedule \n");
			pstmt=conn.prepareStatement(sql.toString());
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
	public int write(ScheduleDto scheduleDto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("insert into schedule(employee_id, schedule_seq, schedule_subject, schedule_content, \n");
			sql.append("				schedule_startdate, schedule_starttime, \n");
			sql.append("				schedule_enddate, schedule_endtime, schedule_participant, schedule_kind) \n");
			sql.append("values(?, schedule_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?) \n");
			pstmt=conn.prepareStatement(sql.toString());
			int idx=0;
			pstmt.setString(++idx, scheduleDto.getEmployee_id());
			pstmt.setString(++idx, scheduleDto.getSchedule_subject());
			pstmt.setString(++idx, scheduleDto.getSchedule_content());
			pstmt.setString(++idx, scheduleDto.getSchedule_startdate());
			pstmt.setString(++idx, scheduleDto.getSchedule_starttime());
			pstmt.setString(++idx, scheduleDto.getSchedule_enddate());
			pstmt.setString(++idx, scheduleDto.getSchedule_endtime());
			pstmt.setString(++idx, scheduleDto.getSchedule_participant());
			pstmt.setString(++idx, scheduleDto.getSchedule_kind());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return result;
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
			sql.append("	schedule_startdate=?, schedule_enddate=?, schedule_kind \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			String subject=map.get("subject");
			String content=map.get("content");
			String startdate=map.get("startdate");
			String enddate=map.get("enddate");
			String seq=map.get("seq");
			String kind=map.get("kind");
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, startdate);
			pstmt.setString(4, enddate);
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
	public int delete(int seq) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("delete schedule \n");
			sql.append("where schedule_seq=? \n");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return result;
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
