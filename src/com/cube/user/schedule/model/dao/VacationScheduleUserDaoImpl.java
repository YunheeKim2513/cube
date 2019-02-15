package com.cube.user.schedule.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.*;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class VacationScheduleUserDaoImpl implements VacationScheduleUserDao {
	private static VacationScheduleUserDao vacationScheduleUserDao;
	static {
		vacationScheduleUserDao=new VacationScheduleUserDaoImpl();
	}
	
	public static VacationScheduleUserDao getVacationScheduleUserDao() {
		return vacationScheduleUserDao;
	}
	private VacationScheduleUserDaoImpl(){}
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
			sql.append("	schedule_startdate, schedule_enddate, schedule_kind \n");
			sql.append("from schedule \n");
			sql.append("where schedule_kind='ÈÞ°¡' \n");
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()){
				ScheduleDto scheduleDto=new ScheduleDto();
				scheduleDto.setEmployee_id(rs.getString("employee_id"));
				scheduleDto.setSchedule_seq(rs.getInt("schedule_seq"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));
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
	public List<VacationListDto> vacationlist() {
		List<VacationListDto> list=new ArrayList<VacationListDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnection.makeConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select e.employee_id, e.name, s.schedule_startdate, s.schedule_enddate, d.department_name, g.grade_name \n");
			sql.append("from employees e, employees_detail ed, schedule s, departments d, grades g \n");
			sql.append("where e.employee_id=ed.employee_id \n");
			sql.append("      and e.employee_id=s.employee_id \n");
			sql.append("      and e.department_id=d.department_id \n");
			sql.append("      and e.grade_id=g.grade_id  \n");
			sql.append("      and s.schedule_kind='ÈÞ°¡' \n");
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()){
				VacationListDto vacationListDto=new VacationListDto();
				vacationListDto.setEmployee_id(rs.getString("employee_id"));
				vacationListDto.setEmployee_name(rs.getString("name"));
				vacationListDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				vacationListDto.setSchedule_enddate(rs.getString("schedule_enddate"));
				vacationListDto.setDepartment_name(rs.getString("department_name"));
				vacationListDto.setGrade_name(rs.getString("grade_name"));
				list.add(vacationListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
