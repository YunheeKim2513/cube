package com.cube.user.businessreport.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cube.model.dto.Work_reportDto;
import com.cube.util.db.DBClose;
import com.cube.util.db.DBConnection;

public class MyWorkreportUserDaoImpl implements MyWorkreportUserDao {

	private static MyWorkreportUserDao myWorkreportUserDao;
	
	static {
		myWorkreportUserDao = new MyWorkreportUserDaoImpl();
	}
	
	private MyWorkreportUserDaoImpl(){}
	
	public static MyWorkreportUserDao getMyWorkreportUserDao() {
		return myWorkreportUserDao;
	}

	@Override
	public void workinsert(Work_reportDto work_reportDto) {
		int cnt=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer docdetail_insert = new StringBuffer();
			docdetail_insert.append("insert into doc_info_detail (doc_seq, doc_writetime, employee_id, doc_code, doc_name, doc_state, doc_dep, doc_writer, doc_date, doc_file, doc_subject)");
			docdetail_insert.append("values(to_char(sysdate,'yyyy-mm-dd')||'-W07-'||doc_seq.nextval,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),?,?,?,?,?,?,?,?,?) \n");
			pstmt = conn.prepareStatement(docdetail_insert.toString());
			int idx = 0;
			pstmt.setString(++idx, work_reportDto.getEmployee_id());	//1
			pstmt.setString(++idx, work_reportDto.getDoc_code());		//2
			pstmt.setString(++idx, work_reportDto.getDoc_name());		//3
			pstmt.setString(++idx, work_reportDto.getDoc_state());		//4
			pstmt.setString(++idx, work_reportDto.getDoc_dep());		//5
			pstmt.setString(++idx, work_reportDto.getDoc_writer());		//6
			pstmt.setString(++idx, work_reportDto.getDoc_date());		//7
			pstmt.setString(++idx, work_reportDto.getDoc_file());		//8
			pstmt.setString(++idx, work_reportDto.getDoc_subject());	//9
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer work_report_insert = new StringBuffer();
			work_report_insert.append("insert into work_report (doc_seq, workdoc_open, workdoc_daycontent, confirmlist, workdoc_nextcontent, workdoc_kind, work_finaltime) \n");
			work_report_insert.append("values(to_char(sysdate,'yyyy-mm-dd')||'-W07-'||doc_seq.currval, ?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh:mi:ss')) \n");
			pstmt = conn.prepareStatement(work_report_insert.toString());
			pstmt.setString(1, work_reportDto.getWorkdoc_open());
			pstmt.setString(2, work_reportDto.getWorkdoc_daycontent());
			pstmt.setString(3, work_reportDto.getConfirmlist());
			pstmt.setString(4, work_reportDto.getWorkdoc_nextcontent());
			pstmt.setString(5, work_reportDto.getWorkdoc_kind());
			pstmt.executeUpdate();
			conn.commit();
			cnt = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public String worktime(String seq) {
		Work_reportDto work_reportDto = new Work_reportDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String worktime = "";
		try {
			conn = DBConnection.makeConnection();
			String sql = "select di.doc_writetime||'@'||w.work_finaltime worktime from doc_info_detail di, work_report w where di.doc_seq=w.doc_seq and w.doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			rs.next();
			worktime=rs.getString("worktime"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return worktime;
	}

	@Override
	public List<Work_reportDto> mywork_reportlist(String employee_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Work_reportDto> work_reportlist = new ArrayList<Work_reportDto>();
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select w.doc_seq, di.doc_code, di.doc_name, di.doc_state, di.doc_dep, di.doc_writer,  \n");
			sql.append("       di.doc_date, di.doc_subject, w.workdoc_open, w.confirmlist, w.workdoc_kind  \n");
			sql.append("from doc_info_detail di, work_report w  \n");
			sql.append("where di.doc_seq=w.doc_seq and di.employee_id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, employee_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Work_reportDto work_reportDto = new Work_reportDto();
				work_reportDto.setDoc_seq(rs.getString("doc_seq"));
				work_reportDto.setDoc_code(rs.getString("doc_code"));
				work_reportDto.setDoc_name(rs.getString("doc_name"));
				work_reportDto.setDoc_state(rs.getString("doc_state"));
				work_reportDto.setDoc_dep(rs.getString("doc_dep"));
				work_reportDto.setDoc_writer(rs.getString("doc_writer"));
				work_reportDto.setDoc_date(rs.getString("doc_date"));
				work_reportDto.setDoc_subject(rs.getString("doc_subject"));
				work_reportDto.setWorkdoc_open(rs.getString("workdoc_open"));
				work_reportDto.setConfirmlist(rs.getString("confirmlist"));
				work_reportDto.setWorkdoc_kind(rs.getString("workdoc_kind"));
				work_reportlist.add(work_reportDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return work_reportlist;
	}

	@Override
	public List<Work_reportDto> receivework_reportlist(String employee_id, String department_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Work_reportDto> work_reportlist = new ArrayList<Work_reportDto>();
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select w.doc_seq, di.doc_code, di.doc_name, di.doc_state, di.doc_dep, di.doc_writer,  \n");
			sql.append("       di.doc_date, di.doc_subject, w.workdoc_open, w.confirmlist, w.workdoc_kind  \n");
			sql.append("from doc_info_detail di, work_report w  \n");
			sql.append("where di.doc_seq=w.doc_seq and (not di.employee_id=?) and  ((w.workdoc_open='비공개' and w.confirmlist=?) or (w.workdoc_open='부서공개' and di.doc_dep=?) or w.workdoc_open='전체공개') \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, employee_id);
			pstmt.setString(2, employee_id);
			pstmt.setString(3, department_name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Work_reportDto work_reportDto = new Work_reportDto();
				work_reportDto.setDoc_seq(rs.getString("doc_seq"));
				work_reportDto.setDoc_code(rs.getString("doc_code"));
				work_reportDto.setDoc_name(rs.getString("doc_name"));
				work_reportDto.setDoc_state(rs.getString("doc_state"));
				work_reportDto.setDoc_dep(rs.getString("doc_dep"));
				work_reportDto.setDoc_writer(rs.getString("doc_writer"));
				work_reportDto.setDoc_date(rs.getString("doc_date"));
				work_reportDto.setDoc_subject(rs.getString("doc_subject"));
				work_reportDto.setWorkdoc_open(rs.getString("workdoc_open"));
				work_reportDto.setConfirmlist(rs.getString("confirmlist"));
				work_reportDto.setWorkdoc_kind(rs.getString("workdoc_kind"));
				work_reportlist.add(work_reportDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return work_reportlist;
	}

	@Override
	public Work_reportDto work_report_view(String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Work_reportDto work_reportDto = new Work_reportDto();
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select w.doc_seq, di.employee_id, di.doc_code, di.doc_name, di.doc_dep, di.doc_writer,  \n");
			sql.append("       di.doc_date, di.doc_subject, di.doc_writetime, w.workdoc_open, w.workdoc_daycontent,  \n");
			sql.append("       w.confirmlist, w.workdoc_nextcontent, w.workdoc_kind, w.work_finaltime  \n");
			sql.append("from doc_info_detail di, work_report w  \n");
			sql.append("where di.doc_seq=w.doc_seq and w.doc_seq=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				work_reportDto.setDoc_seq(rs.getString("doc_seq"));
				work_reportDto.setEmployee_id(rs.getString("employee_id"));
				work_reportDto.setDoc_code(rs.getString("doc_code"));
				work_reportDto.setDoc_name(rs.getString("doc_name"));
				work_reportDto.setDoc_dep(rs.getString("doc_dep"));
				work_reportDto.setDoc_writer(rs.getString("doc_writer"));
				work_reportDto.setDoc_date(rs.getString("doc_date"));
				work_reportDto.setDoc_subject(rs.getString("doc_subject"));
				work_reportDto.setDoc_writetime(rs.getString("doc_writetime"));
				work_reportDto.setWorkdoc_open(rs.getString("workdoc_open"));
				work_reportDto.setWorkdoc_daycontent(rs.getString("workdoc_daycontent"));
				work_reportDto.setConfirmlist(rs.getString("confirmlist"));
				work_reportDto.setWorkdoc_nextcontent(rs.getString("workdoc_nextcontent"));
				work_reportDto.setWorkdoc_kind(rs.getString("workdoc_kind"));
				work_reportDto.setWorkdoc_finaltime(rs.getString("work_finaltime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return work_reportDto;
	}

	@Override
	public void workupdate(Work_reportDto work_reportDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			String sql = "update doc_info_detail set doc_subject=? where doc_seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work_reportDto.getDoc_subject());
			pstmt.setString(2, work_reportDto.getDoc_seq());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer wsql = new StringBuffer();
			wsql.append("update work_report  \n");
			wsql.append("set workdoc_open=?, workdoc_daycontent=?, confirmlist=?, workdoc_nextcontent=?,  \n");
			wsql.append("    workdoc_kind=?, work_finaltime=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')  \n");
			wsql.append("where doc_seq=? \n");
			pstmt = conn.prepareStatement(wsql.toString());
			pstmt.setString(1, work_reportDto.getWorkdoc_open());
			pstmt.setString(2, work_reportDto.getWorkdoc_daycontent());
			pstmt.setString(3, work_reportDto.getConfirmlist());
			pstmt.setString(4, work_reportDto.getWorkdoc_nextcontent());
			pstmt.setString(5, work_reportDto.getWorkdoc_kind());
			pstmt.setString(6, work_reportDto.getDoc_seq());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
}
